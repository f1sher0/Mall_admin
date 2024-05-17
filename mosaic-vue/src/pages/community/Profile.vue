<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden bg-white dark:bg-slate-900">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="relative flex">

          <!-- Profile sidebar -->
          <ProfileSidebar :profileSidebarOpen="profileSidebarOpen" @close-profilesidebar="profileSidebarOpen = false" />

          <!-- Profile body -->
          <ProfileBody :profileSidebarOpen="profileSidebarOpen" @toggle-profilesidebar="profileSidebarOpen = !profileSidebarOpen" />
          
        </div>
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar from '../../partials/Sidebar.vue'
import Header from '../../partials/Header.vue'
import ProfileSidebar from '../../partials/community/ProfileSidebar.vue'
import ProfileBody from '../../partials/community/ProfileBody.vue'

export default {
  name: 'Profile',
  components: {
    Sidebar,
    Header,
    ProfileSidebar,
    ProfileBody,
  }, 
  setup() {

    const sidebarOpen = ref(false)
    const profileSidebarOpen = ref(false)

    return {
      sidebarOpen,
      profileSidebarOpen,
    }  
  }
}
</script>