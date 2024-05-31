import { createApp } from 'vue';
import router from './router';
import axios from './utils/api';
import App from './App.vue';
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './css/style.css';

const app = createApp(App);

// 使用 router
app.use(router);

// 将axios实例作为provider提供
app.provide('$axios', axios);
// 将axios实例挂载到全局
app.config.globalProperties.$axios = axios;
app.use(ElementPlus)
// 挂载应用
app.mount('#app');