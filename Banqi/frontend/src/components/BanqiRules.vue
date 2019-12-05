<template>
    <b-container>
      <table class="table">
        <thead>
        <tr class="center">
          <td></td>
          <td><h5>Name</h5></td>
          <td><h5>Ability</h5></td>
        </tr>
        </thead>
        <tbody>
        <tr class="center">
          <td><img src="../images/Pieces/White_Advisor.png"></td>
          <td class="middle">Advisor</td>
          <td class="middle">A piece may never move onto a square that is already occupied unless such a move is a legal capture. This is true for all pieces. Can move one space left, right, up, or down. Pieces of the opposite color that can be captured are advisor, elephant, chariot, horse, soldier and cannon.</td>
        </tr>
        <tr class="center">
          <td><img src="../images/Pieces/White_Soldier.png"></td>
          <td class="middle">Soldier</td>
          <td class="middle">Can move one space left, right, up, or down. Can capture soliders, general, and cannons of the opposite color.</td>
        </tr>
        <tr class="center">
          <td><img src="../images/Pieces/White_General.png"></td>
          <td class="middle">General</td>
          <td class="middle">Can move one space left, right, up, or down. Can capture any other piece of the opposite color but soliders.</td>
        </tr>
        <tr class="center">
          <td><img src="../images/Pieces/White_Elephant.png"></td>
          <td class="middle">Elephant</td>
          <td class="middle">Can move one space left, right, up, or down. Can capture elephants, chariots, horses, soldiers, and cannons of the opposite color.</td>
        </tr>
        <tr class="center">
          <td><img src="../images/Pieces/White_Cannon.png"></td>
          <td class="middle">Cannon</td>
          <td class="middle">Can move one space left, right, up, or down. Can only capture cannons of the opposite color.</td>
        </tr>
        <tr class="center">
          <td><img src="../images/Pieces/White_Chariot.png"></td>
          <td class="middle">Chariot</td>
          <td class="middle">Can move one space left, right, up, or down. Can capture chariots, horses, soldiers, and cannons of the opposite color.</td>
        </tr>
        <tr class="center">
          <td><img src="../images/Pieces/White_Horse.png"></td>
          <td class="middle">Horse</td>
          <td class="middle">Can move one space left, right, up, or down. Can capture horses, soldiers, and cannos of the opposite color.</td>
        </tr>
        </tbody>
      </table>
    </b-container>
</template>

<script>
    export default {
        name: "Rules"
    }
</script>

<style scoped>
  .center {
    text-align: center;
  }

  .middle {
    vertical-align: middle;
  }
</style>
