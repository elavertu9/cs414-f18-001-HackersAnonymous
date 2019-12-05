<template>
  <div class="myAccount">
    <b-container class="myAccountPageContent">
      <b-row>
        <b-col>
          <b-card title="Recent Games" class="shadow center">
            <table class="table">
              <thead>
                <th>Opponent</th>
                <th>Result</th>
              </thead>
              <tbody>
                <tr>
                  <td>Player 2</td>
                  <td>Win</td>
                </tr>
                <tr>
                  <td>Player 2</td>
                  <td>Loss</td>
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
  </div>
</template>

<script>
    import ChangePassword from "./ChangePassword";
    import API from '../api';
    export default {
      name: "MyAccount",
      components: {ChangePassword},
      data() {
        return {
          userInfo: {
            username: 'Placeholder',
            firstName: '',
            lastName: '',
            email: '',
            userID: ''
          },
          error: '',
          showError: false
        }
      },

      mounted() {
        this.userInfo.userID = localStorage.getItem('userID');
        this.getUserInfo();
      },

      methods: {
        onSubmit() {

        },

        getUserInfo() {
          API.getUser(this.userInfo.userID).then(response => {
            let getUser = {
              username: response.data.username,
              firstName: response.data.firstName,
              lastName: response.data.lastName,
              email: response.data.email,
              userID: this.userInfo.userID
            };
            this.userInfo = getUser;
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
</style>
