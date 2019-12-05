<template>
  <div class="login">
    <b-container class="loginPageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card title="Login" class="mb-2 form">
            <b-card-text>
              <div>
                <b-form @submit="onSubmit">
                  <b-form-group id="username" label="Username:" label-for="username">
                    <b-form-input id="username" v-model="loginForm.username" required></b-form-input>
                  </b-form-group>
                  <b-form-group id="password" label="Password:" label-for="password">
                    <b-form-input id="password" type="password" v-model="loginForm.password" required></b-form-input>
                  </b-form-group>
                  <b-alert v-if="this.showError == true" show variant="danger">{{this.error}}</b-alert>
                  <b-button type="submit" variant="success" class="full-size">Submit</b-button>
                </b-form>
              </div>
            </b-card-text>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
      <div id="spacer"></div>
    </b-container>
    <br/>
  </div>
</template>

<script>
    import API from '../api';
    export default {
      name: "Login",
      data() {
        return {
          loginForm: {
            username: '',
            password: '',
            userID: ''
          },
          showError: false,
          error: ''
        }
      },
      methods: {
        onSubmit(evt) {
          evt.preventDefault();
          this.getUser();
        },

        getUser() {
          API.getUserByUsername(this.loginForm.username).then(response => {
            console.log(response.data);
            if((response.data.username == this.loginForm.username) && (response.data.password == this.loginForm.password)) {
              this.showError = false;
              this.error = '';
              localStorage.setItem('userID', response.data.id);
              window.location.pathname = '/myAccount';
            } else {
              this.error = "Incorrect credentials";
              this.showError = true;
            }
          });
        }
      }
    }
</script>

<style scoped>
  .form {
    box-shadow: 10px 10px 5px grey;
  }

  #spacer {
    height: 300px;
  }

  .full-size {
    width: 100%;
  }
</style>
