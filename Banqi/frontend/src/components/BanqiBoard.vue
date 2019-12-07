<template>
  <div name="BanqiBoard">
    <b-row>
      <b-col><Loader v-if="loading"></Loader></b-col>
      <b-col class="center"><h1>Banqi Game</h1></b-col>
      <b-col></b-col>
    </b-row>
    <br/>
    <b-row>
      <b-col></b-col>
      <b-col class="center">
        <b-button-group>

          <b-dropdown id="dropdown-1" class="help" variant="primary" text="Help">
            <b-dropdown-item @click="$bvModal.show('legend-modal')">Legend</b-dropdown-item>
            <b-dropdown-item @click="$bvModal.show('rules-modal')">Rules</b-dropdown-item>
          </b-dropdown>
          <b-dropdown id="dropdown-1" class="help" variant="primary" text="Actions">
            <b-dropdown-item @click="clear()">Clear</b-dropdown-item>
            <b-dropdown-item @click="backToGameHome()">Change Game</b-dropdown-item>
          </b-dropdown>

          <b-button @click="moveSubmit()" variant="success" class="toolbar">Submit Move</b-button>
        </b-button-group>
      </b-col>
      <b-col></b-col>
    </b-row>
    <br/>
    <b-row>
      <b-col class="center">
        <h3>Move Preview: </h3>
        <div v-if="selectedSquare.length === 2">
          <p>{{this.selectedSquare[0].row}},{{this.selectedSquare[0].col}} TO {{this.selectedSquare[1].row}},{{this.selectedSquare[1].col}}</p>
        </div>
        <!-- ATTACKER -->

          <!--<img v-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/Pieces/blank_piece.png">-->
          <!--<img v-else-if="move.attacker.type === 'SOLDIER' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Soldier.png">-->
          <!--<img v-else-if="move.attacker.type === 'SOLDIER' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Soldier.png">-->

          <!--<img v-else-if="move.attacker.type === 'ADVISOR' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Advisor.png">-->
          <!--<img v-else-if="move.attacker.type === 'ADVISOR' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Advisor.png">-->

          <!--<img v-else-if="move.attacker.type === 'CANNON' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Cannon.png">-->
          <!--<img v-else-if="move.attacker.type === 'CANNON' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Cannon.png">-->

          <!--<img v-else-if="move.attacker.type === 'CHARIOT' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Chariot.png">-->
          <!--<img v-else-if="move.attacker.type === 'CHARIOT' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Chariot.png">-->

          <!--<img v-else-if="move.attacker.type === 'GENERAL' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_General.png">-->
          <!--<img v-else-if="move.attacker.type === 'GENERAL' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_General.png">-->

          <!--<img v-else-if="move.attacker.type === 'HORSE' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Horse.png">-->
          <!--<img v-else-if="move.attacker.type === 'HORSE' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Horse.png">-->

          <!--<img v-else-if="move.attacker.type === 'MINSTER' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Elephant.png">-->
          <!--<img v-else-if="move.attacker.type === 'MINSTER' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Elephant.png">-->

          <!--<img v-else-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/Pieces/blank_piece.png">-->
          <!--<div v-else></div>-->



          <!--<img v-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/flip.png" class="icon">-->
          <!--<img v-else src="../images/swords.png" class="icon">-->


        <!--&lt;!&ndash; CAPTURED &ndash;&gt;-->

          <!--<img v-if="move.captured.type == 'SOLDIER' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png">-->
          <!--<img v-else-if="move.captured.type == 'SOLDIER' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png">-->

          <!--<img v-else-if="move.captured.type == 'ADVISOR' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png">-->
          <!--<img v-else-if="move.captured.type == 'ADVISOR' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png">-->

          <!--<img v-else-if="move.captured.type == 'CANNON' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png">-->
          <!--<img v-else-if="move.captured.type == 'CANNON' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png">-->

          <!--<img v-else-if="move.captured.type == 'CHARIOT' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png">-->
          <!--<img v-else-if="move.captured.type == 'CHARIOT' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png">-->

          <!--<img v-else-if="move.captured.type == 'GENERAL' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_General.png">-->
          <!--<img v-else-if="move.captured.type == 'GENERAL' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_General.png">-->

          <!--<img v-else-if="move.captured.type == 'HORSE' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png">-->
          <!--<img v-else-if="move.captured.type == 'HORSE' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png">-->

          <!--<img v-else-if="move.captured.type == 'MINSTER' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png">-->
          <!--<img v-else-if="move.captured.type == 'MINSTER' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png">-->

          <!--<div v-else></div>-->

      </b-col>
    </b-row>
    <br/>
    <b-row>

      <!-- PLAYER 1 CARD -->
      <b-col>
        <b-card class="player-cards">
          <b-card-title class="center">{{this.player1.username}}</b-card-title>
          <b-card-text>
            Player 1 data to be placed here
          </b-card-text>
        </b-card>
      </b-col>

      <b-col>
        <div class="board-wrapper">
          <div id="board">
            <table class="board-table">
              <tbody>
              <tr>
                <td v-for="(i, index) in this.row1" v-bind:class="getClass(index, 1)" @click="clicked(0, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row2" v-bind:class="getClass(index, 2)" @click="clicked(1, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row3" v-bind:class="getClass(index, 3)" @click="clicked(2, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row4" v-bind:class="getClass(index, 4)" @click="clicked(3, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </b-col>

      <!-- PLAYER 2 CARD -->
      <b-col>
        <b-card class="player-cards">
          <b-card-title class="center">{{this.player2.username}}</b-card-title>
          <b-card-text>
            Player 2 data to be placed here
          </b-card-text>
        </b-card>
      </b-col>
    </b-row>
    <br/>
    <b-row>
      <b-col class="center">
        <h3>Move History</h3>
      </b-col>
    </b-row>
    <b-row>
      <br/>
      <b-card class="shadow full-size">
        <table class="table table-hover white-text">
          <tbody v-if="noHistory == false">
          <tr v-for="(move, index) in moveHistory">
            <td>
              {{moveHistory.length - index}}
            </td>

            <!-- ATTACKER -->
            <td class="center">
              <img v-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/Pieces/blank_piece.png">
              <img v-else-if="move.attacker.type === 'SOLDIER' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Soldier.png">
              <img v-else-if="move.attacker.type === 'SOLDIER' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Soldier.png">

              <img v-else-if="move.attacker.type === 'ADVISOR' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Advisor.png">
              <img v-else-if="move.attacker.type === 'ADVISOR' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Advisor.png">

              <img v-else-if="move.attacker.type === 'CANNON' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Cannon.png">
              <img v-else-if="move.attacker.type === 'CANNON' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Cannon.png">

              <img v-else-if="move.attacker.type === 'CHARIOT' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Chariot.png">
              <img v-else-if="move.attacker.type === 'CHARIOT' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Chariot.png">

              <img v-else-if="move.attacker.type === 'GENERAL' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_General.png">
              <img v-else-if="move.attacker.type === 'GENERAL' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_General.png">

              <img v-else-if="move.attacker.type === 'HORSE' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Horse.png">
              <img v-else-if="move.attacker.type === 'HORSE' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Horse.png">

              <img v-else-if="move.attacker.type === 'MINSTER' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Elephant.png">
              <img v-else-if="move.attacker.type === 'MINSTER' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Elephant.png">

              <img v-else-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/Pieces/blank_piece.png">
              <div v-else></div>
            </td>

            <td>
              <img v-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/flip.png" class="icon">
              <img v-else src="../images/swords.png" class="icon">
            </td>

            <!-- CAPTURED -->
            <td>
              <img v-if="move.captured.type == 'SOLDIER' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png">
              <img v-else-if="move.captured.type == 'SOLDIER' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png">

              <img v-else-if="move.captured.type == 'ADVISOR' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png">
              <img v-else-if="move.captured.type == 'ADVISOR' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png">

              <img v-else-if="move.captured.type == 'CANNON' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png">
              <img v-else-if="move.captured.type == 'CANNON' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png">

              <img v-else-if="move.captured.type == 'CHARIOT' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png">
              <img v-else-if="move.captured.type == 'CHARIOT' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png">

              <img v-else-if="move.captured.type == 'GENERAL' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_General.png">
              <img v-else-if="move.captured.type == 'GENERAL' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_General.png">

              <img v-else-if="move.captured.type == 'HORSE' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png">
              <img v-else-if="move.captured.type == 'HORSE' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png">

              <img v-else-if="move.captured.type == 'MINSTER' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png">
              <img v-else-if="move.captured.type == 'MINSTER' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png">

              <div v-else></div>
            </td>
          </tr>
          </tbody>
          <tbody v-else>

          </tbody>
        </table>
      </b-card>
    </b-row>
    <br/>
    <br/>

    <!-- LEGEND MODAL -->
    <div>
      <b-modal id="legend-modal" hide-footer>
        <template v-slot:modal-title>
          Legend
        </template>
        <Legend></Legend>
        <b-button class="mt-3" variant="danger" block @click="$bvModal.hide('legend-modal')">Exit</b-button>
      </b-modal>
    </div>

    <!-- RULES MODAL -->
    <div>
      <b-modal id="rules-modal" size="lg" hide-footer>
        <template v-slot:modal-title>
          Rules
        </template>
        <BanqiRules></BanqiRules>
        <b-button class="mt-3" variant="danger" block @click="$bvModal.hide('rules-modal')">Exit</b-button>
      </b-modal>
    </div>
  </div>
