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
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Roadmap ✨</h1>
            </div>

            <!-- Right: Actions -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">

              <!-- Add board button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="ml-2">Add Event</span>
              </button>

            </div>

          </div>

          <div class="border-t border-slate-200 dark:border-slate-700">
            <div class="max-w-3xl m-auto mt-8">

              <!-- Posts -->
              <div class="xl:-translate-x-16">

                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <h2 class="text-xl leading-snug font-bold text-slate-800 dark:text-slate-100 xl:leading-7 mb-4 xl:mb-0">2021 Q1</h2>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <div class="flex flex-nowrap items-center space-x-2 mb-6">
                          <!-- Avatars -->
                          <div class="flex shrink-0 -space-x-3 -ml-px">
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-05.jpg" width="28" height="28" alt="User 05" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-08.jpg" width="28" height="28" alt="User 08" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-09.jpg" width="28" height="28" alt="User 09" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-06.jpg" width="28" height="28" alt="User 06" />
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2.5 py-1">Completed</div>
                          </div>
                        </div>
                      </header>
                      <!-- List -->
                      <ul class="-my-2">
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Product V1 - Early Access</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Web3 Compatibility</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Proof-of-Funds Compliance Key</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Activity Feed Integration</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </article>

                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <h2 class="text-xl leading-snug font-bold text-slate-800 dark:text-slate-100 xl:leading-7 mb-4 xl:mb-0">2021 Q2</h2>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <div class="flex flex-nowrap items-center space-x-2 mb-6">
                          <!-- Avatars -->
                          <div class="flex shrink-0 -space-x-3 -ml-px">
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-03.jpg" width="28" height="28" alt="User 03" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-05.jpg" width="28" height="28" alt="User 05" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-01.jpg" width="28" height="28" alt="User 01" />
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Working on</div>
                          </div>
                        </div>
                      </header>
                      <!-- List -->
                      <ul class="-my-2">
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Product V1 - Early Access</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Web3 Compatibility</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-indigo-500" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-white" viewBox="0 0 20 20">
                                <path d="M14.4 8.4L13 7l-4 4-2-2-1.4 1.4L9 13.8z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Proof-of-Funds Compliance Key</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 rounded-full bg-white dark:bg-slate-900" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-slate-400 dark:text-slate-500" viewBox="0 0 20 20">
                                <path d="M10 18a8 8 0 100-16 8 8 0 000 16zm0 2C4.477 20 0 15.523 0 10S4.477 0 10 0s10 4.477 10 10-4.477 10-10 10z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Activity Feed Integration</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </article>

                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <h2 class="text-xl leading-snug font-bold text-slate-800 dark:text-slate-100 xl:leading-7 mb-4 xl:mb-0">2021 Q3</h2>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <div class="flex flex-nowrap items-center space-x-2 mb-6">
                          <!-- Avatars -->
                          <div class="flex shrink-0 -space-x-3 -ml-px">
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-06.jpg" width="28" height="28" alt="User 03" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-05.jpg" width="28" height="28" alt="User 05" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-09.jpg" width="28" height="28" alt="User 01" />
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-amber-100 dark:bg-amber-400/30 text-amber-600 dark:text-amber-400 rounded-full text-center px-2.5 py-1">Planned</div>
                          </div>
                        </div>
                      </header>
                      <!-- List -->
                      <ul class="-my-2">
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-white dark:bg-slate-900" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-slate-400 dark:text-slate-500" viewBox="0 0 20 20">
                                <path d="M10 18a8 8 0 100-16 8 8 0 000 16zm0 2C4.477 20 0 15.523 0 10S4.477 0 10 0s10 4.477 10 10-4.477 10-10 10z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Product V1 - Early Access</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 rounded-full bg-white dark:bg-slate-900" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-slate-400 dark:text-slate-500" viewBox="0 0 20 20">
                                <path d="M10 18a8 8 0 100-16 8 8 0 000 16zm0 2C4.477 20 0 15.523 0 10S4.477 0 10 0s10 4.477 10 10-4.477 10-10 10z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Web3 Compatibility</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </article>

                <!-- Post -->
                <article class="pt-6">
                  <div class="xl:flex">
                    <div class="w-32 shrink-0">
                      <h2 class="text-xl leading-snug font-bold text-slate-800 dark:text-slate-100 xl:leading-7 mb-4 xl:mb-0">2021 Q4</h2>
                    </div>
                    <div class="grow pb-6 border-b border-slate-200 dark:border-slate-700">
                      <header>
                        <div class="flex flex-nowrap items-center space-x-2 mb-6">
                          <!-- Avatars -->
                          <div class="flex shrink-0 -space-x-3 -ml-px">
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-06.jpg" width="28" height="28" alt="User 03" />
                            </a>
                            <a class="block" href="#0">
                              <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-28-02.jpg" width="28" height="28" alt="User 02" />
                            </a>
                          </div>
                          <div class="text-slate-400 dark:text-slate-600">·</div>
                          <div>
                            <div class="text-xs inline-flex font-medium bg-amber-100 dark:bg-amber-400/30 text-amber-600 dark:text-amber-400 rounded-full text-center px-2.5 py-1">Planned</div>
                          </div>
                        </div>
                      </header>
                      <!-- List -->
                      <ul class="-my-2">
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 h-full w-0.5 bg-slate-200 dark:bg-slate-700 self-start ml-2.5 -translate-x-1/2 translate-y-3" aria-hidden="true"></div>
                            <div class="absolute left-0 rounded-full bg-white dark:bg-slate-900" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-slate-400 dark:text-slate-500" viewBox="0 0 20 20">
                                <path d="M10 18a8 8 0 100-16 8 8 0 000 16zm0 2C4.477 20 0 15.523 0 10S4.477 0 10 0s10 4.477 10 10-4.477 10-10 10z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Product V1 - Early Access</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                        <!-- List item -->
                        <li class="relative py-2">
                          <div class="flex items-center mb-1">
                            <div class="absolute left-0 rounded-full bg-white dark:bg-slate-900" aria-hidden="true">
                              <svg class="w-5 h-5 fill-current text-slate-400 dark:text-slate-500" viewBox="0 0 20 20">
                                <path d="M10 18a8 8 0 100-16 8 8 0 000 16zm0 2C4.477 20 0 15.523 0 10S4.477 0 10 0s10 4.477 10 10-4.477 10-10 10z" />
                              </svg>
                            </div>
                            <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100 pl-9">Web3 Compatibility</h3>
                          </div>
                          <div class="pl-9">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </article>
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

export default {
  name: 'Roadmap',
  components: {
    Sidebar,
    Header,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>