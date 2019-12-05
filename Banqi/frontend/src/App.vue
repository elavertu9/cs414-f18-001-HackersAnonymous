<template>
  <div id="app">
    <AppHeader></AppHeader>
    <main>
      <router-view></router-view>
    </main>
    <AppFooter></AppFooter>
  </div>
</template>

<script>
import Home from './components/Home'
import Game from './components/Game'
import AppHeader from './components/AppHeader'
import AppFooter from './components/AppFooter'
import About from './components/About'
import Registration from './components/Registration'
import Login from './components/Login'
import Account from './components/Account'
import MyAccount from './components/MyAccount'
import LogOut from './components/LogOut'
import GameHome from './components/GameHome'
import Admin from './components/Admin'

export default {
  name: 'app',
  components: {
    AppFooter,
    Home,
    Game,
    About,
    AppHeader,
    Registration,
    Login,
    Account,
    MyAccount,
    LogOut,
    GameHome,
    Admin
  }
}
</script>

<style>

</style>
