<template>
  <div class="changePassword">
    <b-container class="changePasswordPageContent">
      <b-row>
        <b-col>
              <div>
                <b-form @submit="onSubmit">
                  <b-form-group id="password" label="New Password:" label-for="password">
                    <b-form-input id="password" type="password" v-model="changePasswordForm.password" required></b-form-input>
                  </b-form-group>

                  <b-form-group id="confirmPassword" label="Confirm New Password:" label-for="confirmPassword">
                    <b-form-input id="confirmPassword" type="password" v-model="changePasswordForm.confirmPassword" required></b-form-input>
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
    import API from '../api';
    export default {
        name: "ChangePassword",

        data() {
          return {
            changePasswordForm: {
              password: '',
              confirmPassword: ''
            },
            userInfo: {
              id: -1,
              firstName: '',
              lastName: '',
              username: '',
              email: ''
            },
            error: '',
            showError: false
          }
        },

        methods: {
          onSubmit(evt) {
            evt.preventDefault();
            if (this.changePasswordForm.password != this.changePasswordForm.confirmPassword) {
              this.error = "Passwords do not match";
              this.showError = true;
            } else {
              this.error = '';
              this.showError = false;
              console.log(this.changePasswordForm.password);
              let changedPassword = {
                firstName: this.userInfo.firstName,
                lastName: this.userInfo.lastName,
                email: this.userInfo.email,
                username: this.userInfo.username,
                password: this.changePasswordForm.password
              };
              API.updateUser(this.userInfo.id, changedPassword).then(response => {
                console.log(response.data);
              });
            }
          }
        }
    }
</script>

<style scoped>
  .full-size {
    width: 100%;
  }
</style>
