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
      <b-modal id="newGameModal" hide-footer>
        <template v-slot:modal-title>
          Create a Game
        </template>
        <div class="d-block text-center">
          <b-button @click="getPlayers()" variant="primary">Players</b-button>
        </div>
        <br/>
        <b-button variant="danger" @click="$bvModal.hide('newGameModal')" class="toolbar">Cancel</b-button>
        <b-button @click="createGame()" variant="success" class="toolbar">Create</b-button>
      </b-modal>
    </b-container>
  </div>
</template>

<script>
    import API from '../api';

    export default {
        name: "GameHome",

        data() {
          return {

          }
        },

        methods: {
          resumeGame(gameID) {
              console.log("Resuming Game");

          },

          getPlayers() {
            API.getAllUsers().then(response => {
               let users = response.data;
               console.log(users);
            });
          },

          createGame() {
              API.getNewGame().then(response => {
                 let gameId = response.data.id;
                 localStorage.setItem('gameId', gameId);
                 window.location.pathname = "/game"
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
</style>
