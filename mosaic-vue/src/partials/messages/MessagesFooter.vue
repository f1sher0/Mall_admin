<template>
  <div class="sticky bottom-0">
    <div class="flex items-center justify-between bg-white dark:bg-slate-900 border-t border-slate-200 dark:border-slate-700 px-4 sm:px-6 md:px-5 h-16">
      <!-- Plus button -->
      <button class="shrink-0 text-slate-400 dark:text-slate-500 hover:text-slate-500 dark:hover:text-slate-400 mr-3">
        <span class="sr-only">Add</span>
        <svg class="w-6 h-6 fill-current" viewBox="0 0 24 24">
          <path d="M12 0C5.373 0 0 5.373 0 12s5.373 12 12 12 12-5.373 12-12C23.98 5.38 18.62.02 12 0zm6 13h-5v5h-2v-5H6v-2h5V6h2v5h5v2z" />
        </svg>
      </button>
      <!-- Message input -->
      <form class="grow flex">
        <div class="grow mr-3">
          <label for="message-input" class="sr-only">Type a message</label>
          <input id="message-input" class="form-input w-full bg-slate-100 dark:bg-slate-800 border-transparent dark:border-transparent focus:bg-white dark:focus:bg-slate-800 placeholder-slate-500" type="text" placeholder="Aa" />
        </div>
        <button type="submit" class="btn bg-indigo-500 hover:bg-indigo-600 text-white whitespace-nowrap">Send -&gt;</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MessagesFooter',
}
</script>