<template>
  <div name="BanqiBoard">
    <b-row>
      <b-col></b-col>
      <b-col class="center"><h1>Banqi Game</h1></b-col>
      <b-col></b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col class="center"><b-button @click="moveSubmit()" variant="primary">Submit Move</b-button></b-col>
      <b-col></b-col>
    </b-row>
    <br/>
    <b-row>
      <b-col>
        <b-card class="player-cards">
          <b-card-title>{{this.players.player1}}</b-card-title>
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
                  <img v-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row2" v-bind:class="getClass(index, 2)" @click="clicked(1, index)">
                  <img v-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row3" v-bind:class="getClass(index, 3)" @click="clicked(2, index)">
                  <img v-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row4" v-bind:class="getClass(index, 4)" @click="clicked(3, index)">
                  <img v-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece == 'SOLDIER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece == 'ADVISOR' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece == 'CANNON' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece == 'CHARIOT' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece == 'GENERAL' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece == 'HORSE' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece == 'MINSTER' && i.faceUp && i.color == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </b-col>
      <b-col>
        <b-card title="Player 2" class="player-cards">
          <b-card-text>
            Player 2 data to be placed here
          </b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
    import API from '../api';

    export default {
      created() {
        console.log("Getting game board instance from backend");
        this.getBoardApi();
      },
      updated() {
        console.log("Testing");
        this.board[0].faceUp = true;
        this.board[0].piece = "SOLDIER";
        this.board[0].color = "RED";
        for (let i in this.row1) {
          this.row1[i].faceUp = true;
        }
        for (let i in this.row2) {
          this.row2[i].faceUp = true;
        }
        for (let i in this.row3) {
          this.row3[i].faceUp = true;
        }
        for (let i in this.row4) {
          this.row4[i].faceUp = true;
        }
      },
      mounted() {
        this.players.player1 = localStorage.getItem('username');
      },

      name: "BanqiBoard",

      data() {
        return {
          board: [
            {
             piece: "",
             color: "",
             coordinate: {
               row: "",
               column: ""
             },
             faceUp: false
            }
          ],
          selectedSquare: {
            row: 9,
            col: 9
          },
          errors: [],
          players: {
            player1: '',
            player2: ''
          }
        }
      },

      methods: {

        getBoardApi() {
          API.getBoard().then(response => {
            this.board = response.data;
          })
          .catch(error => {
            this.errors.push(error);
          })
        },

        getClass(index, row) {
          if (index == this.selectedSquare.col && row - 1 == this.selectedSquare.row) {
            return "selected_square";
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
        },

        moveSubmit() {
          console.log("Move Submitted");
        },

        clicked(row, col) {
          console.log(row, col);
          let selected = {
            row: row,
            col: col
          };
          this.selectedSquare = selected;
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

  .black_square {
    width: 75px;
    height: 75px;
    background-color: #59595B;
  }

  .selected_square {
    width: 75px;
    height: 75px;
    background-color: gold;
  }

  .board-wrapper {
    position: relative;
    width: 600px;
    height: 600px;
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
  }

  .center {
    text-align: center;
  }
</style>
