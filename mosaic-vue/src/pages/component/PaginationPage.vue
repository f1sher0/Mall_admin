<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden bg-white dark:bg-slate-900">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="mb-8">
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Pagination ✨</h1>
          </div>

          <div class="border-t border-slate-200 dark:border-slate-700">

            <!-- Components -->
            <div class="space-y-8 mt-8">

              <!-- Option 1 -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Option 1</h2>
                <div class="px-6 py-8 bg-slate-50 dark:bg-slate-800 border border-slate-200 dark:border-slate-700 rounded-sm">
                  <PaginationNumeric />
                </div>
              </div>

              <!-- Option 2 -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Option 2</h2>
                <div class="px-6 py-8 bg-slate-50 dark:bg-slate-800 border border-slate-200 dark:border-slate-700 rounded-sm">
                  <PaginationClassic />
                </div>
              </div>

              <!-- Option 3 -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Option 3</h2>
                <div class="px-6 py-8 bg-slate-50 dark:bg-slate-800 border border-slate-200 dark:border-slate-700 rounded-sm">
                  <PaginationNumeric2 />
                </div>
              </div>

            </div>

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
import PaginationNumeric from '../../components/PaginationNumeric.vue'
import PaginationClassic from '../../components/PaginationClassic.vue'
import PaginationNumeric2 from '../../components/PaginationNumeric2.vue'

export default {
  name: 'PaginationPage',
  components: {
    Sidebar,
    Header,
    PaginationNumeric,
    PaginationClassic,
    PaginationNumeric2,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>