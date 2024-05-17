<template>
  <div>
    <nav class="flex justify-between" role="navigation" aria-label="Navigation">
      <div class="flex-1 mr-2">
        <span class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 text-slate-300 dark:text-slate-600">&lt;-<span class="hidden sm:inline">&nbsp;Previous</span></span>
      </div>
      <div class="grow text-center">
        <ul class="inline-flex text-sm font-medium -space-x-px">
          <li>
            <span class="inline-flex items-center justify-center rounded-full leading-5 px-2 py-2 bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 text-indigo-500 shadow-sm"><span class="w-5">1</span></span>
          </li>
          <li>
            <a class="inline-flex items-center justify-center leading-5 px-2 py-2 text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500 border border-transparent" href="#0"><span class="w-5">2</span></a>
          </li>
          <li>
            <a class="inline-flex items-center justify-center leading-5 px-2 py-2 text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500 border border-transparent" href="#0"><span class="w-5">3</span></a>
          </li>
          <li>
            <span class="inline-flex items-center justify-center leading-5 px-2 py-2 text-slate-400 dark:text-slate-500">…</span>
          </li>
          <li>
            <a class="inline-flex items-center justify-center rounded-r leading-5 px-2 py-2 text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500 border border-transparent" href="#0"><span class="w-5">9</span></a>
          </li>
        </ul>
      </div>
      <div class="flex-1 text-right ml-2">
        <a class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500" href="#0"><span class="hidden sm:inline">Next&nbsp;</span>-&gt;</a>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'PaginationNumeric2',
}
</script>