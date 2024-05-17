<template>
  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 relative">
    <header class="px-5 py-4">
      <h2 class="font-semibold text-slate-800 dark:text-slate-100">Invoices <span class="text-slate-400 dark:text-slate-500 font-medium">67</span></h2>
    </header>
    <div>

      <!-- Table -->
      <div class="overflow-x-auto">
        <table class="table-auto w-full dark:text-slate-300">
          <!-- Table header -->
          <thead class="text-xs font-semibold uppercase text-slate-500 dark:text-slate-400 bg-slate-50 dark:bg-slate-900/20 border-t border-b border-slate-200 dark:border-slate-700">
            <tr>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap w-px">
                <div class="flex items-center">
                  <label class="inline-flex">
                    <span class="sr-only">Select all</span>
                    <input class="form-checkbox" type="checkbox" v-model="selectAll" @click="checkAll" />
                  </label>
                </div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Invoice</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Total</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Status</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Customer</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Issued on</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Paid on</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Type</div>
              </th>
              <th class="px-2 first:pl-5 last:pr-5 py-3 whitespace-nowrap">
                <div class="font-semibold text-left">Actions</div>
              </th>
            </tr>
          </thead>
          <!-- Table body -->
          <tbody class="text-sm divide-y divide-slate-200 dark:divide-slate-700">
            <Invoice
              v-for="invoice in invoices"
              :key="invoice.id"
              :invoice="invoice"
              v-model:selected="selected"
              :value="invoice.id"
            />
          </tbody>
        </table>

      </div>
    </div>
  </div>
</template>

<script>
import { ref, watch } from 'vue'
import Invoice from './InvoicesTableItem.vue'

export default {
  name: 'InvoicesTable',
  components: {
    Invoice,
  },  
  props: ['selectedItems'],
  setup(props, { emit }) {

    const selectAll = ref(false)
    const selected = ref([])

    const checkAll = () => {
      selected.value = []
      if (!selectAll.value) {
        selected.value = invoices.value.map(invoice => invoice.id)
      }
    }
    
    watch(selected, () => {
      selectAll.value = invoices.value.length === selected.value.length ? true : false
      emit('change-selection', selected.value)
    })    
    
    const invoices = ref([
      {
        id: '0',
        invoice: '#123567',
        total: '$129.00',
        status: 'Overdue',
        customer: 'Dominik Lamakani',
        issueddate: '22/07/2021',
        paiddate: '-',        
        type: 'Subscription',
      },
      {
        id: '1',
        invoice: '#779912',
        total: '$59.00',
        status: 'Paid',
        customer: 'Mark Cameron',
        issueddate: '19/07/2021',
        paiddate: '20/07/2021',        
        type: 'Subscription',
      },
      {
        id: '2',
        invoice: '#889924',
        total: '$89.00',
        status: 'Paid',
        customer: 'Sergio Gonnelli',
        issueddate: '17/07/2021',
        paiddate: '19/07/2021',        
        type: 'One-time',
      },
      {
        id: '3',
        invoice: '#897726',
        total: '$129.00',
        status: 'Due',
        customer: 'Manuel Garbaya',
        issueddate: '04/07/2021',
        paiddate: '-',        
        type: 'Subscription',
      },
      {
        id: '4',
        invoice: '#123567',
        total: '$129.00',
        status: 'Due',
        customer: 'Cool Robot',
        issueddate: '04/07/2021',
        paiddate: '-',        
        type: 'Subscription',
      },
      {
        id: '5',
        invoice: '#896644',
        total: '$129.00',
        status: 'Paid',
        customer: 'Mark Cameron',
        issueddate: '04/07/2021',
        paiddate: '09/07/2021',        
        type: 'One-time',
      },
      {
        id: '6',
        invoice: '#136988',
        total: '$69.00',
        status: 'Paid',
        customer: 'Glenn Thomas',
        issueddate: '01/07/2021',
        paiddate: '01/07/2021',        
        type: 'One-time',
      },
      {
        id: '7',
        invoice: '#442206',
        total: '$129.00',
        status: 'Overdue',
        customer: 'Dominik Lamakani',
        issueddate: '22/06/2021',
        paiddate: '-',        
        type: 'Subscription',
      },
      {
        id: '8',
        invoice: '#764321',
        total: '$89.00',
        status: 'Paid',
        customer: 'Brian Halligan',
        issueddate: '21/06/2021',
        paiddate: '29/06/2021',        
        type: 'One-time',
      },
      {
        id: '9',
        invoice: '#908764',
        total: '$129.00',
        status: 'Due',
        customer: 'Carolyn McNeail',
        issueddate: '17/06/2021',
        paiddate: '-',        
        type: 'Subscription',
      }
    ])

    return {
      selectAll,
      selected,
      checkAll,
      invoices,
    }
  }
}
</script>