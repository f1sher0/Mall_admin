import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueRouter from 'vue-router';
import ElementUI, { Alert } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from "axios";
Vue.prototype.$axios=axios;
Vue.prototype.$httpUrl='http://localhost:5052'
 
    // 如果Token存在，将它添加到请求头中反引号（）是ES6中的模板字符串，
      //用于拼接字符串和变量。在这里，使用模板字符串是正确的，因为它允许我们将变量token`嵌入到字符串中。
      // config.headers.Authorization = `Bearer ${token}`;
 
    //   axios.interceptors.request.use(function (config) {
    //     const token = localStorage.getItem("JWTToken");
    //     if (token && !config.url.endsWith('/login')) {
    //         config.headers.Authorization = "Bearer " + token;
    //     }
    //     return config;
    // }, function (error) {
    //     return Promise.reject(error);
    // });
        
    // axios.defaults.headers.common["Authorization"] = `Bearer ${localStorage.getItem("JWTToken")}`;  
axios.interceptors.request.use(config => {

    
    // if (config.url !== Vue.prototype.$httpUrl + '/emps/user/login') {
      const token = localStorage.getItem("JWTToken");
      if (token) {
        // alert(token);
      config.headers.Authorization = `Bearer ${token}`;
        
        // alert("header头: "+config.headers.Authorization );
      }else {//注：这个else语句里的代码不需要了是因为，后端对于无token，token验证失败统一返回了401，所以对返回
        //结果作判断进行跳转就可以了，不必在请求头这里作跳转功能的实现
        // 如果没有Token且当前路由不是登录页面，则重定向到登录页面

        // alert('main.js没有 JWT令牌,您尚未登录，请先登录。');
      // if (router.currentRoute.path !== '/login') {
      //     router.replace('/login');
         
      //     // 使用Vue的全局通知系统代替alert
      //   }
     
       
      }
      // alert("main  token"+ token);
 
 
 
 
  // 设置请求超时时间为10秒，根据实际情况调整
  config.timeout = 10000;
  
  return config;
}, function (error) {
  // 对请求错误做些什么
  alert("cuowu");
  // return Promise.reject(error);
});

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter);
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
