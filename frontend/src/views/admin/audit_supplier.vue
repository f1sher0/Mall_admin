<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar_admin :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden bg-white dark:bg-slate-900">

      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow dark:bg-slate-900">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="sm:flex sm:justify-between sm:items-center mb-4 md:mb-2">

            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Audit Supplier</h1>
            </div>

            <!-- Right: Actions  -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">


              <!-- Search form -->
              <div class="hidden sm:block">
                <SearchForm class="hidden sm:block" />
              </div>

            </div>

          </div>


          <!-- Filters -->
          <div class="mb-5">
            <ul class="flex flex-wrap -m-1">
              <li v-for="(statusLabel, statusValue) in statusFilters" :key="statusValue" class="m-1">
                <button @click="filterStatus(parseInt(statusValue))"
                  :class="getStatus() === parseInt(statusValue) ? 'inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-transparent shadow-sm bg-indigo-500 text-white duration-150 ease-in-out' : 'inline-flex items-center justify-center text-sm font-medium leading-5 rounded-full px-3 py-1 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm bg-white dark:bg-slate-800 text-slate-500 dark:text-slate-400 duration-150 ease-in-out'">{{
                    statusLabel }}</button>
              </li>
            </ul>
          </div>

          <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="supplierName" label="SupplierName" width="250" />
            <el-table-column prop="address" label="Address" width="350" />
            <el-table-column prop="zip" label="ZipCode" width="150" />
            <el-table-column prop="status" label="status" width="150">
              <template #default="{ row }">
                <el-tag :type="getTagType(row.status)">{{ getStatusText(row.status) }}</el-tag>
              </template>
            </el-table-column>
            <el-table-column prop="date" label="Date" width="200" />
            <el-table-column fixed="right" label="Operations" width="250">
              <template #default="{ row }">
                <el-button type="primary" size="small" @click="handleClick(row)">
                  Edit Status
                </el-button>
              </template>
            </el-table-column>
          </el-table>


        </div>
      </main>

    </div>

    <el-dialog v-model="dialog1" title="Supplier" width="500">
      <el-radio-group v-model="radio">
        <el-radio :value="0">Pending</el-radio>
        <el-radio :value="1">Approved</el-radio>
        <el-radio :value="2">Rejected</el-radio>
      </el-radio-group>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialog1 = false">Cancel</el-button>
          <el-button type="primary" @click="changeStatus">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script>
import { ref, reactive, onMounted, inject } from 'vue';
import Sidebar_admin from '../../partials/Sidebar_admin.vue'
import Header from '../../partials/Header.vue'
import DeleteButton from '../../partials/actions/DeleteButton.vue'
import SearchForm from '../../components/SearchForm.vue'
import DropdownTransaction from '../../components/DropdownTransaction.vue'
import { ElNotification } from 'element-plus'

export default {
  name: 'Transactions',
  components: {
    Sidebar_admin,
    Header,
    DeleteButton,
    SearchForm,
    DropdownTransaction,
  },
  setup() {

    const sidebarOpen = ref(false);
    const dialog1 = ref(false);
    const editForm = ref({});
    const radio = ref(2);
    const axios = inject('$axios');
    let rawData = [];
    let tableData = ref([]);
    const fetchUnreviewedWarehouses = async () => {
      try {
        const response = await axios.get('/supplier/list');
        console.log('Data fetched successfully:', response.data.data);
        rawData = response.data.data;
        tableData.value = response.data.data;
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    onMounted(() => {
      fetchUnreviewedWarehouses();
    });

    const handleClick = (row) => {
      editForm.value = JSON.parse(JSON.stringify(row));
      console.log(editForm.value);
      dialog1.value = true;
      radio.value = parseInt(editForm.value.status);
    };

    const getTagType = (s) => {
      let num = parseInt(s);
      switch (num) {
        case 0:
          return 'primary';
        case 1:
          return 'success';
        case 2:
          return 'danger';
        default:
          return 'info';
      }
    };

    const getStatusText = (status) => {
      let num = parseInt(status);
      switch (num) {
        case 0:
          return 'Pending';
        case 1:
          return 'Approved';
        case 2:
          return 'Rejected';
        default:
          return 'Unknown';
      }
    };

    let filteredStatus = ref(3);  //当前筛选的数据类型

    const filteredData = () => { //返回筛选后的数据
      if (filteredStatus.value == '3') {
        return rawData;
      } else {
        console.log(filteredStatus.value);
        return rawData.filter(item => item.status == filteredStatus.value);
      }
    };

    const statusFilters = {
      3: 'View All',
      0: 'Pending',
      1: 'Approved',
      2: 'Rejected',
    }

    const filterStatus = (status) => {
      filteredStatus.value = status;
      tableData.value = filteredData();
      console.log(tableData.value);
    };

    const getStatus = () => {
      return filteredStatus.value;
    }

    const changeStatus = async () => {
      dialog1.value = false;
      editForm.value.status = radio.value;
      try {
        const response = await axios.put('/supplier/update', editForm.value);
        fetchUnreviewedWarehouses();
        ElNotification({
          title: 'Success',
          message: 'update successfully',
          type: 'success',
        })
      } catch (error) {
        ElNotification({
          title: 'Error',
          message: 'update Status fail',
          type: 'error',
        })
        console.error('Error :', error);
      }
    }

    return {
      sidebarOpen,
      tableData,
      fetchUnreviewedWarehouses,
      handleClick,
      getTagType,
      getStatusText,
      filteredData,
      statusFilters,
      filterStatus,
      getStatus,
      dialog1,
      editForm,
      radio,
      changeStatus,
    }
  }
}
</script>

<style></style>