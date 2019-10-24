<template>
  <div name="BanqiBoard">
    <div class="board-wrapper">
      <div id="board">
        <table class="board-table">
          <tbody>
            <tr>
              <td class="orange_square">1</td>
              <td class="black_square">2</td>
              <td class="orange_square">3</td>
              <td class="black_square">4</td>
              <td class="orange_square">5</td>
              <td class="black_square">6</td>
              <td class="orange_square">7</td>
              <td class="black_square">8</td>
            </tr>
            <tr>
              <td class="black_square">9</td>
              <td class="orange_square">10</td>
              <td class="black_square">11</td>
              <td class="orange_square">12</td>
              <td class="black_square">13</td>
              <td class="orange_square">14</td>
              <td class="black_square">15</td>
              <td class="orange_square">16</td>
            </tr>
            <tr>
              <td class="orange_square">17</td>
              <td class="black_square">18</td>
              <td class="orange_square">19</td>
              <td class="black_square">20</td>
              <td class="orange_square">21</td>
              <td class="black_square">22</td>
              <td class="orange_square">23</td>
              <td class="black_square">24</td>
            </tr>
            <tr>
              <td class="black_square">25</td>
              <td class="orange_square">26</td>
              <td class="black_square">27</td>
              <td class="orange_square">28</td>
              <td class="black_square">29</td>
              <td class="orange_square">30</td>
              <td class="black_square">31</td>
              <td class="orange_square">32</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "BanqiBoard"
    }
</script>

<style scoped>
  .orange_square {
    width: 60px;
    height: 60px;
    background-color: #D9782D;
  }

  .black_square {
    width: 60px;
    height: 60px;
    background-color: #59595B;
  }

  .board-wrapper {
    position: relative;
    width: 480px;
    height: 480px;
    text-align: center;
    margin: auto;
  }

  #board {
    position: absolute;
    top: 0;
  }

  .board-table {
    cellpadding: 0px;
    cellspacing: 0px;
  }
</style>
