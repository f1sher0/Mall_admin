<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar_warehouse :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">

      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow dark:bg-slate-900">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="mb-8">
            <!-- Title -->
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Account Settings ✨</h1>
          </div>

          <!-- Content -->
          <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm mb-8">
            <div class="flex flex-col md:flex-row md:-mr-px">
              <SettingsSidebar_warehouse />
              <AccountPanel />
            </div>
          </div>

        </div>
      </main>

    </div>

  </div>
</template>

<script>
import { ref } from 'vue'
import Header from '../../partials/Header.vue'
import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
import Sidebar_warehouse from '../../partials/Sidebar_warehouse.vue'
import SettingsSidebar_warehouse from '../../partials/settings/SettingsSidebar_warehouse.vue'
import AccountPanel from '../../partials/settings/AccountPanel.vue'

export default {
  name: 'Dashboard',
  components: {
    Sidebar_warehouse,
    Header,
    DashboardAvatars,
    SettingsSidebar_warehouse,
    AccountPanel,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }
  }
}
</script>