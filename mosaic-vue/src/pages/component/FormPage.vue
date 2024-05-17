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
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Input Form ✨</h1>
          </div>

          <div class="border-t border-slate-200 dark:border-slate-700">

            <!-- Components -->
            <div class="space-y-8 mt-8">

              <!-- Input Types -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Input Types</h2>
                <div class="grid gap-5 md:grid-cols-3">

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="default">Default</label>
                      <input id="default" class="form-input w-full" type="text" />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <div class="flex items-center justify-between">
                        <label class="block text-sm font-medium mb-1" for="tooltip">W/ Tooltip</label>
                        <Tooltip class="ml-2" bg="dark" size="md">
                          <div class="text-sm text-slate-200">Excepteur sint occaecat cupidata non proident, sunt.</div>
                        </Tooltip>
                      </div>
                      <input id="tooltip" class="form-input w-full" type="text" />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="mandatory">Mandatory <span class="text-rose-500">*</span></label>
                      <input id="mandatory" class="form-input w-full" type="text" required />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="prefix">W/ Prefix</label>
                      <div class="relative">
                        <input id="prefix" class="form-input w-full pl-12" type="text" />
                        <div class="absolute inset-0 right-auto flex items-center pointer-events-none">
                          <span class="text-sm text-slate-400 dark:text-slate-500 font-medium px-3">USD</span>
                        </div>
                      </div>
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="suffix">W/ Suffix</label>
                      <div class="relative">
                        <input id="suffix" class="form-input w-full pr-8" type="text" />
                        <div class="absolute inset-0 left-auto flex items-center pointer-events-none">
                          <span class="text-sm text-slate-400 dark:text-slate-500 font-medium px-3">%</span>
                        </div>
                      </div>
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="placeholder">W/ Placeholder</label>
                      <input id="placeholder" class="form-input w-full" type="text" placeholder="Something cool..." />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <form>
                      <label class="block text-sm font-medium mb-1" for="icon">W/ Icon</label>
                      <div class="relative">
                        <input id="icon" class="form-input w-full pl-9" type="text" />
                        <div class="absolute inset-0 right-auto flex items-center pointer-events-none">
                          <svg class="w-4 h-4 fill-current text-slate-400 shrink-0 ml-3 mr-2" viewBox="0 0 16 16">
                            <path d="M11.7.3c-.4-.4-1-.4-1.4 0l-10 10c-.2.2-.3.4-.3.7v4c0 .6.4 1 1 1h4c.3 0 .5-.1.7-.3l10-10c.4-.4.4-1 0-1.4l-4-4zM4.6 14H2v-2.6l6-6L10.6 8l-6 6zM12 6.6L9.4 4 11 2.4 13.6 5 12 6.6z" />
                          </svg>
                        </div>
                      </div>
                    </form>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <div>
                        <label class="block text-sm font-medium mb-1" for="supporting-text">W/ Supporting Text</label>
                        <input id="supporting-text" class="form-input w-full" type="text" />
                      </div>
                      <div class="text-xs mt-1">Supporting text goes here!</div>
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <form>
                      <label class="block text-sm font-medium mb-1" for="form-search">Search</label>
                      <div class="relative">
                        <input id="form-search" class="form-input w-full pl-9" type="search" />
                        <button class="absolute inset-0 right-auto group" type="submit" aria-label="Search">
                          <svg class="w-4 h-4 shrink-0 fill-current text-slate-400 dark:text-slate-500 group-hover:text-slate-500 dark:group-hover:text-slate-400 ml-3 mr-2" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                            <path d="M7 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zM7 2C4.243 2 2 4.243 2 7s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5z" />
                            <path d="M15.707 14.293L13.314 11.9a8.019 8.019 0 01-1.414 1.414l2.393 2.393a.997.997 0 001.414 0 .999.999 0 000-1.414z" />
                          </svg>
                        </button>
                      </div>
                    </form>
                    <!-- End -->
                  </div>
                </div>
              </div>

              <!-- Input Sizes -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Input Sizes</h2>
                <div class="grid gap-5 md:grid-cols-3">

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="small">Small</label>
                      <input id="small" class="form-input w-full px-2 py-1" type="text" />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="normal">Default</label>
                      <input id="normal" class="form-input w-full" type="text" />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="large">Large</label>
                      <input id="large" class="form-input w-full px-4 py-3" type="text" />
                    </div>
                    <!-- End -->
                  </div>

                </div>
              </div>

              <!-- Input States -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Input States</h2>
                <div class="grid gap-5 md:grid-cols-3">

                  <div>
                    <!-- Start -->
                    <div>
                      <label class="block text-sm font-medium mb-1" for="disabled">Disabled</label>
                      <input id="disabled" class="form-input w-full disabled:border-slate-200 dark:disabled:border-slate-700 disabled:bg-slate-100 dark:disabled:bg-slate-800 disabled:text-slate-400 dark:disabled:text-slate-600 disabled:cursor-not-allowed" type="text" placeholder="Something cool..." disabled />
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <div>
                        <label class="block text-sm font-medium mb-1" for="error">Error <span class="text-rose-500">*</span></label>
                        <input id="error" class="form-input w-full border-rose-300" type="text" />
                      </div>
                      <div class="text-xs mt-1 text-rose-500">This field is required!</div>
                    </div>
                    <!-- End -->
                  </div>

                  <div>
                    <!-- Start -->
                    <div>
                      <div>
                        <label class="block text-sm font-medium mb-1" for="success">Success <span class="text-rose-500">*</span></label>
                        <input id="success" class="form-input w-full border-emerald-300" type="text" />
                      </div>
                      <div class="text-xs mt-1 text-emerald-500">Sounds good!</div>
                    </div>
                    <!-- End -->
                  </div>

                </div>
              </div>

              <!-- Select -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Select</h2>
                <label class="block text-sm font-medium mb-1" for="country">Country</label>
                <select id="country" class="form-select">
                  <option>Italy</option>
                  <option>USA</option>
                  <option>United Kingdom</option>
                </select>
              </div>

              <!-- Checkbox -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Checkbox</h2>
                <div class="flex flex-wrap items-center -m-3">

                  <div class="m-3">
                    <!-- Start -->
                    <label class="flex items-center">
                      <input type="checkbox" class="form-checkbox" />
                      <span class="text-sm ml-2">Active</span>
                    </label>
                    <!-- End -->
                  </div>

                  <div class="m-3">
                    <!-- Start -->
                    <label class="flex items-center">
                      <input type="checkbox" class="form-checkbox" checked />
                      <span class="text-sm ml-2">Selected</span>
                    </label>
                    <!-- End -->
                  </div>

                  <div class="m-3">
                    <!-- Start -->
                    <label class="flex items-center">
                      <input type="checkbox" class="form-checkbox disabled:bg-slate-50" disabled />
                      <span class="text-sm ml-2">Disabled</span>
                    </label>
                    <!-- End -->
                  </div>

                </div>
              </div>

              <!-- Radio -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Radio</h2>
                <div class="flex flex-wrap items-center -m-3">

                  <div class="m-3">
                    <!-- Start -->
                    <label class="flex items-center">
                      <input type="radio" name="radio-buttons" class="form-radio" />
                      <span class="text-sm ml-2">Active</span>
                    </label>
                    <!-- End -->
                  </div>

                  <div class="m-3">
                    <!-- Start -->
                    <label class="flex items-center">
                      <input type="radio" name="radio-buttons" class="form-radio" checked />
                      <span class="text-sm ml-2">Selected</span>
                    </label>
                    <!-- End -->
                  </div>

                  <div class="m-3">
                    <!-- Start -->
                    <label class="flex items-center">
                      <input type="radio" name="radio-buttons" class="form-radio disabled:bg-slate-50" disabled />
                      <span class="text-sm ml-2">Disabled</span>
                    </label>
                    <!-- End -->
                  </div>

                </div>
              </div>

              <!-- Toggle Switch -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Toggle Switch</h2>
                <div class="flex flex-wrap items-center -m-3">

                  <div class="m-3 w-24">
                    <!-- Start -->
                    <div class="flex items-center mt-5">
                      <div class="form-switch">
                        <input type="checkbox" id="toggle1" class="sr-only" v-model="toggle1" true-value="On" false-value="Off" />
                        <label class="bg-slate-400 dark:bg-slate-700" for="toggle1">
                          <span class="bg-white shadow-sm" aria-hidden="true"></span>
                          <span class="sr-only">Toggle</span>
                        </label>
                      </div>
                      <div class="text-sm text-slate-400 dark:text-slate-500 italic ml-2">{{toggle1}}</div>
                    </div>
                    <!-- End -->
                  </div>

                  <div class="m-3 w-24">
                    <!-- Start -->
                    <div class="flex items-center mt-5">
                      <div class="form-switch">
                        <input type="checkbox" id="toggle2" class="sr-only" v-model="toggle2" true-value="On" false-value="Off" />
                        <label class="bg-slate-400 dark:bg-slate-700" for="toggle2">
                          <span class="bg-white shadow-sm" aria-hidden="true"></span>
                          <span class="sr-only">Toggle</span>
                        </label>
                      </div>
                      <div class="text-sm text-slate-400 dark:text-slate-500 italic ml-2">{{toggle2}}</div>
                    </div>
                    <!-- End -->
                  </div>

                  <div class="m-3 w-32">
                    <!-- Start -->
                    <div class="flex items-center mt-5">
                      <div class="form-switch">
                        <input type="checkbox" id="toggle3" class="sr-only" v-model="toggle3" true-value="On" false-value="Off" disabled />
                        <label class="bg-slate-400 dark:bg-slate-700" for="toggle3">
                          <span class="bg-white shadow-sm" aria-hidden="true"></span>
                          <span class="sr-only">Toggle</span>
                        </label>
                      </div>
                      <div class="text-sm text-slate-400 dark:text-slate-500 italic ml-2">Disabled</div>
                    </div>                    
                    <!-- End -->
                  </div>

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
import Tooltip from '../../components/Tooltip.vue'

export default {
  name: 'FormPage',
  components: {
    Sidebar,
    Header,
    Tooltip,
  },
  setup() {

    const sidebarOpen = ref(false)
    const toggle1 = ref('On')
    const toggle2 = ref('Off')
    const toggle3 = ref('Off')

    return {
      sidebarOpen,
      toggle1,
      toggle2,
      toggle3,
    }  
  }
}
</script>