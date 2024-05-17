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
          <div class="sm:flex sm:justify-between sm:items-center mb-8">

            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Changelog ✨</h1>
            </div>

            <!-- Right: Actions -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">

              <!-- Add board button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="ml-2">Add Entry</span>
              </button>

            </div>

          </div>

          <div class="border-t border-slate-200 dark:border-slate-700">
            <div class="max-w-3xl m-auto mt-8">

              <!-- Filters -->
              <div class="xl:pl-32 xl:-translate-x-16 mb-2">
                <ul class="flex flex-wrap -m-1">
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-transparent shadow-sm bg-indigo-500 text-white duration-150 ease-in-out">View All</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Announcements</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Bug Fix</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Product</button>
                  </li>
                  <li class="m-1">
                    <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Exciting News</button>
                  </li>
                </ul>
              </div>

              <!-- Posts -->
              <div class="xl:-translate-x-16">
                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <div class="text-xs font-semibold uppercase text-slate-400 dark:text-slate-500 xl:leading-8">8 July, 2021</div>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-3">Released version 2.0</h2>
                        <div class="flex flex-nowrap items-center space-x-2 mb-4">
                          <div class="flex items-center">
                            <a class="block mr-2 shrink-0" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-07.jpg" width="32" height="32" alt="User 04" />
                            </a>
                            <a class="block text-sm font-semibold text-slate-800 dark:text-slate-100" href="#0">
                              Simona Lürwer
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2.5 py-1">Product</div>
                          </div>
                        </div>
                      </header>
                      <div class="space-y-3">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur excepteur sint occaecat cupidatat non proident.</p>
                      </div>
                    </div>
                  </div>
                </article>
                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <div class="text-xs font-semibold uppercase text-slate-400 dark:text-slate-500 xl:leading-8">6 July, 2021</div>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-3">Feature Name is now public 🎉</h2>
                        <div class="flex flex-nowrap items-center space-x-2 mb-4">
                          <div class="flex items-center">
                            <a class="block mr-2 shrink-0" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-02.jpg" width="32" height="32" alt="User 04" />
                            </a>
                            <a class="block text-sm font-semibold text-slate-800 dark:text-slate-100" href="#0">
                              Danielle Cohen
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-amber-100 dark:bg-amber-400/30 text-amber-600 dark:text-amber-400 rounded-full text-center px-2.5 py-1">Announcement</div>
                          </div>
                        </div>
                      </header>
                      <div class="space-y-3">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur excepteur sint occaecat cupidatat non proident.</p>
                      </div>
                    </div>
                  </div>
                </article>
                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <div class="text-xs font-semibold uppercase text-slate-400 dark:text-slate-500 xl:leading-8">4 July, 2021</div>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-3">Bugs fixed, issues, and more</h2>
                        <div class="flex flex-nowrap items-center space-x-2 mb-4">
                          <div class="flex items-center">
                            <a class="block mr-2 shrink-0" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-01.jpg" width="32" height="32" alt="User 04" />
                            </a>
                            <a class="block text-sm font-semibold text-slate-800 dark:text-slate-100" href="#0">
                              Patrick Kumar
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-rose-100 dark:bg-rose-500/30 text-rose-500 dark:text-rose-400 rounded-full text-center px-2.5 py-1">Bug Fix</div>
                          </div>
                        </div>
                      </header>
                      <div class="space-y-3">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur excepteur sint occaecat cupidatat non proident.</p>
                        <ul class="list-disc list-inside space-y-1">
                          <li>E-commerce: Better lorem ipsum generator.</li>
                          <li>Booking: Lorem ipsum post generator.</li>
                          <li>Retail: Better lorem ipsum generator.</li>
                          <li>Services: Better lorem ipsum generator.</li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </article>
                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <div class="text-xs font-semibold uppercase text-slate-400 dark:text-slate-500 xl:leading-8">2 July, 2021</div>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-3">Thanks, everyone 🙌</h2>
                        <div class="flex flex-nowrap items-center space-x-2 mb-4">
                          <div class="flex items-center">
                            <a class="block mr-2 shrink-0" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-02.jpg" width="32" height="32" alt="User 04" />
                            </a>
                            <a class="block text-sm font-semibold text-slate-800 dark:text-slate-100" href="#0">
                              Danielle Cohen
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-sky-100 dark:bg-sky-500/30 text-sky-600 dark:text-sky-400 rounded-full text-center px-2.5 py-1">Exciting News</div>
                          </div>
                        </div>
                      </header>
                      <div class="space-y-3">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur excepteur sint occaecat cupidatat non proident.</p>
                      </div>
                    </div>
                  </div>
                </article>
              </div>

              <!-- Pagination -->
              <div class="xl:pl-32 xl:-translate-x-16 mt-6">
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
import PaginationClassic from '../../components/PaginationClassic.vue'

export default {
  name: 'Changelog',
  components: {
    Sidebar,
    Header,
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