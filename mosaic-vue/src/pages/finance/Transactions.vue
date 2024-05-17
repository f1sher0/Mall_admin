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
          <div class="sm:flex sm:justify-between sm:items-center mb-4 md:mb-2">

            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">$47,347.09</h1>
            </div>

            <!-- Right: Actions  -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">

              <!-- Delete button -->
              <DeleteButton :selectedItems="selectedItems" />

              <!-- Search form -->
              <div class="hidden sm:block">
                <SearchForm class="hidden sm:block" />
              </div>

              <!-- Export button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">Export Transactions</button>

            </div>

          </div>

          <div class="mb-5">
            <span>Transactions from </span>
            <DropdownTransaction />
          </div>
          
          <!-- Filters -->
          <div class="mb-5">
            <ul class="flex flex-wrap -m-1">
              <li class="m-1">
                <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-transparent shadow-sm bg-indigo-500 text-white duration-150 ease-in-out">View All</button>
              </li>
              <li class="m-1">
                <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Completed</button>
              </li>
              <li class="m-1">
                <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Pending</button>
              </li>
              <li class="m-1">
                <button class="inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out">Canceled</button>
              </li>
            </ul>
          </div>

          <!-- Table -->
          <TransactionsTable @change-selection="updateSelectedItems($event)" />

          <!-- Pagination -->
          <div class="mt-8">
            <PaginationClassic />
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
import DeleteButton from '../../partials/actions/DeleteButton.vue'
import SearchForm from '../../components/SearchForm.vue'
import DropdownTransaction from '../../components/DropdownTransaction.vue'
import TransactionsTable from '../../partials/finance/TransactionsTable.vue'
import PaginationClassic from '../../components/PaginationClassic.vue'

export default {
  name: 'Transactions',
  components: {
    Sidebar,
    Header,
    DeleteButton,
    SearchForm,
    DropdownTransaction,
    TransactionsTable,
    PaginationClassic,
  },
  setup() {

    const sidebarOpen = ref(false)
    const selectedItems = ref([])

    const updateSelectedItems = (selected) => {
      selectedItems.value = selected
    }

    return {
      sidebarOpen,
      selectedItems,
      updateSelectedItems,
    }  
  }
}
</script>