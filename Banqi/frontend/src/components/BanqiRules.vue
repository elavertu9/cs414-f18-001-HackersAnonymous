<template>
  <b-container>
    <h2><b>Piece Descriptions</b></h2>
    <table class="table table-hover">
      <thead>
        <tr class="center">
          <td></td>
          <td><h5>Rank</h5></td>
          <td><h5>Count</h5></td>
          <td><h5>Name</h5></td>
          <td><h5>Ability</h5></td>
        </tr>
      </thead>
      <tbody>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_General.png"></td>
          <td class="middle">7</td>
          <td class="middle">x1</td>
          <td class="middle-left">General</td>
          <td class="middle-left">The highest ranked piece. The General can capture every piece except the Soldier.</td>
        </tr>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_Chariot.png"></td>
          <td class="middle">6</td>
          <td class="middle">x2</td>
          <td class="middle-left">Chariot</td>
          <td class="middle-left">The Chariot can capture every piece except the General.</td>
        </tr>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_Horse.png"></td>
          <td class="middle">5</td>
          <td class="middle">x2</td>
          <td class="middle-left">Horse</td>
          <td class="middle-left">The Horse can capture every piece except the General and the Chariot.</td>
        </tr>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_Cannon.png"></td>
          <td class="middle">4</td>
          <td class="middle">x2</td>
          <td class="middle-left">Cannon</td>
          <td class="middle-left">The Cannon can capture every piece except the General, Chariot, and Horse pieces.</td>
        </tr>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_Advisor.png"></td>
          <td class="middle">3</td>
          <td class="middle">x2</td>
          <td class="middle-left">Advisor</td>
          <td class="middle-left">The Advisor can capture other Advisors, Elephants, and Soldiers.</td>
        </tr>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_Elephant.png"></td>
          <td class="middle">2</td>
          <td class="middle">x2</td>
          <td class="middle-left">Elephant</td>
          <td class="middle-left">The Elephant can capture other Elephants and Soldiers.</td>
        </tr>
        <tr class="center">
          <td class="middle"><img src="../images/Pieces/White_Soldier.png"></td>
          <td class="middle">1</td>
          <td class="middle">x5</td>
          <td class="middle-left">Soldier</td>
          <td class="middle-left">The Soldier can capture other Soldiers and the General.</td>
        </tr>
      </tbody>
    </table>
    <h3><b>How to play</b></h3>
    <br/>
    <h5><b>Teams</b></h5>
    <p>Player 1 is on team RED, player 2 is on team BLACK.</p>
    <br/>
    <h5><b>Start</b></h5>
    <p>The first player begins by flipping over any piece on the board. Player 2 will then begin their
      first turn by flipping over any other piece on the board.</p>
    <br/>
    <h5><b>Moving pieces</b></h5>
    <p>All pieces can move up, down, left, and right as long as there is an empty square to move to,
      or the piece that is occupying the square can be legally captured. A piece must be flipped over before
    it can be moved.</p>
    <br/>
    <h5><b>Win conditions</b></h5>
    <ul>
      <li>A player successfully captures all of their opponents pieces.</li>
      <li>A player can force their opponent into a position where they can no longer make any moves.</li>
    </ul>
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

  .middle-left {
    vertical-align: middle;
    text-align: left;
  }
</style>
