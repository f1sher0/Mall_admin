<template>
  <div class="flex flex-col col-span-full xl:col-span-8 bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700">
    <header class="px-5 py-4 border-b border-slate-100 dark:border-slate-700 flex items-center">
      <h2 class="font-semibold text-slate-800 dark:text-slate-100">Analytics</h2>
    </header>
    <div class="px-5 py-1">
      <div class="flex flex-wrap">
        <!-- Unique Visitors -->
        <div class="flex items-center py-2">
          <div class="mr-5">
            <div class="flex items-center">
              <div class="text-3xl font-bold text-slate-800 dark:text-slate-100 mr-2">24.7K</div>
              <div class="text-sm font-medium text-emerald-500">+49%</div>
            </div>
            <div class="text-sm text-slate-500 dark:text-slate-400">Unique Visitors</div>
          </div>
          <div class="hidden md:block w-px h-8 bg-slate-200 dark:bg-slate-700 mr-5" aria-hidden="true"></div>
        </div>
        <!-- Total Pageviews -->
        <div class="flex items-center py-2">
          <div class="mr-5">
            <div class="flex items-center">
              <div class="text-3xl font-bold text-slate-800 dark:text-slate-100 mr-2">56.9K</div>
              <div class="text-sm font-medium text-emerald-500">+7%</div>
            </div>
            <div class="text-sm text-slate-500 dark:text-slate-400">Total Pageviews</div>
          </div>
          <div class="hidden md:block w-px h-8 bg-slate-200 dark:bg-slate-700 mr-5" aria-hidden="true"></div>
        </div>
        <!-- Bounce Rate -->
        <div class="flex items-center py-2">
          <div class="mr-5">
            <div class="flex items-center">
              <div class="text-3xl font-bold text-slate-800 dark:text-slate-100 mr-2">54%</div>
              <div class="text-sm font-medium text-amber-500">-7%</div>
            </div>
            <div class="text-sm text-slate-500 dark:text-slate-400">Bounce Rate</div>
          </div>
          <div class="hidden md:block w-px h-8 bg-slate-200 dark:bg-slate-700 mr-5" aria-hidden="true"></div>
        </div>
        <!-- Visit Duration-->
        <div class="flex items-center">
          <div>
            <div class="flex items-center">
              <div class="text-3xl font-bold text-slate-800 dark:text-slate-100 mr-2">2m 56s</div>
              <div class="text-sm font-medium text-amber-500">+7%</div>
            </div>
            <div class="text-sm text-slate-500 dark:text-slate-400">Visit Duration</div>
          </div>
        </div>
      </div>
    </div>
    <!-- Chart built with Chart.js 3 -->
    <div class="grow">
      <!-- Change the height attribute to adjust the chart height -->
      <LineChart :data="chartData" width="800" height="300" />
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import LineChart from '../../charts/LineChart03.vue'

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
          label: 'Current',
          data: [
            5000, 8700, 7500, 12000, 11000, 9500, 10500,
            10000, 15000, 9000, 10000, 7000, 22000, 7200,
            9800, 9000, 10000, 8000, 15000, 12000, 11000,
            13000, 11000, 15000, 17000, 18000,
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
        // Gray line
        {
          label: 'Previous',
          data: [
            8000, 5000, 6500, 5000, 6500, 12000, 8000,
            9000, 8000, 8000, 12500, 10000, 10000, 12000,
            11000, 16000, 12000, 10000, 10000, 14000, 9000,
            10000, 15000, 12500, 14000, 11000,
          ],
          borderColor: `rgba(${hexToRGB(tailwindConfig().theme.colors.slate[500])}, 0.25)`,
          fill: false,
          borderWidth: 2,
          tension: 0,
          pointRadius: 0,
          pointHoverRadius: 3,
          pointBackgroundColor: `rgba(${hexToRGB(tailwindConfig().theme.colors.slate[500])}, 0.25)`,
          pointHoverBackgroundColor: `rgba(${hexToRGB(tailwindConfig().theme.colors.slate[500])}, 0.25)`,
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