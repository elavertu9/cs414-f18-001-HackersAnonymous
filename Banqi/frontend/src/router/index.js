import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import Game from '../components/Game'
import About from '../components/About'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/game',
      name: 'Game',
      component: Game
    },
    {
      path: '/about',
      name: 'About',
      component: About
    }
  ]
})
