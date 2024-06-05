<template>
  <div class="grow">
    <!-- Panel body -->
    <div class="p-6 space-y-6">
      <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-5">My Account</h2>
      <!-- Picture -->
      <section>
        <div class="flex items-center">
          <div class="mr-4">
            <img class="w-20 h-20 rounded-full" src="../../images/user-avatar-80.png" width="80" height="80"
              alt="User upload" />
          </div>
          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Change</button>
        </div>
      </section>
      <!-- Business Profile -->
      <section>
        <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-1">Business Profile</h3>
        <div class="sm:flex sm:items-center space-y-4 sm:space-y-0 sm:space-x-4 mt-5">
          <div class="sm:w-1/3 flex align-center">
            <div class=" text-sm font-medium mb-1 mr-4 pt-1">Purchaser Name</div>
            <el-input v-model="input" clearable class="w-fit">
            </el-input>
          </div>
          <div class="sm:w-1/3 flex align-center">
            <div class=" text-sm font-medium mb-1 mr-4 pt-1">Purchaser Address</div>
            <el-input v-model="input" clearable class="w-fit">
            </el-input>
          </div>
        </div>
      </section>

      <!-- Password -->
      <section>
        <h3 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-1">Password</h3>
        <div class="text-sm">You can set a permanent password if you don't want to use temporary login codes.</div>
        <div class="mt-5">
          <router-link class="btn border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm text-indigo-500"  to="/reset">Set
            New Password</router-link>
        </div>
      </section>

    </div>
    <!-- Panel footer -->
    <footer>
      <div class="flex flex-col px-6 py-5 border-t border-slate-200 dark:border-slate-700">
        <div class="flex self-end">
          <button
            class="btn dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300">Cancel</button>
          <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white ml-3" @click="handleClick">Save Changes</button>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
import { ref, inject, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

export default {
  name: 'AccountPanel',
  setup() {
    const input = ref('');
    const axios = inject('$axios');
    onMounted(() => {
      console.log(sessionStorage.getItem("id"));
      try {
        const response = axios.get('/purchaser/getAccount', sessionStorage.getItem("id"));
        console.log(response);
      } catch (error) {
        console.error(error);
      }
      input.value = sessionStorage.getItem("username");
    });
    const handleClick = () => {
      ElMessageBox.confirm(
        'User name will be changed. Continue?',
        'Warning',
        {
          confirmButtonText: 'Confirm',
          cancelButtonText: 'Cancel',
          type: 'warning',
        }
      )
        .then(() => {
          try {
            const response = axios.put("/user/update", {
              userId: sessionStorage.getItem("id"),
              username: input.value,
            });
            sessionStorage.setItem('username', input.value);
            ElMessage({
            type: 'success',
            message: 'Save completed',
            })
          } catch (error) {
            console.error(error);
          }
        })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: 'Save canceled',
          })
        })
    };

    return {
      handleClick,
      input,
    }
  }
}
</script>