<template>
  <div class="home">
    <b-container class="homePageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <img src="../images/theA.png" class="homeImage">
        </b-col>
        <b-col></b-col>
      </b-row>
      <br/>
      <b-row>
        <b-col>
          <b-card title="Banqi" class="mb-2 homeCards center">
            <b-card-text>
              Press the button below to check your configuration!
            </b-card-text>
            <b-card-text>Backend response: {{ backendResponse }}</b-card-text>
            <b-button @click="callHelloApi()" variant="primary">Call Backend</b-button>
          </b-card>
        </b-col>
        <b-col>
          <div class="homeCards">
            <b-card v-if="this.userInfo.username != null" class="mb-2 center">
              <b-card-title>Welcome Back, {{this.userInfo.username}}!</b-card-title>
              <b-card-text>
                Select "Game" above or press the button below to play Banqi!
                <br/>
                <br/>
                <b-button @click="goToGame()" variant="primary">Play Banqi</b-button>
              </b-card-text>
            </b-card>
            <b-card v-else title="Welcome" class="mb-2 center">
              <b-card-text>
                Select "Account" above to get started!
              </b-card-text>
            </b-card>
          </div>
        </b-col>
      </b-row>
      <br/>
    </b-container>
  </div>
</template>

<script>
  import API from '../api';
  export default {
    name: "Home",

    mounted() {
      if (localStorage.hasOwnProperty('userID')) {
        this.userInfo.userID = localStorage.getItem('userID');
        this.getUserInfo();
      }
    },

    data() {
      return {
        msg: "HowTo call REST-Services",
        backendResponse: [],
        userInfo: {
          username: '',
          userID: ''
        },
        errors: [],
      }
    },

    methods: {
      callHelloApi() {
        API.hello().then(response => {
          this.backendResponse = response.data;
        });
      },

      getUserInfo() {
        API.getUser(this.userInfo.userID).then(response => {
          this.userInfo.username = response.data.username;
        });
      },

      goToGame() {
        if (localStorage.hasOwnProperty('gameId')) {
          window.location.pathname = "/game";
        } else {
          window.location.pathname = "/gameHome";
        }
      }
    }
  }
</script>

<style scoped>
  .homeImage {
    border-radius: 8px;
    border-style: solid;
    border-width: 8px;
    border-color: #1E4D2B;
  }

  .homeCards {
    box-shadow: 10px 10px 5px grey;
  }

  .center {
    text-align: center;
  }

</style>
