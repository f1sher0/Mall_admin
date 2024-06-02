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
              <!-- Create campaign button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" @click="AddAnnouncement">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path
                    d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="hidden xs:block ml-2">Create Announcement</span>
              </button>
            </div>

          </div>

          <div class="px-2 sm:px-1 lg:px-3 py-8 w-full max-w-9xl mx-auto flex flex-wrap justify-center dark:bg-slate-900">
            <el-card class="w-3/12 mx-3 my-3 " v-for="item in sourceData" :key="item.announcementId">
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

          <div class="flex justify-center">
            <el-pagination background default-page-size="9" layout="prev, pager, next" :total=DataNum />
          </div>

        </div>
      </main>

    </div>


    <el-dialog v-model="dialogVisible" title="Add a New Announcement" width="500">
      <div class="font-bold">
        Email
      </div>
      <el-input v-model="email" style="width: 100%" autosize type="textarea" placeholder="Please input the title" />
      <div class="font-bold">
        Title
      </div>
      <el-input v-model="title" style="width: 100%" autosize type="textarea" placeholder="Please input the title" />
      <div class="font-bold">
        Content
      </div>
      <el-input v-model="content" style="width: 100%" :autosize="{ minRows: 8}" type="textarea" placeholder="Please input the title" />
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="postNew()">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { ref, inject, onMounted } from 'vue'
import Header from '../../partials/Header.vue'
import SearchForm from '../../components/SearchForm.vue'
import Sidebar_admin from '../../partials/Sidebar_admin.vue'
import { ElMessageBox } from 'element-plus'

export default {
  name: 'Campaigns',
  components: {
    Sidebar_admin,
    Header,
    SearchForm,
  },
  setup() {
    let sourceData = ref([]);
    let DataNum = ref(0);
    let title = ref('');
    let content = ref('');
    let email = ref('');
    let dialogVisible = ref(false);
    const axios = inject('$axios');
    const sidebarOpen = ref(false);
    const fetchData = async () => {
      try {
        const response = await axios.get('/announcements/list');
        sourceData.value = response.data.data;
        DataNum.value = response.data.data.length;
        console.log('Data fetched successfully:', response.data.data);
        console.log(sourceData.value);
      } catch (error) {
        console.error('Error fetching data:', error);
      } 
    };

    const AddAnnouncement = () => {
      dialogVisible.value = true;
    };

    onMounted(() => {
      fetchData();
    });

    const postNew = async () => {
      try {
        const response = await axios.post('/announcements/add', {
          title: title.value,
          content: content.value,
          publisherEmail: email.value
        });
        console.log('New announcement created:', response.data);
        // 在这里可以根据后端返回的数据执行进一步的操作，如更新界面等
      } catch (error) {
        console.error('Error creating new announcement:', error);
      } finally {
        dialogVisible = false;
      }
    };

    return {
      sidebarOpen,
      fetchData,
      sourceData,
      DataNum,
      AddAnnouncement,
      dialogVisible,
      postNew,
      title,
      content,
      email,
    }
  }
}
</script>