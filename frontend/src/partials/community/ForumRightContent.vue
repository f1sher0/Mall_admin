<template>
  <div class="w-full hidden xl:block xl:w-72">
    <div class="lg:sticky lg:top-16 lg:h-[calc(100dvh-64px)] lg:overflow-x-hidden lg:overflow-y-auto no-scrollbar">
      <div class="md:py-8">

        <!-- Button -->
        <div class="mb-6">
          <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white">Create Post</button>
        </div>

        <!-- Blocks -->
        <div class="space-y-4">

          <!-- Block 1 -->
          <div class="bg-slate-50 dark:bg-slate-800/20 p-4 rounded border border-slate-200 dark:border-slate-700">
            <div class="text-xs font-semibold text-slate-400 dark:text-slate-500 uppercase mb-4">Forum Meetups</div>
            <ul>
              <!-- Event 1 -->
              <li class="relative pb-4 last-of-type:pb-0">
                <div class="pl-6">
                  <div class="text-xs font-medium uppercase text-indigo-600 mb-0.5">Mon 27 Dec</div>
                  <div class="text-sm mb-2">
                    <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Silicon Valley Bootstrapper Breakfast Online for 2021</a>
                  </div>
                  <!-- Avatars -->
                  <div class="flex items-center space-x-2">
                    <div class="flex -space-x-3 -ml-0.5">
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-02.jpg" width="28" height="28" alt="User 02" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-03.jpg" width="28" height="28" alt="User 03" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-04.jpg" width="28" height="28" alt="User 04" />
                    </div>
                    <div class="text-xs font-medium text-slate-400 dark:text-slate-500 italic">+22</div>
                  </div>
                </div>
                <!-- Timeline element -->
                <div aria-hidden="true">
                  <div class="absolute top-0.5 -bottom-1 left-0.5 ml-px w-0.5 bg-slate-200 dark:bg-slate-700"></div>
                  <div class="absolute top-0.5 left-0 -ml-0.5 w-3 h-3 rounded-full bg-slate-400 dark:bg-slate-700 border-2 border-slate-50 dark:border-slate-900"></div>
                </div>
              </li>
              <!-- Event 2 -->
              <li class="relative pb-4 last-of-type:pb-0">
                <div class="pl-6">
                  <div class="text-xs font-medium uppercase text-indigo-600 mb-0.5">Mon 27 Dec</div>
                  <div class="text-sm mb-2">
                    <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">New York & New Jersey Virtual Retreat</a>
                  </div>
                  <!-- Avatars -->
                  <div class="flex items-center space-x-2">
                    <div class="flex -space-x-3 -ml-0.5">
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-01.jpg" width="28" height="28" alt="User 01" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-04.jpg" width="28" height="28" alt="User 04" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-05.jpg" width="28" height="28" alt="User 05" />
                    </div>
                    <div class="text-xs font-medium text-slate-400 dark:text-slate-500 italic">+132</div>
                  </div>
                </div>
                <!-- Timeline element -->
                <div aria-hidden="true">
                  <div class="absolute top-0.5 -bottom-1 left-0.5 ml-px w-0.5 bg-slate-200 dark:bg-slate-700"></div>
                  <div class="absolute top-0.5 left-0 -ml-0.5 w-3 h-3 rounded-full bg-slate-400 dark:bg-slate-700 border-2 border-slate-50 dark:border-slate-900"></div>
                </div>
              </li>
              <!-- Event 3 -->
              <li class="relative pb-4 last-of-type:pb-0">
                <div class="pl-6">
                  <div class="text-xs font-medium uppercase text-indigo-600 mb-0.5">Mon 29 Dec</div>
                  <div class="text-sm mb-2">
                    <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">The World of AI and Machine Learning - Open Chat</a>
                  </div>
                  <!-- Avatars -->
                  <div class="flex items-center space-x-2">
                    <div class="flex -space-x-3 -ml-0.5">
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-06.jpg" width="28" height="28" alt="User 06" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-03.jpg" width="28" height="28" alt="User 03" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-01.jpg" width="28" height="28" alt="User 01" />
                    </div>
                    <div class="text-xs font-medium text-slate-400 dark:text-slate-500 italic">+12</div>
                  </div>
                </div>
                <!-- Timeline element -->
                <div aria-hidden="true">
                  <div class="absolute top-0.5 -bottom-1 left-0.5 ml-px w-0.5 bg-slate-200 dark:bg-slate-700"></div>
                  <div class="absolute top-0.5 left-0 -ml-0.5 w-3 h-3 rounded-full bg-slate-400 dark:bg-slate-700 border-2 border-slate-50 dark:border-slate-900"></div>
                </div>
              </li>
              <!-- Event 4 -->
              <li class="relative pb-4 last-of-type:pb-0">
                <div class="pl-6">
                  <div class="text-xs font-medium uppercase text-indigo-600 mb-0.5">Mon 29 Dec</div>
                  <div class="text-sm mb-2">
                    <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">NYC Code & Coffee 2.0 @ Freehold Brooklyn</a>
                  </div>
                  <!-- Avatars -->
                  <div class="flex items-center space-x-2">
                    <div class="flex -space-x-3 -ml-0.5">
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-03.jpg" width="28" height="28" alt="User 03" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-05.jpg" width="28" height="28" alt="User 05" />
                      <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/avatar-04.jpg" width="28" height="28" alt="User 04" />
                    </div>
                    <div class="text-xs font-medium text-slate-400 dark:text-slate-500 italic">+17</div>
                  </div>
                </div>
                <!-- Timeline element -->
                <div aria-hidden="true">
                  <div class="absolute top-0.5 -bottom-1 left-0.5 ml-px w-0.5 bg-slate-200 dark:bg-slate-700"></div>
                  <div class="absolute top-0.5 left-0 -ml-0.5 w-3 h-3 rounded-full bg-slate-400 dark:bg-slate-700 border-2 border-slate-50 dark:border-slate-900"></div>
                </div>
              </li>
            </ul>
            <div class="mt-4">
              <button class="btn-sm w-full bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500 shadow-none">View All</button>
            </div>
          </div>

          <!-- Block 2 -->
          <div class="bg-slate-50 dark:bg-slate-800/20 p-4 rounded border border-slate-200 dark:border-slate-700">
            <div class="text-xs font-semibold text-slate-400 dark:text-slate-500 uppercase mb-4">Popular Stories</div>
            <ul class="space-y-3">
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">I built and sold 2 small SaaS products and quit my job in the last two years — AMA</a>
                </div>
                <div class="text-xs text-slate-500"><a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">markusj</a> · 2d · 312 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Besides Product Hunt, where else should I promote my new project? 🤔</a>
                </div>
                <div class="text-xs text-slate-500"><a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">katemerlu</a> · 2h · 7 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Which are the main channels you use to drive traffic to your website? 📈</a>
                </div>
                <div class="text-xs text-slate-500"><a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">sophiestar</a> · 3d · 66 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Failed for the past 12 years as a tech entrepreneur. My key takeaways.</a>
                </div>
                <div class="text-xs text-slate-500"><a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">ekuplu89</a> · 4h · 14 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">How to build a following on Twitter as a founder - A guide to growing your audience 🚀</a>
                </div>
                <div class="text-xs text-slate-500"><a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">molliehacks</a> · 3d · 32 comments</div>
              </li>
            </ul>
            <div class="mt-4">
              <button class="btn-sm w-full bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500 shadow-none">View All</button>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ForumRightContent',
}
</script>