<template>
  <footer class="bottom-footer">
    <div class="footerFormat">
      <p>Developed by ___ Hackers Anonymous</p>
    </div>
  </footer>
</template>

<script>
    export default {
        name: "AppFooter"
    }
</script>

<style scoped>
  .footerFormat {
    text-align: center;
    color: white;
  }
  .bottom-footer {
    background-color: #1E4D2B;
    position: absolute;
    left: 0;
    bottom: 0;
    height: 100px;
    width: 100%;
    padding: 70px 0;
  }
</style>
