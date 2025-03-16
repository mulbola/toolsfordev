import api from '@/services/api.ts'

export const regexService = {
  testRegex(regex: string, text: string) {
    return api.post('/regex/test', { regex, text })
  }
}
