<template>
    <b-container>
      <table class="table">
        <tbody>
        <tr class="center">
          <td><img src="../images/gold_square.png"></td>
          <td class="middle">Source selection</td>
        </tr>
        <tr class="center">
          <td><img src="../images/secondClick.png"></td>
          <td class="middle">Destination selection</td>
        </tr>
        <tr class="center">
          <td><img src="../images/green_square.png"></td>
          <td class="middle">Valid moves for selected piece</td>
        </tr>
        <tr class="center">
          <td><img src="../images/flip.png" class="icon"></td>
          <td class="middle">Icon for piece being flipped over</td>
        </tr>
        <tr class="center">
          <td><img src="../images/swords.png" class="icon"></td>
          <td class="middle">Icon for capturing another piece</td>
        </tr>
        <tr class="center">
          <td><img src="../images/reveal.png" class="icon"></td>
          <td class="middle">Icon for an unknown piece to be revealed</td>
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

  .icon {
    width: 45px;
    height: 45px;
  }
</style>
