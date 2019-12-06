<template>
    <b-container>
      <h1 class="center">Admin Page</h1>
      <h4 class="center">Selected Table: {{selectedTable}}</h4>
      <br/>

      <b-row>
        <b-col class="center">
          <b-dropdown variant="primary" text="Change Table">
            <b-dropdown-item @click="switchToUsers()">Users</b-dropdown-item>
            <b-dropdown-item @click="switchToGames()">Games</b-dropdown-item>
          </b-dropdown>
          <br/>
          <br/>
          <div v-if="this.loading" class="loader"></div>
          <br/>
          <b-alert v-if="this.showResponse == true" show variant="success">{{this.response}}</b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <br/>

          <!-- USERS TABLE -->
          <table v-if="selectedTable == 'Users'" class="table table-hover">
            <thead>
            <tr>
              <th>User ID</th>
              <th>Username</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th></th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="user in userList">
              <td>{{user.id}}</td>
              <td>{{user.username}}</td>
              <td>{{user.firstName}}</td>
              <td>{{user.lastName}}</td>
              <td>{{user.email}}</td>
              <td><b-button variant="primary" @click="editPlayer(user.id)">Edit</b-button></td>
              <td><b-button variant="danger" @click="deletePlayer(user.id)">Delete</b-button></td>
            </tr>
            </tbody>
          </table>

          <!-- GAMES TABLE -->
          <table v-else-if="selectedTable == 'Games'" class="table table-hover">
            <thead>
            <tr>
              <th>Game ID</th>
              <th>Player 1</th>
              <th>Player 2</th>
              <th>Status</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(game, index) in gameList">
              <td>{{game.id}}</td>
              <td>{{usernameList[index].p1Username}}</td>
              <td>{{usernameList[index].p2Username}}</td>
              <td>{{game.board.gameOver ? "Completed" : "In Progress"}}</td>
              <td><b-button variant="danger" @click="deleteGame(game.id)">Delete</b-button></td>
            </tr>
            </tbody>
          </table>

          <!-- DEFAULT TABLE -->
          <table v-else class="table table-hover">
            <thead>
            <tr>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td></td>
            </tr>
            </tbody>
          </table>
        </b-col>
      </b-row>

      <!-- EDIT USER MODAL -->
      <div>
        <b-modal id="editUserModal" ref="editUserModal" hide-footer>
          <template v-slot:modal-title>
            Edit User
          </template>
          <div>
            <b-form @submit="onSubmit">
              <b-form-group id="firstName" label="First Name:" label-for="firstName">
                <b-form-input id="firstName" v-model="selectedUser.firstName" required></b-form-input>
              </b-form-group>

              <b-form-group id="lastName" label="Last Name:" label-for="lastName">
                <b-form-input id="lastName" v-model="selectedUser.lastName" required></b-form-input>
              </b-form-group>

              <b-form-group id="username" label="Username:" label-for="username">
                <b-form-input id="username" v-model="selectedUser.username" required></b-form-input>
              </b-form-group>

              <b-form-group id="email" label="Email address:" label-for="email">
                <b-form-input id="email" v-model="selectedUser.email" type="email" required></b-form-input>
              </b-form-group>

              <b-form-group id="password" label="Password:" label-for="password">
                <b-form-input id="password" v-model="selectedUser.password" type="text" required></b-form-input>
              </b-form-group>
              <br/>
              <b-alert v-if="this.showError == true" show variant="danger">{{this.error}}</b-alert>
              <b-button type="submit" variant="success" class="full-size">Submit</b-button>
            </b-form>
          </div>
        </b-modal>
      </div>
    </b-container>
</template>

<script>
    import API from '../api';
    export default {
        name: "Admin",

        mounted() {
          this.getUserList();
          this.getGameList();
        },

        data() {
          return {
            userList: [
              {
                id: '',
                username: '',
                firstName: '',
                lastName: '',
                email: ''
              }
            ],
            gameList: [
              {
                id: '',
                playerOneId: '',
                playerTwoId: '',
                board: {
                  gameOver: false
                }
              }
            ],
            selectedUser: {
              id: '',
              username: '',
              firstName: '',
              lastName: '',
              email: '',
              password: ''
            },
            error: '',
            showError: false,
            selectedTable: 'Users',
            loading: false,
            showResponse: false,
            response: '',
            usernameList: []
          }
        },

        methods: {
          getUserList() {
            API.getAllUsers().then(response => {
              this.userList = response.data;
              this.loading = false;
            });
          },

          getGameList() {
            API.getAllGames().then(response => {
              this.gameList = response.data;
              this.loading = false;
              this.getUsernames();
            });
          },

          editPlayer(id) {
            console.log("Editing user ", id);
            API.getUser(id).then(response => {
              let selected = {
                id: response.data.id,
                username: response.data.username,
                firstName: response.data.firstName,
                lastName: response.data.lastName,
                email: response.data.email,
                password: response.data.password
              };
              this.selectedUser = selected;
              this.$refs['editUserModal'].show()
            });
          },

          deletePlayer(id) {
            this.loading = true;
            API.deleteUser(id).then(() => {
              this.showResponse = true;
              this.response = `User with ID ${id} has been deleted`;
              setTimeout(() => {
                this.showResponse = false;
              }, 5000);
              this.getUserList();
            });
          },

          deleteGame(id) {
            this.loading = true;
            API.deleteGame(id).then(() => {
              this.showResponse = true;
              this.response = `Game with ID ${id} has been deleted`;
              setTimeout(() =>
              {
                this.showResponse = false;
              }, 5000);
              this.getGameList();
            });
          },

          onSubmit() {
            let updatedUser = {
              id: this.selectedUser.id,
              firstName: this.selectedUser.firstName,
              lastName: this.selectedUser.lastName,
              username: this.selectedUser.username,
              email: this.selectedUser.email,
              password: this.selectedUser.password
            };
            API.updateUser(updatedUser).then(() => {
              console.log("Success");
            });
          },

          switchToUsers() {
            this.selectedTable = 'Users';
          },

          switchToGames() {
            this.selectedTable = 'Games';
          },

          getUsernames() {
            for (let i in this.gameList) {
              let usernameAdd = {
                p1Username: '',
                p2Username: ''
              };
              API.getUser(this.gameList[i].playerOneId).then(response => {
                usernameAdd.p1Username = response.data.username;
              });
              API.getUser(this.gameList[i].playerTwoId).then(response => {
                usernameAdd.p2Username = response.data.username;
              });
              this.usernameList.push(usernameAdd);
            }
          }
        }
    }
</script>

<style scoped>
  .center {
    text-align: center;
  }

  .full-size {
    width: 100%;
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
</style>