</template>

<script>
    import API from '../api';
    import Legend from "./Legend";
    import BanqiRules from "./BanqiRules";
    import Loader from './Loader';

    export default {
      components: {
        Loader,
        Legend,
        BanqiRules
      },

      created() {
        console.log("Getting game board instance from backend");
      },

      mounted() {
        this.player1.userID = localStorage.getItem('userID');
        this.selectedSquare = [];
        this.getGame();
        this.getHistory()
      },

      name: "BanqiBoard",

      data() {
        return {
          gameId: '',
          board: [
            {
              piece: {
                type: "",
                teamColor: "",
                faceUp: true
              },
              coordinate: {
                row: 0,
                column: 0
              },
             }
          ],
          // [0] = 1st click, [1] = 2nd click
          selectedSquare: [{
            row: 9,
            col: 9,
            faceUp: false
          }],
          errors: [],
          player1: {
            userID: '',
            username: ''
          },
          player2: {
            userID: '',
            username: ''
          },
          loading: false,
          validMoves: [
            {
              row: 9,
              column: 9
            }
          ],
          noHistory: true,
          moveHistory: [
            {
              gameId: "",
              origin: {
                row: 9,
                column: 9
              },
              destination: {
                row: 9,
                column: 9
              },
              attacker: {
                type: "",
                teamColor: "",
                faceUp: false
              },
              captured: {
                type: "",
                teamColor: "",
                faceUp: false
              },
              moveType: "",
              executed: false,
              validMove: false
            }
          ]
        }
      },

      methods: {
        getGame() {
          if(localStorage.hasOwnProperty('gameId')) {
              this.gameId = localStorage.getItem('gameId');
              API.getExistingGame(this.gameId).then(response => {
                 this.board = response.data.board.board;
                 this.player1.userID = response.data.playerOneId;
                 this.player2.userID = response.data.playerTwoId;
                 this.getPlayerInfo();
                 this.loading = false;
              });
          }
        },

        getHistory() {
          API.getMoveHistory(this.gameId).then(response => {
            if (response.data != "No Move History Yet") {
              this.noHistory = false;
              this.moveHistory = response.data;
              this.reverseArray();
            } else {
              this.noHistory = true;
            }
          });
        },

        getPlayerInfo() {
          // Assign player 1
          API.getUser(this.player1.userID).then(response => {
            let user1 = {
              userID: response.data.id,
              username: response.data.username
            };
            this.player1 = user1;
          });

          // Assign player 2
          API.getUser(this.player2.userID).then(response => {
            let user2 = {
              userID: response.data.id,
              username: response.data.username
            };
            this.player2 = user2;
          });
        },

        getClass(index, row) {
          let clicks = this.selectedSquare.length;
          let isValid = false;
          let isFirstClick = false;
          let isSecondClick = false;

          for(let i in this.validMoves) {
            if ((this.validMoves[i].row === row - 1) && (this.validMoves[i].column === index)) {
              isValid = true;
            }
          }

          if (clicks < 1) {
            if (row % 2 == 0) {
              if (index % 2 == 0) {
                return "orange_square";
              } else {
                return "black_square";
              }
            } else {
              if (index % 2 == 0) {
                return "black_square";
              } else {
                return "orange_square";
              }
            }
          } else if (clicks == 1) {
            if (index === this.selectedSquare[0].col && row - 1 === this.selectedSquare[0].row) {
              isFirstClick = true;
            }
          } else {
            if (index === this.selectedSquare[0].col && row - 1 === this.selectedSquare[0].row) {
              isFirstClick = true;
            }
            if (index === this.selectedSquare[1].col && row - 1 === this.selectedSquare[1].row) {
              isSecondClick = true;
            }
          }

          if (!isValid && !isFirstClick && !isSecondClick) {
            if (row % 2 == 0) {
              if (index % 2 == 0) {
                return "orange_square";
              } else {
                return "black_square";
              }
            } else {
              if (index % 2 == 0) {
                return "black_square";
              } else {
                return "orange_square";
              }
            }
          } else {
            if (isValid && isSecondClick) {
              return "second_click";
            } else if (isValid && isFirstClick) {
              return "selected_square";
            } else if (!isValid && isFirstClick) {
              return "selected_square";
            } else {
              if (isValid && clicks < 2) {
                return "valid_square";
              } else {
                if (row % 2 == 0) {
                  if (index % 2 == 0) {
                    return "orange_square";
                  } else {
                    return "black_square";
                  }
                } else {
                  if (index % 2 == 0) {
                    return "black_square";
                  } else {
                    return "orange_square";
                  }
                }
              }
            }
          }

        },

        moveSubmit() {
          this.loading = true;
          // if the piece is not face up yet, flip it
          if (this.selectedSquare.faceUp == false) {
            this.flipPiece();
          }

        },

        flipPiece() {
          let flip = {
            gameId: this.gameId,
            origin: {
              row: this.selectedSquare.row,
              column: this.selectedSquare.col
            },
            destination: {
              row: this.selectedSquare.row,
              column: this.selectedSquare.col
            }
          };
          API.executeMove(flip, this.gameId).then((response) => {
            this.getGame();
            this.getHistory();
          });
        },

        backToGameHome() {
          localStorage.removeItem('gameId');
          window.location.pathname = "/gameHome";
        },

        clicked(row, col) {
          let selected = {
            row: row,
            col: col,
            faceUp: false
          };

          // Get board slice for selected row
          if (row == 0) {
            selected.faceUp = this.row1[col].piece.faceUp;
          } else if (row == 1) {
            selected.faceUp = this.row2[col].piece.faceUp;
          } else if(row == 2) {
            selected.faceUp = this.row3[col].piece.faceUp;
          }else if(row == 3) {
            selected.faceUp = this.row4[col].piece.faceUp;
          } else {
            console.log("Invalid Selection");
          }
          // fist click and second click
          if (this.selectedSquare.length <= 1) {
            if (this.selectedSquare.length < 1) {
              this.selectedSquare.push(selected);
            } else {
              let isValid = false;
              for (let i in this.validMoves) {
                if (this.validMoves[i].row === selected.row && this.validMoves[i].column === selected.col) {
                  isValid = true;
                }
              }

              if (this.selectedSquare.length === 1 && isValid) {
                this.selectedSquare.push(selected);
              } else  {
                this.selectedSquare = [];
                this.selectedSquare.push(selected);
              }
            }
          } else {
            if (this.selectedSquare.length == 2) {
              this.selectedSquare = [];
              this.selectedSquare.push(selected);
            }
          }

          this.getValidMoves();
        },

        getValidMoves() {
          this.validMoves = [];
          let selected = {
            row: this.selectedSquare[0].row,
            column: this.selectedSquare[0].col
          };
          API.getValidMoves(selected, this.gameId).then(response => {
            if (response.data != "No Valid Moves Found") {
              this.validMoves = response.data;
            }
          });
        },

        reverseArray() {
          let temp = this.moveHistory;
          let sorted = [];
          for (let i in temp) {
            sorted[i] = temp[temp.length - 1 - i];
          }
          this.moveHistory = sorted;
        },

        clear() {
          let clear = {
            row: 9,
            col: 9,
            faceUp: false
          };
          this.selectedSquare = clear;
          this.validMoves = [];
        }
      },

      computed: {
        row1() {
          return this.board.slice(0, 8);
        },

        row2() {
          return this.board.slice(8, 16);
        },

        row3() {
          return this.board.slice(16, 24);
        },

        row4() {
          return this.board.slice(24, 33);
        }
      }
    }
