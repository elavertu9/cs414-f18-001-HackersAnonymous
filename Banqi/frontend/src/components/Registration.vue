<template>
  <div class="registration">
    <b-container class="registrationPageContent">
      <b-row>
        <b-col>
          <b-card title="Registration" class="mb-2">
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
        <b-col>
          <b-card style="max-width: 20rem; text-align:center;" class="mb-2">
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
          error: 'Passwords do not match',
          showError: false,
          backendErrors: []
        }
      },
      methods: {
        onSubmit(evt) {
          evt.preventDefault();
          if (this.registrationForm.password != this.confirmPassword) {
            console.log("Passwords do not match");
            this.showError = true;
          } else {
            console.log(JSON.stringify(this.registrationForm));
            this.showError = false;
            this.callApiRegister();
          }
        },
        callApiRegister() {
          API.registerUser(this.registrationForm).then(response => {
             console.log(response.data);
          })
          .catch(error => {
              this.backendErrors.push(error);
          });
        }
      }
    }
</script>

<style scoped>
  #loginButton {
    text-decoration: none;
    color: white;
    text-align: center;
  }
</style>
