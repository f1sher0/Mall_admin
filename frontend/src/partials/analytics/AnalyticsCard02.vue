<template>
  <div class="flex flex-col col-span-full xl:col-span-4 bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700">
    <header class="px-5 py-4 border-b border-slate-100 dark:border-slate-700">
      <h2 class="font-semibold text-slate-800 dark:text-slate-100">Active Users Right Now</h2>
    </header>
    <!-- Card content -->
    <div class="flex flex-col h-full">
      <!-- Live visitors number -->
      <div class="px-5 py-3">
        <div class="flex items-center">
          <!-- Red dot -->
          <div class="relative flex items-center justify-center w-3 h-3 mr-3" aria-hidden="true">
            <div class="animate-ping absolute inline-flex h-full w-full rounded-full bg-rose-400 opacity-50"></div>
            <div class="relative inline-flex rounded-full w-1.5 h-1.5 bg-rose-500"></div>
          </div> 
          <!-- Vistors number -->
          <div>
            <div class="text-3xl font-bold text-slate-800 dark:text-slate-100 mr-2">347</div>
            <div class="text-sm text-slate-500 dark:text-slate-400">Live visitors</div>
          </div>
        </div>
      </div>

      <!-- Chart built with Chart.js 3 -->
      <div >
        <!-- Change the height attribute to adjust the chart height -->
        <LineChart :data="chartData" width="389" height="70" />
      </div>

      <!-- Table -->
      <div class="grow px-5 pt-3 pb-1">
        <div class="overflow-x-auto">
          <table class="table-auto w-full dark:text-slate-300">
            <!-- Table header -->
            <thead class="text-xs uppercase text-slate-400 dark:text-slate-500">
              <tr>
                <th class="py-2">
                  <div class="font-semibold text-left">Top pages</div>
                </th>
                <th class="py-2">
                  <div class="font-semibold text-right">Active users</div>
                </th>
              </tr>
            </thead>
            <!-- Table body -->
            <tbody class="text-sm divide-y divide-slate-100 dark:divide-slate-700">
              <!-- Row -->
              <tr>
                <td class="py-2">
                  <div class="text-left">preview.cruip.com/open-pro/</div>
                </td>
                <td class="py-2">
                  <div class="font-medium text-right text-slate-800">94</div>
                </td>
              </tr>
              <!-- Row -->
              <tr>
                <td class="py-2">
                  <div class="text-left">preview.cruip.com/simple/</div>
                </td>
                <td class="py-2">
                  <div class="font-medium text-right text-slate-800">42</div>
                </td>
              </tr>
              <!-- Row -->
              <tr>
                <td class="py-2">
                  <div class="text-left">cruip.com/unlimited/</div>
                </td>
                <td class="py-2">
                  <div class="font-medium text-right text-slate-800">12</div>
                </td>
              </tr>
              <!-- Row -->
              <tr>
                <td class="py-2">
                  <div class="text-left">preview.cruip.com/twist/</div>
                </td>
                <td class="py-2">
                  <div class="font-medium text-right text-slate-800">4</div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <!-- Card footer -->
      <div class="text-right px-5 pb-4">
        <router-link class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" to="#0">Real-Time Report -&gt;</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import LineChart from '../../charts/LineChart04.vue'

// Import utilities
import { tailwindConfig, hexToRGB } from '../../utils/Utils'

export default {
  name: 'AnalyticsCard01',
  components: {
    LineChart,
  },
  setup() {
    const chartData = ref({
      labels: [
        '12-01-2020', '01-01-2021', '02-01-2021',
        '03-01-2021', '04-01-2021', '05-01-2021',
        '06-01-2021', '07-01-2021', '08-01-2021',
        '09-01-2021', '10-01-2021', '11-01-2021',
        '12-01-2021', '01-01-2022', '02-01-2022',
        '03-01-2022', '04-01-2022', '05-01-2022',
        '06-01-2022', '07-01-2022', '08-01-2022',
        '09-01-2022', '10-01-2022', '11-01-2022',
        '12-01-2022', '01-01-2023',
      ],
      datasets: [
        // Indigo line
        {
          data: [
            732, 610, 610, 504, 504, 504, 349,
            349, 504, 342, 504, 610, 391, 192,
            154, 273, 191, 191, 126, 263, 349,
            252, 423, 622, 470, 532,
          ],
          fill: true,
          backgroundColor: `rgba(${hexToRGB(tailwindConfig().theme.colors.blue[500])}, 0.08)`,
          borderColor: tailwindConfig().theme.colors.indigo[500],
          borderWidth: 2,
          tension: 0,
          pointRadius: 0,
          pointHoverRadius: 3,
          pointBackgroundColor: tailwindConfig().theme.colors.indigo[500],
          pointHoverBackgroundColor: tailwindConfig().theme.colors.indigo[500],
          pointBorderWidth: 0,
          pointHoverBorderWidth: 0,          
          clip: 20,
        },
      ],
    })

    return {
      chartData,
    } 
  }
}
</script>