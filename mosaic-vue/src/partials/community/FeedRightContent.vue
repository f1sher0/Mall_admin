<template>
  <div class="w-full hidden xl:block xl:w-72">
    <div class="lg:sticky lg:top-16 lg:h-[calc(100dvh-64px)] lg:overflow-x-hidden lg:overflow-y-auto no-scrollbar">
      <div class="md:py-8">

        <!-- Search form -->
        <div class="mb-6">
          <form class="relative">
            <label for="feed-search-desktop" class="sr-only">Search</label>
            <input id="feed-search-desktop" class="form-input w-full pl-9 bg-white dark:bg-slate-800" type="search" placeholder="Search…" />
            <button class="absolute inset-0 right-auto group" type="submit" aria-label="Search">
              <svg class="w-4 h-4 shrink-0 fill-current text-slate-400 dark:text-slate-500 group-hover:text-slate-500 dark:group-hover:text-slate-400 ml-3 mr-2" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                <path d="M7 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zM7 2C4.243 2 2 4.243 2 7s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5z" />
                <path d="M15.707 14.293L13.314 11.9a8.019 8.019 0 01-1.414 1.414l2.393 2.393a.997.997 0 001.414 0 .999.999 0 000-1.414z" />
              </svg>
            </button>
          </form>
        </div>

        <!-- Blocks -->
        <div class="space-y-4">

          <!-- Block 1 -->
          <div class="bg-slate-50 dark:bg-slate-800/20 p-4 rounded border border-slate-200 dark:border-slate-700">
            <div class="text-xs font-semibold text-slate-400 dark:text-slate-500 uppercase mb-4">Top Communities</div>
            <ul class="space-y-3">
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/group-avatar-01.png" width="32" height="32" alt="Group 01" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Introductions</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Join</button>
                </div>
              </li>
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/group-avatar-02.png" width="32" height="32" alt="Group 02" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">HackerNews</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Join</button>
                </div>
              </li>
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/group-avatar-03.png" width="32" height="32" alt="Group 03" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">ReactJs</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2.5 py-1">
                    <svg class="w-4 h-4 fill-current shrink-0" viewBox="0 0 16 16">
                      <path d="m2.457 8.516.969-.99 2.516 2.481 5.324-5.304.985.989-6.309 6.284z"></path>
                    </svg>
                  </button>
                </div>
              </li>
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/group-avatar-04.png" width="32" height="32" alt="Group 04" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">JustChatting</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Join</button>
                </div>
              </li>
            </ul>
            <div class="mt-4">
              <button class="btn-sm w-full bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500 shadow-none">View All</button>
            </div>
          </div>

          <!-- Block 2 -->
          <div class="bg-slate-50 dark:bg-slate-800/20 p-4 rounded border border-slate-200 dark:border-slate-700">
            <div class="text-xs font-semibold text-slate-400 dark:text-slate-500 uppercase mb-4">Who to follow</div>
            <ul class="space-y-3">
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/user-32-02.jpg" width="32" height="32" alt="User 02" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Elly Boutin</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Follow</button>
                </div>
              </li>
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/user-32-04.jpg" width="32" height="32" alt="User 04" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Rich Harris</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Follow</button>
                </div>
              </li>
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/user-32-05.jpg" width="32" height="32" alt="User 05" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Mary Porzio</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Follow</button>
                </div>
              </li>
              <li>
                <div class="flex items-center justify-between">
                  <div class="grow flex items-center">
                    <div class="relative mr-3">
                      <img class="w-8 h-8 rounded-full" src="../../images/user-32-01.jpg" width="32" height="32" alt="User 01" />
                    </div>
                    <div class="truncate">
                      <span class="text-sm font-medium text-slate-800 dark:text-slate-100">Brian Lovin</span>
                    </div>
                  </div>
                  <button class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">Follow</button>
                </div>
              </li>
            </ul>
            <div class="mt-4">
              <button class="btn-sm w-full bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500 shadow-none">View All</button>
            </div>
          </div>

          <!-- Block 3 -->
          <div class="bg-slate-50 dark:bg-slate-800/20 p-4 rounded border border-slate-200 dark:border-slate-700">
            <div class="text-xs font-semibold text-slate-400 dark:text-slate-500 uppercase mb-4">Trends for you</div>
            <ul class="space-y-3">
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Tracking your website traffic on launch day 📈</a>
                </div>
                <div class="text-xs text-slate-500">248 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Freemium model questions</a>
                </div>
                <div class="text-xs text-slate-500">47 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Slack and Community</a>
                </div>
                <div class="text-xs text-slate-500">24 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Who owns user onboarding in your company?</a>
                </div>
                <div class="text-xs text-slate-500">17 comments</div>
              </li>
              <li>
                <div class="text-sm mb-1">
                  <a class="font-medium text-slate-800 hover:text-slate-900 dark:text-slate-100 dark:hover:text-white" href="#0">Questions from a very confused Web3 startup founder 🤔</a>
                </div>
                <div class="text-xs text-slate-500">9 comments</div>
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
  name: 'FeedRightContent',
}
</script>