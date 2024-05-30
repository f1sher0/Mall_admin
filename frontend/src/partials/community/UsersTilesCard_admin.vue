<template>
  <div class="col-span-full sm:col-span-6 xl:col-span-4 bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700">
    <div class="flex flex-col h-full">
      <!-- Card top -->
      <div class="grow p-5">
        <div class="flex justify-between items-start">
          <!-- Image + name -->
          <header>
            <div class="flex mb-2">
              <router-link class="relative inline-flex items-start mr-5" to="#">
                <div class="absolute top-0 right-0 -mr-2 bg-white dark:bg-slate-700 rounded-full shadow" aria-hidden="true">
                </div>
                <img class="rounded-full" :src="item.avatar" width="64" height="64" :alt="item.purchaserName" />
              </router-link>
              <div class="mt-1 pr-1">
                <router-link class="inline-flex text-slate-800 dark:text-slate-100 hover:text-slate-900 dark:hover:text-white" to="#">
                  <h2 class="text-xl leading-snug justify-center font-semibold">{{item.purchaserName}}</h2>
                </router-link>
                <div class="flex items-center"><span class="text-sm font-medium text-slate-400 -mt-0.5 mr-1">-&gt;</span> <span>{{item.address}}</span></div>
              </div>
            </div>
          </header>
          <!-- Menu button -->
          <EditMenu align="right" class="relative inline-flex shrink-0">
            <li>
              <router-link class="font-medium text-sm text-slate-600 dark:text-slate-300 hover:text-slate-800 dark:hover:text-slate-200 flex py-1 px-3" to="#0">Detail</router-link>
            </li>
            <li>
              <router-link class="font-medium text-sm text-rose-500 hover:text-rose-600 flex py-1 px-3" to="#0">Remove</router-link>
            </li>
          </EditMenu>
        </div>
        <!-- Bio -->
        <div class="mt-2">
          <div class="text-sm">{{item.purchaserDesc}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EditMenu from '../../components/DropdownEditMenu.vue'

export default {
  name: 'UsersTilesCard',
  props: ['item'],
  components: {
    EditMenu,
  }, 
  mounted() {
    console.log('Received item:', this.item);
  }
}
</script>