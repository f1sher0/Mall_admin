<template>
  <div class="flex h-[100dvh] overflow-hidden">
    <Sidebar_supplier :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />
      
      <main class="grow dark:bg-slate-900 p-4">
        <!-- Welcome banner -->
        <WelcomeBanner />
        <div>
          <el-button type="info" @click="filterStatus('待审核')">待审核</el-button>
          <el-button type="success" @click="filterStatus('已批准')">已批准</el-button>
          <el-button type="danger" @click="filterStatus('已拒绝')">已拒绝</el-button>
          <el-button type="primary" @click="filterStatus('all')">所有申请</el-button>
        </div>
        
        <div style="margin-bottom: 10px"> 
          <el-input v-model="search" placeholder="搜索退货理由..." @input="handleSearch" class="w-1/3"></el-input>
          <el-button style="margin-left: 10px" type="primary" @click="handleSearch">搜 索</el-button>
          <el-button type="info" @click="reset">重 置</el-button>
        </div>

        <el-table :data="paginatedRequests" border stripe style="width: 100%" max-height="66vh" v-loading="loading"
          :default-sort="{ prop: 'submitTime', order: 'descending' }">
          <el-table-column prop="submitterName" label="提交人姓名" width="180">
            <template #default="{ row }">
              <HighlightText :text="row.submitterName" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="reason" label="退货理由" width="300">
            <template #default="{ row }">
              <HighlightText :text="row.reason" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="goodsId" label="商品ID" width="180"></el-table-column>
          <el-table-column prop="goodsName" label="商品名" width="180"></el-table-column>
          <el-table-column prop="submitTime" label="提交时间" width="180" :formatter="formatDate"></el-table-column>
  
          <el-table-column prop="reviewerName" label="审核人" width="180">
            <template #default="{ row }">
              {{ row.reviewerName || '无人审核' }}
            </template>
          </el-table-column>
          <el-table-column prop="reviewTime" label="审核时间" width="180" :formatter="formatDate"></el-table-column>
          <el-table-column prop="role" label="提交人角色" width="180"></el-table-column>
          <el-table-column prop="submitterId" label="提交人ID" width="180"></el-table-column>
          <el-table-column prop="status" label="审核状态" width="180" fixed="right">
            <template #default="{ row }">
              <el-tag :type="getTagType(row.status)">{{ row.status }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column label="Operations" width="120" fixed="right">
            <template #default="{ row }">
              <el-button link type="primary" size="small" @click="handleDetail(row)">
                Detail
              </el-button>
              <el-button link type="primary" size="small" @click="handleEdit(row)">
                Edit
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <el-dialog v-model="detailDialogVisible" title="Return Request Details" width="500" :before-close="handleClose">
          <el-form label-position="right" label-width="auto" :model="formLabelAlign" style="max-width: 600px">
            <el-form-item label="Submitter Name">
              <el-input v-model="formLabelAlign.submitterName" disabled />
              <!-- //disabled可以禁止修改 -->
            </el-form-item>
            <el-form-item label="Reason">
              <el-input v-model="formLabelAlign.reason" disabled />
            </el-form-item>
            <el-form-item label="Reviewer">
              <el-input v-model="formLabelAlign.reviewerName" disabled />
            </el-form-item>
            <el-form-item label="Review Time">
              <el-input v-model="formLabelAlign.reviewTime" disabled />
            </el-form-item>
            <el-form-item label="Status">
              <el-input v-model="formLabelAlign.status" disabled />
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="detailDialogVisible = false">关闭</el-button>
          </div>
        </el-dialog>

        <el-dialog v-model="editDialogVisible" title="Edit Return Request" width="500" :before-close="handleClose">
          <el-form label-position="right" label-width="auto" :model="formLabelAlign" style="max-width: 600px">
            <el-form-item label="Submitter Name">
              <el-input v-model="formLabelAlign.submitterName" />
            </el-form-item>
            <el-form-item label="Reason">
              <el-input v-model="formLabelAlign.reason" />
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="editDialogVisible = false">取消</el-button>
            <el-button type="primary" @click="submitReturnRequest">提交</el-button>
          </div>
        </el-dialog>

        <div class="mt-4">
          <el-pagination
            @current-change="handleCurrentChange"
            @size-change="handleSizeChange"
            :current-page="currentPage"
            :page-size="pageSize"
            :page-sizes="[5,10,15,20]"
            layout="total, sizes, prev, pager, next"
            :total="totalRequests">
          </el-pagination>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, inject, computed } from 'vue';
import Header from '../../partials/Header.vue';
import Sidebar_supplier from '../../partials/Sidebar_supplier.vue';
import HighlightText from '../HighlightText.vue';
import dayjs from 'dayjs';
import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
  import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
