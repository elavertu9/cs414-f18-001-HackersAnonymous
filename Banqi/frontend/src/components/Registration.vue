<template>
  <div class="registration">
    <b-container class="registrationPageContent">
      <b-row>
        <b-col>
          <b-card title="Registration" class="mb-2 forms">
            <b-card-text>
              <div>
                <b-form @submit="onSubmit">
                  <b-form-group id="firstName" label="First Name:" label-for="firstName">
                    <b-form-input id="firstName" v-model="registrationForm.firstName" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="lastName" label="Last Name:" label-for="lastName">
                    <b-form-input id="lastName" v-model="registrationForm.lastName" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="username" label="Username:" label-for="username">
                    <b-form-input id="username" v-model="registrationForm.username" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="email" label="Email address:" label-for="email">
                    <b-form-input id="email" v-model="registrationForm.email" type="email" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="password" label="Password:" label-for="password">
                    <b-form-input id="password" type="password" v-model="registrationForm.password" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="confirmPassword" label="Confirm Password:" label-for="confirmPassword">
                    <b-form-input id="confirmPassword" type="password" v-model="confirmPassword" required></b-form-input>
                  </b-form-group>
                  <br/>
                  <b-alert v-if="this.showError == true" show variant="danger">{{this.error}}</b-alert>
                  <b-button type="submit" variant="success" style="width:100%">Submit</b-button>
                </b-form>
              </div>
            </b-card-text>
          </b-card>
        </b-col>
        <b-col class="col-md-4 center">
          <b-card class="mb-2 forms">
            <b-card-text>Already have an account?</b-card-text>
            <b-button variant="primary"><router-link id="loginButton" to="/login">Login</router-link></b-button>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
    <br/>
  </div>
</template>

<script>
    import API from '../api';
    export default {
      name: "Registration",
      data() {
        return {
          registrationForm: {
            firstName: '',
            lastName: '',
            username: '',
            email: '',
            password: '',
          },
          confirmPassword: '',
          error: '',
          showError: false,
          backendErrors: []
        }
      },
      methods: {
        onSubmit(evt) {
          evt.preventDefault();
          // Check passwords match
          if (this.registrationForm.password != this.confirmPassword) {
            this.error = "Passwords do not match";
            this.showError = true;
          } else {
            // Check password length
            if (this.registrationForm.password.length < 5) {
              this.error = "Password must contain 5 or more characters";
              this.showError = true;
            } else {
              this.showError = false;
              this.error = '';
              this.checkUsernameEmail();
            }
          }
        },

        checkUsernameEmail() {
          this.callApiGetAllUsers();
          //this.callApiRegister();
        },

        callApiGetAllUsers() {
          API.getAllUsers().then(response => {
            let userList = response.data;
            let emailExists = false;
            let usernameExists = false;
            for(let i in userList) {
              // Check if username is already in use
              if (userList[i].username == this.registrationForm.username) {
                usernameExists = true;
              }
              // Check if email is already in use
              if (userList[i].email == this.registrationForm.email) {
                emailExists = true;

              }
            }
            if (emailExists) {
              this.error = "Email address already in use, try a different email"
              this.showError = true;
            } else if (usernameExists) {
              this.error = "Username already in use, try a different username";
              this.showError = true;
            } else {
              this.error = '';
              this.showError = false;
              this.callApiRegister();
            }
          });
        },

        callApiRegister() {
          let postUser = {
            firstName: this.registrationForm.firstName,
            lastName: this.registrationForm.lastName,
            email: this.registrationForm.email,
            username: this.registrationForm.username,
            password: this.registrationForm.password
          };
          API.registerUser(postUser).then(response => {
            console.log(response.data);
            // TODO: check if account creation was successful or failed
            window.location.pathname = "/login"
          });
        },
      }
    }
</script>

<style scoped>
  #loginButton {
    text-decoration: none;
    color: white;
    text-align: center;
  }

  .center {
    text-align: center;
  }

  .forms {
    box-shadow: 10px 10px 5px grey;
  }
</style>
