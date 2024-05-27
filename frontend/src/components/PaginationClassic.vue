<template>
  <div class="flex flex-col sm:flex-row sm:items-center sm:justify-between">
    <nav class="mb-4 sm:mb-0 sm:order-1" role="navigation" aria-label="Navigation">
      <ul class="flex justify-center">
        <li class="ml-3 first:ml-0">
          <span class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 text-slate-300 dark:text-slate-600">&lt;- Previous</span>
        </li>
        <li class="ml-3 first:ml-0">
          <a class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500" href="#0">Next -&gt;</a>
        </li>
      </ul>
    </nav>
    <div class="text-sm text-slate-500 dark:text-slate-400 text-center sm:text-left">
      Showing <span class="font-medium text-slate-600 dark:text-slate-300">1</span> to <span class="font-medium text-slate-600 dark:text-slate-300">10</span> of <span class="font-medium text-slate-600 dark:text-slate-300">467</span> results
    </div>
  </div>
</template>

<script>
export default {
  name: 'PaginationClassic',
}
</script>