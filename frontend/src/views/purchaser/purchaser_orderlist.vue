<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar_purchaser :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">

      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow dark:bg-slate-900">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Welcome banner -->
          <WelcomeBanner />
          <div>
            <el-button type="primary" @click="filterReturned('Yes')">Returned Orders</el-button>
            <el-button type="info" @click="filterReturned('No')">Non-returned Orders</el-button>
            <el-button type="success" @click="filterReturned('all')">All Orders</el-button>
          </div>
          <div style="margin-bottom: 10px">
            <el-input v-model="search" placeholder="Search goods..." @input="handleSearch" class="w-1/3"></el-input>
            <el-button style="margin-left: 10px" type="primary" @click="handleSearch">Search</el-button>
            <el-button type="info" @click="reset">Reset</el-button>
          </div>
          <el-table :data="paginatedGoods" border stripe style="width: 100%" max-height="66vh" v-loading="loading"
            :default-sort="{ prop: 'sellingPrice', order: 'descending' }">
            <!-- <el-table-column prop="purchaserName" label="Purchaser Name" width="180">
              <template #default="{ row }">
                <HighlightText :text="row.purchaserName" :query="search" />
              </template>
            </el-table-column> -->
            
            <el-table-column prop="goodsName" label="Goods Name" fixed width="180">
              <template #default="{ row }">
                <HighlightText :text="row.goodsName" :query="search" />
              </template>
            </el-table-column>
            <el-table-column prop="purchasePrice" label="Purchase Price" sortable width="180"></el-table-column>
            <el-table-column prop="sellingPrice" label="Selling Price" sortable width="180"></el-table-column>
            <!-- <el-table-column prop="purchaserDesc" label="Purchaser Description" width="300">
              <template #default="{ row }">
                <HighlightText :text="row.purchaserDesc" :query="search" />
              </template>
            </el-table-column> -->
            <el-table-column prop="purchaserAddress" label="Purchaser Address" width="180">
              <template #default="{ row }">
                <HighlightText :text="row.purchaserAddress" :query="search" />
              </template>
            </el-table-column>
            <el-table-column prop="email" label="Email" width="180">
              <template #default="{ row }">
                <HighlightText :text="row.email || 'N/A'" :query="search" />
              </template>
            </el-table-column>
            <el-table-column prop="salesTime" label="Sales Time" width="180" :formatter="formatDate"></el-table-column>
            <el-table-column prop="salesId" label="Sales ID" width="180"></el-table-column>
            <el-table-column prop="goodsId" label="Goods ID" width="180"></el-table-column>
            <el-table-column prop="warehouseId" label="Warehouse ID" width="180"></el-table-column>
            <el-table-column prop="warehouseName" label="Warehouse Name" width="180">
              <template #default="{ row }">
                <HighlightText :text="row.warehouseName" :query="search" />
              </template>
            </el-table-column>
            <el-table-column prop="warehouseAddress" label="Warehouse Address" width="180">
              <template #default="{ row }">
                <HighlightText :text="row.warehouseAddress" :query="search" />
              </template>
            </el-table-column>
            <el-table-column prop="onShelf" label="On Shelf" width="180"></el-table-column>
            <el-table-column prop="isReturned" label="Is Returned" width="180" fixed="right">
              <template #default="{ row }">
                <el-tag :type="getTagType(row.isReturned)">{{ getStatusText(row.isReturned) }}</el-tag>
              </template>
            </el-table-column>
            <el-table-column fixed="right" label="Action" width="120">
              <template #default="{ row }">
                <el-button link type="primary" size="small" v-if="row.isReturned === 'No'"
                  @click="openReturnDialog(row)">
                  Return Request
                </el-button>
              </template>
            </el-table-column>
          </el-table>

          <div class="mt-4">
            <el-pagination @current-change="handleCurrentChange" @size-change="handleSizeChange"
              :current-page="currentPage" :page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
              layout="total, sizes, prev, pager, next" :total="totalGoods">
            </el-pagination>
          </div>
        </div>
      </main>

    </div>

  </div>
  <el-dialog title="退货申请" v-model="dialogVisible" width="50%" max-height="55vh">
    <el-form :model="returnForm">
      <!-- <el-form-item label="提交人姓名">
        <el-input v-model="returnForm.submitterName"></el-input>
      </el-form-item> -->
      <el-form-item label="退货理由">
        <el-input type="textarea" v-model="returnForm.reason"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="submitReturnRequest">提交</el-button>
    </div>
  </el-dialog>
</template>


