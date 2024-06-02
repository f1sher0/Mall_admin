<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar_admin :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">

      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow dark:bg-slate-900">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="sm:flex sm:justify-between sm:items-center mb-8">

            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Announcement ✨</h1>
            </div>
            <!-- Right: Actions  -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">
              <!-- Search form -->
              <SearchForm />
              <!-- Filter button -->
              <FilterButton align="right" />
              <!-- Create campaign button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path
                    d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="hidden xs:block ml-2">Create Announcement</span>
              </button>
            </div>

          </div>

          <div class="px-2 sm:px-1 lg:px-3 py-8 w-11/12 max-w-9xl mx-auto flex flex-wrap">
            <el-card class="w-2/6 mx-3" v-for="item in sourceData" :key="item.announcementId">
              <template #header>
                <div class="font-bold text-2xl">
                  {{ item.title }}
                </div>
              </template>
                {{ item.content }}
              <template #footer>
                {{ item.updateTime }}
              </template>
            </el-card>
          </div>


        </div>
      </main>

    </div>

  </div>
</template>

<script>
import { ref, inject, onMounted } from 'vue'
import Header from '../../partials/Header.vue'
import SearchForm from '../../components/SearchForm.vue'
import FilterButton from '../../components/DropdownFilter.vue'

import Sidebar_admin from '../../partials/Sidebar_admin.vue'

export default {
  name: 'Campaigns',
  components: {
    Sidebar_admin,
    Header,
    SearchForm,
    FilterButton,
  },
  setup() {
    let sourceData = ref([]);
    const axios = inject('$axios');
    const sidebarOpen = ref(false);
    const fetchData = async () => {
      try {
        const response = await axios.get('/announcements/list');
        sourceData.value = response.data.data;
        console.log('Data fetched successfully:', response.data.data);
        console.log(sourceData.value);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
    onMounted(() => {
      fetchData();
    })
    return {
      sidebarOpen,
      fetchData,
      sourceData,
    }
  }
}
</script>