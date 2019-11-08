import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `http://localhost:8080/api`,
  timeout: 2000,
  headers: {
    'Content-Type': 'application/json'
  }
});

export default {
  hello() {
    return AXIOS.get(`/hello`);
  },
  getBoard() {
    return AXIOS.get('/board');
  }
}
