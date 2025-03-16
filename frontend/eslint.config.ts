import pluginVue from 'eslint-plugin-vue'
import { defineConfigWithVueTs, vueTsConfigs } from '@vue/eslint-config-typescript'
import skipFormatting from '@vue/eslint-config-prettier/skip-formatting'

// To allow more languages other than `ts` in `.vue` files, uncomment the following lines:
// import { configureVueProject } from '@vue/eslint-config-typescript'
// configureVueProject({ scriptLangs: ['ts', 'tsx'] })
// More info at https://github.com/vuejs/eslint-config-typescript/#advanced-setup

export default defineConfigWithVueTs(
  {
    // 파일 패턴 및 무시할 파일 설정
    files: ['**/*.{js,ts,jsx,tsx,html,vue}'],
    ignores: ['**/dist/**', '**/dist-ssr/**', '**/coverage/**', '**/node_modules/**'],

    // ESLint v9에서 필요한 linterOptions 설정
    linterOptions: {
      reportUnusedDisableDirectives: "warn"
    },

    // 기본 규칙 설정
    rules: {
      "vue/multi-word-component-names": "off",
      "semi": ["error", "always"],
      "quotes": ["warn", "single"],
      "no-unused-vars": "warn"
    }
  },

  // Vue 구성 - flat/essential은 기본 규칙만 포함
  pluginVue.configs['flat/essential'],

  // TypeScript 구성
  vueTsConfigs.recommended,

  // Prettier 통합
  skipFormatting
)
