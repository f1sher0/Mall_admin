import { createApp } from 'vue';
import router from './router';
import App from './App.vue';
import axios from 'axios';
import './css/style.css';

// 创建一个新的 Axios 实例
const axiosInstance = axios.create({
  baseURL: 'http://localhost:5052',
});

const app = createApp(App);

// 使用 router
app.use(router);

// 将 Axios 实例添加到全局属性中
app.config.globalProperties.$axios = axiosInstance;
app.config.globalProperties.$httpUrl = 'http://localhost:5052';

// 挂载应用
app.mount('#app');
