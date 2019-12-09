<template>
  <div name="BanqiBoard">
    <b-row>
      <b-col></b-col>
      <b-col class="center"><h1>Banqi Game: {{gameId}}</h1></b-col>
      <b-col><h3 v-if="gameOver">GAME OVER</h3></b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col class="center">
        <h5>Turn: {{turn === false ? player1.username : player2.username}}</h5>
      </b-col>
      <b-col></b-col>
    </b-row>
    <br/>
    <b-row>
      <b-col><Loader v-if="loading"></Loader></b-col>
      <b-col class="center">
        <b-button-group>
          <b-button @click="refresh()" variant="primary" class="toolbar">Refresh</b-button>

          <b-dropdown id="dropdown-1" class="help" variant="primary" text="Help">
            <b-dropdown-item @click="$bvModal.show('legend-modal')">Legend</b-dropdown-item>
            <b-dropdown-item @click="$bvModal.show('rules-modal')">Rules</b-dropdown-item>
          </b-dropdown>
          <b-dropdown id="dropdown-1" class="help" variant="primary" text="Actions">
            <b-dropdown-item @click="clear()">Clear</b-dropdown-item>
            <b-dropdown-item @click="backToGameHome()">Change Game</b-dropdown-item>
          </b-dropdown>

          <b-button @click="moveSubmit()" :disabled="selectedSquare.length < 2" variant="success" class="toolbar">Submit Move</b-button>
        </b-button-group>
      </b-col>
      <b-col></b-col>
    </b-row>
    <br/>
    <b-row>
      <b-col class="center">
        <h3>Move Preview: </h3>
        <b-alert v-if="showTurnError" show variant="danger">{{turnError}}</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col>
        <table class="table">
          <tr v-if="selectedSquare.length === 2">
            <td>
              <img v-if="movePreview.src.type === movePreview.dest.type && movePreview.src.teamColor === movePreview.dest.teamColor" src="../images/Pieces/blank_piece.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'SOLDIER' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_Soldier.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'SOLDIER' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_Soldier.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === 'ADVISOR' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_Advisor.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'ADVISOR' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_Advisor.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === 'CANNON' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_Cannon.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'CANNON' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_Cannon.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === 'CHARIOT' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_Chariot.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'CHARIOT' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_Chariot.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === 'GENERAL' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_General.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'GENERAL' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_General.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === 'HORSE' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_Horse.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'HORSE' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_Horse.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === 'MINSTER' && movePreview.src.teamColor === 'RED'" src="../images/Pieces/Black_Elephant.png" width="45" height="45">
              <img v-else-if="movePreview.src.type === 'MINSTER' && movePreview.src.teamColor === 'BLACK'" src="../images/Pieces/White_Elephant.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === movePreview.dest.type && movePreview.src.teamColor === movePreview.dest.teamColor" src="../images/Pieces/blank_piece.png" width="45" height="45">
              <div v-else></div>
            </td>

            <td>
              <img v-if="movePreview.src.type === movePreview.dest.type && movePreview.src.teamColor === movePreview.dest.teamColor" src="../images/flip.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'EMPTY'" src="../images/arrow.png" width="45" height="45">
              <img v-else src="../images/swords.png" cwidth="45" height="45">
            </td>

            <!-- CAPTURED -->
            <td>
              <img v-if="movePreview.src.type === movePreview.dest.type && movePreview.src.teamColor === movePreview.dest.teamColor" src="../images/reveal.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'SOLDIER' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_Soldier.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'SOLDIER' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_Soldier.png" width="45" height="45">

              <img v-else-if="movePreview.dest.type === 'ADVISOR' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_Advisor.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'ADVISOR' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_Advisor.png" width="45" height="45">

              <img v-else-if="movePreview.dest.type === 'CANNON' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_Cannon.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'CANNON' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_Cannon.png" width="45" height="45">

              <img v-else-if="movePreview.dest.type === 'CHARIOT' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_Chariot.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'CHARIOT' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_Chariot.png" width="45" height="45">

              <img v-else-if="movePreview.dest.type === 'GENERAL' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_General.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'GENERAL' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_General.png" width="45" height="45">

              <img v-else-if="movePreview.dest.type === 'HORSE' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_Horse.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'HORSE' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_Horse.png" width="45" height="45">

              <img v-else-if="movePreview.dest.type === 'MINSTER' && movePreview.dest.teamColor === 'RED'" src="../images/Pieces/Black_Elephant.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'MINSTER' && movePreview.dest.teamColor === 'BLACK'" src="../images/Pieces/White_Elephant.png" width="45" height="45">

              <img v-else-if="movePreview.src.type === movePreview.dest.type && movePreview.src.teamColor === movePreview.dest.teamColor" src="../images/reveal.png" width="45" height="45">
              <img v-else-if="movePreview.dest.type === 'EMPTY'" src="../images/empty.png" width="45" height="45">
              <div v-else></div>
            </td>
          </tr>
        </table>
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
            <b-row class="center">
              <b-col class="center">
                <h5>Color:</h5>
              </b-col>
              <b-col class="center">
                <img src="../images/Pieces/Black_General.png" width="45" height="45">
              </b-col>
            </b-row>
            <br/>
            <h6 class="center">Pieces Remaining</h6>
            <div class="overflow">
              <table>
                <tr>
                  <td v-for="piece in player1.pieces.general">
                    <img src="../images/Pieces/Black_General.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player1.pieces.chariot">
                    <img src="../images/Pieces/Black_Chariot.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player1.pieces.horse">
                    <img src="../images/Pieces/Black_Horse.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player1.pieces.cannon">
                    <img src="../images/Pieces/Black_Cannon.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player1.pieces.advisor">
                    <img src="../images/Pieces/Black_Advisor.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player1.pieces.elephant">
                    <img src="../images/Pieces/Black_Elephant.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player1.pieces.soldier">
                    <img src="../images/Pieces/Black_Soldier.png" width="30" height="30">
                  </td>
                </tr>
              </table>
            </div>
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

                  <p v-else-if="i.piece.type == 'EMPTY'"></p>

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

                  <p v-else-if="i.piece.type == 'EMPTY'"></p>

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

                  <p v-else-if="i.piece.type == 'EMPTY'"></p>

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

                  <p v-else-if="i.piece.type == 'EMPTY'"></p>

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
            <b-row class="center">
              <b-col class="center">
                <h5>Color:</h5>
              </b-col>
              <b-col class="center">
                <img src="../images/Pieces/White_General.png" width="45" height="45">
              </b-col>
            </b-row>
            <br/>
            <h6 class="center">Pieces Remaining</h6>
            <div class="overflow">
              <table>
                <tr>
                  <td v-for="piece in player2.pieces.general">
                    <img src="../images/Pieces/White_General.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player2.pieces.chariot">
                    <img src="../images/Pieces/White_Chariot.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player2.pieces.horse">
                    <img src="../images/Pieces/White_Horse.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player2.pieces.cannon">
                    <img src="../images/Pieces/White_Cannon.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player2.pieces.advisor">
                    <img src="../images/Pieces/White_Advisor.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player2.pieces.elephant">
                    <img src="../images/Pieces/White_Elephant.png" width="30" height="30">
                  </td>
                </tr>
                <tr>
                  <td v-for="piece in player2.pieces.soldier">
                    <img src="../images/Pieces/White_Soldier.png" width="30" height="30">
                  </td>
                </tr>
              </table>
            </div>
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
        <table class="table white-text">
          <tbody v-if="noHistory == false">
          <tr v-for="(move, index) in moveHistory">
            <td>
              {{moveHistory.length - index}}
            </td>

            <td>
              <p>{{moveHistoryUsernames[index]}}</p>
            </td>

            <!-- ATTACKER -->
            <td class="center">
              <img v-if="move.moveType === 'FLIP'" src="../images/Pieces/blank_piece.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'SOLDIER' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Soldier.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'SOLDIER' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Soldier.png" width="45" height="45">

              <img v-else-if="move.attacker.type === 'ADVISOR' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Advisor.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'ADVISOR' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Advisor.png" width="45" height="45">

              <img v-else-if="move.attacker.type === 'CANNON' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Cannon.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'CANNON' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Cannon.png" width="45" height="45">

              <img v-else-if="move.attacker.type === 'CHARIOT' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Chariot.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'CHARIOT' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Chariot.png" width="45" height="45">

              <img v-else-if="move.attacker.type === 'GENERAL' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_General.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'GENERAL' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_General.png" width="45" height="45">

              <img v-else-if="move.attacker.type === 'HORSE' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Horse.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'HORSE' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Horse.png" width="45" height="45">

              <img v-else-if="move.attacker.type === 'MINSTER' && move.attacker.teamColor === 'RED'" src="../images/Pieces/Black_Elephant.png" width="45" height="45">
              <img v-else-if="move.attacker.type === 'MINSTER' && move.attacker.teamColor === 'BLACK'" src="../images/Pieces/White_Elephant.png" width="45" height="45">

              <img v-else-if="move.attacker.type === move.captured.type && move.attacker.teamColor === move.captured.teamColor" src="../images/Pieces/blank_piece.png" width="45" height="45">
              <div v-else></div>
            </td>

            <td class="center">
              <img v-if="move.moveType === 'FLIP'" src="../images/flip.png" width="45" height="45">
              <img v-else-if="move.moveType === 'TRAVEL'" src="../images/arrow.png" width="45" height="45">
              <img v-else src="../images/swords.png" cwidth="45" height="45">
            </td>

            <!-- CAPTURED -->
            <td class="center">
              <img v-if="move.moveType === 'TRAVEL'" src="../images/empty.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'SOLDIER' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Soldier.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'SOLDIER' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Soldier.png" width="45" height="45">

              <img v-else-if="move.captured.type == 'ADVISOR' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Advisor.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'ADVISOR' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Advisor.png" width="45" height="45">

              <img v-else-if="move.captured.type == 'CANNON' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Cannon.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'CANNON' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Cannon.png" width="45" height="45">

              <img v-else-if="move.captured.type == 'CHARIOT' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Chariot.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'CHARIOT' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Chariot.png" width="45" height="45">

              <img v-else-if="move.captured.type == 'GENERAL' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_General.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'GENERAL' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_General.png" width="45" height="45">

              <img v-else-if="move.captured.type == 'HORSE' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Horse.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'HORSE' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Horse.png" width="45" height="45">

              <img v-else-if="move.captured.type == 'MINSTER' && move.captured.teamColor == 'RED'" src="../images/Pieces/Black_Elephant.png" width="45" height="45">
              <img v-else-if="move.captured.type == 'MINSTER' && move.captured.teamColor == 'BLACK'" src="../images/Pieces/White_Elephant.png" width="45" height="45">

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

      mounted() {
        this.selectedSquare = [];
        this.getGame();
        this.getHistory();
        window.setInterval(() => {
          this.phoneHome();
        }, this.callHomeEvery);
      },

      name: "BanqiBoard",

      data() {
        return {
          gameId: '',
          callHomeEvery: 3000,
          turn: false,
          gameOver: false,
          turnError: 'Please wait your turn',
          showTurnError: false,
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
            faceUp: false,
            type: ''
          }],
          errors: [],
          player1: {
                userID: '',
                username: '',
                color: 'RED',
                pieces: {
                  general: 1,
                  chariot: 2,
                  horse: 2,
                  cannon: 2,
                  advisor: 2,
                  elephant: 2,
                  soldier: 5
                }
              },
              player2: {
                userID: '',
                username: '',
                color: 'BLACK',
                pieces: {
                  general: 1,
                  chariot: 2,
                  horse: 2,
                  cannon: 2,
                  advisor: 2,
              elephant: 2,
              soldier: 5
            }
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
              activeUser: '',
              executed: false,
              validMove: false
            }
          ],
            movePreview: {
            activeUser: '',
              src: {
                  type: '',
                  teamColor: '',
                  faceUp: false
              },
              dest: {
                  type: '',
                  teamColor: '',
                  faceUp: false
              }
            },
          moveHistoryUsernames: []
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
                 this.turn = response.data.turn;
                 this.gameOver = response.data.gameOver;
                 this.getPlayerInfo();
                 this.loading = false;
              });
          }
        },

        phoneHome() {
          API.getExistingGame(this.gameId).then(response => {
            if (response.data.turn !== this.turn) {
              this.refresh();
            }
          });
        },

        refresh() {
          this.loading = true;
          this.getGame();
          this.getHistory();
        },

        countPieces(color) {
          let count = {
            general: 0,
            chariot: 0,
            horse: 0,
            cannon: 0,
            advisor: 0,
            elephant: 0,
            soldier: 0
          };

          for (let i in this.row1) {
            if (this.row1[i].piece.type === "GENERAL" && this.row1[i].piece.teamColor === color) {
              count.general++;
            }
            if (this.row1[i].piece.type === "CHARIOT" && this.row1[i].piece.teamColor === color) {
              count.chariot++;
            }
            if (this.row1[i].piece.type === "HORSE" && this.row1[i].piece.teamColor === color) {
              count.horse++;
            }
            if (this.row1[i].piece.type === "CANNON" && this.row1[i].piece.teamColor === color) {
              count.cannon++;
            }
            if (this.row1[i].piece.type === "ADVISOR" && this.row1[i].piece.teamColor === color) {
              count.advisor++;
            }
            if (this.row1[i].piece.type === "MINSTER" && this.row1[i].piece.teamColor === color) {
              count.elephant++;
            }
            if (this.row1[i].piece.type === "SOLDIER" && this.row1[i].piece.teamColor === color) {
              count.soldier++;
            }
          }
          for (let i in this.row2) {
            if (this.row2[i].piece.type === "GENERAL" && this.row2[i].piece.teamColor === color) {
              count.general++;
            }
            if (this.row2[i].piece.type === "CHARIOT" && this.row2[i].piece.teamColor === color) {
              count.chariot++;
            }
            if (this.row2[i].piece.type === "HORSE" && this.row2[i].piece.teamColor === color) {
              count.horse++;
            }
            if (this.row2[i].piece.type === "CANNON" && this.row2[i].piece.teamColor === color) {
              count.cannon++;
            }
            if (this.row2[i].piece.type === "ADVISOR" && this.row2[i].piece.teamColor === color) {
              count.advisor++;
            }
            if (this.row2[i].piece.type === "MINSTER" && this.row2[i].piece.teamColor === color) {
              count.elephant++;
            }
            if (this.row2[i].piece.type === "SOLDIER" && this.row2[i].piece.teamColor === color) {
              count.soldier++;
            }
          }
          for (let i in this.row3) {
            if (this.row3[i].piece.type === "GENERAL" && this.row3[i].piece.teamColor === color) {
              count.general++;
            }
            if (this.row3[i].piece.type === "CHARIOT" && this.row3[i].piece.teamColor === color) {
              count.chariot++;
            }
            if (this.row3[i].piece.type === "HORSE" && this.row3[i].piece.teamColor === color) {
              count.horse++;
            }
            if (this.row3[i].piece.type === "CANNON" && this.row3[i].piece.teamColor === color) {
              count.cannon++;
            }
            if (this.row3[i].piece.type === "ADVISOR" && this.row3[i].piece.teamColor === color) {
              count.advisor++;
            }
            if (this.row3[i].piece.type === "MINSTER" && this.row3[i].piece.teamColor === color) {
              count.elephant++;
            }
            if (this.row3[i].piece.type === "SOLDIER" && this.row3[i].piece.teamColor === color) {
              count.soldier++;
            }
          }
          for (let i in this.row4) {
            if (this.row4[i].piece.type === "GENERAL" && this.row4[i].piece.teamColor === color) {
              count.general++;
            }
            if (this.row4[i].piece.type === "CHARIOT" && this.row4[i].piece.teamColor === color) {
              count.chariot++;
            }
            if (this.row4[i].piece.type === "HORSE" && this.row4[i].piece.teamColor === color) {
              count.horse++;
            }
            if (this.row4[i].piece.type === "CANNON" && this.row4[i].piece.teamColor === color) {
              count.cannon++;
            }
            if (this.row4[i].piece.type === "ADVISOR" && this.row4[i].piece.teamColor === color) {
              count.advisor++;
            }
            if (this.row4[i].piece.type === "MINSTER" && this.row4[i].piece.teamColor === color) {
              count.elephant++;
            }
            if (this.row4[i].piece.type === "SOLDIER" && this.row4[i].piece.teamColor === color) {
              count.soldier++;
            }
          }
          return count;
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

        historyUsernames() {
          let usernames = [];
          for (let i in this.moveHistory) {
            let user = this.moveHistory[i].activeUser;
            console.log(user);
            console.log(user);
            API.getUser(user).then(response => {
              let name = response.data.username;
              usernames.push(name);
            });
          }
          this.moveHistoryUsernames = usernames;
        },

        getPlayerInfo() {
          let p1Pieces = this.countPieces("RED");
          let p2Pieces = this.countPieces("BLACK");

          // Assign player 1
          API.getUser(this.player1.userID).then(response => {
            let user1 = {
              userID: this.player1.userID,
              username: response.data.username,
              color: this.player1.color,
              pieces: p1Pieces
            };
            this.player1 = user1;
          });

          // Assign player 2
          API.getUser(this.player2.userID).then(response => {
            let user2 = {
              userID: this.player2.userID,
              username: response.data.username,
              color: this.player2.color,
              pieces: p2Pieces
            };
            this.player2 = user2;
          });
        },

        orangeOrBlack(row, col) {
          row = row + 1;
          col = col + 1;
          let square = '';
          if (row % 2 == 0) {
            if (col % 2 == 0) {
              square = "orange_square";
            } else {
              square =  "black_square";
            }
          } else {
            if (col % 2 == 0) {
              square = "black_square";
            } else {
              square = "orange_square";
            }
          }
          return square;
        },

        checkIfValid(row, col) {
          let isValid = false;
          for(let i in this.validMoves) {
            if ((this.validMoves[i].row === row ) && (this.validMoves[i].column === col)) {
              isValid = true;
            }
          }
          return isValid;
        },

        checkIfFirstClick(row, col) {
          let isFirstClick = false;
          if (col === this.selectedSquare[0].col && row === this.selectedSquare[0].row) {
            isFirstClick = true;
          }
          return isFirstClick;
        },

        checkIfSecondClick(row, col) {
          let isSecondClick = false;
          if (col === this.selectedSquare[1].col && row === this.selectedSquare[1].row) {
            isSecondClick = true;
          }
          return isSecondClick;
        },

        getClass(col, row) {
          row = row - 1;

          let numSelected = this.selectedSquare.length;

          if (numSelected < 1) {
            let square = this.orangeOrBlack(row, col);
            return square;
          } else if (numSelected == 1) {
            let isValidSquare = this.checkIfValid(row, col);

            if (row === this.selectedSquare[0].row && col === this.selectedSquare[0].col) {
              return "selected_square";
            } else if (isValidSquare) {
              return "valid_square";
            } else {
              let square = this.orangeOrBlack(row, col);
              return square;
            }
          } else if (numSelected === 2) {
            let isFirstClick = this.checkIfFirstClick(row, col);
            let isSecondClick = this.checkIfSecondClick(row, col);

            if (isFirstClick && !isSecondClick) {
              return "selected_square";
            } else if (isFirstClick && isSecondClick) {
              return "second_click";
            } else if (isSecondClick) {
              return "second_click";
            } else {
              let square = this.orangeOrBlack(row, col);
              return square;
            }
          }

        },

        moveSubmit() {
          this.loading = true;
          // if the piece is not face up yet, flip it
          if (!this.selectedSquare[0].faceUp && this.selectedSquare[1].type !== 'EMPTY') {
            this.flipPiece();
            this.selectedSquare = [];
            this.movePreview = {
              src: {
                type: '',
                teamColor: '',
                faceUp: false
              },
              dest: {
                type: '',
                teamColor: '',
                faceUp: false
              }
            };
          } else {
            let executedBy = "";
            if (this.turn === false) {
              executedBy = this.player1.userID;
            } else {
              executedBy = this.player2.userID;
            }
            let execute = {
              origin: {
                row: this.selectedSquare[0].row,
                column: this.selectedSquare[0].col
              },
              destination: {
                row: this.selectedSquare[1].row,
                column: this.selectedSquare[1].col
              }
            };
            API.executeMove(execute, this.gameId, executedBy).then(response => {
              this.getGame();
              this.getHistory();
              this.selectedSquare = [];
              this.movePreview = {
                activeUser: '',
                src: {
                  type: '',
                  teamColor: '',
                  faceUp: false
                },
                dest: {
                  type: '',
                  teamColor: '',
                  faceUp: false
                }
              };
            });
          }

        },

        flipPiece() {
          let executedBy = "";
          if (this.turn === false) {
            executedBy = this.player1.userID;
          } else {
            executedBy = this.player2.userID;
          }
          let flip = {
            origin: {
              row: this.selectedSquare[0].row,
              column: this.selectedSquare[0].col
            },
            destination: {
              row: this.selectedSquare[1].row,
              column: this.selectedSquare[1].col
            }
          };
          console.log(flip);
          API.executeMove(flip, this.gameId, executedBy).then((response) => {
            this.getGame();
            this.getHistory();
          });
        },

        backToGameHome() {
          localStorage.removeItem('gameId');
          window.location.pathname = "/gameHome";
        },

        getPiece(row, col) {
          if (row === 0) {
            return this.row1[col].piece;
          } else if (row === 1) {
            return this.row2[col].piece;
          } else if (row === 2) {
            return this.row3[col].piece;
          } else {
            return this.row4[col].piece;
          }
        },

        isValid(selected) {
          let isValidMove = false;
          for (let i in this.validMoves) {
            if (this.validMoves[i].row === selected.row && this.validMoves[i].column === selected.col) {
              isValidMove = true;
            }
          }
          return isValidMove;
        },

        // handle board clicks
        clicked(row, col) {
          if (!this.turn) {
            let numSelected = this.selectedSquare.length;
            let pieceDetails = this.getPiece(row, col);
            let selected = {
              row: row,
              col: col,
              faceUp: pieceDetails.faceUp,
              type: pieceDetails.type
            };
            if (parseInt(localStorage.getItem('userID')) === parseInt(this.player1.userID)) {

                if (numSelected < 1) {
                  if (!pieceDetails.faceUp && pieceDetails.type !== 'EMPTY') {
                    this.clearSelected();
                    this.addSelection(selected);
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else if (pieceDetails.type !== 'EMPTY' && pieceDetails.teamColor === this.player1.color) {
                     this.addSelection(selected);
                    this.getValidMoves();
                  } else {
                    console.log("INVALID");
                  }
                } else if (numSelected === 1) {
                  let isValidMove = this.isValid(selected);

                  if (!pieceDetails.faceUp && pieceDetails.type !== 'EMPTY') {
                    this.clearSelected();
                    this.addSelection(selected);
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else if (!pieceDetails.teamColor !== this.player1.color && !isValidMove) {
                    this.clearSelected();
                  } else if (pieceDetails.type === "EMPTY") {
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else {

                    if (isValidMove || pieceDetails.type === "EMPTY") {
                      this.addSelection(selected);
                      this.getMovePreview();
                    } else  {
                      this.clearSelected();
                      this.addSelection(selected);
                      this.getValidMoves();
                    }
                  }
                } else if (numSelected === 2) {
                  this.clearSelected();
                  if (!pieceDetails.faceUp && pieceDetails.type !== 'EMPTY') {
                    this.addSelection(selected);
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else {
                    if (pieceDetails.type !== 'EMPTY') {
                      this.addSelection(selected);
                      this.getValidMoves();
                    }
                  }
                } else {
                  // numSelected > 2
                  console.log("overflow! ", numSelected);
                }
            } else {
              // p1 disabled
              // p2 goes
              this.showTurnError = true;
              setTimeout(() => {
                this.showTurnError = false;
              }, 5000);
            }
          } else {
            let numSelected = this.selectedSquare.length;
            let pieceDetails = this.getPiece(row, col);
            let selected = {
              row: row,
              col: col,
              faceUp: pieceDetails.faceUp,
              type: pieceDetails.type
            };
            if (parseInt(localStorage.getItem('userID')) === parseInt(this.player2.userID)) {
                if (numSelected < 1) {
                  if (!pieceDetails.faceUp && pieceDetails.type !== 'EMPTY') {
                    this.clearSelected();
                    this.addSelection(selected);
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else if (pieceDetails.type !== 'EMPTY' && pieceDetails.teamColor === this.player2.color) {
                    this.addSelection(selected);
                    this.getValidMoves();
                  } else {
                    console.log("INVALID");
                  }
                } else if (numSelected === 1) {
                  let isValidMove = this.isValid(selected);

                  if (!pieceDetails.faceUp && pieceDetails.type !== 'EMPTY') {
                    this.clearSelected();
                    this.addSelection(selected);
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else if (!pieceDetails.teamColor !== this.player2.color && !isValidMove) {
                    this.clearSelected();
                  } else if (pieceDetails.type === "EMPTY") {
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else {

                    if (isValidMove || pieceDetails.type === "EMPTY") {
                      this.addSelection(selected);
                      this.getMovePreview();
                    } else  {
                      this.clearSelected();
                      this.addSelection(selected);
                      this.getValidMoves();
                    }
                  }
                } else if (numSelected === 2) {
                  this.clearSelected();
                  if (!pieceDetails.faceUp && pieceDetails.type !== 'EMPTY') {
                    this.addSelection(selected);
                    this.addSelection(selected);
                    this.getMovePreview();
                  } else {
                    if (pieceDetails.type !== 'EMPTY') {
                      this.addSelection(selected);
                      this.getValidMoves();
                    }
                  }
                } else {
                  // numSelected > 2
                  console.log("overflow! ", numSelected);
                }
            } else {
              this.showTurnError = true;
              setTimeout(() => {
                this.showTurnError = false;
              }, 5000);
            }
          }

        },

        clearSelected() {
          this.selectedSquare = [];
        },

        addSelection(selected) {
          this.selectedSquare.push(selected);
        },

        getMovePreview() {
            let srcClick = this.selectedSquare[0];
            let destClick = this.selectedSquare[1];

            let movePrev = {
                src: {
                    type: '',
                    teamColor: '',
                    faceUp: false
                },
                dest: {
                    type: '',
                    teamColor: '',
                    faceUp: false
                }
            };

            if (srcClick.row === 0) {
                let piece = this.row1[srcClick.col];
                movePrev.src = piece.piece;
            }else if (srcClick.row === 1)   {
                let piece = this.row2[srcClick.col];
                movePrev.src = piece.piece;
            } else if (srcClick.row === 2) {
                let piece = this.row3[srcClick.col];
                movePrev.src = piece.piece;
            } else {
                let piece = this.row4[srcClick.col];
                movePrev.src =  piece.piece;
            }

            if (destClick.row === 0) {
                let piece = this.row1[destClick.col];
                movePrev.dest = piece.piece;
            }else if (destClick.row === 1)   {
                let piece = this.row2[destClick.col];
                movePrev.dest = piece.piece;
            } else if (destClick.row === 2) {
                let piece = this.row3[destClick.col];
                movePrev.dest = piece.piece;
            } else {
                let piece = this.row4[destClick.col];
                movePrev.dest =  piece.piece;
            }

            this.movePreview = movePrev;

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
          this.historyUsernames();
        },

        clear() {
          this.selectedSquare = [];
          this.validMoves = [];
          this.movePreview = {
            src: {
              type: '',
              teamColor: '',
              faceUp: false
            },
            dest: {
              type: '',
              teamColor: '',
              faceUp: false
            }
          }
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
    height: 350px;
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

  .overflow {
    height: 175px;
    overflow: scroll;
    border: 3px solid black;
    background-color: #A8A8A8;
    color: black;
  }

</style>
