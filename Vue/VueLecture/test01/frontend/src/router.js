import { createRouter, createWebHistory } from 'vue-router'; // Vue 라우터 관련 기능 가져오기
import MainPage from './components/MainPage.vue'; // 메인 페이지 컴포넌트 가져오기
import SignUpPage from './components/SignUpPage.vue'; // 회원가입 페이지 컴포넌트 가져오기

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: MainPage }, // 기본 경로로 메인 페이지 지정
    { path: '/signup', component: SignUpPage } // /signup 경로로 회원가입 페이지 지정
  ]
});

export default router;
