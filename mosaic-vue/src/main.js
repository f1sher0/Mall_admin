import { createApp } from 'vue'
import router from './router'
import App from './App.vue'
import { createPinia } from 'pinia';
import './css/style.css'
import axios from 'axios';

const app = createApp(App)
const pinia = createPinia();
 
app.use(router);
app.use(axios);
app.use(pinia);
app.mount('#app')
