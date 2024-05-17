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
          <div class="sm:flex sm:justify-between sm:items-center mb-4">

            <!-- Left: Title -->
            <div class="mb-4 sm:mb-0">
              <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold"><span>{{`${monthNames[month]} ${year}`}}</span> ✨</h1>
            </div>

            <!-- Right: Actions -->
            <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-2">

              <!-- Previous month button -->
              <button
                class="btn px-2.5 bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 hover:text-slate-600 dark:text-slate-400 dark:hover:text-slate-300 disabled:border-slate-200 dark:disabled:border-slate-700 disabled:bg-slate-100 dark:disabled:bg-slate-800 disabled:text-slate-400 dark:disabled:text-slate-600 disabled:cursor-not-allowed"
                :disabled="month === 0 ? true : false"
                @click="month--;getDays()"
              >
                <span class="sr-only">Previous month</span><wbr />
                <svg class="h-4 w-4 fill-current" viewBox="0 0 16 16">
                  <path d="M9.4 13.4l1.4-1.4-4-4 4-4-1.4-1.4L4 8z" />
                </svg>
              </button>

              <!-- Next month button -->
              <button
                class="btn px-2.5 bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 hover:text-slate-600 dark:text-slate-400 dark:hover:text-slate-300 disabled:border-slate-200 dark:disabled:border-slate-700 disabled:bg-slate-100 dark:disabled:bg-slate-800 disabled:text-slate-400 dark:disabled:text-slate-600 disabled:cursor-not-allowed"
                :disabled="month === 11 ? true : false"
                @click="month++;getDays()"
              >
                <span class="sr-only">Next month</span><wbr />
                <svg class="h-4 w-4 fill-current" viewBox="0 0 16 16">
                  <path d="M6.6 13.4L5.2 12l4-4-4-4 1.4-1.4L12 8z" />
                </svg>
              </button>

              <hr class="w-px h-full bg-slate-200 dark:bg-slate-700 border-none mx-1" />

              <!-- Create event button -->
              <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                  <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                </svg>
                <span class="hidden xs:block ml-2">Create Event</span>
              </button>

            </div>

          </div>

          <!-- Filters and view buttons -->
          <div class="sm:flex sm:justify-between sm:items-center mb-4">

            <!-- Filters  -->
            <div class="mb-4 sm:mb-0 mr-2">
              <ul class="flex flex-wrap items-center -m-1">
                <li class="m-1">
                  <button class="btn-sm bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 dark:text-slate-400">
                    <div class="w-1 h-3.5 bg-sky-500 shrink-0"></div>
                    <span class="ml-1.5">Acme Inc.</span>
                  </button>
                </li>
                <li class="m-1">
                  <button class="btn-sm bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 dark:text-slate-400">
                    <div class="w-1 h-3.5 bg-emerald-500 shrink-0"></div>
                    <span class="ml-1.5">Life & Family</span>
                  </button>
                </li>
                <li class="m-1">
                  <button class="btn-sm bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 dark:text-slate-400">
                    <div class="w-1 h-3.5 bg-indigo-500 shrink-0"></div>
                    <span class="ml-1.5">Reservations</span>
                  </button>
                </li>
                <li class="m-1">
                  <button class="btn-sm bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 dark:text-slate-400">
                    <div class="w-1 h-3.5 bg-rose-400 shrink-0"></div>
                    <span class="ml-1.5">Events</span>
                  </button>
                </li>
                <li class="m-1">
                  <button class="btn-sm bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-500 dark:text-slate-400">
                    <div class="w-1 h-3.5 bg-amber-500 shrink-0"></div>
                    <span class="ml-1.5">Misc</span>
                  </button>
                </li>
                <li class="m-1">
                  <button class="btn-sm bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500">+Add New</button>
                </li>
              </ul>
            </div>

            <!-- View buttons (requires custom integration) -->
            <div class="flex flex-nowrap -space-x-px">
              <button class="btn bg-slate-50 dark:bg-slate-900 border-slate-200 dark:border-slate-700 hover:bg-slate-50 text-indigo-500 rounded-none first:rounded-l last:rounded-r">Month</button>
              <button class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:bg-slate-50 dark:hover:bg-slate-900 text-slate-600 dark:text-slate-300 rounded-none first:rounded-l last:rounded-r">Week</button>
              <button class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:bg-slate-50 dark:hover:bg-slate-900 text-slate-600 dark:text-slate-300 rounded-none first:rounded-l last:rounded-r">Day</button>
            </div>
          </div>

          <!-- Calendar table -->
          <div class="bg-white dark:bg-slate-800 rounded-sm shadow overflow-hidden">

            <!-- Days of the week -->
            <div class="grid grid-cols-7 gap-px border-b border-slate-200 dark:border-slate-700">
              <div class="px-1 py-3" v-for="(day, index) in dayNames" :key="index">
                <div class="text-slate-500 text-sm font-medium text-center lg:hidden">{{day.substring(0,3)}}</div>
                <div class="text-slate-500 dark:text-slate-400 text-sm font-medium text-center hidden lg:block">{{day}}</div>
              </div>
            </div>

            <!-- Day cells -->
            <div class="grid grid-cols-7 gap-px bg-slate-200 dark:bg-slate-700">
              <!-- Diagonal stripes pattern -->
              <svg class="sr-only">
                <defs>
                  <pattern id="stripes" patternUnits="userSpaceOnUse" width="5" height="5" patternTransform="rotate(135)">
                    <line class="stroke-current text-slate-200 dark:text-slate-700 opacity-50" x1="0" y="0" x2="0" y2="5" stroke-width="2" />
                  </pattern>
                </defs>
              </svg>
              <!-- Empty cells (previous month) -->
              <div class="bg-slate-50 dark:bg-slate-800 h-20 sm:h-28 lg:h-36" v-for="(blankday, index) in startingBlankDays" :key="index">
                <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%">
                  <rect width="100%" height="100%" fill="url(#stripes)" />
                </svg>
              </div>
              <!-- Days of the current month -->
              <div class="relative bg-white dark:bg-slate-800 h-20 sm:h-28 lg:h-36 overflow-hidden" v-for="(day, index) in daysInMonth" :key="index">
                <div class="h-full flex flex-col justify-between">
                  <!-- Events -->
                  <div class="grow flex flex-col relative p-0.5 sm:p-1.5 overflow-hidden">
                    <button
                      class="relative w-full text-left mb-1"
                      v-for="(event, index) in getEvents(day)"
                      :key="index"
                    >
                      <div class="px-2 py-0.5 rounded overflow-hidden" :class="eventColor(event.eventColor)">
                        <!-- Event name -->
                        <div class="text-xs font-semibold truncate">{{event.eventName}}</div>
                        <!-- Event time -->
                        <div class="text-xs uppercase truncate hidden sm:block">
                          <!-- Start date -->
                          <span v-if="event.eventStart">{{event.eventStart.toLocaleTimeString([], {hour12: true, hour: 'numeric', minute:'numeric'})}}</span>
                          <!-- End date -->
                          <span v-if="event.eventEnd">
                            - <span>{{event.eventEnd.toLocaleTimeString([], {hour12: true, hour: 'numeric', minute:'numeric'})}}</span>
                          </span>
                        </div>
                      </div>
                    </button>
                    <div class="absolute bottom-0 left-0 right-0 h-4 bg-gradient-to-t from-white dark:from-slate-800 to-transparent pointer-events-none" aria-hidden="true"></div>
                  </div>
                  <!-- Cell footer -->
                  <div class="flex justify-between items-center p-0.5 sm:p-1.5">
                    <!-- More button (if more than 2 events) -->
                    <button
                      v-if="getEvents(day).length > 2"
                      class="text-xs text-slate-500 dark:text-slate-300 font-medium whitespace-nowrap text-center sm:py-0.5 px-0.5 sm:px-2 border border-slate-200 dark:border-slate-700 rounded"
                    >
                      <span class="md:hidden">+</span><span>{{getEvents(day).length - 2}}</span> <span class="hidden md:inline">more</span>
                    </button>
                    <!-- Day number -->
                    <button class="inline-flex ml-auto w-6 h-6 items-center justify-center text-xs sm:text-sm dark:text-slate-300 font-medium text-center rounded-full hover:bg-indigo-100 dark:hover:bg-slate-600" :class="{'text-indigo-500': isToday(day) }">{{day}}</button>
                  </div>
                </div>
              </div>
              <!-- Empty cells (next month) -->
              <div class="bg-slate-50 dark:bg-slate-800 h-20 sm:h-28 lg:h-36" v-for="(blankday, index) in endingBlankDays" :key="index">
                <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%">
                  <rect width="100%" height="100%" fill="url(#stripes)" />
                </svg>
              </div>
            </div>
          </div>

        </div>
      </main>

    </div> 

  </div>
