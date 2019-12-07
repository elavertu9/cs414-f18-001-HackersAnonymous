<template>
    <p>
      <h3><b>How to play</b></h3>
      <br/>
      <h5><b>Start</b></h5>
      <p> The first player begins by flipping any piece on the board over. the color of the first flipped over piece
      will be assigned to player 1, and player 2 will be assigned to the opposing team. Player 2 will then begin their
        first turn by flipping over any piece on the board.</p>
      <br/>
      <h5><b>Moving pieces</b></h5>
      <p>All pieces can move up, down, left, and right as long as there is an empty square to move to,
        or the piece that is occupying the square can be legally captured</p>
      <br/>
      <h5><b>Win conditions</b></h5>
      <ul>
        <li>A player successfully captures all of their opponents pieces.</li>
        <li>A player can force their opponent into a position where they can no longer make any moves</li>
      </ul>
      <table class="table table-hover">
        <thead>
          <tr class="center">
            <td></td>
            <td><h5>Rank</h5></td>
            <td><h5>Name</h5></td>
            <td><h5>Ability</h5></td>
          </tr>
        </thead>
        <tbody>
          <tr class="center">
            <td><img src="../images/Pieces/White_General.png"></td>
            <td>7</td>
            <td class="middle">General</td>
            <td class="middle">Blah</td>
          </tr>
          <tr class="center">
            <td><img src="../images/Pieces/White_Chariot.png"></td>
            <td>6</td>
            <td class="middle">Chariot</td>
            <td class="middle">Blah</td>
          </tr>
          <tr class="center">
            <td><img src="../images/Pieces/White_Horse.png"></td>
            <td>5</td>
            <td class="middle">Horse</td>
            <td class="middle">Blah</td>
          </tr>
          <tr class="center">
            <td><img src="../images/Pieces/White_Cannon.png"></td>
            <td>4</td>
            <td class="middle">Cannon</td>
            <td class="middle">Blah</td>
          </tr>
          <tr class="center">
            <td><img src="../images/Pieces/White_Advisor.png"></td>
            <td>3</td>
            <td class="middle">Advisor</td>
            <td class="middle">Blah</td>
          </tr>
          <tr class="center">
            <td><img src="../images/Pieces/White_Elephant.png"></td>
            <td>2</td>
            <td class="middle">Elephant</td>
            <td class="middle">Blah</td>
          </tr>
          <tr class="center">
            <td><img src="../images/Pieces/White_Soldier.png"></td>
            <td>1</td>
            <td class="middle">Soldier</td>
            <td class="middle">Blah</td>
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
