<template>
  <div class="flex flex-col col-span-full sm:col-span-6 xl:col-span-4 bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700">
    <header class="px-5 py-4 border-b border-slate-100 dark:border-slate-700">
      <h2 class="font-semibold text-slate-800 dark:text-slate-100">Sessions By Gender</h2>
    </header>
    <!-- Chart built with Chart.js 3 -->
    <!-- Change the height attribute to adjust the chart height -->
    <PolarChart :data="chartData" width="389" height="260" />
  </div>
</template>

<script>
import { ref } from 'vue'
import PolarChart from '../../charts/PolarChart.vue'

// Import utilities
import { tailwindConfig, hexToRGB } from '../../utils/Utils'

export default {
  name: 'AnalyticsCard10',
  components: {
    PolarChart,
  },
  setup() {
    const chartData = ref({
      labels: ['Males', 'Females', 'Unknown'],
      datasets: [
        {
          label: 'Sessions By Gender',
          data: [
            500, 326, 242,
          ],
          backgroundColor: [
            `rgba(${hexToRGB(tailwindConfig().theme.colors.indigo[500])}, 0.8)`,
            `rgba(${hexToRGB(tailwindConfig().theme.colors.sky[400])}, 0.8)`,
            `rgba(${hexToRGB(tailwindConfig().theme.colors.emerald[500])}, 0.8)`,
          ],
          hoverBackgroundColor: [
            `rgba(${hexToRGB(tailwindConfig().theme.colors.indigo[600])}, 0.8)`,
            `rgba(${hexToRGB(tailwindConfig().theme.colors.sky[500])}, 0.8)`,
            `rgba(${hexToRGB(tailwindConfig().theme.colors.emerald[600])}, 0.8)`,
          ],
          borderWidth: 0,
        },
      ],
    })

    return {
      chartData,
    } 
  }
}
</script>