</template>

<script>
import { ref, onMounted } from 'vue'
import Sidebar from '../partials/Sidebar.vue'
import Header from '../partials/Header.vue'

export default {
  name: 'Calendar',
  components: {
    Sidebar,
    Header,
  },
  setup() {
    const today = new Date()
    const sidebarOpen = ref(false)
    const monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
    const dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    const month = ref(today.getMonth())
    const year = ref(today.getFullYear())
    const daysInMonth = ref([])
    const startingBlankDays = ref([])
    const endingBlankDays = ref([])
    const events = ref([
      // Previous month
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() - 1, 8, 3),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth() - 1, 8, 7),
        eventName: '⛱️ Relax for 2 at Marienbad',
        eventColor: 'indigo'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() - 1, 12, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 12, 11),
        eventName: 'Team Catch-up',
        eventColor: 'sky'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() - 1, 18, 2),
        eventEnd: '',
        eventName: '✍️ New Project (2)',
        eventColor: 'yellow'
      },                    
      // Current month
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 1, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 1, 11),
        eventName: 'Meeting w/ Patrick Lin',
        eventColor: 'sky'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 1, 19),
        eventEnd: '',
        eventName: 'Reservation at La Ginestre',
        eventColor: 'indigo'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 3, 9),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 3, 10),
        eventName: '✍️ New Project',
        eventColor: 'yellow'
      }, 
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 7, 21),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 7, 22),
        eventName: '⚽ 2021 - Semi-final',
        eventColor: 'red'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 9, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 9, 11),
        eventName: 'Meeting w/Carolyn',
        eventColor: 'sky'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 9, 13),
        eventEnd: '',
        eventName: 'Pick up Marta at school',
        eventColor: 'emerald'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 9, 14),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 9, 15),
        eventName: 'Meeting w/ Patrick Lin',
        eventColor: 'emerald'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 9, 19),
        eventEnd: '',
        eventName: 'Reservation at La Ginestre',
        eventColor: 'indigo'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 11, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 11, 11),
        eventName: '⛱️ Relax for 2 at Marienbad',
        eventColor: 'indigo'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 11, 19),
        eventEnd: '',
        eventName: '⚽ 2021 - Semi-final',
        eventColor: 'red'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 14, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 14, 11),
        eventName: 'Team Catch-up',
        eventColor: 'sky'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 21, 2),
        eventEnd: '',
        eventName: 'Pick up Marta at school',
        eventColor: 'emerald'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 21, 3),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 21, 7),
        eventName: '✍️ New Project (2)',
        eventColor: 'yellow'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 22, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 22, 11),
        eventName: 'Team Catch-up',
        eventColor: 'sky'
      },                     
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 22, 19),
        eventEnd: '',
        eventName: '⚽ 2021 - Semi-final',
        eventColor: 'red'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 23, 0),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 23, 23),
        eventName: 'You stay at Meridiana B&B',
        eventColor: 'indigo'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 25, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 25, 11),
        eventName: 'Meeting w/ Kylie Joh',
        eventColor: 'sky'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth(), 29, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 29, 11),
        eventName: 'Call Request ->',
        eventColor: 'sky'
      },
      // Next month
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 2, 3),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 2, 7),
        eventName: '✍️ New Project (2)',
        eventColor: 'yellow'
      },                    
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 14, 10),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth(), 14, 11),
        eventName: 'Team Catch-up',
        eventColor: 'sky'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 25, 2),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 25, 3),
        eventName: 'Pick up Marta at school',
        eventColor: 'emerald'
      },
      {
        eventStart: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 27, 21),
        eventEnd: new Date(new Date().getFullYear(), new Date().getMonth() + 1, 27, 22),
        eventName: '⚽ 2021 - Semi-final',
        eventColor: 'red'
      },
    ])

    const isToday = (date) => {
      const day = new Date(year.value, month.value, date)
      return today.toDateString() === day.toDateString() ? true : false
    }

    const getEvents = (date) => {
      return events.value.filter(e => new Date(e.eventStart).toDateString() === new Date(year.value, month.value, date).toDateString())
    }

    const getDays = () => {
      const days = new Date(year.value, month.value + 1, 0).getDate()

      // starting empty cells (previous month)
      const startingDayOfWeek = new Date(year.value, month.value).getDay()
      let startingBlankDaysArray = []
      for (let i = 1; i <= startingDayOfWeek; i++) {
        startingBlankDaysArray.push(i)
      }

      // ending empty cells (next month)
      const endingDayOfWeek = new Date(year.value, month.value + 1, 0).getDay()
      let endingBlankDaysArray = []
      for (let i = 1; i < 7 - endingDayOfWeek; i++) {
        endingBlankDaysArray.push(i)
      }                    

      // current month cells
      let daysArray = []
      for (let i = 1; i <= days; i++) {
        daysArray.push(i)
      }

      startingBlankDays.value = startingBlankDaysArray
      endingBlankDays.value = endingBlankDaysArray
      daysInMonth.value = daysArray
    }

    const eventColor = (color) => {
      switch (color) {
        case 'sky':
          return 'text-white bg-sky-500';
        case 'indigo':
          return 'text-white bg-indigo-500';
        case 'yellow':
          return 'text-white bg-amber-500';
        case 'emerald':
          return 'text-white bg-emerald-500';
        case 'red':
          return 'text-white bg-rose-400';
        default:
          return '';
      }
    }    

    onMounted(() => {
      getDays()
    })

    return {
      sidebarOpen,
      monthNames,
      dayNames,
      month,
      year,
      daysInMonth,
      startingBlankDays,
      endingBlankDays,
      events,
      isToday,
      getEvents,
      getDays,
      eventColor,
    }  
  }
}
</script>