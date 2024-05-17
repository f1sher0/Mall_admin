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
          <div class="sm:flex sm:justify-between sm:items-center mb-5">
          
            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Search For Jobs ✨</h1>
            </div>
        
            <!-- Post a job button -->
            <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
              <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
              </svg>
              <span class="hidden xs:block ml-2">Post A Job</span>
            </button>
          
          </div>

          <!-- Page content -->
          <div class="flex flex-col space-y-10 sm:flex-row sm:space-x-6 sm:space-y-0 md:flex-col md:space-x-0 md:space-y-10 xl:flex-row xl:space-x-6 xl:space-y-0 mt-9">

            <!-- Sidebar -->
            <JobSidebar />

              <!-- Content -->
              <div class="w-full">

                <!-- Search form -->
                <div class="mb-5">
                  <form class="relative">
                    <label for="job-search" class="sr-only">Search</label>
                    <input id="job-search" class="form-input w-full pl-9 bg-white dark:bg-slate-800" type="search" placeholder="Search job title or keyword…" />
                    <button class="absolute inset-0 right-auto group" type="submit" aria-label="Search">
                      <svg class="w-4 h-4 shrink-0 fill-current text-slate-400 dark:text-slate-500 group-hover:text-slate-500 dark:group-hover:text-slate-400 ml-3 mr-2" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                        <path d="M7 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zM7 2C4.243 2 2 4.243 2 7s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5z" />
                        <path d="M15.707 14.293L13.314 11.9a8.019 8.019 0 01-1.414 1.414l2.393 2.393a.997.997 0 001.414 0 .999.999 0 000-1.414z" />
                      </svg>
                    </button>
                  </form>
                </div>

                <!-- Jobs header -->
                <div class="flex justify-between items-center mb-4">
                  <div class="text-sm text-slate-500 dark:text-slate-400 italic">Showing 289 Jobs</div>
                  <!-- Sort -->
                  <div class="text-sm">
                    <span>Sort by </span>
                    <DropdownSort align="right" />
                  </div>
                </div>          

                <!-- Job list -->
                <div class="space-y-2">
                    <JobListItem
                      v-for="item in items"
                      :key="item.id"
                      :item="item"
                    />                    
                </div>

                <!-- Pagination -->
                <div class="mt-6">
                  <PaginationNumeric />
                </div>

              </div>

          </div>

        </div>        
      </main>

    </div> 

  </div>
</template>

<script>
import { ref } from 'vue'
import Sidebar from '../../partials/Sidebar.vue'
import Header from '../../partials/Header.vue'
import JobSidebar from '../../partials/job/JobSidebar.vue'
import DropdownSort from '../../components/DropdownSort.vue'
import JobListItem from '../../partials/job/JobListItem.vue'
import PaginationNumeric from '../../components/PaginationNumeric.vue'

import Image01 from '../../images/company-icon-05.svg'
import Image02 from '../../images/company-icon-06.svg'
import Image03 from '../../images/company-icon-03.svg'
import Image04 from '../../images/company-icon-07.svg'
import Image05 from '../../images/company-icon-08.svg'
import Image06 from '../../images/company-icon-01.svg'
import Image07 from '../../images/company-icon-02.svg'

export default {
  name: 'JobListing',
  components: {
    Sidebar,
    Header,
    JobSidebar,
    DropdownSort,
    JobListItem,    
    PaginationNumeric,
  },
  setup() {

    const sidebarOpen = ref(false)

    const items = ref([
      {
        id: 0,
        image: Image01,
        company: 'Company 01',
        role: 'Senior Web App Designer',
        link: '/job/job-post',
        details: 'Contract / Remote / New York, NYC',
        date: 'Jan 4',
        type: 'Featured',
        fav: false,
      },
      {
        id: 1,
        image: Image01,
        company: 'Company 02',
        role: 'Senior Full Stack Engineer',
        link: '/job/job-post',
        details: 'Contract / Remote / New York, NYC',
        date: 'Jan 7',
        type: 'New',
        fav: true,
      }, 
      {
        id: 2,
        image: Image02,
        company: 'Company 03',
        role: 'Ruby on Rails Engineer',
        link: '/job/job-post',
        details: 'Contract / Remote / New York, NYC',
        date: 'Jan 7',
        type: 'New',
        fav: false,
      }, 
      {
        id: 3,
        image: Image03,
        company: 'Company 04',
        role: 'Senior Software Engineer Backend',
        link: '/job/job-post',
        details: 'Full-time / Remote / Anywhere',
        date: 'Jan 7',
        type: 'New',
        fav: false,
      }, 
      {
        id: 4,
        image: Image04,
        company: 'Company 05',
        role: 'React.js Software Developer',
        link: '/job/job-post',
        details: 'Full-time / Remote / London, UK',
        date: 'Jan 6',
        type: 'New',
        fav: true,
      }, 
      {
        id: 5,
        image: Image05,
        company: 'Company 06',
        role: 'Senior Full Stack Rails Developer',
        link: '/job/job-post',
        details: 'Part-time / Remote / Milan, IT',
        date: 'Jan 6',
        type: 'New',
        fav: false,
      }, 
      {
        id: 6,
        image: Image06,
        company: 'Company 07',
        role: 'Principal Software Engineer',
        link: '/job/job-post',
        details: 'Freelance / Remote / London, UK',
        date: 'Jan 6',
        type: 'New',
        fav: false,
      }, 
      {
        id: 7,
        image: Image04,
        company: 'Company 08',
        role: 'Contract React Native Engineer',
        link: '/job/job-post',
        details: 'Contract / Remote / Miami, FL',
        date: 'Jan 6',
        type: 'New',
        fav: false,
      }, 
      {
        id: 8,
        image: Image05,
        company: 'Company 09',
        role: 'Senior Client Engineer (React & React Native)',
        link: '/job/job-post',
        details: 'Full-time / Remote / Lincoln, NE',
        date: 'Jan 5',
        type: 'New',
        fav: false,
      }, 
      {
        id: 9,
        image: Image07,
        company: 'Company 10',
        role: 'QA Automation Engineer',
        link: '/job/job-post',
        details: 'Contract / Remote / Anywhere',
        date: 'Jan 5',
        type: 'New',
        fav: false,
      },                                                       
    ])

    return {
      sidebarOpen,
      items,
    }  
  }
}
</script>