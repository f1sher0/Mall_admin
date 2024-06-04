<template>
  <div class="grow">
    <!-- Panel body -->
    <div class="p-6 space-y-6">
      <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-5">My Account</h2>
      <!-- Picture -->
      <section>
        <div class="flex items-center">
          <div class="mr-4">
            <img class="w-20 h-20 rounded-full" src="../../images/user-avatar-80.png" width="80" height="80" alt="User upload" />
          </div>
          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Change</button>
        </div>
      </section>
      <!-- Business Profile -->
      <section>
        <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-1">Business Profile</h3>
        <div class="sm:flex sm:items-center space-y-4 sm:space-y-0 sm:space-x-4 mt-5">
          <div class="sm:w-1/3">
            <label class="block text-sm font-medium mb-1" for="name">Name</label>
            <input id="name" v-model="name" class="form-input w-full" type="text" />
          </div>
          <div class="sm:w-1/3">
            <label class="block text-sm font-medium mb-1" for="address">Address</label>
            <input id="address" v-model="address" class="form-input w-full" type="text" />
          </div>
        </div>
      </section>

      <!-- Password -->
      <section>
        <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-1">Password</h3>
        <div class="text-sm">You can set a permanent password if you don't want to use temporary login codes.</div>
        <div class="mt-5">
          <button class="btn border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm text-indigo-500">Set New Password</button>
        </div>
      </section>
    </div>
    <!-- Panel footer -->
    <footer>
      <div class="flex flex-col px-6 py-5 border-t border-slate-200 dark:border-slate-700">
        <div class="flex self-end">
          <button class="btn dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click="cancel">Cancel</button>
          <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white ml-3" @click="saveChanges">Save Changes</button>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
import { ref, onMounted, inject } from 'vue';
import Supplier_dashboard from '../../views/supplier/supplier_dashboard.vue';

export default {
  name: 'AccountPanel',
  setup() {
    const axios = inject('$axios');
    const role = sessionStorage.getItem('role');
    const id = sessionStorage.getItem('id');
    const name = ref('');
    const address = ref('');

    const fetchAccountInfo = async () => {
      try {
        alert(role);alert(id);
        const response = await axios.get(`http://localhost:5052/api/${role.toLowerCase()}/getAccount`, { params: { id } });
       
        if (response.status === 200) {
          const accountInfo = response.data.data;
          name.value = accountInfo.name;
          alert(name.value )
          address.value = accountInfo.address;
        } else {
          console.error('Failed to fetch account info:', response.data.message);
        }
      } catch (error) {
        console.error('Error fetching account info:', error);
      }
    };
    const cancel = async()=>{
      fetchAccountInfo().catch(error => {
    console.error('Error canceling:', error);
  });
    }
    const saveChanges = async () => {
      try {
        alert(id);
        const payload = { supplierId:id, supplierName: name.value, address: address.value };
        const response = await axios.put(`http://localhost:5052/api/${role.toLowerCase()}/update`, payload);
        if (response.data && response.data.code === 200) {
          alert('Changes saved successfully');
        } else {
          console.error('Failed to save changes:', response.data.message);
        }
      } catch (error) {
        console.error('Error saving changes:', error);
      }
    };

    onMounted(fetchAccountInfo);

    return {
      name,
      address,
      saveChanges,
      cancel
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
