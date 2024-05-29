import axios from 'axios';

// 创建一个axios实例，配置基本URL
const instance = axios.create({
  baseURL: 'http://localhost:5052/api', // 在这里设置你的后端请求路径
});

// 可以在实例中自定义其他配置，例如设置请求头或拦截器等

export default instance;