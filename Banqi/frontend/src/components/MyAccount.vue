<template>
  <div class="myAccount">
    <b-container class="myAccountPageContent">
      <b-row>
        <b-col>
          <b-card title="Recent Games" class="shadow center">
            <table class="table">
              <thead>
                <th>Players</th>
                <th>Result</th>
              </thead>
              <tbody>
                <tr>
                  <td>{{this.userInfo.username}} vs. Player 2</td>
                  <td>Win</td>
                </tr>
                <tr>
                  <td>{{this.userInfo.username}} vs. Player 2</td>
                  <td>Loss</td>
                </tr>
              </tbody>
            </table>
          </b-card>
        </b-col>
        <b-col>
          <b-card title="My Account" class="shadow center">
            <h2><b>{{this.userInfo.username}}</b></h2>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
    <br/>6
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
  .shadow {
    box-shadow: 10px 10px 5px grey;
  }

  .center {
    text-align: center;
  }
</style>
