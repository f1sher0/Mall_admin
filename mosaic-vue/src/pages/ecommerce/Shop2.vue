<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="mb-5">

            <!-- Title -->
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Find the right product for you ✨</h1>

          </div>

          <!-- Page content -->
          <div class="flex flex-col space-y-10 sm:flex-row sm:space-x-6 sm:space-y-0 md:flex-col md:space-x-0 md:space-y-10 xl:flex-row xl:space-x-6 xl:space-y-0 mt-9">

            <!-- Sidebar -->
            <ShopSidebar />

            <!-- Content -->
            <div>

              <!-- Filters -->
              <div class="mb-5">
                <ul class="flex flex-wrap -m-1">
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-transparent shadow-sm bg-indigo-500 text-white duration-150 ease-in-out">View All</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Featured</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Newest</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Price - Low To High</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Price - High to Low</button>
                  </li>
                </ul>
              </div>

              <div class="text-sm text-slate-500 dark:text-slate-400 italic mb-4">67.975 Items</div>

              <!-- Cards 1 (Video Courses) -->
              <div>
                <div class="grid grid-cols-12 gap-6">
                  <ShopCards07 />
                </div>
              </div>

              <!-- Pagination -->
              <div class="mt-6">
                <PaginationClassic />
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
import ShopSidebar from '../../partials/ecommerce/ShopSidebar.vue'
import ShopCards07 from '../../partials/ecommerce/ShopCards07.vue'
import PaginationClassic from '../../components/PaginationClassic.vue'

export default {
  name: 'Shop2',
  components: {
    Sidebar,
    Header,
    ShopSidebar,
    ShopCards07,    
    PaginationClassic,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>