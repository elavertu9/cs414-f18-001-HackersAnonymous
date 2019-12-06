<template>
  <div class="deleteAccount">
    <b-container class="deleteAccountPageContent">
      <b-row>
        <b-col>
          <div>
            <p>Are you sure you want to delete your account? Please enter your account username below if you wish to continue...</p>
            <b-form @submit="onSubmit">
              <b-form-group id="confirmUsername" label="Confirm account username:" label-for="confirmUsername">
                <b-form-input id="confirmUsername" type="text" v-model="userInfo.confirmUsername" required></b-form-input>
              </b-form-group>
              <br/>
              <b-alert v-if="this.showResponse" show variant="success">{{this.response}}</b-alert>
              <b-alert v-if="this.showError == true" show variant="danger">{{this.error}}</b-alert>
              <b-button type="submit" class="full-size" variant="success">Submit</b-button>
            </b-form>
          </div>
        </b-col>
      </b-row>
    </b-container>
    <br/>
  </div>
</template>

<script>
    import API from '../api';
    export default {
        name: "DeleteAccount",

        data() {
          return  {
            userInfo: {
              userID: '',
              confirmUsername: ''
            },
            showError: false,
            error: '',
            response: '',
            showResponse: ''
          }
        },

        mounted() {
          this.userInfo.userID = localStorage.getItem('userID');
        },

        methods: {
          onSubmit(evt) {
            evt.preventDefault();
            this.checkIDUsername();
          },

          checkIDUsername() {
            API.getUser(this.userInfo.userID).then(response => {
              if(response.data.username == this.userInfo.confirmUsername) {
                this.showError = false;
                this.error = '';
                API.deleteUser(this.userInfo.userID).then(res => {
                  this.response = `Account ${response.data.username} was successfully deleted`;
                  this.showResponse = true;
                  setTimeout(() => {
                    this.showResponse = false;
                    this.response = '';
                    localStorage.removeItem('userID');
                    if (localStorage.hasOwnProperty('gameId')) {
                      localStorage.removeItem('gameId');
                    }
                    window.location.pathname = "/";
                  }, 4000);
                });
              }else{
                this.error = "Incorrect Username";
                this.showError = true;
                this.response = '';
                this.showResponse = false;
              }
            });
          }
        }
    }
</script>

<style scoped>
  .full-size {
    width: 100%;
  }
</style>
