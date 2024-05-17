<template>
  <div
    ref="panelContent"
    class="absolute inset-0 sm:left-auto z-20 shadow-xl transition-transform duration-200 ease-in-out"
    :class="transactionPanelOpen ? 'translate-x-0' : 'translate-x-full'"
  >
    <div class="sticky top-16 bg-slate-50 dark:bg-gradient-to-b dark:from-slate-800 dark:to-slate-900 overflow-x-hidden overflow-y-auto no-scrollbar shrink-0 border-l border-slate-200 dark:border-slate-700 w-full sm:w-[390px] h-[calc(100dvh-64px)]">

      <button ref="closeBtn" @click.stop="$emit('close-transactionpanel')" class="absolute top-0 right-0 mt-6 mr-6 group p-2">
        <svg class="w-4 h-4 fill-slate-400 group-hover:fill-slate-600 pointer-events-none" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
          <path d="m7.95 6.536 4.242-4.243a1 1 0 1 1 1.415 1.414L9.364 7.95l4.243 4.242a1 1 0 1 1-1.415 1.415L7.95 9.364l-4.243 4.243a1 1 0 0 1-1.414-1.415L6.536 7.95 2.293 3.707a1 1 0 0 1 1.414-1.414L7.95 6.536Z" />
        </svg>
      </button>

      <div class="py-8 px-4 lg:px-8">
        <div class="max-w-sm mx-auto lg:max-w-none">

          <div class="text-slate-800 dark:text-slate-100 font-semibold text-center mb-1">Bank Transfer</div>
          <div class="text-sm text-center italic">22/01/2022, 8:56 PM</div>

          <!-- Details -->
          <div class="drop-shadow-lg mt-12">
            <!-- Top -->
            <div class="bg-white dark:bg-slate-700 rounded-t-xl px-5 pb-2.5 text-center">
              <div class="mb-3 text-center">
                <img class="inline-flex w-12 h-12 rounded-full -mt-6" src="../../images/transactions-image-04.svg" width="48" height="48" alt="Transaction 04" />
              </div>
              <div class="text-2xl font-semibold text-emerald-500 mb-1">+$2,179.36</div>
              <div class="text-sm font-medium text-slate-800 dark:text-slate-100 mb-3">Acme LTD UK</div>
              <div class="text-xs inline-flex font-medium bg-slate-100 dark:bg-slate-800 text-slate-500 dark:text-slate-400 rounded-full text-center px-2.5 py-1">Pending</div>
            </div>
            <!-- Divider -->
            <div class="flex justify-between items-center" aria-hidden="true">
              <svg class="w-5 h-5 fill-white dark:fill-slate-700" xmlns="http://www.w3.org/2000/svg">
                <path d="M0 20c5.523 0 10-4.477 10-10S5.523 0 0 0h20v20H0Z" />
              </svg>
              <div class="grow w-full h-5 bg-white dark:bg-slate-700 flex flex-col justify-center">
                <div class="h-px w-full border-t border-dashed border-slate-200 dark:border-slate-600"></div>
              </div>
              <svg class="w-5 h-5 fill-white dark:fill-slate-700 rotate-180" xmlns="http://www.w3.org/2000/svg">
                <path d="M0 20c5.523 0 10-4.477 10-10S5.523 0 0 0h20v20H0Z" />
              </svg>
            </div>
            <!-- Bottom -->
            <div class="bg-white dark:bg-slate-800 dark:bg-gradient-to-b dark:from-slate-700 dark:to-slate-700/70 rounded-b-xl p-5 pt-2.5 text-sm space-y-3">
              <div class="flex justify-between space-x-1">
                <span class="italic">IBAN:</span>
                <span class="font-medium text-slate-700 dark:text-slate-100 text-right">IT17 2207 1010 0504 0006 88</span>
              </div>
              <div class="flex justify-between space-x-1">
                <span class="italic">BIC:</span>
                <span class="font-medium text-slate-700 dark:text-slate-100 text-right">BARIT22</span>
              </div>
              <div class="flex justify-between space-x-1">
                <span class="italic">Reference:</span>
                <span class="font-medium text-slate-700 dark:text-slate-100 text-right">Freelance Work</span>
              </div>
              <div class="flex justify-between space-x-1">
                <span class="italic">Emitter:</span>
                <span class="font-medium text-slate-700 dark:text-slate-100 text-right">Acme LTD UK</span>
              </div>
            </div>
          </div>

          <!-- Receipts -->
          <div class="mt-6">
            <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-2">Receipts</div>
            <form class="rounded bg-slate-100 dark:bg-slate-700/30 border border-dashed border-slate-300 dark:border-slate-700 text-center px-5 py-8">
              <svg class="inline-flex w-4 h-4 fill-slate-400 dark:fill-slate-500 mb-3" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                <path d="M8 4c-.3 0-.5.1-.7.3L1.6 10 3 11.4l4-4V16h2V7.4l4 4 1.4-1.4-5.7-5.7C8.5 4.1 8.3 4 8 4ZM1 2h14V0H1v2Z" />
              </svg>
              <label for="upload" class="block text-sm text-slate-500 dark:text-slate-400 italic">We accept PNG, JPEG, and PDF files.</label>
              <input class="sr-only" id="upload" type="file" />
            </form>
          </div>

          <!-- Notes -->
          <div class="mt-6">
            <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-2">Notes</div>
            <form>
              <label class="sr-only" for="notes">Write a note</label>
              <textarea id="notes" class="form-textarea w-full focus:border-slate-300" rows="4" placeholder="Write a note…"></textarea>
            </form>
          </div>

          <!-- Download / Report -->
          <div class="flex items-center space-x-3 mt-6">
            <div class="w-1/2">
              <button class="btn w-full dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300">
                <svg class="w-4 h-4 fill-current text-slate-400 dark:text-slate-500 shrink-0 rotate-180" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                  <path d="M8 4c-.3 0-.5.1-.7.3L1.6 10 3 11.4l4-4V16h2V7.4l4 4 1.4-1.4-5.7-5.7C8.5 4.1 8.3 4 8 4ZM1 2h14V0H1v2Z" />
                </svg>
                <span class="ml-2">Download</span>
              </button>
            </div>
            <div class="w-1/2">
              <button class="btn w-full dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-rose-500">
                <svg class="w-4 h-4 fill-current shrink-0" viewBox="0 0 16 16">
                  <path d="M7.001 3h2v4h-2V3Zm1 7a1 1 0 1 1 0-2 1 1 0 0 1 0 2ZM15 16a1 1 0 0 1-.6-.2L10.667 13H1a1 1 0 0 1-1-1V1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1ZM2 11h9a1 1 0 0 1 .6.2L14 13V2H2v9Z" />
                </svg>
                <span class="ml-2">Report</span>
              </button>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, onUnmounted } from 'vue'

export default {
  name: 'TransactionPanel',
  props: ['transactionPanelOpen'],
  emits: ['close-transactionpanel'],
  setup(props, { emit }) {

    const panelContent = ref(null)
    const closeBtn = ref(null)

    // close on click outside
    const clickHandler = ({ target }) => {
      if (
        !props.transactionPanelOpen ||
        panelContent.value.contains(target) ||
        closeBtn.value.contains(target)
      ) return
      emit('close-transactionpanel')
    }

    // close if the esc key is pressed
    const keyHandler = ({ keyCode }) => {
      if (!props.transactionPanelOpen || keyCode !== 27) return
      emit('close-transactionpanel')
    }

    onMounted(() => {
      document.addEventListener('click', clickHandler)
      document.addEventListener('keydown', keyHandler)
    })

    onUnmounted(() => {
      document.removeEventListener('click', clickHandler)
      document.removeEventListener('keydown', keyHandler)
    })
    
    return {
      panelContent,
      closeBtn,
    }    
  }
}
</script>