import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ConverterView from '@/views/ConverterView.vue'
import RegexView from '@/views/RegexView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/converter',
      name: 'converter',
      component: ConverterView
    },
    {
      path: '/regex',
      name: 'regex',
      component: RegexView
    }
  ],
})

export default router
