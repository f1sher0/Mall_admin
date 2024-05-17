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

                  <!-- Buttons group -->
                  <div class="mb-4">
                    <div class="w-full flex flex-wrap -space-x-px">
                        <button class="btn grow bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 text-indigo-500 rounded-none first:rounded-l last:rounded-r">Popular</button>
                        <button class="btn grow bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:bg-slate-50 dark:hover:bg-slate-700/20 text-slate-600 dark:text-slate-300 rounded-none first:rounded-l last:rounded-r">Newest</button>
                        <button class="btn grow bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:bg-slate-50 dark:hover:bg-slate-700/20 text-slate-600 dark:text-slate-300 rounded-none first:rounded-l last:rounded-r">Following</button>
                    </div>
                  </div>

                  <!-- Forum entries -->
                  <div class="space-y-2">
                    <ForumEntries />
                  </div>

                  <!-- Pagination -->
                  <div class="mt-6 text-right">
                    <nav class="inline-flex" role="navigation" aria-label="Navigation">
                      <ul class="flex justify-center">
                        <li class="ml-3 first:ml-0">
                          <span class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 text-slate-300 dark:text-slate-600">&lt;- Previous</span>
                        </li>
                        <li class="ml-3 first:ml-0">
                          <a class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500" href="#0">Next -&gt;</a>
                        </li>
                      </ul>
                    </nav>
                  </div>

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
import ForumEntries from '../../partials/community/ForumEntries.vue'
import ForumRightContent from '../../partials/community/ForumRightContent.vue'

export default {
  name: 'Forum',
  components: {
    Sidebar,
    Header,
    ForumLeftContent,
    ForumEntries,
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