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
    export default {
        name: "DeleteAccount",

        data() {
          return  {
            userInfo: {
              userID: '',
              confirmUsername: ''
            },
            showError: false,
            error: ''
          }
        },

        mounted() {
          this.userID = localStorage.getItem('userID');
        },

        methods: {
          onSubmit(evt) {
            evt.preventDefault();
            // call api/user/list to confirm username entered is the username of the account id
            // if so call /api/user delete endpoint
            // else, show error
            console.log(this.userInfo.confirmUsername);
          }
        }
    }
</script>

<style scoped>

</style>
