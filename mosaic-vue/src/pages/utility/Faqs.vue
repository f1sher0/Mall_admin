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

          <div class="max-w-3xl m-auto">

            <!-- Page title -->
            <div class="mb-5">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">👋 How we can help you today?</h1>
            </div>

            <!-- Search form -->
            <div class="mb-6">
              <form class="relative">
                <label for="action-search" class="sr-only">Search</label>
                <input id="action-search" class="form-input pl-9 py-3 focus:border-slate-300 w-full" type="search" />
                <button class="absolute inset-0 right-auto group" type="submit" aria-label="Search">
                  <svg class="w-4 h-4 shrink-0 fill-current text-slate-400 dark:text-slate-500 group-hover:text-slate-500 dark:group-hover:text-slate-400 ml-3 mr-2" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                    <path d="M7 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zM7 2C4.243 2 2 4.243 2 7s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5z" />
                    <path d="M15.707 14.293L13.314 11.9a8.019 8.019 0 01-1.414 1.414l2.393 2.393a.997.997 0 001.414 0 .999.999 0 000-1.414z" />
                  </svg>
                </button>
              </form>
            </div>

            <!-- Filters -->
            <div class="mb-8 border-b border-slate-200 dark:border-slate-700">
              <ul class="text-sm font-medium flex flex-nowrap -mx-4 sm:-mx-6 lg:-mx-8 overflow-x-scroll no-scrollbar">
                <li class="pb-3 mr-6 last:mr-0 first:pl-4 sm:first:pl-6 lg:first:pl-8 last:pr-4 sm:last:pr-6 lg:last:pr-8">
                  <a class="text-indigo-500 whitespace-nowrap" href="#0">Popular</a>
                </li>
                <li class="pb-3 mr-6 last:mr-0 first:pl-4 sm:first:pl-6 lg:first:pl-8 last:pr-4 sm:last:pr-6 lg:last:pr-8">
                  <a class="text-slate-500 dark:text-slate-400 hover:text-slate-600 dark:hover:text-slate-300 whitespace-nowrap" href="#0">Accessibility</a>
                </li>
                <li class="pb-3 mr-6 last:mr-0 first:pl-4 sm:first:pl-6 lg:first:pl-8 last:pr-4 sm:last:pr-6 lg:last:pr-8">
                  <a class="text-slate-500 dark:text-slate-400 hover:text-slate-600 dark:hover:text-slate-300 whitespace-nowrap" href="#0">Marketing</a>
                </li>
                <li class="pb-3 mr-6 last:mr-0 first:pl-4 sm:first:pl-6 lg:first:pl-8 last:pr-4 sm:last:pr-6 lg:last:pr-8">
                  <a class="text-slate-500 dark:text-slate-400 hover:text-slate-600 dark:hover:text-slate-300 whitespace-nowrap" href="#0">Development</a>
                </li>
                <li class="pb-3 mr-6 last:mr-0 first:pl-4 sm:first:pl-6 lg:first:pl-8 last:pr-4 sm:last:pr-6 lg:last:pr-8">
                  <a class="text-slate-500 dark:text-slate-400 hover:text-slate-600 dark:hover:text-slate-300 whitespace-nowrap" href="#0">Account</a>
                </li>
              </ul>
            </div>

            <!-- Posts -->
            <div>
              <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-4">Popular Questions</h2>
              <!-- Post -->
              <article class="py-4 border-b border-slate-200 dark:border-slate-700">
                <header class="flex items-start mb-2">
                  <div class="mt-2 mr-3">
                    <svg class="w-4 h-4 shrink-0 fill-current" viewBox="0 0 16 16">
                      <path class="text-indigo-300" d="M4 8H0v4.9c0 1 .7 1.9 1.7 2.1 1.2.2 2.3-.8 2.3-2V8z" />
                      <path class="text-indigo-500" d="M15 1H7c-.6 0-1 .4-1 1v11c0 .7-.2 1.4-.6 2H13c1.7 0 3-1.3 3-3V2c0-.6-.4-1-1-1z" />
                    </svg>
                  </div>
                  <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold">How can the widget to my website?</h3>
                </header>
                <div class="pl-7">
                  <div class="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco.</div>
                  <ul class="flex flex-wrap">
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">General</a>
                    </li>
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Marketing</a>
                    </li>
                  </ul>
                </div>
              </article>
              <!-- Post -->
              <article class="py-4 border-b border-slate-200 dark:border-slate-700">
                <header class="flex items-start mb-2">
                  <div class="mt-2 mr-3">
                    <svg class="w-4 h-4 shrink-0 fill-current" viewBox="0 0 16 16">
                      <path class="text-indigo-300" d="M4 8H0v4.9c0 1 .7 1.9 1.7 2.1 1.2.2 2.3-.8 2.3-2V8z" />
                      <path class="text-indigo-500" d="M15 1H7c-.6 0-1 .4-1 1v11c0 .7-.2 1.4-.6 2H13c1.7 0 3-1.3 3-3V2c0-.6-.4-1-1-1z" />
                    </svg>
                  </div>
                  <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold">What would happen if I choose not to pay after the usage?</h3>
                </header>
                <div class="pl-7">
                  <div class="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco.</div>
                  <ul class="flex flex-wrap">
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Development</a>
                    </li>
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Acessibility</a>
                    </li>
                  </ul>
                </div>
              </article>
              <!-- Post -->
              <article class="py-4 border-b border-slate-200 dark:border-slate-700">
                <header class="flex items-start mb-2">
                  <div class="mt-2 mr-3">
                    <svg class="w-4 h-4 shrink-0 fill-current" viewBox="0 0 16 16">
                      <path class="text-indigo-300" d="M4 8H0v4.9c0 1 .7 1.9 1.7 2.1 1.2.2 2.3-.8 2.3-2V8z" />
                      <path class="text-indigo-500" d="M15 1H7c-.6 0-1 .4-1 1v11c0 .7-.2 1.4-.6 2H13c1.7 0 3-1.3 3-3V2c0-.6-.4-1-1-1z" />
                    </svg>
                  </div>
                  <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold">What limitations do trial accounts have?</h3>
                </header>
                <div class="pl-7">
                  <div class="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco.</div>
                  <ul class="flex flex-wrap">
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Development</a>
                    </li>
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Plans</a>
                    </li>
                  </ul>
                </div>
              </article>
              <!-- Post -->
              <article class="py-4 border-b border-slate-200 dark:border-slate-700">
                <header class="flex items-start mb-2">
                  <div class="mt-2 mr-3">
                    <svg class="w-4 h-4 shrink-0 fill-current" viewBox="0 0 16 16">
                      <path class="text-indigo-300" d="M4 8H0v4.9c0 1 .7 1.9 1.7 2.1 1.2.2 2.3-.8 2.3-2V8z" />
                      <path class="text-indigo-500" d="M15 1H7c-.6 0-1 .4-1 1v11c0 .7-.2 1.4-.6 2H13c1.7 0 3-1.3 3-3V2c0-.6-.4-1-1-1z" />
                    </svg>
                  </div>
                  <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold">Is there any difference between Standard and Plus licenses?</h3>
                </header>
                <div class="pl-7">
                  <div class="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco.</div>
                  <ul class="flex flex-wrap">
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Development</a>
                    </li>
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Account</a>
                    </li>
                  </ul>
                </div>
              </article>
              <!-- Post -->
              <article class="py-4 border-b border-slate-200 dark:border-slate-700">
                <header class="flex items-start mb-2">
                  <div class="mt-2 mr-3">
                    <svg class="w-4 h-4 shrink-0 fill-current" viewBox="0 0 16 16">
                      <path class="text-indigo-300" d="M4 8H0v4.9c0 1 .7 1.9 1.7 2.1 1.2.2 2.3-.8 2.3-2V8z" />
                      <path class="text-indigo-500" d="M15 1H7c-.6 0-1 .4-1 1v11c0 .7-.2 1.4-.6 2H13c1.7 0 3-1.3 3-3V2c0-.6-.4-1-1-1z" />
                    </svg>
                  </div>
                  <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold">Is my personal information protected?</h3>
                </header>
                <div class="pl-7">
                  <div class="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco.</div>
                  <ul class="flex flex-wrap">
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">General</a>
                    </li>
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Accessibility</a>
                    </li>
                  </ul>
                </div>
              </article>
              <!-- Post -->
              <article class="py-4 border-b border-slate-200 dark:border-slate-700">
                <header class="flex items-start mb-2">
                  <div class="mt-2 mr-3">
                    <svg class="w-4 h-4 shrink-0 fill-current" viewBox="0 0 16 16">
                      <path class="text-indigo-300" d="M4 8H0v4.9c0 1 .7 1.9 1.7 2.1 1.2.2 2.3-.8 2.3-2V8z" />
                      <path class="text-indigo-500" d="M15 1H7c-.6 0-1 .4-1 1v11c0 .7-.2 1.4-.6 2H13c1.7 0 3-1.3 3-3V2c0-.6-.4-1-1-1z" />
                    </svg>
                  </div>
                  <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold">What can I create with with this product?</h3>
                </header>
                <div class="pl-7">
                  <div class="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam, quis nostrud exercitation ullamco.</div>
                  <ul class="flex flex-wrap">
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Marketing</a>
                    </li>
                    <li class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Plans</a>
                    </li>
                  </ul>
                </div>
              </article>
            </div>

            <!-- Pagination -->
            <div class="mt-6">
              <div class="flex justify-end">
                <a class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500" href="#0">See All Questions -&gt;</a>
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
  name: 'Faqs',
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