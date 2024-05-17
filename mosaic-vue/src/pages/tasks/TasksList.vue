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

          <!-- Smaller container -->
          <div class="max-w-3xl mx-auto">

            <!-- Page header -->
            <div class="sm:flex sm:justify-between sm:items-center mb-8">

              <!-- Left: Title -->
              <div class="mb-4 sm:mb-0">
                <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Acme Inc. Tasks ✨</h1>
              </div>

              <!-- Right: Actions -->
              <div class="grid grid-flow-col sm:auto-cols-max justify-start sm:justify-end gap-4">

                <!-- Avatars -->
                <div class="flex shrink-0 -space-x-3 -ml-px">
                  <a class="block" href="#0">
                    <img class="rounded-full border-2 border-slate-100 dark:border-slate-900 box-content" src="../../images/user-32-08.jpg" width="32" height="32" alt="User 08" />
                  </a>
                  <a class="block" href="#0">
                    <img class="rounded-full border-2 border-slate-100 dark:border-slate-900 box-content" src="../../images/user-32-07.jpg" width="32" height="32" alt="User 07" />
                  </a>
                  <a class="block" href="#0">
                    <img class="rounded-full border-2 border-slate-100 dark:border-slate-900 box-content" src="../../images/user-32-05.jpg" width="32" height="32" alt="User 05" />
                  </a>
                  <button class="flex justify-center items-center w-9 h-9 rounded-full bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500 shadow-sm transition duration-150 ml-2">
                    <span class="sr-only">Add new user</span>
                    <svg class="w-3 h-3 fill-current" viewBox="0 0 12 12">
                      <path d="M11 5H7V1a1 1 0 0 0-2 0v4H1a1 1 0 0 0 0 2h4v4a1 1 0 0 0 2 0V7h4a1 1 0 0 0 0-2Z" />
                    </svg>
                  </button>
                </div>

                <!-- Add taks button -->
                <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white">
                  <svg class="w-4 h-4 fill-current opacity-50 shrink-0" viewBox="0 0 16 16">
                    <path d="M15 7H9V1c0-.6-.4-1-1-1S7 .4 7 1v6H1c-.6 0-1 .4-1 1s.4 1 1 1h6v6c0 .6.4 1 1 1s1-.4 1-1V9h6c.6 0 1-.4 1-1s-.4-1-1-1z" />
                  </svg>
                  <span class="ml-2">Add Task</span>
                </button>

              </div>

            </div>

            <!-- Tasks -->
            <div class="space-y-6">

              <!-- Group 1 -->
              <div>
                <h2 class="grow font-semibold text-slate-800 dark:text-slate-100 truncate mb-4">To Do's 🖋️</h2>
                <div class="space-y-2">

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Senior Software Engineer Backend</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Avatars -->
                        <div class="flex shrink-0 -space-x-3 -ml-px">
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-07.jpg" width="24" height="24" alt="User 07" />
                          </a>
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-05.jpg" width="24" height="24" alt="User 05" />
                          </a>
                        </div>
                        <!-- Like button -->
                        <button class="flex items-center text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M14.682 2.318A4.485 4.485 0 0011.5 1 4.377 4.377 0 008 2.707 4.383 4.383 0 004.5 1a4.5 4.5 0 00-3.182 7.682L8 15l6.682-6.318a4.5 4.5 0 000-6.364zm-1.4 4.933L8 12.247l-5.285-5A2.5 2.5 0 014.5 3c1.437 0 2.312.681 3.5 2.625C9.187 3.681 10.062 3 11.5 3a2.5 2.5 0 011.785 4.251h-.003z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">4</div>
                        </button>
                        <!-- Replies button -->
                        <button class="flex items-center text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M8 0C3.6 0 0 3.1 0 7s3.6 7 8 7h.6l5.4 2v-4.4c1.2-1.2 2-2.8 2-4.6 0-3.9-3.6-7-8-7zm4 10.8v2.3L8.9 12H8c-3.3 0-6-2.2-6-5s2.7-5 6-5 6 2.2 6 5c0 2.2-2 3.8-2 3.8z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">7</div>
                        </button>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">User should receive a daily digest email</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Date -->
                        <div class="flex items-center text-amber-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M15 2h-2V0h-2v2H9V0H7v2H5V0H3v2H1a1 1 0 00-1 1v12a1 1 0 001 1h14a1 1 0 001-1V3a1 1 0 00-1-1zm-1 12H2V6h12v8z" />
                          </svg>
                          <div class="text-sm text-amber-600">Mar 27</div>
                        </div>
                        <!-- Replies button -->
                        <button class="flex items-center text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M8 0C3.6 0 0 3.1 0 7s3.6 7 8 7h.6l5.4 2v-4.4c1.2-1.2 2-2.8 2-4.6 0-3.9-3.6-7-8-7zm4 10.8v2.3L8.9 12H8c-3.3 0-6-2.2-6-5s2.7-5 6-5 6 2.2 6 5c0 2.2-2 3.8-2 3.8z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">6</div>
                        </button>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Change license and remove products</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Avatars -->
                        <div class="flex shrink-0 -space-x-3 -ml-px">
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-08.jpg" width="24" height="24" alt="User 08" />
                          </a>
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-07.jpg" width="24" height="24" alt="User 07" />
                          </a>
                        </div>
                        <!-- Replies button -->
                        <button class="flex items-center text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M8 0C3.6 0 0 3.1 0 7s3.6 7 8 7h.6l5.4 2v-4.4c1.2-1.2 2-2.8 2-4.6 0-3.9-3.6-7-8-7zm4 10.8v2.3L8.9 12H8c-3.3 0-6-2.2-6-5s2.7-5 6-5 6 2.2 6 5c0 2.2-2 3.8-2 3.8z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">4</div>
                        </button>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                </div>
              </div>

              <!-- Group 2 -->
              <div>
                <h2 class="grow font-semibold text-slate-800 dark:text-slate-100 truncate mb-4">In Progress ✌️</h2>
                <div class="space-y-2">

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Managing teams (book)</span>
                          </label>
                        </div>
                        <!-- Nested checkboxes -->
                        <ul class="pl-12 space-y-3">
                          <li>
                            <label class="flex items-center">
                              <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" checked />
                              <span class="text-sm text-slate-800 dark:text-slate-100 peer-checked:line-through ml-3">Finish the presentation</span>
                            </label>
                          </li>
                          <li>
                            <label class="flex items-center">
                              <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                              <span class="text-sm text-slate-800 dark:text-slate-100 peer-checked:line-through ml-3">Finish the design</span>
                            </label>
                          </li>
                          <li>
                            <label class="flex items-center">
                              <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                              <span class="text-sm text-slate-800 dark:text-slate-100 peer-checked:line-through ml-3">Publish the content</span>
                            </label>
                          </li>
                        </ul>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Avatars -->
                        <div class="flex shrink-0 -space-x-3 -ml-px">
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-05.jpg" width="24" height="24" alt="User 05" />
                          </a>
                        </div>
                        <!-- To-do info -->
                        <div class="flex items-center text-slate-400 dark:text-slate-500 ml-3">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M6.974 14c-.3 0-.7-.2-.9-.5l-2.2-3.7-2.1 2.8c-.3.4-1 .5-1.4.2-.4-.3-.5-1-.2-1.4l3-4c.2-.3.5-.4.9-.4.3 0 .6.2.8.5l2 3.3 3.3-8.1c0-.4.4-.7.8-.7s.8.2.9.6l4 8c.2.5 0 1.1-.4 1.3-.5.2-1.1 0-1.3-.4l-3-6-3.2 7.9c-.2.4-.6.6-1 .6z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">1/3</div>
                        </div>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Product Update - Q4 2021</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Date -->
                        <div class="flex items-center text-amber-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M15 2h-2V0h-2v2H9V0H7v2H5V0H3v2H1a1 1 0 00-1 1v12a1 1 0 001 1h14a1 1 0 001-1V3a1 1 0 00-1-1zm-1 12H2V6h12v8z" />
                          </svg>
                          <div class="text-sm text-amber-600">Mar 27</div>
                        </div>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Design marketing assets</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Avatars -->
                        <div class="flex shrink-0 -space-x-3 -ml-px">
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-07.jpg" width="24" height="24" alt="User 07" />
                          </a>
                        </div>
                        <!-- Date -->
                        <div class="flex items-center text-amber-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M15 2h-2V0h-2v2H9V0H7v2H5V0H3v2H1a1 1 0 00-1 1v12a1 1 0 001 1h14a1 1 0 001-1V3a1 1 0 00-1-1zm-1 12H2V6h12v8z" />
                          </svg>
                          <div class="text-sm text-amber-600">Mar 27</div>
                        </div>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                </div>
              </div>

              <!-- Group 3 -->
              <div>
                <h2 class="grow font-semibold text-slate-800 dark:text-slate-100 truncate mb-4">Completed 🎉</h2>
                <div class="space-y-2">

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4 opacity-60" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" checked />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Design new diagrams</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Avatars -->
                        <div class="flex shrink-0 -space-x-3 -ml-px">
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-08.jpg" width="24" height="24" alt="User 08" />
                          </a>
                        </div>
                        <!-- To-do info -->
                        <div class="flex items-center text-slate-400 dark:text-slate-500 ml-3">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M6.974 14c-.3 0-.7-.2-.9-.5l-2.2-3.7-2.1 2.8c-.3.4-1 .5-1.4.2-.4-.3-.5-1-.2-1.4l3-4c.2-.3.5-.4.9-.4.3 0 .6.2.8.5l2 3.3 3.3-8.1c0-.4.4-.7.8-.7s.8.2.9.6l4 8c.2.5 0 1.1-.4 1.3-.5.2-1.1 0-1.3-.4l-3-6-3.2 7.9c-.2.4-.6.6-1 .6z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">3/3</div>
                        </div>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                  <!-- Task -->
                  <div class="bg-white dark:bg-slate-800 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 p-4 opacity-60" draggable="true">
                    <div class="sm:flex sm:justify-between sm:items-start">
                      <!-- Left side -->
                      <div class="grow mt-0.5 mb-3 sm:mb-0 space-y-3">
                        <div class="flex items-center">
                          <!-- Drag button -->
                          <button class="cursor-move mr-2">
                            <span class="sr-only">Drag</span>
                            <svg class="w-3 h-3 fill-slate-300 dark:fill-slate-600" viexBox="0 0 12 12" xmlns="http://www.w3.org/2000/svg">
                              <path d="M0 1h12v2H0V1Zm0 4h12v2H0V5Zm0 4h12v2H0V9Z" fill-rule="evenodd" />
                            </svg>
                          </button>
                          <!-- Checkbox button -->
                          <label class="flex items-center">
                            <input type="checkbox" class="form-checkbox w-5 h-5 rounded-full peer" checked />
                            <span class="font-medium text-slate-800 dark:text-slate-100 peer-checked:line-through ml-2">Update the contact page</span>
                          </label>
                        </div>
                      </div>
                      <!-- Right side -->
                      <div class="flex items-center justify-end space-x-3">
                        <!-- Avatars -->
                        <div class="flex shrink-0 -space-x-3 -ml-px">
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-08.jpg" width="24" height="24" alt="User 08" />
                          </a>
                          <a class="block" href="#0">
                            <img class="rounded-full border-2 border-white dark:border-slate-800 box-content" src="../../images/user-32-07.jpg" width="24" height="24" alt="User 07" />
                          </a>
                        </div>
                        <!-- To-do info -->
                        <div class="flex items-center text-slate-400 dark:text-slate-500 ml-3">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M6.974 14c-.3 0-.7-.2-.9-.5l-2.2-3.7-2.1 2.8c-.3.4-1 .5-1.4.2-.4-.3-.5-1-.2-1.4l3-4c.2-.3.5-.4.9-.4.3 0 .6.2.8.5l2 3.3 3.3-8.1c0-.4.4-.7.8-.7s.8.2.9.6l4 8c.2.5 0 1.1-.4 1.3-.5.2-1.1 0-1.3-.4l-3-6-3.2 7.9c-.2.4-.6.6-1 .6z" />
                          </svg>
                          <div class="text-sm text-slate-500 dark:text-slate-400">2/2</div>
                        </div>
                        <!-- Attach button -->
                        <button class="text-slate-400 dark:text-slate-500 hover:text-indigo-500 dark:hover:text-indigo-500">
                          <svg class="w-4 h-4 shrink-0 fill-current mr-1.5" viewBox="0 0 16 16">
                            <path d="M11 0c1.3 0 2.6.5 3.5 1.5 1 .9 1.5 2.2 1.5 3.5 0 1.3-.5 2.6-1.4 3.5l-1.2 1.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l1.1-1.2c.6-.5.9-1.3.9-2.1s-.3-1.6-.9-2.2C12 1.7 10 1.7 8.9 2.8L7.7 4c-.4.4-1 .4-1.4 0-.4-.4-.4-1 0-1.4l1.2-1.1C8.4.5 9.7 0 11 0zM8.3 12c.4-.4 1-.5 1.4-.1.4.4.4 1 0 1.4l-1.2 1.2C7.6 15.5 6.3 16 5 16c-1.3 0-2.6-.5-3.5-1.5C.5 13.6 0 12.3 0 11c0-1.3.5-2.6 1.5-3.5l1.1-1.2c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4L2.9 8.9c-.6.5-.9 1.3-.9 2.1s.3 1.6.9 2.2c1.1 1.1 3.1 1.1 4.2 0L8.3 12zm1.1-6.8c.4-.4 1-.4 1.4 0 .4.4.4 1 0 1.4l-4.2 4.2c-.2.2-.5.3-.7.3-.2 0-.5-.1-.7-.3-.4-.4-.4-1 0-1.4l4.2-4.2z" />
                          </svg>
                        </button>
                      </div>
                    </div>
                  </div>

                </div>
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

export default {
  name: 'TasksList',
  components: {
    Sidebar,
    Header,
  },
  setup() {

    const sidebarOpen = ref(false)

    return {
      sidebarOpen,
    }  
  }
}
</script>