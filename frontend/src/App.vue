<template>
  <NavBar />
  <main class="container mt-4">
    <router-view />
  </main>
  <Footer />
</template>

<script setup lang="ts">
import NavBar from './components/common/NavBar.vue'
import Footer from './components/common/Footer.vue'
</script>

<style>
@import 'bootstrap/dist/css/bootstrap.min.css';

body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background-color: #f8f9fa;
}
</style>
