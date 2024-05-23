// src/stores/auth.js
import { defineStore } from 'pinia';
import { ref } from 'vue';
import router from '../router';  // 正确导入 router
import axios from 'axios';

export const useAuthStore = defineStore('auth', () => {

  
  async function login(email, password) {
    try {
      // isAuthenticated = false;
      const response = await axios.post('http://localhost:5052/api/user/login', { email, password });
      // const token = response.data.token;
      const ReceiveData = response.data  ;
      console.log("token "+ReceiveData.data);
      console.log("dd"+ReceiveData.msg);
      console.log(ReceiveData.code);
      const token = ReceiveData.data;
      if(token!=null){
          //需要写出弹窗提示

      
      console.log(response.data);
 
      // const token = "jwtTokenTest"; 
      localStorage.setItem('authToken', token);
      alert(localStorage.getItem('authToken'))
      isAuthenticated.value = true;
      router.push('/');  // Redirect to the Dashboard
    }else{
 
          router.replace('/signin');
          alert(ReceiveData.msg);
    
      
    }
    } catch (error) {
      console.error('Login failed:', error);
  
      // Handle login error (e.g., show notification)
    }
  }
  const isAuthenticated = ref(!!localStorage.getItem('authToken'));
  function logout() {
    localStorage.removeItem('authToken');
    isAuthenticated.value = false;
    router.push('/signin'); // 跳转到登录页面
  }

  return { isAuthenticated, login, logout };
});
