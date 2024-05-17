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
          <div class="sm:flex sm:justify-between sm:items-center mb-5">
          
            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Fintech ✨</h1>
            </div>

            <!-- Right: Actions -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">

              <!-- Datepicker built with flatpickr -->
              <Datepicker align="right" />

              <!-- Add account button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="hidden xs:block ml-2">Add Account</span>
              </button>

            </div>

          </div>

          <!-- Cards -->
          <div class="grid grid-cols-12 gap-6">

            <!-- Page Intro -->
            <FintechIntro />
            <!-- Line chart (Portfolio Returns) -->
            <FintechCard01 />
            <!-- Credit Card -->
            <FintechCard02 />
            <!-- Bar chart (Cash Flow) -->
            <FintechCard03 />
            <!-- Horizontal bar chart (Cash Flow by Account) -->
            <FintechCard04 />
            <!-- Table (Recent Expenses) -->
            <FintechCard05 />
            <!-- Table (Recent Earnings) -->
            <FintechCard06 />
            <!-- Line chart (Saving Goals) -->
            <FintechCard07 />
            <!-- Line chart (Growth Portfolio) -->
            <FintechCard08 />
            <!-- Pie chart (Portfolio Value) -->
            <FintechCard09 />
            <!-- Line charts (Stock graphs) -->
            <FintechCard10 />
            <FintechCard11 />
            <FintechCard12 />
            <FintechCard13 />
            <!-- Table (Market Trends) -->
            <FintechCard14 />

          </div>

        </div>
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar from '../partials/Sidebar.vue'
import Header from '../partials/Header.vue'
import Datepicker from '../components/Datepicker.vue'
import FintechIntro from '../partials/fintech/FintechIntro.vue'
import FintechCard01 from '../partials/fintech/FintechCard01.vue'
import FintechCard02 from '../partials/fintech/FintechCard02.vue'
import FintechCard03 from '../partials/fintech/FintechCard03.vue'
import FintechCard04 from '../partials/fintech/FintechCard04.vue'
import FintechCard05 from '../partials/fintech/FintechCard05.vue'
import FintechCard06 from '../partials/fintech/FintechCard06.vue'
import FintechCard07 from '../partials/fintech/FintechCard07.vue'
import FintechCard08 from '../partials/fintech/FintechCard08.vue'
import FintechCard09 from '../partials/fintech/FintechCard09.vue'
import FintechCard10 from '../partials/fintech/FintechCard10.vue'
import FintechCard11 from '../partials/fintech/FintechCard11.vue'
import FintechCard12 from '../partials/fintech/FintechCard12.vue'
import FintechCard13 from '../partials/fintech/FintechCard13.vue'
import FintechCard14 from '../partials/fintech/FintechCard14.vue'

export default {
  name: 'Dashboard',
  components: {
    Sidebar,
    Header,
    Datepicker,
    FintechIntro,
    FintechCard01,
    FintechCard02,
    FintechCard03,
    FintechCard04,
    FintechCard05,
    FintechCard06,
    FintechCard07,
    FintechCard08,
    FintechCard09,
    FintechCard10,
    FintechCard11,
    FintechCard12,
    FintechCard13,
    FintechCard14,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>