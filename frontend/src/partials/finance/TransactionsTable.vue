<template>
  <div class="bg-white dark:bg-slate-900">
    <div>

      <!-- Table -->
      <div class="overflow-x-auto">
        <table class="table-auto w-full dark:text-slate-300">
          <!-- Table header -->
          <thead class="text-xs font-semibold uppercase text-slate-500 border-t border-b border-slate-200 dark:border-slate-700">
            <tr>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap w-px">
                <div class="flex items-center">
                  <label class="inline-flex">
                    <span class="sr-only">Select all</span>
                    <input id="parent-checkbox" class="form-checkbox" type="checkbox" @click="checkAll" />
                  </label>
                </div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Warehouse Name</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Submission Date</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Status</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-right">Location</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-right">Manipulate</div>
              </th>
            </tr>
          </thead>
          <!-- Table body -->
          <tbody class="text-sm divide-y divide-slate-200 dark:divide-slate-700 border-b border-slate-200 dark:border-slate-700">
            <TransactionItem
              v-for="transaction in transactions"
              :key="transaction.id"
              :transaction="transaction"
              v-model:selected="selected"
              :value="transaction.id"
            />
          </tbody>
        </table>

      </div>
    </div>
  </div>
</template>

<script>
import { ref, watch } from 'vue'
import TransactionItem from './TransactionsTableItem.vue'

import Image01 from '../../images/transactions-image-01.svg'
import Image02 from '../../images/transactions-image-02.svg'
import Image03 from '../../images/user-36-05.jpg'


export default {
  name: 'TransactionsTable',
  components: {
    TransactionItem,
  },  
  props: ['selectedItems'],
  setup(props, { emit }) {

    const selectAll = ref(false)
    const selected = ref([])

    const checkAll = () => {
      selected.value = []
      if (!selectAll.value) {
        selected.value = transactions.value.map(transaction => transaction.id)
      }
    }
    
    watch(selected, () => {
      selectAll.value = transactions.value.length === selected.value.length ? true : false
      emit('change-selection', selected.value)
    })    
    
    const transactions = ref([
      {
        id: '0',
        image: Image01,
        name: 'Form Builder CP',
        date: '22/01/2022',
        status: 'Pending',
        amount: 'Beijing China',
      },
      {
        id: '1',
        image: Image02,
        name: 'Imperial Hotel ****',
        date: '22/01/2022',
        status: 'Completed',
        amount: 'Shanghai China',
      },   
      {
        id: '2',
        image: Image03,
        name: 'Aprilynne Pills',
        date: '22/01/2022',
        status: 'Pending',
        amount: '+$499.99',
      },                                                
    ])

    return {
      selectAll,
      selected,
      checkAll,
      transactions,
    }
  }
}
</script>