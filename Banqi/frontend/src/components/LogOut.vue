<template>
  <div class="logOut">
    <b-container class="logOutPageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card title="Log Out" class="mb-2">
            <b-card-text>
              Logging out...
            </b-card-text>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
      <div id="spacer"></div>
    </b-container>
  </div>
</template>

<script>
    export default {
        name: "LogOut",
        mounted() {
          localStorage.removeItem('userID');
          setTimeout(() => {
              window.location.pathname = "/";
          }, 1500);
        }
    }
</script>

<style scoped>
  #spacer {
    height: 500px;
  }
</style>
