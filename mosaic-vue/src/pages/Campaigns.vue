<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="sm:flex sm:justify-between sm:items-center mb-8">

            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Campaigns ✨</h1>
            </div>

            <!-- Right: Actions  -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">
              <!-- Search form -->
              <SearchForm />
              <!-- Filter button -->
              <FilterButton align="right" />
              <!-- Create campaign button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="hidden xs:block ml-2">Create Campaign</span>
              </button>
            </div>            

          </div>

          <!-- Cards -->
          <div class="grid grid-cols-12 gap-6">
            <CampaignsCard
              v-for="item in items"
              :key="item.id"
              :item="item"
            />
          </div>

          <!-- Pagination -->
          <div class="mt-8">
            <PaginationNumeric />
          </div>          

        </div>
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar from '../partials/Sidebar.vue'
import Header from '../partials/Header.vue'
import SearchForm from '../components/SearchForm.vue'
import FilterButton from '../components/DropdownFilter.vue'
import CampaignsCard from '../partials/campaigns/CampaignsCard.vue'
import PaginationNumeric from '../components/PaginationNumeric.vue'

import Image01 from '../images/user-28-01.jpg'
import Image02 from '../images/user-28-02.jpg'
import Image03 from '../images/user-28-03.jpg'
import Image04 from '../images/user-28-04.jpg'
import Image05 from '../images/user-28-05.jpg'
import Image06 from '../images/user-28-06.jpg'
import Image07 from '../images/user-28-07.jpg'
import Image08 from '../images/user-28-08.jpg'
import Image09 from '../images/user-28-09.jpg'
import Image10 from '../images/user-28-10.jpg'
import Image11 from '../images/user-28-11.jpg'
import Image12 from '../images/user-28-12.jpg'

export default {
  name: 'Campaigns',
  components: {
    Sidebar,
    Header,
    SearchForm,
    FilterButton,
    CampaignsCard,
    PaginationNumeric,
  },
  setup() {

    const sidebarOpen = ref(false)

    const items = ref([
      {
        id: 0,
        category: '1',
        members: [
          {
            name: 'User 01',
            image: Image01,
            link: '#0'
          },
          {
            name: 'User 02',
            image: Image02,
            link: '#0'
          },
          {
            name: 'User 03',
            image: Image03,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'One-Time'
      },
      {
        id: 1,
        category: '2',
        members: [
          {
            name: 'User 04',
            image: Image04,
            link: '#0'
          },
          {
            name: 'User 05',
            image: Image05,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'Off-Track'
      },
      {
        id: 3,
        category: '3',
        members: [
          {
            name: 'User 07',
            image: Image07,
            link: '#0'
          },
          {
            name: 'User 08',
            image: Image08,
            link: '#0'
          },
          {
            name: 'User 09',
            image: Image09,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'At Risk'
      },
      {
        id: 4,
        category: '1',
        members: [
          {
            name: 'User 10',
            image: Image10,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'At Risk'
      },
      {
        id: 5,
        category: '4',
        members: [
          {
            name: 'User 11',
            image: Image11,
            link: '#0'
          },
          {
            name: 'User 05',
            image: Image05,
            link: '#0'
          },
          {
            name: 'User 12',
            image: Image12,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'One-Time'
      },
      {
        id: 6,
        category: '2',
        members: [
          {
            name: 'User 07',
            image: Image07,
            link: '#0'
          },
          {
            name: 'User 04',
            image: Image04,
            link: '#0'
          },
          {
            name: 'User 11',
            image: Image11,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'At Risk'
      },
      {
        id: 7,
        category: '4',
        members: [
          {
            name: 'User 01',
            image: Image01,
            link: '#0'
          },
          {
            name: 'User 02',
            image: Image02,
            link: '#0'
          },
          {
            name: 'User 06',
            image: Image06,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'One-Time'
      },
      {
        id: 8,
        category: '1',
        members: [
          {
            name: 'User 09',
            image: Image09,
            link: '#0'
          },
          {
            name: 'User 01',
            image: Image01,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'Off-Track'
      },
      {
        id: 9,
        category: '3',
        members: [
          {
            name: 'User 07',
            image: Image07,
            link: '#0'
          },
          {
            name: 'User 08',
            image: Image08,
            link: '#0'
          },
          {
            name: 'User 09',
            image: Image09,
            link: '#0'
          },
          {
            name: 'User 06',
            image: Image06,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'One-Time'
      },
      {
        id: 10,
        category: '4',
        members: [
          {
            name: 'User 06',
            image: Image06,
            link: '#0'
          },
          {
            name: 'User 11',
            image: Image11,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'Off-Track'
      },
      {
        id: 11,
        category: '2',
        members: [
          {
            name: 'User 05',
            image: Image05,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'Off-Track'
      },
      {
        id: 12,
        category: '3',
        members: [
          {
            name: 'User 07',
            image: Image07,
            link: '#0'
          },
          {
            name: 'User 08',
            image: Image08,
            link: '#0'
          },
          {
            name: 'User 09',
            image: Image09,
            link: '#0'
          },
        ],
        title: 'Monitor progress in Real Time Value',
        link: '#0',
        content: 'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts.',
        dates: {
          from: 'Jan 20',
          to: 'Jan 27'
        },
        type: 'At Risk'
      },      
    ])

    return {
      sidebarOpen,
      items,
    }  
  }
}
</script>