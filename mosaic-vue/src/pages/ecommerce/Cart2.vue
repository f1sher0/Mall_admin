<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="lg:relative lg:flex">

          <!-- Content -->
          <div class="px-4 sm:px-6 lg:px-8 py-8 lg:grow lg:pr-8 xl:pr-16 2xl:ml-[80px]">
            <div class="lg:max-w-[640px] lg:mx-auto">

              <!-- Cart items -->
              <div class="mb-6 lg:mb-0">
                <div class="mb-3">
                  <div class="flex text-sm font-medium text-slate-400 dark:text-slate-500 space-x-2">
                    <span class="text-slate-500 dark:text-slate-400">Review</span>
                    <span>-&gt;</span>
                    <span class="text-indigo-500">Payment</span>
                    <span>-&gt;</span>
                    <span class="text-slate-500 dark:text-slate-400">Confirm</span>
                  </div>
                </div>
                <header class="mb-2">
                  <!-- Title -->
                  <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Shopping Cart (3) ✨</h1>
                </header>
                <CartItems />
              </div>

            </div>
          </div>

          <!-- Sidebar -->
          <div>
            <div class="lg:sticky lg:top-16 bg-slate-50 dark:bg-slate-800/20 lg:overflow-x-hidden lg:overflow-y-auto no-scrollbar lg:shrink-0 border-t lg:border-t-0 lg:border-l border-slate-200 dark:border-slate-700 lg:w-[320px] xl:w-[352px] 2xl:w-[calc(352px+80px)] lg:h-[calc(100dvh-64px)]">
              <div class="py-8 px-4 lg:px-8 2xl:px-12">
                <div class="max-w-sm mx-auto lg:max-w-none">
                  <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Review & Pay</h2>
                  <div class="space-y-6">

                    <!-- Order summary -->
                    <div>
                      <div class="text-slate-800 dark:text-slate-100 font-semibold mb-2">Order Summary</div>
                      <ul class="mb-4">
                        <li class="text-sm w-full flex justify-between py-3 border-b border-slate-200 dark:border-slate-700">
                          <div>Subtotal</div>
                          <div class="font-medium text-slate-800 dark:text-slate-100">$205</div>
                        </li>
                        <li class="text-sm w-full flex justify-between py-3 border-b border-slate-200 dark:border-slate-700">
                          <div>Total due (including taxes)</div>
                          <div class="font-medium text-emerald-600">$253</div>
                        </li>
                      </ul>
                    </div>

                    <!-- Payment Details -->
                    <div>
                      <div class="text-slate-800 dark:text-slate-100 font-semibold mb-4">Payment Details</div>
                      <div class="space-y-4">
                        <!-- Card Number -->
                        <div>
                          <label class="block text-sm font-medium mb-1" for="card-nr">Card Number <span class="text-rose-500">*</span></label>
                          <input id="card-nr" class="form-input w-full" type="text" placeholder="1234 1234 1234 1234" />
                        </div>
                        <!-- Expiry and CVC -->
                        <div class="flex space-x-4">
                          <div class="flex-1">
                            <label class="block text-sm font-medium mb-1" for="card-expiry">Expiry Date <span class="text-rose-500">*</span></label>
                            <input id="card-expiry" class="form-input w-full" type="text" placeholder="MM/YY" />
                          </div>
                          <div class="flex-1">
                            <label class="block text-sm font-medium mb-1" for="card-cvc">CVC <span class="text-rose-500">*</span></label>
                            <input id="card-cvc" class="form-input w-full" type="text" placeholder="CVC" />
                          </div>
                        </div>
                        <!-- Name on Card -->
                        <div>
                          <label class="block text-sm font-medium mb-1" for="card-name">Name on Card <span class="text-rose-500">*</span></label>
                          <input id="card-name" class="form-input w-full" type="text" placeholder="John Doe" />
                        </div>
                      </div>
                    </div>

                    <!-- Additional Details -->
                    <div>
                      <div class="text-slate-800 dark:text-slate-100 font-semibold mb-4">Additional Details</div>
                      <div class="space-y-4">
                        <!-- Email -->
                        <div>
                          <label class="block text-sm font-medium mb-1" for="card-email">Email <span class="text-rose-500">*</span></label>
                          <input id="card-email" class="form-input w-full" type="email" placeholder="john@company.com" />
                        </div>
                        <!-- Country -->
                        <div>
                          <label class="block text-sm font-medium mb-1" for="card-country">Country <span class="text-rose-500">*</span></label>
                          <select id="card-country" class="form-select w-full">
                            <option>Italy</option>
                            <option>USA</option>
                            <option>United Kingdom</option>
                          </select>
                        </div>
                      </div>
                    </div>

                    <div class="mt-6">
                      <div class="mb-4">
                        <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white">Pay $253.00</button>
                      </div>
                      <div class="text-xs text-slate-500 italic text-center">You'll be charged $253, including $48 for VAT in Italy</div>
                    </div>

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
import CartItems from '../../partials/ecommerce/CartItems.vue'

export default {
  name: 'Cart2',
  components: {
    Sidebar,
    Header,
    CartItems,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>