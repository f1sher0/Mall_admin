<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden bg-white dark:bg-slate-900">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="mb-8">
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Alert & Banner ✨</h1>
          </div>

          <div class="border-t border-slate-200 dark:border-slate-700">

            <!-- Components -->
            <div class="space-y-8 mt-8">

              <!-- Banner -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Banner</h2>
                <div class="space-y-3">

                  <Banner type="warning" :open="bannerWarningOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner>

                  <Banner type="success" :open="bannerSuccessOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner>                  

                  <Banner type="error" :open="bannerErrorOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner>

                  <Banner :open="bannerInfoOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner>                                                      

                </div>
              </div>

              <!-- Banner 2 -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Banner 2</h2>
                <div class="space-y-3">

                  <Banner2 type="warning" :open="banner2WarningOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner2>

                  <Banner2 type="success" :open="banner2SuccessOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner2>                  

                  <Banner2 type="error" :open="banner2ErrorOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner2>

                  <Banner2 :open="banner2InfoOpen">
                    We're currently experiencing an increase in inquiries. There may be a delay in responses from the Support.
                  </Banner2> 

                </div>
              </div>

              <!-- Toast -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Toast</h2>
                <div class="space-y-3">

                  <Toast type="warning" :open="toastWarningOpen">
                    A warning toast.
                  </Toast>

                  <Toast type="success" :open="toastSuccessOpen">
                    A successful toast.
                  </Toast>                  

                  <Toast type="error" :open="toastErrorOpen">
                    A dangerous toast.
                  </Toast>

                  <Toast :open="toastInfoOpen">
                    An informational toast.
                  </Toast> 

                </div>
              </div>

              <!-- Toast 2 -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Toast 2</h2>
                <div class="space-y-3">

                  <Toast2 type="warning" :open="toast2WarningOpen">
                    A warning toast.
                  </Toast2>

                  <Toast2 type="success" :open="toast2SuccessOpen">
                    A successful toast.
                  </Toast2>                  

                  <Toast2 type="error" :open="toast2ErrorOpen">
                    A dangerous toast.
                  </Toast2>

                  <Toast2 :open="toast2InfoOpen">
                    An informational toast.
                  </Toast2> 

                </div>
              </div>

              <!-- Toast 3 -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Toast 3</h2>
                <div class="space-y-3">

                  <Toast3 type="warning" :open="toast3WarningOpen">
                    A warning toast.
                  </Toast3>

                  <Toast3 type="success" :open="toast3SuccessOpen">
                    A successful toast.
                  </Toast3>                  

                  <Toast3 type="error" :open="toast3ErrorOpen">
                    A dangerous toast.
                  </Toast3>

                  <Toast3 :open="toast3InfoOpen">
                    An informational toast.
                  </Toast3>

                </div>
              </div>

              <!-- Notification -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Notification</h2>
                <div class="space-y-3">

                  <Notification type="warning" :open="notificationWarningOpen">
                    <div class="font-medium text-slate-800 dark:text-slate-100 mb-1">Merged Pull Request</div>
                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing sed do eiusmod tempor incididunt ut labore et dolore.</div>
                  </Notification>

                  <Notification type="success" :open="notificationSuccessOpen">
                    <div class="font-medium text-slate-800 dark:text-slate-100 mb-1">Merged Pull Request</div>
                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing sed do eiusmod tempor incididunt ut labore et dolore.</div>
                  </Notification>                  

                  <Notification type="error" :open="notificationErrorOpen">
                    <div class="font-medium text-slate-800 dark:text-slate-100 mb-1">Merged Pull Request</div>
                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing sed do eiusmod tempor incididunt ut labore et dolore.</div>
                  </Notification>

                  <Notification :open="notificationInfoOpen">
                    <div class="font-medium text-slate-800 dark:text-slate-100 mb-1">Merged Pull Request</div>
                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing sed do eiusmod tempor incididunt ut labore et dolore.</div>
                  </Notification>

                </div>
              </div>

            </div>

          </div>

        </div>        
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar from '../../partials/Sidebar.vue'
import Header from '../../partials/Header.vue'
import Banner from '../../components/Banner.vue'
import Banner2 from '../../components/Banner2.vue'
import Toast from '../../components/Toast.vue'
import Toast2 from '../../components/Toast2.vue'
import Toast3 from '../../components/Toast3.vue'
import Notification from '../../components/Notification.vue'

export default {
  name: 'AlertPage',
  components: {
    Sidebar,
    Header,
    Banner,
    Banner2,
    Toast,
    Toast2,
    Toast3,
    Notification,
  },
  setup() {

    const sidebarOpen = ref(false)
    const bannerWarningOpen = ref(true)
    const bannerErrorOpen = ref(true)
    const bannerSuccessOpen = ref(true)
    const bannerInfoOpen = ref(true)
    const banner2WarningOpen = ref(true)
    const banner2ErrorOpen = ref(true)
    const banner2SuccessOpen = ref(true)
    const banner2InfoOpen = ref(true)
    const toastWarningOpen = ref(true)
    const toastErrorOpen = ref(true)
    const toastSuccessOpen = ref(true)
    const toastInfoOpen = ref(true)
    const toast2WarningOpen = ref(true)
    const toast2ErrorOpen = ref(true)
    const toast2SuccessOpen = ref(true)
    const toast2InfoOpen = ref(true)
    const toast3WarningOpen = ref(true)
    const toast3ErrorOpen = ref(true)
    const toast3SuccessOpen = ref(true)
    const toast3InfoOpen = ref(true)
    const notificationWarningOpen = ref(true)
    const notificationErrorOpen = ref(true)
    const notificationSuccessOpen = ref(true)
    const notificationInfoOpen = ref(true)

    return {
      sidebarOpen,
      bannerWarningOpen,
      bannerErrorOpen,
      bannerSuccessOpen,
      bannerInfoOpen,
      banner2WarningOpen,
      banner2ErrorOpen,
      banner2SuccessOpen,
      banner2InfoOpen,
      toastWarningOpen,
      toastErrorOpen,
      toastSuccessOpen,
      toastInfoOpen,
      toast2WarningOpen,
      toast2ErrorOpen,
      toast2SuccessOpen,
      toast2InfoOpen,
      toast3WarningOpen,
      toast3ErrorOpen,
      toast3SuccessOpen,
      toast3InfoOpen,
      notificationWarningOpen,
      notificationErrorOpen,
      notificationSuccessOpen,
      notificationInfoOpen,            
    }  
  }
}
</script>