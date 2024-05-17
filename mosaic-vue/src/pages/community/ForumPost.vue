<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 md:py-0 w-full max-w-9xl mx-auto">

          <div class="xl:flex">

            <!-- Left + Middle content -->
            <div class="md:flex flex-1">

              <!-- Left content -->
              <ForumLeftContent />

              <!-- Middle content -->
              <div class="flex-1 md:ml-8 xl:mx-4 2xl:mx-8">
                <div class="md:py-8">

                  <!-- Forum entry -->
                  <ForumEntry />

                </div>
              </div>

            </div>

            <!-- Right content -->
            <ForumRightContent />

          </div>
          
        </div>
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar from '../../partials/Sidebar.vue'
import Header from '../../partials/Header.vue'
import ForumLeftContent from '../../partials/community/ForumLeftContent.vue'
import ForumEntry from '../../partials/community/ForumEntry.vue'
import ForumRightContent from '../../partials/community/ForumPostRightContent.vue'

export default {
  name: 'ForumPost',
  components: {
    Sidebar,
    Header,
    ForumLeftContent,
    ForumEntry,
    ForumRightContent,
  }, 
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>