<template>
    <div class="flex h-[100dvh] overflow-hidden">
  
      <!-- Sidebar -->
      <Sidebar_admin :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />
  
      <!-- Content area -->
      <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
        
        <!-- Site header -->
        <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />
  
        <main class="grow dark:bg-slate-900">
          <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">
  
            <!-- Welcome banner -->
            <WelcomeBanner />

          </div>
        </main>
  
      </div> 
  
    </div>
  </template>
  
  <script>
  import { ref } from 'vue'
  import Header from '../../partials/Header.vue'
  import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
  import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
  import Sidebar_admin from '../../partials/Sidebar_admin.vue'
  
  export default {
    name: 'Dashboard',
    components: {
      Sidebar_admin,
      Header,
      WelcomeBanner,
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