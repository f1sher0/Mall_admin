<template>
  <header class="bg-white dark:bg-[#182235] border-b border-slate-200 dark:border-slate-700">
    <div class="px-4 sm:px-6 lg:px-8">
      <div class="flex items-center justify-between h-16">

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
            <path d="M18.277.16C26.035 1.267 32 7.938 32 16c0 8.837-7.163 16-16 16a15.937 15.937 0 01-10.426-3.863L18.277.161z" fill="#4F46E5" />
            <path d="M7.404 2.503l18.339 26.19A15.93 15.93 0 0116 32C7.163 32 0 24.837 0 16 0 10.327 2.952 5.344 7.404 2.503z" fill="url(#logo-a)" />
            <path d="M2.223 24.14L29.777 7.86A15.926 15.926 0 0132 16c0 8.837-7.163 16-16 16-5.864 0-10.991-3.154-13.777-7.86z" fill="url(#logo-b)" />
          </svg>
        </router-link>

        <router-link class="block rounded-full bg-slate-100 dark:bg-slate-700 text-slate-500 dark:text-slate-400 hover:text-slate-600 dark:hover:text-slate-300" to="/ecommerce/cart">
          <span class="sr-only">Back</span>
          <svg width="32" height="32" viewBox="0 0 32 32">
            <path class="fill-current" d="M15.95 14.536l4.242-4.243a1 1 0 111.415 1.414l-4.243 4.243 4.243 4.242a1 1 0 11-1.415 1.415l-4.242-4.243-4.243 4.243a1 1 0 01-1.414-1.415l4.243-4.242-4.243-4.243a1 1 0 011.414-1.414l4.243 4.243z" />
          </svg>
        </router-link>

      </div>
    </div>
  </header>

  <main class="grow">

    <div class="relative pt-8">
      <div class="absolute inset-0 bg-slate-800 overflow-hidden" aria-hidden="true">
        <img class="object-cover h-full w-full filter blur opacity-10" src="../../images/pay-bg.jpg" width="460" height="180" alt="Pay background" />
      </div>
      <div class="relative px-4 sm:px-6 lg:px-8 max-w-lg mx-auto">
        <img class="rounded-t shadow-lg" src="../../images/pay-bg.jpg" width="460" height="180" alt="Pay background" />
      </div>
    </div>

    <div class="relative px-4 sm:px-6 lg:px-8 pb-8 max-w-lg mx-auto">
      <div class="bg-white dark:bg-slate-800 px-8 pb-6 rounded-b shadow-lg">

        <!-- Card header -->
        <div class="text-center mb-6">
          <div class="mb-2">
            <img class="-mt-8 inline-flex rounded-full" src="../../images/user-64-13.jpg" width="64" height="64" alt="User" />
          </div>
          <h1 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-semibold mb-2">Front-End Learning 🔥</h1>
          <div class="text-sm">
            Learn how to create real web apps using HTML & CSS. Code templates included.
          </div>
        </div>

        <!-- Toggle -->
        <div class="flex justify-center mb-6">
          <div class="relative flex w-full p-1 bg-slate-50 dark:bg-slate-700/30 rounded">
            <span class="absolute inset-0 m-1 pointer-events-none" aria-hidden="true">
              <span class="absolute inset-0 w-1/2 bg-white dark:bg-slate-700 rounded border border-slate-200 dark:border-slate-600 shadow-sm transition duration-150 ease-in-out" :class="card ? 'translate-x-0' : 'translate-x-full'"></span>
            </span>
            <button class="relative flex-1 text-sm font-medium p-1 duration-150 ease-in-out" :class="card && 'dark:text-slate-100'" @click.prevent="card = true">Pay With Card</button>
            <button class="relative flex-1 text-sm font-medium p-1 duration-150 ease-in-out" :class="!card && 'dark:text-slate-100'" @click.prevent="card = false">Pay With PayPal</button>
          </div>
        </div>

        <!-- Card form -->
        <div v-if="card">
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
            <!-- Email -->
            <div>
              <label class="block text-sm font-medium mb-1" for="card-email">Email <span class="text-rose-500">*</span></label>
              <input id="card-email" class="form-input w-full" type="email" placeholder="john@company.com" />
            </div>
          </div>
          <!-- Form footer -->
          <div class="mt-6">
            <div class="mb-4">
              <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white">Pay $253.00</button>
            </div>
            <div class="text-xs text-slate-500 italic text-center">You'll be charged $253, including $48 for VAT in Italy</div>
          </div>
        </div>

        <!-- PayPal form -->
        <div v-if="!card">
          <div>
            <div class="mb-4">
              <button class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white">Pay with PayPal - $253.00</button>
            </div>
            <div class="text-xs text-slate-500 italic text-center">You'll be charged $253, including $48 for VAT in Italy</div>
          </div>
        </div>

      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'Pay',
  data: function () {
    return {
      card: true,
    }
  } 
}
</script>