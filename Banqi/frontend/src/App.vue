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

export default {
  name: 'app',
  components: {
    AppFooter,
    Home,
    Game,
    AppHeader
  }
}
</script>

<style>

</style>
