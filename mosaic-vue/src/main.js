import { createApp } from 'vue'
import router from './router'
import App from './App.vue'
import { createPinia } from 'pinia';
import './css/style.css'
import axios from 'axios';

const app = createApp(App)
const pinia = createPinia();

axios.interceptors.request.use(config => {
const token = localStorage.getItem("authToken");
    if (token) {
      // alert(token);
    config.headers.Authorization = `Bearer ${token}`;
      
      alert("header头: "+config.headers.Authorization );
    }else {//注：这个else语句里的代码不需要了是因为，后端对于无token，token验证失败统一返回了401，所以对返回
      //结果作判断进行跳转就可以了，不必在请求头这里作跳转功能的实现
      // 如果没有Token且当前路由不是登录页面，则重定向到登录页面

      // alert('main.js没有 JWT令牌,您尚未登录，请先登录。');
    // if (router.currentRoute.path !== '/login') {
    //     router.replace('/login');
       
    //     // 使用Vue的全局通知系统代替alert
    //   }
 
      // 如果没有 Token 且当前路由不是登录页面，则重定向到登录页面
      if (router.currentRoute.path !== '/signin') {
   
    router.push('/signin'); // 跳转到登录页面

        // 使用 Vue 的全局通知系统代替 alert
      }
 
     
    }
    config.timeout = 10000;

return config;
}, function (error) {
// 对请求错误做些什么
alert("cuowu");
// return Promise.reject(error);
});

app.use(router);
app.use(axios);
app.use(pinia);
app.mount('#app')
