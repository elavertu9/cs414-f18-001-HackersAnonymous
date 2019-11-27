import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `http://localhost:8080/api`,
  timeout: 2000,
  headers: {
    'Content-Type': 'application/json'
  }
});

export default {

  // User Endpoints
  registerUser(userData) {
    return AXIOS.post('/user/add', userData);
  },
  getAllUsers() {
    return AXIOS.get('/user/list');
  },

  // Game Endpoints
  hello() {
    return AXIOS.get(`/game/hello`);
  },
  getExistingGame(gameId) {
    return AXIOS.post('/game/board', gameId);
  },

  getNewGame() {
    return AXIOS.get('/game/new')
  }
}
