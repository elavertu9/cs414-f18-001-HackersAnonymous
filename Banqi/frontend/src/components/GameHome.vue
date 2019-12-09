<template>
  <div class="home">
    <b-container class="gameHomeContent">
      <b-row>
        <b-col class="col-md-4 center">
          <b-card class="mb-2 shadow">
            <b-card-text>Create a New Game</b-card-text>
            <b-button variant="primary" id="show-btn" @click="$bvModal.show('newGameModal')">New Game</b-button>
          </b-card>
          <br/>
          <b-card title="Completed Games" class="shadow">
            <table class="table">
              <thead>
              <th>Game ID</th>
              <th>Player1</th>
              <th>Player2</th>
              </thead>
              <tbody>
              <tr v-for="game in gamesInProgress" v-if="game.gameOver">
                <td>{{game.id}}</td>
                <td>{{game.player1.username}}</td>
                <td>{{game.player2.username}}</td>
              </tr>
              </tbody>
            </table>
          </b-card>
        </b-col>
        <b-col class="center">
          <b-card title="Games in Progress" class="shadow">
            <table class="table">
              <thead>
                <th>Game ID</th>
                <th>Player1</th>
                <th>Player2</th>
                <th></th>
              </thead>
              <tbody>
                <tr v-for="game in gamesInProgress" v-if="!game.gameOver">
                  <td>{{game.id}}</td>
                  <td>{{game.player1.username}}</td>
                  <td>{{game.player2.username}}</td>
                  <td><b-button variant="success" @click="resumeGame(game.id)">Resume</b-button></td>
                </tr>
              </tbody>
            </table>
          </b-card>
        </b-col>
      </b-row>
      <br/>

      <!-- Create New Game Modal -->
      <b-modal id="newGameModal" size="xl" hide-footer>
        <template v-slot:modal-title>
          Create a Game
        </template>
        <div class="overflow">
          <table class="table table-hover">
            <thead>
            <tr>
              <th>Username</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(user, index) in userList">
              <td>{{user.username}}</td>
              <td>{{user.firstName}}</td>
              <td>{{user.lastName}}</td>
              <td>{{user.email}}</td>
              <td><b-button variant="success" @click="selectPlayer(index)">Invite</b-button>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <br/>
        <div class="d-block text-center">
          <b-alert v-if="this.playerSelected" show variant="success">
            <h5><b>Creating Game:</b></h5>
            {{this.currentPlayer.username}} VS. {{this.selectedPlayer.username}}
          </b-alert>
        </div>
        <br/>
        <Loader v-if="loading"></Loader>
        <br/>
        <b-alert v-if="this.showError == true" show variant="danger">{{this.error}}</b-alert>
        <div class="center">
          <b-button variant="danger" @click="$bvModal.hide('newGameModal')" class="toolbar">Cancel</b-button>
          <b-button @click="createGame()" variant="success" class="toolbar">Create</b-button>
        </div>
      </b-modal>
    </b-container>
  </div>
</template>

<script>
    import API from '../api';
    import Loader from './Loader';

    export default {
        name: "GameHome",
        components: {Loader},

        mounted() {
          API.getAllUsers().then(response => {
            this.userList = response.data;
          });

          this.getUserInfo();
          this.getGameList();
          window.setInterval(() => {
            this.phoneHome();
          }, this.callHomeEvery);
        },

        data() {
          return {
            loading: false,
            userList: [
              {
                id: '',
                username: '',
                firstName: '',
                lastName: '',
                email: ''
              }
            ],
            selectedPlayer: {
              id: '',
              username: ''
            },
            playerSelected: false,
            currentPlayer: {
              id: '',
              firstName: '',
              lastName: '',
              username: '',
              email: '',
            },
            error: '',
            showError: false,
            gamesInProgress: [],
            turn: false,
            gameOver: false,
            callHomeEvery: 3000
          }
        },

        methods: {
          resumeGame(gameID) {
              localStorage.setItem('gameId', gameID);
              window.location.pathname = "/game";
          },

          phoneHome() {
            API.getUsersGames(this.currentPlayer.id).then(response => {
              if (response.data.length !== this.gamesInProgress.length) {
                this.getGameList();
              }
            });
          },

          createGame() {
            if (this.playerSelected) {
              this.error = '';
              this.showError = false;
              this.loading = true;
              API.createNewGame(this.currentPlayer.id, this.selectedPlayer.id).then(response => {
                let gameId = response.data.id;
                localStorage.setItem('gameId', gameId);
                window.location.pathname = "/game";
                this.loading = false;
              });
            } else {
              this.error = "Please select an opponent";
              this.showError = true;
            }
          },

          selectPlayer(index) {
            this.error = '';
            this.showError = false;
            this.playerSelected = true;
            let selected = this.userList[index];
            let newSelection = {
              id: selected.id,
              username: selected.username
            };
            this.selectedPlayer = newSelection;
          },

          getUserInfo() {
            this.currentPlayer.id = localStorage.getItem('userID');
            API.getUser(this.currentPlayer.id).then(response => {
              let currUser = {
                id: response.data.id,
                firstName: response.data.firstName,
                lastName: response.data.lastName,
                username: response.data.username,
                email: response.data.email
              };
              this.currentPlayer = currUser;
            });
          },

          getGameList() {
            API.getUsersGames(this.currentPlayer.id).then(response => {
              for (let i in response.data) {
                let game = {
                  id: response.data[i].id,
                  player1: {
                    id: response.data[i].playerOneId,
                    username: ''
                  },
                  player2: {
                    id: response.data[i].playerTwoId,
                    username: ''
                  },
                  turn: response.data[i].turn,
                  gameOver: response.data[i].gameOver
                };
                this.gamesInProgress.push(game);
              }
              this.populateUsernames();
            });
          },

          populateUsernames() {
            for (let i in this.gamesInProgress) {
              API.getUser(this.gamesInProgress[i].player1.id).then(response => {
                this.gamesInProgress[i].player1.username = response.data.username;
              });

              API.getUser(this.gamesInProgress[i].player2.id).then(response => {
                this.gamesInProgress[i].player2.username = response.data.username;
              });
            }
          },

        }
    }
</script>

<style scoped>
  .shadow {
    box-shadow: 10px 10px 5px grey;
  }

  .center {
    text-align: center;
  }

  .toolbar {
    margin-left: 2px;
    margin-right: 2px;
    width: 200px;
    border-radius: 12px;
  }
</style>
