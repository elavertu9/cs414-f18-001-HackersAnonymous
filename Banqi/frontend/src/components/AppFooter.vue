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
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 60px;
    line-height: 60px;
    background-color: #1E4D2B;
  }
</style>
