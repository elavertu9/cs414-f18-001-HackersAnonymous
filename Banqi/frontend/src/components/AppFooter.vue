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
    position: relative;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: #1E4D2B;
  }
</style>
