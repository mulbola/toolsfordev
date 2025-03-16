<template>
  <div>
    <div class="mb-3">
      <label for="operation" class="form-label">작업</label>
      <select class="form-select" id="operation" v-model="operation">
        <option value="encode">인코딩 (텍스트 → Base64)</option>
        <option value="decode">디코딩 (Base64 → 텍스트)</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="inputValue" class="form-label">입력값</label>
      <textarea class="form-control" id="inputValue" v-model="inputValue" rows="4" placeholder="변환할 텍스트를 입력하세요"></textarea>
    </div>

    <button class="btn btn-primary mb-3" @click="convertBase64">변환</button>

    <div v-if="result" class="mb-3">
      <label for="result" class="form-label">결과</label>
      <textarea class="form-control" id="result" v-model="result" rows="4" readonly></textarea>
    </div>

    <div v-if="error" class="alert alert-danger">
      <strong>오류:</strong> {{ error }}
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { converterService } from '../../services/converterService'

const inputValue = ref('')
const operation = ref('encode')
const result = ref('')
const error = ref('')

const convertBase64 = async () => {
  try {
    error.value = ''
    result.value = ''

    const response = await converterService.convertBase64(
      inputValue.value,
      operation.value as 'encode' | 'decode'
    )

    if (response.data.success) {
      result.value = response.data.result
    } else {
      error.value = response.data.error
    }
  } catch (err) {
    error.value = '변환 중 오류가 발생했습니다.'
    console.error(err)
  }
}
</script>
