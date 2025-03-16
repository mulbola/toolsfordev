import api from '@/services/api.ts'

export const converterService = {
  convertBase(value: string, fromBase: number, toBase: number) {
    return api.post('/converter/base', { value, fromBase, toBase })
  },

  convertBase64(value: string, operation: 'encode' | 'decode') {
    return api.post('/converter/base64', { value, operation })
  },

  convertTimestamp(value: string, operation: 'toDate' | 'toTimestamp') {
    return api.post('/converter/timestamp', { value, operation })
  }
}
