<template>
  <div>
    <h1 class="mb-4">개발자용 단위 변환기</h1>

    <div class="card mb-4">
      <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs">
          <li class="nav-item">
            <a class="nav-link" :class="{ active: activeTab === 'base' }" @click.prevent="activeTab = 'base'" href="#">진수 변환</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" :class="{ active: activeTab === 'base64' }" @click.prevent="activeTab = 'base64'" href="#">Base64</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" :class="{ active: activeTab === 'timestamp' }" @click.prevent="activeTab = 'timestamp'" href="#">타임스탬프</a>
          </li>
        </ul>
      </div>
      <div class="card-body">
        <BaseConverter v-if="activeTab === 'base'" />
        <Base64Converter v-if="activeTab === 'base64'" />
        <TimestampConverter v-if="activeTab === 'timestamp'" />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import BaseConverter from '../components/converter/BaseConverter.vue'
import Base64Converter from '../components/converter/Base64Converter.vue'
import TimestampConverter from '../components/converter/TimestampConverter.vue'

const activeTab = ref('base')
</script>