export default {
  name: 'ReturnRequests',
  components: {
    Sidebar_supplier,
    Header,
    HighlightText,
    WelcomeBanner,
    DashboardAvatars,
  },
  setup() {
    const axios = inject('$axios');
    const sidebarOpen = ref(false);
    const search = ref('');
    const currentPage = ref(1);
    const pageSize = ref(5);
    const totalRequests = ref(0);
    const returnRequests = ref([]);
    const loading = ref(false);
    const filterValue = ref('all');
    const detailDialogVisible = ref(false);
    const editDialogVisible = ref(false);
    const formLabelAlign = ref({
      submitterName: '',
      reason: '',
      reviewerName: '',
      reviewTime: '',
      status: '',
      goodsId: null
    });

    const fetchReturnRequests = async () => {
      // loading.value = true;
      try {
        const response = await axios.get('/returnrequests/getBySubid_Role', {
          params: { 
            id: sessionStorage.getItem("id"),
            role: sessionStorage.getItem("role")
          }
        });
         console.log(response)
        if (response.status == "200") {
          returnRequests.value = response.data.data;
          totalRequests.value = returnRequests.value.length;
          console.log(totalRequests)
          loading.value = false;
        }
        else{
          ElNotification({
            title: 'Error',
            message: response.data.msg,
            type: 'error',
            position: 'top-right',
          });
          loading.value = false;
        }
      } catch (error) {
        console.error('Failed to fetch return requests:', error);
        loading.value = false;
      } finally {
        loading.value = false;
      }
    };

    const handleEdit = (row) => {
      formLabelAlign.value = { ...row };
      editDialogVisible.value = true;
    };

    const handleDetail = (row) => {
      formLabelAlign.value = { ...row };
      formLabelAlign.value.reviewerName = row.reviewerName || '无人审核';
      formLabelAlign.value.reviewTime = formatDate(row, null, row.reviewTime);
      detailDialogVisible.value = true;
    };

    const handleClose = (done) => {
      detailDialogVisible.value = false;
      editDialogVisible.value = false;
    };

    const paginatedRequests = computed(() => {
      const startIndex = (currentPage.value - 1) * pageSize.value;
      const endIndex = currentPage.value * pageSize.value;
      return filteredRequests.value.slice(startIndex, endIndex);
    });

    const filteredRequests = computed(() => {
      const searchLower = search.value.toLowerCase();
      const filtered = returnRequests.value.filter(request =>
        (request.reason && request.reason.toLowerCase().includes(searchLower)) ||
        (request.submitterName && request.submitterName.toLowerCase().includes(searchLower)) ||
        (request.status && request.status.toLowerCase().includes(searchLower)) ||
        (request.role && request.role.toLowerCase().includes(searchLower))
      );

      if (filterValue.value === 'all') {
        totalRequests.value = filtered.length;
        return filtered;
      } else {
        return filtered.filter(request => request.status === filterValue.value);
      }
    });

    const filterStatus = (status) => {
      filterValue.value = status;
      totalRequests.value = filteredRequests.value.length;
    };

    const handleSearch = () => {
      // 这里不需要做任何事情，因为过滤是通过计算属性 filteredRequests 函数完成的
    };

    const getTagType = (status) => {
      if (status === '已批准') {
        return 'success';
      } else if (status === '待审核') {
        return 'warning';
      } else if (status === '已拒绝') {
        return 'danger';
      } else {
        return 'info';
      }
    };

    const handleCurrentChange = (page) => {
      currentPage.value = page;
    };

    const handleSizeChange = (size) => {
      pageSize.value = size;
      currentPage.value = 1;
    };

    const reset = () => {
      search.value = '';
      fetchReturnRequests();
    };

    const formatDate = (row, column, cellValue) => {
      if (!cellValue) return '';
      return dayjs(cellValue).format('YYYY-MM-DD HH:mm:ss');
    };

    const submitReturnRequest = async () => {
      try {
        await axios.post('/returnrequests/update', formLabelAlign.value);
        editDialogVisible.value = false;
        fetchReturnRequests();
      } catch (error) {
        console.error('Failed to submit return request:', error);
      }
    };

    onMounted(() => {
      fetchReturnRequests();
    });

    return {
      sidebarOpen,
      search,
      currentPage,
      pageSize,
      totalRequests,
      returnRequests,
      filteredRequests,
      paginatedRequests,
      fetchReturnRequests,
      handleCurrentChange,
      handleSizeChange,
      handleEdit,
      handleDetail,
      reset,
      loading,
      formatDate,
      getTagType,
      filterStatus,
      detailDialogVisible,
      editDialogVisible,
      submitReturnRequest,
      handleClose,
      formLabelAlign
    };
  }
};
</script>

<style scoped>
body {
  margin: 0;
}

.example-showcase .el-loading-mask {
  z-index: 9;
}
</style>
