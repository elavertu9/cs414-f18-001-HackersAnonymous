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
          <b-button @click="moveSubmit()" variant="success" class="toolbar">Submit Move</b-button>
          <b-button @click="clear()" variant="primary" class="toolbar">Clear Selection</b-button>
          <b-button @click="$bvModal.show('legend-modal')" variant="primary" class="toolbar">Legend</b-button>
          <b-button @click="$bvModal.show('rules-modal')" variant="primary" class="toolbar">Rules</b-button>
          <b-button @click="backToGameHome()" variant="primary" class="toolbar">Change Game</b-button>
        </b-button-group>
      </b-col>
      <b-col></b-col>
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
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row2" v-bind:class="getClass(index, 2)" @click="clicked(1, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row3" v-bind:class="getClass(index, 3)" @click="clicked(2, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

                  <img v-else src="../images/Pieces/blank_piece.png">
                </td>
              </tr>
              <tr>
                <td v-for="(i, index) in this.row4" v-bind:class="getClass(index, 4)" @click="clicked(3, index)">
                  <img v-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Soldier.png">
                  <img v-else-if="i.piece.type == 'SOLDIER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Soldier.png">

                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Advisor.png">
                  <img v-else-if="i.piece.type == 'ADVISOR' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Advisor.png">

                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Cannon.png">
                  <img v-else-if="i.piece.type == 'CANNON' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Cannon.png">

                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Chariot.png">
                  <img v-else-if="i.piece.type == 'CHARIOT' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Chariot.png">

                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_General.png">
                  <img v-else-if="i.piece.type == 'GENERAL' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_General.png">

                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Horse.png">
                  <img v-else-if="i.piece.type == 'HORSE' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Horse.png">

                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'RED'" src="../images/Pieces/White_Elephant.png">
                  <img v-else-if="i.piece.type == 'MINSTER' && i.piece.faceUp && i.piece.teamColor == 'BLACK'" src="../images/Pieces/Black_Elephant.png">

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
      <b-modal id="rules-modal" hide-footer>
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
        this.getGame();
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
          selectedSquare: {
            row: 9,
            col: 9,
            faceUp: false
          },
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
          for(let i in this.validMoves) {
            if ((this.validMoves[i].row == row - 1) && (this.validMoves[i].column == index)) {
              return "valid_square";
            }
          }
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

          this.selectedSquare = selected;

          this.getValidMoves();
        },

        getValidMoves() {
          this.validMoves = [];
          let selected = {
            row: this.selectedSquare.row,
            column: this.selectedSquare.col
          };
          API.getValidMoves(selected, this.gameId).then(response => {
            if (response.data != "No Valid Moves Found") {
              this.validMoves = response.data;
            }
          });
        },

        clear() {
          let clear = {
            row: 9,
            col: 9
          };
          this.selectedSquare = clear;
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
    box-shadow: 10px 10px 5px grey;
  }

  .center {
    text-align: center;
  }

  .toolbar {
    margin-left: 2px;
    margin-right: 2px;
    width: 200px;
    border-radius: 12px;
  }
</style>
