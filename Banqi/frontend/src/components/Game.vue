<template>
  <b-container class="gamePageContent">
    <banqi-board></banqi-board>
  </b-container>
</template>

<script>
    import BanqiBoard from "./BanqiBoard";

    export default {
      name: "Game",
      components: {
        'banqi-board': BanqiBoard
      },
    }
</script>

<style scoped>

</style>
