import { createApp } from 'vue'
import router from './router'
import App from './App.vue'

import './css/style.css'
import axios from "axios";
Vue.prototype.$axios=axios;
Vue.prototype.$httpUrl='http://localhost:5052'
 
const app = createApp(App)
app.use(router)
app.mount('#app')