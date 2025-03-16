<template>
  <div>
    <div class="mb-3">
      <label for="regexPattern" class="form-label">정규식 패턴</label>
      <input type="text" class="form-control" id="regexPattern" v-model="regexPattern" placeholder="/pattern/flags">
    </div>

    <div class="mb-3">
      <label for="testText" class="form-label">테스트할 텍스트</label>
      <textarea class="form-control" id="testText" v-model="testText" rows="6" placeholder="정규식으로 테스트할 텍스트를 입력하세요"></textarea>
    </div>

    <button class="btn btn-primary mb-3" @click="testRegex">테스트</button>

    <div v-if="isResultAvailable" class="mt-4">
      <h5>테스트 결과:</h5>
      <div v-if="matches" class="alert alert-success">
        <p><strong>일치함!</strong> 정규식이 텍스트와 일치합니다.</p>

        <div v-if="matchResults && matchResults.length > 0">
          <h6>일치하는 항목:</h6>
          <ul class="list-group">
            <li class="list-group-item" v-for="(match, index) in matchResults" :key="index">
              {{ match }}
            </li>
          </ul>
        </div>
      </div>

      <div v-else class="alert alert-warning">
        <strong>일치하지 않음!</strong> 정규식이 텍스트와 일치하지 않습니다.
      </div>
    </div>

    <div v-if="error" class="alert alert-danger mt-3">
      <strong>오류:</strong> {{ error }}
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { regexService } from '../../services/regexService'

const regexPattern = ref('')
const testText = ref('')
const matches = ref(false)
const matchResults = ref<string[]>([])
const error = ref('')
const isResultAvailable = ref(false)

const testRegex = async () => {
  try {
    error.value = ''
    isResultAvailable.value = false

    if (!regexPattern.value || !testText.value) {
      error.value = '정규식 패턴과 테스트 텍스트를 모두 입력해주세요.'
      return
    }

    const response = await regexService.testRegex(regexPattern.value, testText.value)

    if (response.data.success) {
      matches.value = response.data.matches
      matchResults.value = response.data.matchResults || []
      isResultAvailable.value = true
    } else {
      error.value = response.data.error
    }
  } catch (err) {
    error.value = '테스트 중 오류가 발생했습니다.'
    console.error(err)
  }
}
</script>
