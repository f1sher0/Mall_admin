<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar_supplier :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">

      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow dark:bg-slate-900">
        <WelcomeBanner />
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="sm:flex sm:justify-between sm:items-center mb-4 md:mb-2">
            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Add New Goods</h1>
            </div>
          </div>

          <!-- Form -->
          <div class="bg-white dark:bg-slate-800 shadow-md rounded p-5">
            <form @submit.prevent="submitForm">
              <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                <div>
                  <label for="goodsName" class="block text-sm font-medium mb-1">Goods Name</label>
                  <input id="goodsName" v-model="form.goodsName" class="form-input w-full" type="text" required />
                </div>
                <div>
                  <label for="goodsCategory" class="block text-sm font-medium mb-1">Goods Category</label>
                  <input id="goodsCategory" v-model="form.goodsCategory" class="form-input w-full" type="text" required />
                </div>
                <div>
                  <label for="supplierName" class="block text-sm font-medium mb-1">Supplier Name</label>
                  <input id="supplierName" v-model="form.supplierName" class="form-input w-full" type="text" required disabled />
                </div>
                <div>
                  <label for="goodsPrice" class="block text-sm font-medium mb-1">Goods Price</label>
                  <input id="goodsPrice" v-model="form.goodsPrice" class="form-input w-full" type="text" required />
                </div>
                <div>
                  <label for="warehouseId" class="block text-sm font-medium mb-1">Warehouse Id</label>
                  <input id="warehouseId" v-model="form.warehouseId" class="form-input w-full" type="text" required />
                </div>
                <div>
                  <label for="remark" class="block text-sm font-medium mb-1">Remark</label>
                  <textarea id="remark" v-model="form.remark" class="form-textarea w-full" rows="4"></textarea>
                </div>
              </div>
              <div class="mt-6">
                <button type="submit" class="btn bg-indigo-500 hover:bg-indigo-600 text-white">Submit</button>
              </div>
            </form>
          </div>

        </div>

      </main>

    </div>

  </div>
</template>

<script>
import { ref, onMounted, inject } from 'vue';
// import axios from 'axios';
import { ElMessage, ElNotification } from 'element-plus';
import Header from '../../partials/Header.vue';
import Sidebar_supplier from '../../partials/Sidebar_supplier.vue';
import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
export default {
  name: 'AddGoods',
  components: {
    Sidebar_supplier,
    Header,
    WelcomeBanner,
  },
  setup() {
    const axios = inject('$axios');
    const sidebarOpen = ref(false);
    const form = ref({
      goodsName: '',
      goodsCategory: '',
      supplierName: sessionStorage.getItem('username') || '',
      supplierId:sessionStorage.getItem('id'),
      goodsPrice: '',
      warehouseId: '',
      remark: ''
    });

    const submitForm = async () => {
      try {
        const response = await axios.post('/goodsIn/add', form.value, {
          headers: {
            'Content-Type': 'application/json'
          }
        });
        const data = response.data;

        if (data.code === 200) {
          ElMessage({
            message: 'Goods added successfully',
            type: 'success',
          });
          // Reset form
          form.value = {
            goodsName: '',
            goodsCategory: '',
            supplierName: sessionStorage.getItem('username') || '',
            goodsPrice: '',
            warehouseId: '',
            remark: ''
          };
        } else {
          ElNotification({
            title: 'Error',
            message: data.msg,
            type: 'error',
            position: 'top-right',
          });
        }
      } catch (error) {
        ElNotification({
          title: 'Error',
          message: 'Error adding goods: ' + error.msg,
          type: 'error',
          position: 'top-right',
        });
      }
    };

    return {
      sidebarOpen,
      form,
      submitForm
    };
  }
};
</script>

<style scoped>
.form-input {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.form-textarea {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.btn {
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
