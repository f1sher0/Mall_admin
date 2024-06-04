<template>
  <main class="bg-white dark:bg-slate-900">
    <div class="relative flex">
      <!-- Content -->
      <div class="w-full md:w-1/2">
        <div class="min-h-[100dvh] h-full flex flex-col after:flex-1">
          <div class="flex-1">
            <div class="flex items-center justify-between h-16 px-4 sm:px-6 lg:px-8">
              <!-- Logo -->
              <router-link class="block" to="/">
                <svg width="32" height="32" viewBox="0 0 32 32">
                  <defs>
                    <linearGradient x1="28.538%" y1="20.229%" x2="100%" y2="108.156%" id="logo-a">
                      <stop stop-color="#A5B4FC" stop-opacity="0" offset="0%" />
                      <stop stop-color="#A5B4FC" offset="100%" />
                    </linearGradient>
                    <linearGradient x1="88.638%" y1="29.267%" x2="22.42%" y2="100%" id="logo-b">
                      <stop stop-color="#38BDF8" stop-opacity="0" offset="0%" />
                      <stop stop-color="#38BDF8" offset="100%" />
                    </linearGradient>
                  </defs>
                  <rect fill="#6366F1" width="32" height="32" rx="16" />
                  <path
                    d="M18.277.16C26.035 1.267 32 7.938 32 16c0 8.837-7.163 16-16 16a15.937 15.937 0 01-10.426-3.863L18.277.161z"
                    fill="#4F46E5" />
                  <path
                    d="M7.404 2.503l18.339 26.19A15.93 15.93 0 0116 32C7.163 32 0 24.837 0 16 0 10.327 2.952 5.344 7.404 2.503z"
                    fill="url(#logo-a)" />
                  <path
                    d="M2.223 24.14L29.777 7.86A15.926 15.926 0 0132 16c0 8.837-7.163 16-16 16-5.864 0-10.991-3.154-13.777-7.86z"
                    fill="url(#logo-b)" />
                </svg>
              </router-link>
            </div>
          </div>

          <div class="max-w-sm mx-auto w-full px-4 py-8">
            <h1 class="text-3xl text-slate-800 dark:text-slate-100 font-bold mb-6">Create your Account</h1>
            <!-- Form -->
            <form @submit.prevent="handleSubmit">
              <div class="space-y-4">
                <div>
                  <label class="block text-sm font-medium mb-1" for="email">Email Address <span
                      class="text-rose-500">*</span></label>
                  <input id="email" v-model="email" class="form-input w-full" type="email" required />
                </div>
                <div>
                  <label class="block text-sm font-medium mb-1" for="name">Name <span
                      class="text-rose-500">*</span></label>
                  <input id="name" v-model="name" class="form-input w-full" type="text" required />
                </div>
                <div>
                  <label class="block text-sm font-medium mb-1" for="password">Password <span
                      class="text-rose-500">*</span></label>
                  <input id="password" v-model="password" class="form-input w-full" type="password" autocomplete="on"
                    required />
                </div>
                <div>
                  <label class="block text-sm font-medium mb-1" for="role">Role <span
                      class="text-rose-500">*</span></label>
                  <select id="role" v-model="role" class="form-select w-full" required>

                    <option value="Purchaser">Purchaser</option>
                    <option value="Supplier">Supplier</option>

                  </select>
                </div>

                <div v-if="role == 'Purchaser'">
                  <label class="block text-sm font-medium mb-1" for="address">Address<span
                      class="text-rose-500">*</span></label>
                  <input id="address" v-model="address" class="form-input w-full" type="address" autocomplete="on"
                    required />
                  <label class="block text-sm font-medium mb-1 mt-3" for="zip">Zip Code<span
                      class="text-rose-500">*</span></label>
                  <input id="zip" v-model="zip" class="form-input w-full" type="zip" autocomplete="on"
                    required />
                  <label class="block text-sm font-medium mb-1 mt-3" for="description">Self Description<span
                      class="text-rose-500">*</span></label>
                  <el-input v-model="description" style="width: 100%" :autosize="{ minRows: 3, maxRows: 6 }"
                    type="textarea" placeholder="Please input" />
                </div>

                <div v-if="role == 'Supplier'">
                  <label class="block text-sm font-medium mb-1" for="address">Address<span
                      class="text-rose-500">*</span></label>
                  <input id="address" v-model="address" class="form-input w-full" type="address" autocomplete="on"
                    required />
                  <label class="block text-sm font-medium mb-1 mt-3" for="zip">Zip Code<span
                      class="text-rose-500">*</span></label>
                  <input id="zip" v-model="zip" class="form-input w-full" type="zip" autocomplete="on"
                    required />
                  <label class="block text-sm font-medium mb-1 mt-3" for="description">Self Description<span
                      class="text-rose-500">*</span></label>
                  <el-input v-model="description" style="width: 100%" :autosize="{ minRows: 3, maxRows: 6 }"
                    type="textarea" placeholder="Please input" />
                </div>

              </div>
              <div class="flex items-center justify-between mt-6">
                <div class="mr-1">
                  <label class="flex items-center">
                    <input type="checkbox" class="form-checkbox" v-model="subscribe" />
                    <span class="text-sm ml-2">Subscibe Our News</span>
                  </label>
                </div>
                <button type="submit"
                  class="btn bg-indigo-500 hover:bg-indigo-600 text-white ml-3 whitespace-nowrap">Register</button>
              </div>
            </form>
            <!-- Footer -->
            <div class="pt-5 mt-6 border-t border-slate-200 dark:border-slate-700">
              <div class="text-sm">
                Already have an account? <router-link
                  class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" to="/signin">Sign
                  in</router-link>
              </div>
            </div>
          </div>

        </div>
      </div>

      <!-- Image -->
      <div class="hidden md:block absolute top-0 bottom-0 right-0 md:w-1/2" aria-hidden="true">
        <img class="object-cover object-center w-full h-full" src="../images/auth-image.jpg" width="760" height="1024"
          alt="Authentication" />
        <img class="absolute top-1/4 left-0 -translate-x-1/2 ml-8 hidden lg:block" src="../images/auth-decoration.png"
          width="218" height="224" alt="Authentication decoration" />
      </div>

    </div>

  </main>
