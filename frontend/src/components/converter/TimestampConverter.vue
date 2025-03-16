<template>
  <div>
    <div class="mb-3">
      <label for="operation" class="form-label">작업</label>
      <select class="form-select" id="operation" v-model="operation">
        <option value="toDate">타임스탬프 → 날짜</option>
        <option value="toTimestamp">날짜 → 타임스탬프</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="inputValue" class="form-label">입력값</label>
      <input type="text" class="form-control" id="inputValue" v-model="inputValue"
             :placeholder="operation === 'toDate' ? 'Unix 타임스탬프 입력 (예: 1625097600)' : '날짜 입력 (예: 2021-07-01T12:00:00)'">
    </div>

    <button class="btn btn-primary mb-3" @click="convertTimestamp">변환</button>

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
const operation = ref('toDate')
const result = ref('')
const error = ref('')

const convertTimestamp = async () => {
  try {
    error.value = ''
    result.value = ''

    const response = await converterService.convertTimestamp(
      inputValue.value,
      operation.value as 'toDate' | 'toTimestamp'
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
