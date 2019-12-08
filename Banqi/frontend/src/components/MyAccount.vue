<template>
  <div class="myAccount">
    <b-container class="myAccountPageContent">
      <b-row>
        <b-col>
          <b-card title="Recent Games" class="shadow center">
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

        <b-col>
          <b-card title="My Account" class="shadow center">
            <h2><b>{{this.userInfo.username}}</b></h2>
            <br/>
            <b-button @click="$bvModal.show('changePasswordModal')" variant="primary">Change Password</b-button>
            <br/>
            <br/>
            <b-button @click="$bvModal.show('deleteAccountModal')" variant="danger">Delete Account</b-button>
          </b-card>
          <br/>
          <b-card class="shadow center">
            <div v-if="gameLoaded">
              <h5>{{this.gameInfo.player1.username}} <b>vs.</b> {{this.gameInfo.player2.username}}</h5>
            </div>
            <div v-else>
              <h5>Let's get started!</h5>
            </div>
            <br/>

            <b-button v-if="gameLoaded" @click="playBanqi()" variant="success">Resume Game</b-button>
            <b-button v-else @click="playBanqi()" variant="success">Play Banqi</b-button>
          </b-card>
        </b-col>
        <b-col>
          <b-card title="Edit Account Information" class="shadow center">
            <b-card-text>
              <div>
                <b-form @submit="onSubmit">
                  <b-form-group id="firstName" label="First Name:" label-for="firstName">
                    <b-form-input id="firstName" v-model="userInfo.firstName" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="lastName" label="Last Name:" label-for="lastName">
                    <b-form-input id="lastName" v-model="userInfo.lastName" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="username" label="Username:" label-for="username">
                    <b-form-input id="username" v-model="userInfo.username" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="email" label="Email address:" label-for="email">
                    <b-form-input id="email" v-model="userInfo.email" type="email" required></b-form-input>
                  </b-form-group>

                  <br/>
                  <b-alert v-if="this.showError == true" show variant="danger">{{this.error}}</b-alert>
                  <b-button type="submit" variant="success">Submit</b-button>
                </b-form>
              </div>
            </b-card-text>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
    <br/>

    <!-- CHANGE PASSWORD MODAL -->
    <div>
      <b-modal id="changePasswordModal" hide-footer>
        <template v-slot:modal-title>
          Change Password
        </template>
        <ChangePassword></ChangePassword>
      </b-modal>
    </div>

    <!-- DELETE ACCOUNT MODAL -->
    <div>
      <b-modal id="deleteAccountModal" hide-footer>
        <template v-slot:modal-title>
          Delete Account
        </template>
        <DeleteAccount></DeleteAccount>
      </b-modal>
    </div>
  </div>
</template>

<script>
    import ChangePassword from "./ChangePassword";
    import DeleteAccount from "./DeleteAccount";
    import API from '../api';
    export default {
      name: "MyAccount",
      components: {ChangePassword, DeleteAccount},
      data() {
        return {
          userInfo: {
            username: '',
            firstName: '',
            lastName: '',
            email: '',
            userID: '',
            password: ''
          },
          error: '',
          showError: false,
          gameLoaded: false,
          gameInfo: {
            player1: {
              id: '',
              username: ''
            },
            player2: {
              id: '',
              username: ''
            }
          },
          gamesInProgress: []
        }
      },

      mounted() {
        this.userInfo.userID = localStorage.getItem('userID');
        if (localStorage.hasOwnProperty('gameId')) {
          this.gameLoaded = true;
          this.getGameInfo();
        } else {
          this.gameLoaded = false;
        }
        this.getUserInfo();
        this.getGameList();
      },

      methods: {

        onSubmit() {
          console.log("Hello");
          let updatedUser = {
            id: this.userInfo.userID,
            firstName: this.userInfo.firstName,
            lastName: this.userInfo.lastName,
            username: this.userInfo.username,
            email: this.userInfo.email,
            password: this.userInfo.password
          };
          API.updateUser(updatedUser).then(() => {
            console.log("Success");
          });
        },

        getUserInfo() {
          API.getUser(this.userInfo.userID).then(response => {
            let getUser = {
              username: response.data.username,
              firstName: response.data.firstName,
              lastName: response.data.lastName,
              email: response.data.email,
              userID: this.userInfo.userID,
              password: response.data.password
            };
            this.userInfo = getUser;
          });
        },

        playBanqi() {
          if (localStorage.hasOwnProperty('gameId')) {
            window.location.pathname = "/game";
          } else {
            window.location.pathname = "/gameHome";
          }
        },

        getGameInfo() {
          API.getExistingGame(localStorage.getItem('gameId')).then(response => {
            this.gameInfo.player1.id = response.data.playerOneId;
            this.gameInfo.player2.id = response.data.playerTwoId;
            this.getPlayers();
          });
        },

        getPlayers() {
          // Get player1 info
          API.getUser(this.gameInfo.player1.id).then(response => {
            let user1 = {
              id: response.data.id,
              username: response.data.username
            };
            this.gameInfo.player1 = user1;
          });

          // Get player2 info
          API.getUser(this.gameInfo.player2.id).then(response => {
            let user2 = {
              id: response.data.id,
              username: response.data.username
            };
            this.gameInfo.player2 = user2;
          });
        },

        getGameList() {
          API.getUsersGames(this.userInfo.userID).then(response => {
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
</style>
