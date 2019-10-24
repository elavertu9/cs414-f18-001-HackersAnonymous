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
            <router-link class="normalLinks" to="/game">Game</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link class="normalLinks" to="/about">About</router-link>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
    export default {
        name: "AppHeader"
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
