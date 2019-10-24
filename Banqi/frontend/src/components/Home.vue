<template>
  <div class="home">
    <h1 id="title">Banqi</h1>
    <button @click="callHelloApi()">CALL Spring Boot REST backend service</button>
    <h4>Backend response: {{ backendResponse }}</h4>
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
