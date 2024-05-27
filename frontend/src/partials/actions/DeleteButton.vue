<template>
  <div :class="selectedItems.length < 1 && 'hidden'">
    <div class="flex items-center">
      <div class="hidden xl:block text-sm italic mr-2 whitespace-nowrap"><span>{{selectedItems.length}}</span> items selected</div>
      <button class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-rose-500">Delete</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DeleteButton',
  props: ['selectedItems'],
}
</script>