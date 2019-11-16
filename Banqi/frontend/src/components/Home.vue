<template>
  <div class="home">
    <b-container class="homePageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card v-if="this.userInfo.username != null" class="mb-2">
            <b-card-title>Welcome Back, {{this.userInfo.username}}!</b-card-title>
            <b-card-text>
              Select "Game" above to play Banqi!
            </b-card-text>
          </b-card>
          <b-card v-else title="Welcome" class="mb-2">
            <b-card-text>
              Select "Account" above to get started!
            </b-card-text>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card title="Banqi" class="mb-2">
            <b-card-text>
              Press the button below to check your configuration!
            </b-card-text>
            <b-card-text>Backend response: {{ backendResponse }}</b-card-text>
            <b-button @click="callHelloApi()" variant="primary">Call Backend</b-button>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
  import API from '../api';
  export default {
    name: "Home",
    mounted() {
      this.userInfo.username = localStorage.getItem('username');
    },
    data() {
      return {
        msg: "HowTo call REST-Services",
        backendResponse: [],
        userInfo: {
          username: ''
        },
        errors: [],
      }
    },
    methods: {
      callHelloApi() {
        API.hello().then(response => {
          this.backendResponse = response.data;
          console.log(response.data);
        })
        .catch(error => {
          this.errors.push(error);
        })
      },

      getCardTitle() {
        return "Welcome Back, " + this.userInfo.username + "!";
      }
    }
  }
</script>

<style scoped>

</style>
