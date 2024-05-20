// src/stores/auth.js
import { defineStore } from 'pinia';
import { ref } from 'vue';
import router from '../router';  // 正确导入 router

export const useAuthStore = defineStore('auth', () => {
  const isAuthenticated = ref(!!localStorage.getItem('authToken'));

  async function login(email, password) {
    try {
      //const response = await axios.post('/api/user/login', { email, password });
      //const token = response.data.token;
      const token = "jwtTokenTest"; 
      localStorage.setItem('authToken', token);
      isAuthenticated.value = true;
      router.push('/');  // Redirect to the Dashboard
    } catch (error) {
      console.error('Login failed:', error);
      // Handle login error (e.g., show notification)
    }
  }

  function logout() {
    localStorage.removeItem('authToken');
    isAuthenticated.value = false;
    router.push('/signin'); // 跳转到登录页面
  }

  return { isAuthenticated, login, logout };
});
