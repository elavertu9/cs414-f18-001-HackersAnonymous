<template>
  <div class="AppHeader">
    <b-navbar toggleable="lg" class="navbar-color">
      <b-navbar-brand class="brand-size" href="#">
        <img class="logo-size" src="../images/ramsLogo.png" alt="CSU">
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item>
            <router-link class="normalLinks" to="/">Home</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link class="normalLinks" to="/about">About</router-link>
          </b-nav-item>
          <b-nav-item v-if="this.signedIn">
            <router-link v-if="this.gameLoaded" class="normalLinks" to="/game">Game</router-link>
            <router-link v-else class="normalLinks" to="/gameHome">Game</router-link>
          </b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav v-if="this.signedIn" class="ml-auto">
          <b-nav-item-dropdown  class="normalLinks" right>
            <template v-slot:button-content>
              <em class="normalLinks">{{username}}</em>
            </template>
            <b-dropdown-item class="dropDownLinks" href="/myAccount">Profile</b-dropdown-item>
            <b-dropdown-item v-if="authenticated" class="dropDownLinks" href="/admin">Admin</b-dropdown-item>
            <b-dropdown-item class="dropDownLinks" href="/logOut">Log Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
        <b-navbar-nav v-else class="ml-auto">
          <b-nav-item right>
            <router-link class="normalLinks" to="/account">Account</router-link>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
    import API from '../api';
    export default {
      name: "AppHeader",
      data() {
        return {
          signedIn: false,
          gameLoaded: false,
          userID: '',
          username: '',
          authenticated: false
        }
      },
      mounted() {
        if(localStorage.hasOwnProperty('userID')) {
          this.signedIn = true;
          this.userID = localStorage.getItem('userID');
          this.getUserInfo();
        } else {
          this.signedIn = false;
          this.userID = '';
        }

        if(localStorage.hasOwnProperty('gameId')) {
          this.gameLoaded = true;
        } else {
          this.gameLoaded = false;
        }
      },

      methods: {
        getUserInfo() {
          API.getUser(this.userID).then(response => {
            this.username = response.data.username;
            // Add other admin account checks here
            if (this.username == "elavertu9" || this.username == "crcolema" || this.username == "jack" || this.username == "pkeleher" || this.username == "kareem21") {
              this.authenticated = true;
            } else {
              this.authenticated = false;
            }
          });
        }
      }
    }
</script>

<style scoped>
  .logo-size {
    width: 50%;
    height: 50%;
  }

  .brand-size {
    width: 5%;
  }

  .normalLinks {
    font-size: 24px;
    text-decoration: none;
    color: white;
  }

  .dropDownLinks {
    font-size: 20px;
  }

  .normalLinks:hover {
    color: #FE5000;
  }

  .navbar-color {
    background-color: #1E4D2B;
  }

  .AppHeader {
    padding-bottom: 25px;
  }
</style>
