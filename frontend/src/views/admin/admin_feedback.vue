<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar_admin :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="mb-8">
            <!-- Title -->
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Account Settings ✨</h1>
          </div>

          <!-- Content --> 
          <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm mb-8">
            <div class="flex flex-col md:flex-row md:-mr-px">
              <SettingsSidebar_admin />
              <FeedbackPanel />
            </div>
          </div>

        </div>         
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar_admin from '../../partials/Sidebar_admin.vue'
import Header from '../../partials/Header.vue'
import SettingsSidebar_admin from '../../partials/settings/SettingsSidebar_admin.vue'
import FeedbackPanel from '../../partials/settings/FeedbackPanel.vue'

export default {
  name: 'Apps',
  components: {
    Sidebar_admin,
    Header,
    SettingsSidebar_admin,
    FeedbackPanel,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>