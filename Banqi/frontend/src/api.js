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

  getUser(id) {
    return AXIOS.get(`/user/${id}`);
  },

  getUserByUsername(username) {
    return AXIOS.get(`/user/byUsername/${username}`);
  },

  // Game Endpoints
  hello() {
    return AXIOS.get(`/game/hello`);
  },

  getExistingGame(gameId) {
    return AXIOS.get(`/game/${gameId}`);
  },

  getNewGame() {
    return AXIOS.get('/game/create');
  },

  createNewGame(id1, id2) {
    return AXIOS.get(`/game/create/${id1}/${id2}`);
  },

  updateUser(userInfo) {
    return AXIOS.post(`/user/edit`, userInfo);
  },

  getAllGames() {
    return AXIOS.get('/admin/game/list/all');
  },

  deleteGame(id) {
    return AXIOS.get(`/game/${id}/delete`);
  },

  deleteUser(id) {
    return AXIOS.get(`/user/${id}/delete`);
  },
}
