<template>
  <div class="login">
    <b-container class="loginPageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card title="Login" style="max-width: 20rem;" class="mb-2">
            <b-card-text>
              <div>
                <b-form @submit="onSubmit">
                  <b-form-group id="username" label="Username:" label-for="username">
                    <b-form-input id="username" v-model="loginForm.username" required></b-form-input>
                  </b-form-group>
                  <b-form-group id="password" label="Password:" label-for="password">
                    <b-form-input id="password" type="password" v-model="loginForm.password" required></b-form-input>
                  </b-form-group>
                  <b-button type="submit" variant="success" style="width:100%;">Submit</b-button>
                </b-form>
              </div>
            </b-card-text>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
    <br/>
  </div>
</template>

<script>
    export default {
      name: "Login",
      data() {
        return {
          loginForm: {
            username: '',
            password: ''
          }
        }
      },
      methods: {
        onSubmit(evt) {
          evt.preventDefault();
          console.log(this.loginForm.username);
          console.log(this.loginForm.password);
        }
      }
    }
</script>

<style scoped>

</style>
