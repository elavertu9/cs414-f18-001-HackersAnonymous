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
    </b-container>
  </div>
</template>

<script>
    export default {
        name: "LogOut",
        mounted() {
          localStorage.removeItem('username');
          window.location.pathname = "/";
        }
    }
</script>

<style scoped>

</style>
