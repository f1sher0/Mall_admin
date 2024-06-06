<template>
    <div class="flex h-[100dvh] overflow-hidden">
  
      <!-- Sidebar -->
      <Sidebar_supplier :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />
  
      <!-- Content area -->
      <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
        
        <!-- Site header -->
        <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />
  
        <main class="grow dark:bg-slate-900">
           <!-- Announcements Section -->
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
                
              
              </div>
  
            </div>
  
            <div
              class="px-2 sm:px-1 lg:px-3 py-8 w-full max-w-9xl mx-auto flex flex-wrap justify-center dark:bg-slate-900">
              <el-card class="w-3/12 mx-3 my-3 " v-for="item in sourceData" :key="item.announcementId">
                <template #header>
                  <div class="font-bold text-2xl">
                    {{ item.title }}
                  </div>
                </template>
                {{ item.content }}
                <template #footer>
                  {{ formatDate(item.updateTime)  }}
                </template>
              </el-card>
            </div>
  
            <div class="flex justify-center">
              <el-pagination background default-page-size="9" layout="prev, pager, next" :total=DataNum />
            </div>
  
          </div>
        </main>
  
      </div> 
  
    </div>
  </template>
  
  <script>
import { ref, onMounted,inject } from 'vue'
  import Header from '../../partials/Header.vue'
  import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
  import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
  import Sidebar_supplier from '../../partials/Sidebar_supplier.vue'
 
  import { ElMessage } from 'element-plus'
  import dayjs from 'dayjs'
   
export default {
  name: 'Dashboard',
  components: {
    Sidebar_supplier,
    Header,
    WelcomeBanner,
    DashboardAvatars,
  },
  setup() {
    let sourceData = ref([]);
    let DataNum = ref(0);
    const sidebarOpen = ref(false);
    const axios = inject('$axios');
    const fetchData = async () => {
      try {
        const response = await axios.get('/announcements/list');
        if (response.data.code === '200') {
          sourceData.value = response.data.data;
          DataNum.value = response.data.data.length;
          console.log('Data fetched successfully:', response.data.data);
        console.log(sourceData.value);
        } else {
          ElMessage.error('获取公告失败')
        }     
      } catch (error) {
        ElMessage.error('获取公告失败')
      } 
    };
    const formatDate = (row, column, cellValue) => {
      return dayjs(cellValue).format('YYYY-MM-DD HH:mm:ss')
    }
    onMounted(() => {
      fetchData();
    });
    return {
      sidebarOpen,
      fetchData,
      sourceData,
      DataNum,
      formatDate,
    }
  }
}
</script>

<style scoped>
body {
  margin: 0;
}
</style>
