<template>
  <tr class="cursor-pointer">
    <td class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap w-px">
      <div class="flex items-center">
        <label class="inline-flex">
          <span class="sr-only">Select</span>
          <input :id="transaction.id" class="form-checkbox" type="checkbox" :value="value" @change="check" :checked="checked" @click.stop />
        </label>
      </div>
    </td>
    <td class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap md:w-1/2">
      <div class="flex items-center">
        <div class="w-9 h-9 shrink-0 mr-2 sm:mr-3">
          <img class="rounded-full" :src="transaction.image" width="36" height="36" :alt="transaction.name" />
        </div>
        <div class="font-medium text-slate-800 dark:text-slate-100">{{transaction.name}}</div>
      </div>
    </td>
    <td class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
      <div class="text-left">{{transaction.date}}</div>
    </td>
    <td class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
      <div class="text-left">
        <div class="text-xs inline-flex font-medium rounded-full text-center px-2.5 py-1" :class="statusColor(transaction.status)">{{transaction.status}}</div>
      </div>
    </td>
    <td class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap w-px">
      <div class="text-right font-medium" :class="amountColor(transaction.amount)">{{transaction.amount}}</div>
    </td>    
  </tr>  
</template>

<script>
import { computed } from 'vue'

export default {
  name: 'TransactionsTableItem02',
  props: ['transaction', 'value', 'selected'],
  setup(props, context) {
    const checked = computed(() => props.selected.includes(props.value))

    function check() {
      let updatedSelected = [...props.selected]
      if (this.checked) {
        updatedSelected.splice(updatedSelected.indexOf(props.value), 1)
      } else {
        updatedSelected.push(props.value)
      }
      context.emit('update:selected', updatedSelected)
    }

    const statusColor = (status) => {
      switch (status) {
        case 'Completed':
          return 'bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400'
        case 'Canceled':
          return 'bg-rose-100 dark:bg-rose-500/30 text-rose-500 dark:text-rose-400'
        default:
          return 'bg-slate-100 dark:bg-slate-800 text-slate-500 dark:text-slate-400'
      }
    }
    
    const amountColor = (amount) => {
      switch (amount.charAt(0)) {
        case '+':
          return 'text-emerald-500'
        default:
          return 'text-slate-800 dark:text-slate-300'
      }
    }    

    return {
      check,
      checked,
      statusColor,
      amountColor,
    }
  },
}
</script>