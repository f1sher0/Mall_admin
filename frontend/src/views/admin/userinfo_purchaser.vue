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
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Purchaser Information✨</h1>
            </div>

            <!-- Right: Actions  -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">

            </div>

          </div>

          <!-- Cards -->
          <div class="grid grid-cols-12 gap-6 dark:text-slate-100">
            <UsersTilesCard_admin v-for="(item, index) in items" :key="index" :item="item"/>
          </div>

          <div class="flex justify-center mt-5">
            <el-pagination background  default-page-size="9" layout="prev, pager, next" :total=DataNum />
          </div>

        </div>
      </main>

    </div>

  </div>
</template>

<script>
import { ref, inject , onMounted} from 'vue'
import Sidebar_admin from '../../partials/Sidebar_admin.vue'
import Header from '../../partials/Header.vue'
import UsersTilesCard_admin from '../../partials/community/UsersTilesCard_admin.vue'
import Image1 from '../../assets/image.png'


export default {
  name: 'UsersTiles',
  components: {
    Sidebar_admin,
    Header,
    UsersTilesCard_admin,
  },
  setup() {
    let DataNum = ref(0);
    const sidebarOpen = ref(false);
    const axios = inject('$axios');
    const items = ref([]);
    const fetchData = async () => {
      try {
        const response = await axios.get('/purchaser/list');
        console.log('Data fetched successfully:', response.data.data);
        items.value = response.data.data;
        DataNum.value = response.data.data.length;
        items.value.forEach(item => {item.avatar = Image1})
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    onMounted(() => {
      fetchData();
    })

    return {
      sidebarOpen,
      items,
      DataNum,
    }
  }
}
</script>