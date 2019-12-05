import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `http://localhost:8080/api`,
  timeout: 5000,
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
    return AXIOS.get(`/game/${gameId}/board`);
  },

  getNewGame() {
    return AXIOS.get('/game/create');
  },

  createNewGame(id1, id2) {
    return AXIOS.get(`/game/create/${id1}/${id2}`);
  },

  updateUser(userId, userInfo) {
    return AXIOS.post(`/user/${userId}/update`, userInfo);
  }
}
