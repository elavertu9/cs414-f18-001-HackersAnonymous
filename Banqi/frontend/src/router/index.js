import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import Game from '../components/Game'
import About from '../components/About'
import Registration from '../components/Registration'
import Login from '../components/Login'
import Account from '../components/Account'
import MyAccount from '../components/MyAccount'

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
    },
    {
      path: '/register',
      name: 'Registration',
      component: Registration
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/account',
      name: 'Account',
      component: Account
    },
    {
      path: '/myAccount/:username',
      name: 'MyAccount',
      component: MyAccount
    }
  ]
})
