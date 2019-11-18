<template>
    <b-container>
      <table class="table">
        <tbody>
        <tr class="center">
          <td><img src="../images/gold_square.png"></td>
          <td class="middle">Currently selected piece</td>
        </tr>
        <tr class="center">
          <td><img src="../images/green_square.png"></td>
          <td class="middle">Valid moves for selected piece</td>
        </tr>
        </tbody>
      </table>
    </b-container>
</template>

<script>
    export default {
        name: "Legend"
    }
</script>

<style scoped>
  .middle {
    vertical-align: middle;
  }
</style>
