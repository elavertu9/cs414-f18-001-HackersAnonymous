<template>
  <div class="home">
    <b-container class="gameHomeContent">
      <b-row>
        <b-col class="col-md-4 center">
          <b-card class="mb-2 shadow">
            <b-card-text>Create a New Game</b-card-text>
            <b-button variant="primary" id="show-btn" @click="$bvModal.show('newGameModal')">New Game</b-button>
          </b-card>
        </b-col>
        <b-col class="center">
          <b-card title="Existing Games" class="shadow">
            <table class="table">
              <thead>
                <th>Game ID</th>
                <th>Players</th>
                <th></th>
              </thead>
              <tbody>
                <td>1</td>
                <td>2</td>
                <td><b-button variant="success" @click="resumeGame()">Resume</b-button></td>
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
        <div v-if="this.loading" class="loader"></div>
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

    export default {
        name: "GameHome",

        mounted() {
          API.getAllUsers().then(response => {
            this.userList = response.data;
          });

          this.getUserInfo();
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
              username: ''
            },
            error: '',
            showError: false
          }
        },

        methods: {
          resumeGame(gameID) {
              console.log("Resuming Game");

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
                username: response.data.username
              };
              this.currentPlayer = currUser;
            });
          }
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

  .loader {
    border: 10px solid #1E4D2B; /* Light grey */
    border-top: 10px solid #D9782D; /* Blue */
    border-radius: 50%;
    width: 50px;
    height: 50px;
    animation: spin 2s linear infinite;
    margin-left: auto;
    margin-right: auto;
    display: block;
  }

  @keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
  }

  .overflow {
    height: 300px;
    width: 100%;
    overflow: scroll;
    border: 3px solid black;
  }
</style>
