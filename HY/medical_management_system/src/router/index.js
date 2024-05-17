import Vue from 'vue'
import VueRouter from 'vue-router'
//导入

//import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/pages/LoginView.vue')
  },
  {
    path: '/index',
    name: 'index',
    component: () => import('../views/pages/IndexView.vue'),
  },
  {
    path: '/today',
    name: 'today',
    component: () => import('../views/pages/TodayView.vue')
  },
  {
    path: '/month',
    name: 'month',
    component: () => import('../views/pages/MonthView.vue')
  },
  {
    path: '/emp', //地址hash
    name: 'emp',
    component: () => import('../views/pages/EmpView.vue') //对应的vue组件
  },
  {
    path: '/med',
    name: 'med',
    component: () => import('../views/pages/MedView.vue')
  },
  {
    path: '/cust',
    name: 'cust',
    component: () => import('../views/pages/CustView.vue')
  },
  {
    path: '/supp',
    name: 'supp',
    component: () => import('../views/pages/SuppView.vue')
  },
  {
    path: '/outIns',
    name: 'outIns',
    component: () => import('../views/pages/InView.vue')
  },
  {
    path: '/store',
    name: 'store',
    component: () => import('../views/pages/StoreView.vue')
  },
  {
    path: '/sale',
    name: 'sale',
    component: () => import('../views/pages/SaleView.vue')
  },
  {
    path: '/',
    redirect: '/login' //表示重定向
  },

]
const router = new VueRouter({
  // mode:'history',
  routes
})


export default router