</script>

<style scoped>
  .orange_square {
    width: 75px;
    height: 75px;
    background-color: #d2b48c;
  }

  .second_click {
    width: 75px;
    height: 75px;
    background-color: #008000;
  }

  .black_square {
    width: 75px;
    height: 75px;
    background-color: #59595B;
  }

  .selected_square {
    width: 75px;
    height: 75px;
    background-color: #FFD700;
  }

  .valid_square {
    width: 75px;
    height: 75px;
    background-color: #7FFF00;
  }

  .board-wrapper {
    position: relative;
    width: 600px;
    height: auto;
    text-align: center;
    margin: auto;
  }

  #board {
    position: absolute;
    top: 0;
    border-style: solid;
    border-width: 8px;
    border-color: black;
  }

  .board-table {
    cellpadding: 0px;
    cellspacing: 0px;
  }

  .player-cards {
    height: 300px;
    background-color: #1E4D2B;
    color: white;
    box-shadow: 10px 10px 5px grey;
  }

  .center {
    text-align: center;
  }

  .toolbar {
    margin-left: 5px;
    margin-right: 5px;
    width: 150px;
    border-radius: 12px;
  }

  .shadow {
    background-color: #1E4D2B;
    color: white;
  }

  .white-text {
    color: white;
  }

  .full-size {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
    height: 400px;
    overflow: scroll;
  }

  .icon {
    width: 20%;
    height: 20%;
    display: block;
    margin-left: auto;
    margin-right: auto;
  }

  .help {
    margin-left: 5px;
    margin-right: 5px;
    width: 150px;
    border-right: 12px;
  }
</style>
