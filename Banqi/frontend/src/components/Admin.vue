<template>
    <b-container>
      <h1 class="center">Admin Page</h1>
      <br/>
      <b-row>
        <b-col>
          <table class="table table-hover">
            <thead>
            <tr>
              <th>ID</th>
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
            selectedUser: {
              id: '',
              username: '',
              firstName: '',
              lastName: '',
              email: '',
              password: ''
            },
            error: '',
            showError: false
          }
        },

        methods: {
          getUserList() {
            API.getAllUsers().then(response => {
              this.userList = response.data;
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
            console.log("Editing user ", id)
          },

          onSubmit() {

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
</style>
