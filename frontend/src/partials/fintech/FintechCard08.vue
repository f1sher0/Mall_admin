<template>
  <div class="flex flex-col col-span-full sm:col-span-6 xl:col-span-4 bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700">
    <header class="px-5 py-4 border-b border-slate-100 dark:border-slate-700 flex items-center">
      <h2 class="font-semibold text-slate-800 dark:text-slate-100">Growth Portfolio</h2>
    </header>
    <div class="px-5 py-3">
      <div class="text-sm italic mb-2">Hey Mark, by age 65 you could have:</div>
      <div class="text-3xl font-bold text-slate-800 dark:text-slate-100">$2M - $3.5M</div>
      <div class="text-sm text-slate-500 dark:text-slate-400">Risk level 8</div>
    </div>
    <!-- Chart built with Chart.js 3 -->
    <div class="grow">
      <!-- Change the height attribute to adjust the chart height -->
      <LineChart :data="chartData" width="389" height="262" />
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import LineChart from '../../charts/LineChart07.vue'

// Import utilities
import { tailwindConfig, hexToRGB } from '../../utils/Utils'

export default {
  name: 'FintechCard08',
  components: {
    LineChart,
  },
  setup() {
    const chartData = ref({
      labels: ['2010', 'Age 65'],
      datasets: [
        // Dark green line
        {
          label: 'Growth 1',
          data: [0, 3500000],
          borderColor: tailwindConfig().theme.colors.emerald[500],
          fill: true,
          backgroundColor: `rgba(${hexToRGB(tailwindConfig().theme.colors.emerald[500])}, 0.08)`,
          borderWidth: 2,
          tension: 0,
          pointRadius: 0,
          pointHoverRadius: 3,
          pointBackgroundColor: tailwindConfig().theme.colors.emerald[500],
          clip: 20,
        },
        // Light green line
        {
          label: 'Growth 2',
          data: [0, 2000000],
          borderColor: tailwindConfig().theme.colors.emerald[200],
          fill: false,
          borderWidth: 2,
          tension: 0,
          pointRadius: 0,
          pointHoverRadius: 3,
          pointBackgroundColor: tailwindConfig().theme.colors.emerald[200],
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