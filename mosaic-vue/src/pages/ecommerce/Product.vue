<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full">

          <!-- Page content -->
          <div class="max-w-5xl mx-auto flex flex-col lg:flex-row lg:space-x-8 xl:space-x-16">

            <!-- Content -->
            <div>
              <div class="mb-3">
                <a class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">&lt;- Back To Listing</a>
              </div>
              <header class="mb-4">
                <!-- Title -->
                <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold mb-2">Front-End Learning: Hands-On HTML & CSS In Real Web Apps ✨</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam.</p>
              </header>

              <!-- Meta -->
              <div class="space-y-3 sm:flex sm:items-center sm:justify-between sm:space-y-0 mb-6">
                <!-- Author -->
                <div class="flex items-center sm:mr-4">
                  <a class="block mr-2 shrink-0" href="#0">
                    <img class="rounded-full" src="../../images/user-32-07.jpg" width="32" height="32" alt="User 04" />
                  </a>
                  <a class="block text-sm font-semibold text-slate-800 dark:text-slate-100 whitespace-nowrap" href="#0">
                    Simona Lürwer
                  </a>
                </div>
                <!-- Right side -->
                <div class="flex flex-wrap items-center sm:justify-end space-x-4">
                  <!-- Tag -->
                  <div class="inline-flex items-center text-xs font-medium text-slate-100 dark:text-slate-300 bg-slate-900/60 dark:bg-slate-800/60 rounded-full text-center px-2 py-0.5">
                    <svg class="w-3 h-3 shrink-0 fill-current text-amber-500 mr-1" viewBox="0 0 12 12">
                      <path d="M11.953 4.29a.5.5 0 00-.454-.292H6.14L6.984.62A.5.5 0 006.12.173l-6 7a.5.5 0 00.379.825h5.359l-.844 3.38a.5.5 0 00.864.445l6-7a.5.5 0 00.075-.534z" />
                    </svg>
                    <span>Special Offer</span>
                  </div>
                  <!-- Rating -->
                  <div class="flex items-center space-x-2 mr-2">
                    <!-- Stars -->
                    <div class="flex space-x-1">
                      <button>
                        <span class="sr-only">1 star</span>
                        <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                          <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                        </svg>
                      </button>
                      <button>
                        <span class="sr-only">2 stars</span>
                        <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                          <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                        </svg>
                      </button>
                      <button>
                        <span class="sr-only">3 stars</span>
                        <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                          <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                        </svg>
                      </button>
                      <button>
                        <span class="sr-only">4 stars</span>
                        <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                          <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                        </svg>
                      </button>
                      <button>
                        <span class="sr-only">5 stars</span>
                        <svg class="w-4 h-4 fill-current text-slate-300 dark:text-slate-600" viewBox="0 0 16 16">
                          <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                        </svg>
                      </button>
                    </div>
                    <!-- Rate -->
                    <div class="inline-flex text-sm font-medium text-amber-600">4.2</div>
                  </div>
                </div>
              </div>

              <!-- Image -->
              <figure class="mb-6">
                <img class="w-full rounded-sm" src="../../images/product-image.jpg" width="640" height="360" alt="Product" />
              </figure>

              <!-- Product content -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Overview</h2>
                <p class="mb-6">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua u t enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                <p class="mb-6">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                <ul class="list-disc list-inside space-y-1 mb-6">
                  <li>E-commerce: Better lorem ipsum generator.</li>
                  <li>Booking: Lorem ipsum post generator.</li>
                  <li>Retail: Better lorem ipsum generator.</li>
                  <li>Services: Better lorem ipsum generator.</li>
                </ul>
                <blockquote class="italic mb-6">
                  “Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.”
                </blockquote>
              </div>

              <hr class="my-6 border-t border-slate-200 dark:border-slate-700" />

              <!-- Reviews -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Featured Reviews (44)</h2>
                <ul class="space-y-5 my-6">
                  <!-- Review -->
                  <li>
                    <div class="flex items-center mb-2">
                      <img class="w-8 h-8 rounded-full mr-3" src="../../images/user-32-07.jpg" width="32" height="32" alt="User 07" />
                      <div>
                        <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-1">Danielle Mark</div>
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-slate-300 dark:text-slate-600" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.6</div>
                        </div>
                      </div>
                    </div>
                    <div class="text-sm italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                  </li>
                  <!-- Review -->
                  <li>
                    <div class="flex items-center mb-2">
                      <img class="w-8 h-8 rounded-full mr-3" src="../../images/user-32-05.jpg" width="32" height="32" alt="User 05" />
                      <div>
                        <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-1">Marija Urkjulz</div>
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.9</div>
                        </div>
                      </div>
                    </div>
                    <div class="text-sm italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                  </li>
                  <!-- Review -->
                  <li>
                    <div class="flex items-center mb-2">
                      <img class="w-8 h-8 rounded-full mr-3" src="../../images/user-32-03.jpg" width="32" height="32" alt="User 03" />
                      <div>
                        <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-1">Rodrigo Pantoja</div>
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-slate-300 dark:text-slate-600" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.4</div>
                        </div>
                      </div>
                    </div>
                    <div class="text-sm italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                  </li>
                  <!-- Review -->
                  <li>
                    <div class="flex items-center mb-2">
                      <img class="w-8 h-8 rounded-full mr-3" src="../../images/user-32-04.jpg" width="32" height="32" alt="User 04" />
                      <div>
                        <div class="text-sm font-semibold text-slate-800 dark:text-slate-100 mb-1">Juan Johnson</div>
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.9</div>
                        </div>
                      </div>
                    </div>
                    <div class="text-sm italic">“Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.”</div>
                  </li>
                </ul>
                <!-- Load More -->
                <div class="text-center">
                  <button class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500">Load More Reviews</button>
                </div>
              </div>

              <hr class="my-6 border-t border-slate-200 dark:border-slate-700" />

              <!-- Related -->
              <div>
                <h2 class="text-xl leading-snug text-slate-800 dark:text-slate-100 font-bold mb-2">Frequently Bought Together</h2>
                <ul class="space-y-8 sm:space-y-5 my-6">
                  <!-- Related item -->
                  <li class="sm:flex items-center">
                    <a class="block mb-4 sm:mb-0 mr-5 md:w-32 xl:w-auto shrink-0" href="#0">
                      <img class="rounded-sm" src="../../images/related-product-01.jpg" width="200" height="142" alt="Product 01" />
                    </a>
                    <div class="grow">
                      <a href="#0">
                        <h3 class="text-lg font-semibold text-slate-800 dark:text-slate-100 mb-1">The Complete Front-End Development Course!</h3>
                      </a>
                      <div class="text-sm mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.</div>
                      <!-- Rating and price -->
                      <div class="flex flex-wrap items-center space-x-2">
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-slate-300 dark:text-slate-600" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.2</div>
                        </div>
                        <div class="text-slate-400 dark:text-slate-600">·</div>
                        <!-- Price -->
                        <div>
                          <div class="inline-flex text-sm font-medium bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2 py-0.5">$89.00</div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <!-- Related item -->
                  <li class="sm:flex items-center">
                    <a class="block mb-4 sm:mb-0 mr-5 md:w-32 xl:w-auto shrink-0" href="#0">
                      <img class="rounded-sm" src="../../images/related-product-02.jpg" width="200" height="142" alt="Product 02" />
                    </a>
                    <div class="grow">
                      <a href="#0">
                        <h3 class="text-lg font-semibold text-slate-800 dark:text-slate-100 mb-1">Web Development Ultimate Course 2021</h3>
                      </a>
                      <div class="text-sm mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.</div>
                      <!-- Rating and price -->
                      <div class="flex flex-wrap items-center space-x-2">
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-slate-300 dark:text-slate-600" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.2</div>
                        </div>
                        <div class="text-slate-400 dark:text-slate-600">·</div>
                        <!-- Price -->
                        <div>
                          <div class="inline-flex text-sm font-medium bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2 py-0.5">$89.00</div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <!-- Related item -->
                  <li class="sm:flex items-center">
                    <a class="block mb-4 sm:mb-0 mr-5 md:w-32 xl:w-auto shrink-0" href="#0">
                      <img class="rounded-sm" src="../../images/related-product-03.jpg" width="200" height="142" alt="Product 03" />
                    </a>
                    <div class="grow">
                      <a href="#0">
                        <h3 class="text-lg font-semibold text-slate-800 dark:text-slate-100 mb-1">Full-Stack JavaScript Course!</h3>
                      </a>
                      <div class="text-sm mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut.</div>
                      <!-- Rating and price -->
                      <div class="flex flex-wrap items-center space-x-2">
                        <!-- Rating -->
                        <div class="flex items-center space-x-2">
                          <!-- Stars -->
                          <div class="flex space-x-1">
                            <button>
                              <span class="sr-only">1 star</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">2 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">3 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">4 stars</span>
                              <svg class="w-4 h-4 fill-current text-amber-500" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                            <button>
                              <span class="sr-only">5 stars</span>
                              <svg class="w-4 h-4 fill-current text-slate-300 dark:text-slate-600" viewBox="0 0 16 16">
                                <path d="M10 5.934L8 0 6 5.934H0l4.89 3.954L2.968 16 8 12.223 13.032 16 11.11 9.888 16 5.934z" />
                              </svg>
                            </button>
                          </div>
                          <!-- Rate -->
                          <div class="inline-flex text-sm font-medium text-amber-600">4.2</div>
                        </div>
                        <div class="text-slate-400 dark:text-slate-600">·</div>
                        <!-- Price -->
                        <div>
                          <div class="inline-flex text-sm font-medium bg-emerald-100 dark:bg-emerald-400/30 text-emerald-600 dark:text-emerald-400 rounded-full text-center px-2 py-0.5">$89.00</div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
                <!-- Load More -->
                <div class="text-center">
                  <button class="btn bg-white dark:bg-slate-800 border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-indigo-500">Load More Stuff</button>
                </div>
              </div>

              <hr class="my-6 border-t border-slate-200 dark:border-slate-700" />

            </div>

            <!-- Sidebar -->
            <div>
              <div class="bg-white dark:bg-slate-800 p-5 shadow-lg rounded-sm border border-slate-200 dark:border-slate-700 lg:w-72 xl:w-80">
                <div class="text-sm text-slate-800 dark:text-slate-100 font-semibold mb-3">Select a Package</div>
                <ul class="space-y-2 sm:flex sm:space-y-0 sm:space-x-2 lg:space-y-2 lg:space-x-0 lg:flex-col mb-4">
                  <li>
                    <button class="w-full h-full text-left py-3 px-4 rounded bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm duration-150 ease-in-out">
                      <div class="flex flex-wrap items-center justify-between mb-0.5">
                        <span class="font-semibold text-slate-800 dark:text-slate-100">Essential</span>
                        <span class="font-medium text-emerald-600">$39.00</span>
                      </div>
                      <div class="text-sm">Lorem ipsum dolor sit amet elit sed do eiusmod.</div>
                    </button>
                  </li>
                  <li>
                    <button class="w-full h-full text-left py-3 px-4 rounded bg-white dark:bg-slate-800 border-2 border-indigo-400 dark:border-indigo-500 shadow-sm duration-150 ease-in-out">
                      <div class="flex flex-wrap items-center justify-between mb-0.5">
                        <span class="font-semibold text-slate-800 dark:text-slate-100">Premium <span class="text-xs italic text-indigo-500 align-top">Best Value ✨</span></span>
                        <span class="font-medium text-emerald-600">$69.00</span>
                      </div>
                      <div class="text-sm">Lorem ipsum dolor sit amet elit sed do eiusmod.</div>
                    </button>
                  </li>
                  <li>
                    <button class="w-full h-full text-left py-3 px-4 rounded bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm duration-150 ease-in-out">
                      <div class="flex flex-wrap items-center justify-between mb-0.5">
                        <span class="font-semibold text-slate-800 dark:text-slate-100">Complete</span>
                        <span class="font-medium text-emerald-600">$89.00</span>
                      </div>
                      <div class="text-sm">Lorem ipsum dolor sit amet elit sed do eiusmod.</div>
                    </button>
                  </li>
                </ul>
                <div class="mb-4">
                  <a class="btn w-full bg-indigo-500 hover:bg-indigo-600 text-white" href="#0">Buy Now - $69.00</a>
                </div>
                <div class="text-xs text-slate-500 italic text-center">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do <a class="underline hover:no-underline" href="#0">Terms</a>.</div>
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
  name: 'Product',
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