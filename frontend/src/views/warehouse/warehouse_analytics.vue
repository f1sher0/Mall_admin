<template>
    <div class="flex h-[100dvh] overflow-hidden">
  
      <!-- Sidebar -->
      <Sidebar_warehouse :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />
  
      <!-- Content area -->
      <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
        
        <!-- Site header -->
        <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />
  
        <main class="grow dark:bg-slate-900">
          
        </main>
  
      </div> 
  
    </div>
  </template>
  
  <script>
  import { ref } from 'vue'
  import Header from '../../partials/Header.vue'
  import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
  import Sidebar_warehouse from '../../partials/Sidebar_warehouse.vue'
  
  export default {
    name: 'Dashboard',
    components: {
      Sidebar_warehouse,
      Header,
      DashboardAvatars,
    },
    setup() {
  
      const sidebarOpen = ref(false)
  
      return {
        sidebarOpen,
      }  
    }
  }
  </script>