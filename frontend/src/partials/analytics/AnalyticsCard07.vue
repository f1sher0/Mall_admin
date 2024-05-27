<template>
  <div class="flex flex-col col-span-full sm:col-span-6 xl:col-span-4 bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700">
    <header class="px-5 py-4 border-b border-slate-100 dark:border-slate-700">
      <h2 class="font-semibold text-slate-800 dark:text-slate-100">Top Countries</h2>
    </header>
    <div class="grow p-3">
      <div class="flex flex-col h-full">
        <!-- Card content -->
        <div class="grow">
          <ul class="flex justify-between text-xs uppercase text-slate-400 dark:text-slate-500 font-semibold px-2 space-x-2">
            <li>Source</li>
            <li>Sessions</li>
          </ul>

          <ul class="space-y-1 text-sm text-slate-800 dark:text-slate-100 mt-3 mb-4">
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 82%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇨🇮 Ireland</div>
                <div class="font-medium">4.2K</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 70%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇺🇸 United States</div>
                <div class="font-medium">3.4K</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 60%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇩🇪 Germany</div>
                <div class="font-medium">1.6k</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 44%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇮🇹 Italy</div>
                <div class="font-medium">1.2k</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 40%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇬🇧 United Kingdom</div>
                <div class="font-medium">912</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 30%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇫🇷 France</div>
                <div class="font-medium">677</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 22%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇮🇳 India</div>
                <div class="font-medium">449</div>
              </div>
            </li>
            <!-- Item -->
            <li class="relative px-2 py-1">
              <div class="absolute inset-0 bg-sky-100 dark:bg-sky-400/30" aria-hidden="true" style="width: 12%;"></div>
              <div class="relative flex justify-between space-x-2">
                <div>🇸🇬 Singapore</div>
                <div class="font-medium">269</div>
              </div>
            </li>
          </ul>
        </div>
        <!-- Card footer -->
        <div class="text-center pt-4 pb-1 border-t border-slate-100 dark:border-slate-700">
          <router-link class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" to="#0">Countries Report -&gt;</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AnalyticsCard07',
}
</script>