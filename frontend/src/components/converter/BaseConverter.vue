<template>
  <div>
    <div class="mb-3">
      <label for="inputValue" class="form-label">입력값</label>
      <input type="text" class="form-control" id="inputValue" v-model="inputValue" placeholder="변환할 값을 입력하세요">
    </div>

    <div class="row mb-3">
      <div class="col">
        <label for="fromBase" class="form-label">입력 진수</label>
        <select class="form-select" id="fromBase" v-model="fromBase">
          <option value="2">2진수 (Binary)</option>
          <option value="8">8진수 (Octal)</option>
          <option value="10">10진수 (Decimal)</option>
          <option value="16">16진수 (Hexadecimal)</option>
        </select>
      </div>
      <div class="col">
        <label for="toBase" class="form-label">출력 진수</label>
        <select class="form-select" id="toBase" v-model="toBase">
          <option value="2">2진수 (Binary)</option>
          <option value="8">8진수 (Octal)</option>
          <option value="10">10진수 (Decimal)</option>
          <option value="16">16진수 (Hexadecimal)</option>
        </select>
      </div>
    </div>

    <button class="btn btn-primary mb-3" @click="convertBase">변환</button>

    <div v-if="result" class="alert alert-success">
      <strong>결과:</strong> {{ result }}
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
const fromBase = ref(10)
const toBase = ref(2)
const result = ref('')
const error = ref('')

const convertBase = async () => {
  try {
    error.value = ''
    result.value = ''

    const response = await converterService.convertBase(
      inputValue.value,
      parseInt(fromBase.value.toString()),
      parseInt(toBase.value.toString())
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
