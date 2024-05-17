<template>
  <div class="flex flex-col col-span-full xl:col-span-4 bg-gradient-to-b from-slate-700  to-slate-800 dark:bg-none dark:bg-slate-800 shadow-lg rounded-sm border border-slate-700">
    <header class="px-5 py-4 border-b border-slate-600 dark:border-slate-700 flex items-center">
      <h2 class="font-semibold text-slate-200">Active Cards</h2>
    </header>
    <div class="h-full flex flex-col px-5 py-6">
      <!-- CC container -->
      <div class="relative w-full max-w-sm mx-auto bg-slate-800 dark:bg-slate-900 p-3 rounded-2xl">
        <!-- Credit Card -->
        <div class="relative aspect-[7/4] bg-gradient-to-tr from-indigo-500 to-indigo-400 p-5 rounded-xl overflow-hidden">
          <!-- Gradients -->
          <div class="absolute left-0 -bottom-1/3 w-[398px] aspect-square" aria-hidden="true">
            <svg class="w-full h-full" width="398" height="392" viewBox="0 0 398 392" xmlns="http://www.w3.org/2000/svg">
              <defs>
                <filter x="-88.2%" y="-88.2%" width="276.5%" height="276.5%" filterUnits="objectBoundingBox" id="glow-a">
                  <feGaussianBlur stdDeviation="50" in="SourceGraphic" />
                </filter>
              </defs>
              <circle class="fill-indigo-100 opacity-60" filter="url(#glow-a)" cx="85" cy="85" r="85" transform="translate(0 216)" />
            </svg>
          </div>
          <div class="absolute right-0 -top-1/3 w-[398px] aspect-square" aria-hidden="true">
            <svg class="w-full h-full" width="398" height="392" viewBox="0 0 398 392" xmlns="http://www.w3.org/2000/svg">
              <defs>
                <filter x="-88.2%" y="-88.2%" width="276.5%" height="276.5%" filterUnits="objectBoundingBox" id="glow-b">
                  <feGaussianBlur stdDeviation="50" in="SourceGraphic" />
                </filter>
              </defs>
              <circle class="fill-sky-400 opacity-60" filter="url(#glow-b)" cx="85" cy="85" r="85" transform="translate(228 0)" />
            </svg>
          </div>
          <div class="relative h-full flex flex-col justify-between">
            <!-- Logo on card -->
            <svg width="32" height="32" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
              <defs>
                <linearGradient x1="50%" y1="0%" x2="50%" y2="100%" id="icon1-b">
                  <stop stop-color="#A5B4FC" offset="0%" />
                  <stop stop-color="#E0E7FF" offset="100%" />
                </linearGradient>
                <linearGradient x1="50%" y1="24.537%" x2="50%" y2="100%" id="icon1-c">
                  <stop stop-color="#4338CA" offset="0%" />
                  <stop stop-color="#6366F1" stop-opacity="0" offset="100%" />
                </linearGradient>
                <path id="icon1-a" d="M16 0l16 32-16-5-16 5z" />
              </defs>
              <g transform="rotate(90 16 16)" fill="none" fill-rule="evenodd">
                <mask id="icon1-d" fill="#fff">
                  <use xlink:href="#icon1-a" />
                </mask>
                <use fill="url(#icon1-b)" xlink:href="#icon1-a" />
                <path fill="url(#icon1-c)" mask="url(#icon1-d)" d="M16-6h20v38H16z" />
              </g>
            </svg>
            <!-- Card number -->
            <div class="flex justify-between text-lg font-bold text-slate-200 tracking-widest drop-shadow-sm">
              <span>****</span>
              <span>****</span>
              <span>****</span>
              <span>7328</span>
            </div>
            <!-- Card footer -->
            <div class="relative flex justify-between items-center z-10 mb-0.5">
              <!-- Card expiration -->
              <div class="text-sm font-bold text-slate-200 tracking-widest drop-shadow-sm space-x-3">
                <span>EXP 12/24</span>
                <span>CVC ***</span>
              </div>
            </div>
            <!-- Mastercard logo -->
            <svg class="absolute bottom-0 right-0" width="48" height="28" viewBox="0 0 48 28">
              <circle fill="#F59E0B" cx="34" cy="14" r="14" fill-opacity=".8" />
              <circle fill="#F43F5E" cx="14" cy="14" r="14" fill-opacity=".8" />
            </svg>
          </div>
        </div>
        <!-- Options button -->
        <EditMenu align="right" class="absolute top-0 right-0 inline-flex">
          <li>
            <router-link class="font-medium text-sm text-slate-600 dark:text-slate-300 hover:text-slate-800 dark:hover:text-slate-200 flex py-1 px-3" to="#0">Option 1</router-link>
          </li>
          <li>
            <router-link class="font-medium text-sm text-slate-600 dark:text-slate-300 hover:text-slate-800 dark:hover:text-slate-200 flex py-1 px-3" to="#0">Option 2</router-link>
          </li>
          <li>
            <router-link class="font-medium text-sm text-rose-500 hover:text-rose-600 flex py-1 px-3" to="#0">Remove</router-link>
          </li>
        </EditMenu>
      </div>
      <!-- Details -->
      <div class="grow flex flex-col justify-center mt-3">
        <div class="text-xs text-slate-500 font-semibold uppercase mb-3">Details</div>
        <div class="space-y-2">
          <div>
            <div class="flex justify-between text-sm mb-2">
              <div class="text-slate-300">Payment Limits</div>
              <div class="text-slate-400 italic">$780,00 <span class="text-slate-500 dark:text-slate-400">/</span> $1,500.00</div>
            </div>
            <div class="relative w-full h-2 bg-slate-600">
              <div class="absolute inset-0 bg-emerald-500" aria-hidden="true" style="width: 50%;"></div>
            </div>
          </div>
          <div>
            <div class="flex justify-between text-sm mb-2">
              <div class="text-slate-300">ATM Limits</div>
              <div class="text-slate-400 italic">$179,00 <span class="text-slate-500 dark:text-slate-400">/</span> $1,000.00</div>
            </div>
            <div class="relative w-full h-2 bg-slate-600">
              <div class="absolute inset-0 bg-emerald-500" aria-hidden="true" style="width: 35%;"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EditMenu from '../../components/DropdownEditMenuCard.vue'

export default {
  name: 'FintechCard02',
  components: {
    EditMenu,
  },
}
</script>