import axios from 'axios';
 
import { ElMessage, ElMessageBox ,ElNotification} from 'element-plus'
 
// 创建一个axios实例，配置基本URL
const instance = (router) => {
  const instance = axios.create({
    baseURL: 'http://localhost:5052/api', // 在这里设置你的后端请求路径
  });

// 可以在实例中自定义其他配置，例如设置请求头或拦截器等
// 请求拦截器
instance.interceptors.request.use(
  config => {
    const token = sessionStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    console.log('Request:', config); // 调试输出
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

// 响应拦截器
instance.interceptors.response.use(
  response => response,
  error => {
    if (error.response && error.response.status === 401) {
      // 清除token并跳转到登录页面
      sessionStorage.removeItem('token');
      sessionStorage.clear();
      ElNotification({
        title: 'Error',
        message: "用户token验证失败,请登录",
        type: 'error',
        position: 'top-right',
      });
     router.push('/signin');  
    }
   
    return Promise.reject(error);
  }
);
 
return instance;
};
export default instance;