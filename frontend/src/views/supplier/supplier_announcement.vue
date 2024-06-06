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
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>公告</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="refreshAnnouncements">刷新</el-button>
          </div>
          <el-table :data="announcements" v-loading="loading" style="width: 100%">
            <!-- <el-table-column prop="announcementId" label="公告ID" width="100"></el-table-column> -->
            <el-table-column prop="title" label="标题" width="180"></el-table-column>
            <el-table-column prop="content" label="内容"></el-table-column>
            <el-table-column prop="publisherEmail" label="发布者邮箱" width="200"></el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="180" :formatter="formatDate"></el-table-column>
            <el-table-column prop="updateTime" label="更新时间" width="180" :formatter="formatDate"></el-table-column>
          </el-table>
        </el-card>
        </main>
  
      </div> 
  
    </div>
  </template>
  
  <script>
import { ref, onMounted,inject } from 'vue'
  import Header from '../../partials/Header.vue'
  import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
  import Sidebar_supplier from '../../partials/Sidebar_supplier.vue'
  import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
 
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
    const axios = inject('$axios');
    const sidebarOpen = ref(false)
    const announcements = ref([])
    const loading = ref(false)

    const fetchAnnouncements = async () => {
      loading.value = true
      try {
        const response = await axios.get('/announcements/list')
        if (response.data.code === '200') {
          announcements.value = response.data.data
        } else {
          ElMessage.error('获取公告失败')
        }
      } catch (error) {
        console.error('Failed to fetch announcements:', error)
        ElMessage.error('获取公告失败')
      } finally {
        loading.value = false
      }
    }

    const refreshAnnouncements = () => {
      fetchAnnouncements()
    }

    const formatDate = (row, column, cellValue) => {
      return dayjs(cellValue).format('YYYY-MM-DD HH:mm:ss')
    }

    onMounted(() => {
      fetchAnnouncements()
    })

    return {
      sidebarOpen,
      announcements,
      loading,
      refreshAnnouncements,
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
