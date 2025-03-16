<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <router-link class="navbar-brand" to="/">개발자 툴킷</router-link>

      <!-- 토글 버튼 수정 -->
      <button class="navbar-toggler" type="button"
              @click="toggleMenu"
              aria-controls="navbarNav"
              :aria-expanded="isMenuOpen ? 'true' : 'false'"
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- collapse 클래스에 조건부 show 클래스 추가 -->
      <div class="collapse navbar-collapse" :class="{ 'show': isMenuOpen }" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/" @click="closeMenu">홈</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/converter" @click="closeMenu">단위 변환기</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/regex" @click="closeMenu">정규식 테스터</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const isMenuOpen = ref(false)

const toggleMenu = () => {
  isMenuOpen.value = !isMenuOpen.value
  console.log('Menu toggled:', isMenuOpen.value) // 디버깅용
}

const closeMenu = () => {
  isMenuOpen.value = false
}
</script>
