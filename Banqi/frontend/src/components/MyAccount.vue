<template>
  <div class="myAccount">
    <b-container class="myAccountPageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card title="My Account" style="max-width: 20rem;" class="mb-2">
            <b-card-text>
              Welcome to your account, {{this.userInfo.username}}!
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
      name: "MyAccount",
      data() {
        return {
          userInfo: {
            username: ''
          }
        }
      },
      mounted() {
        this.userInfo.username = localStorage.getItem('username');
      }
    }
</script>

<style scoped>

</style>
