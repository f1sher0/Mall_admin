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
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Warehouse Management</h1>
            </div>

            <!-- Right: Actions  -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">
              <el-button type="primary" @click="dialogVisible = true">
                Add New Warehouse
              </el-button>
            </div>

          </div>

          <el-table :data="tableData" style="width: 100%">
            <el-table-column fixed prop="warehouseName" label="Warehouse Name" width="250" />
            <el-table-column prop="warehouseLocation" label="Warehouse Location" width="400" />
            <el-table-column prop="totalCapacity" label="Total Capacity" width="150" />
            <el-table-column prop="availableCapacity" label="Available Capacity" width="150" />
            <el-table-column prop="date" label="Last Update Date" width="200" />
            <el-table-column fixed="right" label="Operations" width="200">
              <template #default="{ row }">
                <el-button type="primary" size="small" @click="handleClick(row)">
                  Edit
                </el-button>
                <el-button type="danger" size="small" @click="handleRemove(row)">Remove</el-button>
              </template>
            </el-table-column>
          </el-table>


        </div>
      </main>

    </div>

    <el-dialog v-model="dialogVisible" title="Add Warehouse" width="500">
      <el-form label-position="right" label-width="auto" :model="formLabelAlign" style="max-width: 600px">
        <el-form-item label="Warehouse Name">
          <el-input v-model="formLabelAlign.name" />
        </el-form-item>
        <el-form-item label="Warehouse Location">
          <el-input v-model="formLabelAlign.location" />
        </el-form-item>
        <el-form-item label="Total Capacity">
          <el-input v-model="formLabelAlign.capacity" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="addNewWarehouse">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>

    <el-dialog v-model="dialogVisible1" title="Edit Warehouse Information" width="500">
      <el-form label-position="right" label-width="auto" :model="editForm" style="max-width: 600px">
        <el-form-item label="Warehouse Name">
          <el-input v-model="editForm.warehouseName" />
        </el-form-item>
        <el-form-item label="Warehouse Location">
          <el-input v-model="editForm.warehouseLocation" />
        </el-form-item>
        <el-form-item label="Total Capacity">
          <el-input v-model="editForm.totalCapacity" />
        </el-form-item>
        <el-form-item label="Available Capacity">
          <el-input v-model="editForm.availableCapacity" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible1 = false">Cancel</el-button>
          <el-button type="primary" @click="editWarehouse">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>


    <el-dialog v-model="dialogVisible2" title="Tips" width="500">
      <span>Confirm to Remove the Warehouse</span>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogVisible2 = false">Cancel</el-button>
          <el-button type="danger" @click="removeWarehouse">
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
    const formLabelAlign = reactive({
      name: '',
      location: '',
      capacity: '',
    })
    const editForm = ref({});
    const dialogVisible = ref(false);
    const sidebarOpen = ref(false);
    const axios = inject('$axios');
    const dialogVisible1 = ref(false);
    const dialogVisible2 = ref(false);
    let rawData = [];
    let tableData = ref([]);
    const fetchUnreviewedWarehouses = async () => {
      try {
        const response = await axios.get('/warehouse/list');
        tableData.value = response.data.data;
        rawData = response.data.data;
        console.log('Data fetched successfully:', response.data.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    onMounted(() => {
      fetchUnreviewedWarehouses();
    });

    const handleClick = (row) => {
      editForm.value = JSON.parse(JSON.stringify(row));
      dialogVisible1.value = true;
    };

    const handleRemove = (row) => {
      editForm.value = JSON.parse(JSON.stringify(row));
      dialogVisible2.value = true;
    }
    const addNewWarehouse = async () => {
      dialogVisible.value = false;
      try {
        const response = await axios.post('/warehouse/add', {
          availableCapacity: formLabelAlign.capacity,
          totalCapacity: formLabelAlign.capacity,
          status: 1,
          warehouseLocation: formLabelAlign.location,
          warehouseName: formLabelAlign.name,
        });
        formLabelAlign.capacity = '';
        formLabelAlign.location = '';
        formLabelAlign.name = '';
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }

    const editWarehouse = async () => {
      dialogVisible1.value = false;
      try {
        const response = await axios.put('/warehouse/update', editForm.value);
        fetchUnreviewedWarehouses();
        ElNotification({
          title: 'Success',
          message: 'Edit successfully',
          type: 'success',
        })
      } catch (error) {
        ElNotification({
          title: 'Error',
          message: 'Edit fail',
          type: 'error',
        })
        console.error('Error fetching data:', error);
      }
    }

    const removeWarehouse = async () => {
      dialogVisible2.value = false;
      try {
        console.log(editForm.value.warehouseId);
        const response = await axios.delete(`/warehouse/delete?id=${editForm.value.warehouseId}`);
        fetchUnreviewedWarehouses();
        ElNotification({
          title: 'Success',
          message: 'Remove successfully',
          type: 'success',
        })
      } catch (error) {
        ElNotification({
          title: 'Error',
          message: 'Remove fail',
          type: 'error',
        })
        console.error('Error Removing Warehouse:', error);
      }
    }

    return {
      sidebarOpen,
      tableData,
      fetchUnreviewedWarehouses,
      handleClick,
      handleRemove,
      dialogVisible,
      dialogVisible1,
      dialogVisible2,
      formLabelAlign,
      editForm,
      addNewWarehouse,
      editWarehouse,
      removeWarehouse,
    }
  }
}
</script>
