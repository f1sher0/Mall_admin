<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full">

          <!-- Page content -->
          <div class="max-w-5xl mx-auto flex flex-col lg:flex-row lg:space-x-8 xl:space-x-16">

            <!-- Cart items -->
            <div class="mb-6 lg:mb-0">
              <div class="mb-3">
                <div class="flex text-sm font-medium text-slate-400 dark:text-slate-500 space-x-2">
                  <span class="text-indigo-500">Review</span>
                  <span>-&gt;</span>
                  <span class="text-slate-500 dark:text-slate-400">Payment</span>
                  <span>-&gt;</span>
                  <span class="text-slate-500 dark:text-slate-400">Confirm</span>
                </div>
              </div>
              <header class="mb-2">
                <!-- Title -->
                <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Shopping Cart (3) ✨</h1>
              </header>

              <!-- Cart items -->
              <CartItems />

            </div>

            <!-- Sidebar -->
            <div>
              <div class="bg-white dark:bg-slate-800 p-5 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 lg:w-72 xl:w-80">
                <div class="text-slate-800 dark:text-slate-100 font-semibold mb-2">Order Summary</div>
                <!-- Order details -->
                <ul class="mb-4">
                  <li class="text-sm w-full flex justify-between py-3 border-b border-slate-200 dark:border-slate-700">
                    <div>Products & Subscriptions</div>
                    <div class="font-medium text-slate-800 dark:text-slate-100">$205</div>
                  </li>
                  <li class="text-sm w-full flex justify-between py-3 border-b border-slate-200 dark:border-slate-700">
                    <div>Shipping</div>
                    <div class="font-medium text-slate-800 dark:text-slate-100">-</div>
                  </li>
                  <li class="text-sm w-full flex justify-between py-3 border-b border-slate-200 dark:border-slate-700">
                    <div>Taxes</div>
                    <div class="font-medium text-slate-800 dark:text-slate-100">$48</div>
                  </li>
                  <li class="text-sm w-full flex justify-between py-3 border-b border-slate-200 dark:border-slate-700">
                    <div>Total due (including taxes)</div>
                    <div class="font-medium text-emerald-600">$253</div>
                  </li>
                </ul>
                <!-- Promo box -->
                <div class="mb-6">
                  <div class="flex items-center justify-between">
                    <label class="block text-sm font-medium mb-1" for="promo">Promo Code</label>
                    <div class="text-sm text-slate-400 dark:text-slate-500 italic">optional</div>
                  </div>
                  <input id="promo" class="form-input w-full mb-2" type="text" />
                  <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white disabled:border-slate-200 dark:disabled:border-slate-700 disabled:bg-slate-100 dark:disabled:bg-slate-800 disabled:text-slate-400 dark:disabled:text-slate-600 disabled:cursor-not-allowed shadow-none" disabled>Apply Code</button>
                </div>
                <div class="mb-4">
                  <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white">Buy Now - $253.00</button>
                </div>
                <div class="text-xs text-slate-500 italic text-center">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do <a class="underline hover:no-underline" href="#0">Terms</a>.</div>
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
  name: 'Cart',
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