<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">

      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full">

          <!-- Page content -->
          <div class="max-w-5xl mx-auto flex flex-col lg:flex-row lg:space-x-8 xl:space-x-16">

            <!-- Content -->
            <div>
              <div class="mb-6">
                <router-link class="btn-sm px-3 bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" to="/community/meetups">
                  <svg class="fill-current text-slate-400 dark:text-slate-500 mr-2" width="7" height="12" viewBox="0 0 7 12">
                    <path d="M5.4.6 6.8 2l-4 4 4 4-1.4 1.4L0 6z" />
                  </svg>
                  <span>Back To Meetups</span>
                </router-link>
              </div>
              <div class="text-sm font-semibold text-indigo-500 uppercase mb-2">Mon 27 Dec, 2021 - 9:00 PM -&gt; 10:00 PM</div>
              <header class="mb-4">
                <!-- Title -->
                <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold mb-2">The World of AI and Machine Learning — Open Chat</h1>
                <p>Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.</p>
              </header>

              <!-- Meta -->
              <div class="space-y-3 sm:flex sm:items-center sm:justify-between sm:space-y-0 mb-6">
                <!-- Author -->
                <div class="flex items-center sm:mr-4">
                  <a class="block mr-2 shrink-0" href="#0">
                    <img class="rounded-full" src="../../images/user-32-07.jpg" width="32" height="32" alt="User 04" />
                  </a>
                  <div class="text-sm whitespace-nowrap">Hosted by <a class="font-semibold text-slate-800 dark:text-slate-100" href="#0">Monica Fishkin</a></div>
                </div>
                <!-- Right side -->
                <div class="flex flex-wrap items-center sm:justify-end space-x-2">
                  <!-- Tags -->
                  <div class="text-xs inline-flex items-center font-medium bg-white dark:bg-slate-700 text-slate-600 dark:text-slate-400 rounded-full text-center px-2.5 py-1">
                    <svg class="w-4 h-3 fill-slate-400 dark:fill-slate-500 mr-2" viewBox="0 0 16 12">
                      <path d="m16 2-4 2.4V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V7.6l4 2.4V2ZM2 10V2h8v8H2Z" />
                    </svg>
                    <span>Online Event</span>
                  </div>
                  <div class="text-xs inline-flex font-medium uppercase bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2.5 py-1">Free</div>
                </div>
              </div>

              <!-- Image -->
              <figure class="mb-6">
                <img class="w-full rounded-sm" src="../../images/meetup-image.jpg" width="640" height="360" alt="Meetup" />
              </figure>

              <!-- Post content -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Meetup Details</h2>
                <p class="mb-6">In the world of AI, behavioural predictions are leading the charge to better machine learning.</p>
                <p class="mb-6">There is so much happening in the AI space. Advances in the economic sectors have seen automated business practices rapidly increasing economic value. While the realm of the human sciences has used the power afforded by computational capabilities to solve many human based dilemmas. Even the art scene has adopted carefully selected ML applications to usher in the technological movement.</p>
                <p class="mb-6">Join us every second Wednesday as we host an open discussion about the amazing things happening in the world of AI and machine learning. Feel free to share your experiences, ask questions, ponder the possibilities, or just listen as we explore new topics and revisit old ones.</p>
              </div>

              <hr class="my-6 border-t border-slate-200 dark:border-slate-700" />

              <!-- Photos -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Photos (3)</h2>
                <div class="grid grid-cols-3 gap-4 my-6">
                  <a class="block" href="#0">
                    <img class="w-full rounded-sm" src="../../images/meetup-photo-01.jpg" width="203" height="152" alt="Meetup photo 01" />
                  </a>
                  <a class="block" href="#0">
                    <img class="w-full rounded-sm" src="../../images/meetup-photo-02.jpg" width="203" height="152" alt="Meetup photo 02" />
                  </a>
                  <a class="block" href="#0">
                    <img class="w-full rounded-sm" src="../../images/meetup-photo-03.jpg" width="203" height="152" alt="Meetup photo 03" />
                  </a>
                </div>
              </div>

              <hr class="my-6 border-t border-slate-200 dark:border-slate-700" />

              <!-- Comments -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Comments (3)</h2>
                <ul class="space-y-5 my-6">
                  <!-- Comment -->
                  <li class="flex items-start">
                    <a class="block mr-3 shrink-0" href="#0">
                      <img class="rounded-full" src="../../images/user-32-07.jpg" width="32" height="32" alt="User 07" />
                    </a>
                    <div class="grow">
                      <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-2">Taylor Nieman</div>
                      <div class="italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                    </div>
                  </li>
                  <!-- Comment -->
                  <li class="flex items-start">
                    <a class="block mr-3 shrink-0" href="#0">
                      <img class="rounded-full" src="../../images/user-32-08.jpg" width="32" height="32" alt="User 08" />
                    </a>
                    <div class="grow">
                      <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-2">Meagan Loyst</div>
                      <div class="italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                    </div>
                  </li>
                  <!-- Comment -->
                  <li class="flex items-start">
                    <a class="block mr-3 shrink-0" href="#0">
                      <img class="rounded-full" src="../../images/user-32-02.jpg" width="32" height="32" alt="User 02" />
                    </a>
                    <div class="grow">
                      <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-2">Frank Malik</div>
                      <div class="italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                    </div>
                  </li>
                </ul>
              </div>

              <hr class="my-6 border-t border-slate-200 dark:border-slate-700" />

              <!-- Similar Meetups -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Similar Meetups</h2>
                <div class="space-y-8 sm:space-y-5 my-6 lg:mb-0">
                  <!-- Related item -->
                  <article class="flex bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 overflow-hidden">
                    <!-- Image -->
                    <a class="relative block w-24 sm:w-56 lg:sidebar-expanded:w-20 xl:sidebar-expanded:w-56 shrink-0" href="#0">
                      <img class="absolute object-cover object-center w-full h-full" src="../../images/meetups-thumb-02.jpg" width="220" height="236" alt="Meetup 02" />
                      <!-- Like button -->
                      <button class="absolute top-0 right-0 mt-4 mr-4">
                        <div class="text-slate-100 bg-slate-900 bg-opacity-60 rounded-full">
                          <span class="sr-only">Like</span>
                          <svg class="h-8 w-8 fill-current" viewBox="0 0 32 32">
                            <path d="M22.682 11.318A4.485 4.485 0 0019.5 10a4.377 4.377 0 00-3.5 1.707A4.383 4.383 0 0012.5 10a4.5 4.5 0 00-3.182 7.682L16 24l6.682-6.318a4.5 4.5 0 000-6.364zm-1.4 4.933L16 21.247l-5.285-5A2.5 2.5 0 0112.5 12c1.437 0 2.312.681 3.5 2.625C17.187 12.681 18.062 12 19.5 12a2.5 2.5 0 011.785 4.251h-.003z" />
                          </svg>
                        </div>
                      </button>
                    </a>
                    <!-- Content -->
                    <div class="grow p-5 flex flex-col">
                      <div class="grow">
                        <div class="text-sm font-semibold text-indigo-500 uppercase mb-2">Mon 27 Dec, 2021</div>
                        <a class="inline-flex mb-2" href="#0">
                          <h3 class="text-lg font-bold text-slate-800 dark:text-slate-100">New York & New Jersey Virtual Retreat 2021</h3>
                        </a>
                        <div class="text-sm">Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.</div>
                      </div>
                      <!-- Footer -->
                      <div class="flex justify-between mt-3">
                        <!-- Tag -->
                        <div class="text-xs inline-flex items-center font-medium bg-slate-100 dark:bg-slate-700 text-slate-600 dark:text-slate-400 rounded-full text-center px-2.5 py-1">
                          <svg class="w-4 h-3 fill-slate-400 dark:fill-slate-500 mr-2" viewBox="0 0 16 12">
                            <path d="m16 2-4 2.4V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V7.6l4 2.4V2ZM2 10V2h8v8H2Z" />
                          </svg>
                          <span>Online Event</span>
                        </div>
                        <!-- Avatars -->
                        <div class="flex items-center space-x-2">
                          <div class="flex -space-x-3 -ml-0.5">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-02.jpg" width="28" height="28" alt="User 02" />
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-03.jpg" width="28" height="28" alt="User 03" />
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-04.jpg" width="28" height="28" alt="User 04" />
                          </div>
                          <div class="text-xs font-medium text-slate-400 dark:text-slate-500 italic">+132</div>
                        </div>
                      </div>
                    </div>
                  </article>
                </div>
              </div>

            </div>

            <!-- Sidebar -->
            <div class="space-y-4">

              <!-- 1st block -->
              <div class="bg-white dark:bg-slate-800 p-5 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 lg:w-72 xl:w-80">
                <div class="space-y-2">
                  <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white">
                    <svg class="w-4 h-4 fill-current shrink-0" viewBox="0 0 16 16">
                      <path d="m2.457 8.516.969-.99 2.516 2.481 5.324-5.304.985.989-6.309 6.284z" />
                    </svg>
                    <span class="ml-1">Attending</span>
                  </button>
                  <button class="btn w-full dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300">
                    <svg class="w-4 h-4 fill-rose-500 shrink-0" viewBox="0 0 16 16">
                      <path d="M14.682 2.318A4.485 4.485 0 0 0 11.5 1 4.377 4.377 0 0 0 8 2.707 4.383 4.383 0 0 0 4.5 1a4.5 4.5 0 0 0-3.182 7.682L8 15l6.682-6.318a4.5 4.5 0 0 0 0-6.364Zm-1.4 4.933L8 12.247l-5.285-5A2.5 2.5 0 0 1 4.5 3c1.437 0 2.312.681 3.5 2.625C9.187 3.681 10.062 3 11.5 3a2.5 2.5 0 0 1 1.785 4.251h-.003Z" />
                    </svg>
                    <span class="ml-2">Favorite</span>
                  </button>
                </div>
              </div>

              <!-- 2nd block -->
              <div class="bg-white dark:bg-slate-800 p-5 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 lg:w-72 xl:w-80">
                <div class="flex justify-between space-x-1 mb-5">
                  <div class="text-sm text-slate-800 dark:text-slate-100 font-semibold">Attendees (127)</div>
                  <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">View All</a>
                </div>
                <ul class="space-y-3">
                  <li>
                    <div class="flex justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-08.jpg" width="32" height="32" alt="User 08" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Carolyn McNeail</span>
                        </div>
                      </div>
                      <button class="text-slate-400 hover:text-slate-500 dark:text-slate-500 dark:hover:text-slate-400 rounded-full">
                        <span class="sr-only">Menu</span>
                        <svg class="w-8 h-8 fill-current" viewBox="0 0 32 32">
                          <circle cx="16" cy="16" r="2" />
                          <circle cx="10" cy="16" r="2" />
                          <circle cx="22" cy="16" r="2" />
                        </svg>
                      </button>
                    </div>
                  </li>
                  <li>
                    <div class="flex justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-01.jpg" width="32" height="32" alt="User 01" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Dominik Lamakani</span>
                        </div>
                      </div>
                      <button class="text-slate-400 hover:text-slate-500 dark:text-slate-500 dark:hover:text-slate-400 rounded-full">
                        <span class="sr-only">Menu</span>
                        <svg class="w-8 h-8 fill-current" viewBox="0 0 32 32">
                          <circle cx="16" cy="16" r="2" />
                          <circle cx="10" cy="16" r="2" />
                          <circle cx="22" cy="16" r="2" />
                        </svg>
                      </button>
                    </div>
                  </li>
                  <li>
                    <div class="flex justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-03.jpg" width="32" height="32" alt="User 03" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Ivan Mesaros</span>
                        </div>
                      </div>
                      <button class="text-slate-400 hover:text-slate-500 dark:text-slate-500 dark:hover:text-slate-400 rounded-full">
                        <span class="sr-only">Menu</span>
                        <svg class="w-8 h-8 fill-current" viewBox="0 0 32 32">
                          <circle cx="16" cy="16" r="2" />
                          <circle cx="10" cy="16" r="2" />
                          <circle cx="22" cy="16" r="2" />
                        </svg>
                      </button>
                    </div>
                  </li>
                  <li>
                    <div class="flex justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-05.jpg" width="32" height="32" alt="User 05" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Maria Martinez</span>
                        </div>
                      </div>
                      <button class="text-slate-400 hover:text-slate-500 dark:text-slate-500 dark:hover:text-slate-400 rounded-full">
                        <span class="sr-only">Menu</span>
                        <svg class="w-8 h-8 fill-current" viewBox="0 0 32 32">
                          <circle cx="16" cy="16" r="2" />
                          <circle cx="10" cy="16" r="2" />
                          <circle cx="22" cy="16" r="2" />
                        </svg>
                      </button>
                    </div>
                  </li>
                </ul>
              </div>

              <!-- 3rd block -->
              <div class="bg-white dark:bg-slate-800 p-5 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 lg:w-72 xl:w-80">
                <div class="flex justify-between space-x-1 mb-5">
                  <div class="text-sm text-slate-800 dark:text-slate-100 font-semibold">Invite Friends</div>
                  <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">View All</a>
                </div>
                <ul class="space-y-3">
                  <li>
                    <div class="flex items-center justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-02.jpg" width="32" height="32" alt="User 02" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Haruki Masuno</span>
                        </div>
                      </div>
                      <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Invite</button>
                    </div>
                  </li>
                  <li>
                    <div class="flex items-center justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-04.jpg" width="32" height="32" alt="User 04" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Joe Huang</span>
                        </div>
                      </div>
                      <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Invite</button>
                    </div>
                  </li>
                  <li>
                    <div class="flex items-center justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-06.jpg" width="32" height="32" alt="User 06" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Carolyn McNeail</span>
                        </div>
                      </div>
                      <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Invite</button>
                    </div>
                  </li>
                  <li>
                    <div class="flex items-center justify-between">
                      <div class="grow flex items-center">
                        <div class="relative mr-3">
                          <img class="w-8 h-8 rounded-full" src="../../images/user-32-08.jpg" width="32" height="32" alt="User 08" />
                        </div>
                        <div class="truncate">
                          <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Lisa Sitwala</span>
                        </div>
                      </div>
                      <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Invite</button>
                    </div>
                  </li>
                </ul>
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
  name: 'MeetupsPost',
  components: {
    Sidebar,
    Header,
  },
  setup() {
    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }
  },
}
</script>