</template>

<script>
import { ref, inject, onMounted} from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'
export default {
  name: 'Signup',
  setup() {
    const email = ref('');
    const name = ref('');
    const role = ref('');
    const password = ref('');
    const address = ref('');
    const description = ref('');
    const zip = ref('');
    const capacity = ref(0);
    const subscribe = ref(false);
    const router = useRouter();
    const axios = inject("$axios")

    const handleSubmit = async () => {
      try {
        const response = await axios.post('/user/register', {
          email: email.value,
          username: name.value,
          role: role.value,
          password: password.value,
          subscribe: subscribe.value,
        })
        let response1;
        if (role.value == "Purchaser") {
          response1 = await axios.post('/purchaser/add', {
            purchaserDesc: description.value,
            purchaserName: name.value,
            password: password.value,
            zip: zip.value,
            address: address.value,
            email: email.value,
            status: 1,
          })
        } else {
          response1 = await axios.post('/supplier/add', {
            supplierDesc: description.value,
            supplierName: name.value,
            password: password.value,
            zip: zip.value,
            address: address.value,
            email: email.value,
            status: 0,
          })
        } 
        if (response.data.code === '200' && response1.data.code === '200') {
          // 注册成功，弹出确认框
          ElMessageBox.confirm('Registration successful, please wait for review. Do you want to jump to the login page?', 'Tips', {
            confirmButtonText: 'Confirm',
            cancelButtonText: 'Cancel',
            type: 'success'
          }).then(() => {
            // 用户点击确认，执行跳转到登录页面的操作
            router.push('/signin')

          }).catch(() => {
            // 用户点击取消，不执行任何操作
          })
        } else {
          ElMessage.error(response.data.msg || '注册失败')
        }
      } catch (error) {
        console.error('注册失败:', error)
        ElMessage.error('注册失败，请稍后再试')
      }
    }

    return {
      email,
      name,
      role,
      password,
      description,
      zip,
      address,
      subscribe,
      handleSubmit,
      router
    }
  },
}
</script>

<style scoped>
body {
  margin: 0;
}
</style>
