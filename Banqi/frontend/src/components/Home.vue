<template>
  <div class="home">
    <b-container class="homePageContent">
      <b-row>
        <b-col></b-col>
        <b-col>
          <b-card title="Banqi" style="max-width: 20rem;" class="mb-2">
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
    data() {
      return {
        msg: "HowTo call REST-Services",
        backendResponse: [],
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
      }
    }
  }
</script>

<style scoped>

</style>