<script>
import { ref, onMounted, inject, computed } from 'vue';
import Header from '../../partials/Header.vue'
import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
import Sidebar_purchaser from '../../partials/Sidebar_purchaser.vue'
import dayjs from 'dayjs';
import { ElNotification } from 'element-plus'
import HighlightText from '../HighlightText.vue';
export default {
  name: 'OrderList',
  components: {
    Sidebar_purchaser,
    Header,
    WelcomeBanner,
    DashboardAvatars,
     HighlightText,
  },
  setup() {
    const axios = inject('$axios');
    const sidebarOpen = ref(false);
    const search = ref('');
    const currentPage = ref(1);
    const pageSize = ref(5);
    const totalGoods = ref(0);
    const warehouseGoods = ref([]);
    const loading = ref(false);
    const filterValue = ref('all');
    const dialogVisible = ref(false);
    const returnForm = ref({
      submitterName: '',
      reason: '',
      goodsId: null
    });
  
    const fetchWarehouseGoods = async (purchaserId = sessionStorage.getItem('id')) => {
      loading.value = true;
      try {
        const response = await axios.get('/purchaser/goodsOutInfo', {
          params: { purchaserId }
        });
        if (response.status === 200) {
          // alert(sessionStorage.getItem("role"));
          console.log(response.data.data)
          warehouseGoods.value = response.data.data;
          totalGoods.value = warehouseGoods.value.length;
        }
      } catch (error) {
        console.error('Failed to fetch warehouse goods info:', error);
      } finally {
        loading.value = false;
      }
    };
    const submitReturnRequest = async () => {
      try {
        const submitterName = sessionStorage.getItem('username');
        const submitterId = sessionStorage.getItem('id');
        const role = sessionStorage.getItem('role');
        const reason = returnForm.value.reason;
        const goodsId = returnForm.value.goodsId;
 
        const response = await axios.post('/returnrequests/add', {
          submitterName,
          reason,
          goodsId,
          submitterId,
          role
        });
        if (response.status === 200) {
          // alert(response.data.data)
          dialogVisible.value = false;
          resetReturnForm();
          ElNotification({
            title: 'Success',
            message: response.data.msg,
            type: 'success',
            position: 'top-right',
          });
          // 这里可以添加刷新表格数据的逻辑
        } else {
          ElNotification({
            title: 'Error',
            message: response.data.msg,
            type: 'error',
            position: 'top-right',
          });
        }
      } catch (error) {
        ElNotification({
          title: 'Error',
          message: '请求失败，请稍后再试',
          type: 'error',
          position: 'top-right',
        });
      }
    };

    const paginatedGoods = computed(() => {
      const startIndex = (currentPage.value - 1) * pageSize.value;
      const endIndex = currentPage.value * pageSize.value;
      return filteredGoods.value.slice(startIndex, endIndex);
    });

    const filteredGoods = computed(() => {
  const searchLower = search.value.toLowerCase();
  const filtered = warehouseGoods.value.filter(good =>
    (good.salesTime && good.salesTime.toLowerCase().includes(searchLower)) ||
    (good.purchaserName && good.purchaserName.toLowerCase().includes(searchLower)) ||
    (good.purchaserDesc && good.purchaserDesc.toLowerCase().includes(searchLower)) ||
    (good.purchaserAddress && good.purchaserAddress.toLowerCase().includes(searchLower)) ||
    (good.email && good.email.toLowerCase().includes(searchLower)) ||
    (good.isReturned && good.isReturned.toLowerCase().includes(searchLower)) ||
    (good.warehouseName && good.warehouseName.toLowerCase().includes(searchLower)) ||
    (good.warehouseAddress && good.warehouseAddress.toLowerCase().includes(searchLower))
  );

  if (filterValue.value === 'all') {
    totalGoods.value = filtered.length;
    return filtered;
  } else {
    return filtered.filter(good => good.isReturned === filterValue.value);
  }
});


    const filterReturned = (returned) => {
      filterValue.value = returned;
      totalGoods.value = filteredGoods.value.length;
    };

    const handleSearch = () => {
      // 这里不需要做任何事情，因为过滤是通过计算属性 filteredGoods 函数完成的
    };

    const getTagType = (isReturned) => {
      if (isReturned === 'Yes') {
        return 'success';
      } else if (isReturned === 'No') {
        return 'primary';
      } else {
        return 'info';
      }
    };

    const getStatusText = (isReturned) => {
      if (isReturned === 'Yes') {
        return 'Returned';
      } else if (isReturned === 'No') {
        return 'Not Returned';
      } else {
        return 'Unknown';
      }
    };

    const openReturnDialog = (row) => {
      returnForm.value.goodsId = row.goodsId;
      dialogVisible.value = true;
    };



    const resetReturnForm = () => {
      returnForm.value.submitterName = '';
      returnForm.value.reason = '';
      returnForm.value.goodsId = null;
    };

    const handleCurrentChange = (page) => {
      currentPage.value = page;
    };

    const handleSizeChange = (size) => {
      pageSize.value = size;
      currentPage.value = 1;
    };
    const add = () => {
      fetchWarehouseGoods();
    };

    const reset = () => {
      search.value = '';
      fetchWarehouseGoods();
    };

    onMounted(() => {
      fetchWarehouseGoods();
    });

    const formatDate = (row, column, cellValue) => {
      return dayjs(cellValue).format('YYYY-MM-DD HH:mm:ss');
    };

    return {
      sidebarOpen,
      search,
      currentPage,
      pageSize,
      totalGoods,
      warehouseGoods,
      filteredGoods,
      paginatedGoods,
      fetchWarehouseGoods,
      handleCurrentChange,
      handleSizeChange,
      handleSearch,
      reset,
      loading,
      formatDate,
      getTagType,
      getStatusText,
      filterReturned,
      dialogVisible,
      returnForm,
      openReturnDialog,
      submitReturnRequest
    };
  }
}
</script>