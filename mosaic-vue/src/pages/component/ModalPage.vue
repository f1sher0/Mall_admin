<template>
  <div class="flex h-[100dvh] overflow-hidden">

    <!-- Sidebar -->
    <Sidebar :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden bg-white dark:bg-slate-900">
      
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow">
        <div class="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">

          <!-- Page header -->
          <div class="mb-8">
            <h1 class="text-2xl md:text-3xl text-slate-800 dark:text-slate-100 font-bold">Modal ✨</h1>
          </div>

          <div class="border-t border-slate-200 dark:border-slate-700">

            <!-- Components -->
            <div class="space-y-8 mt-8">
            
              <!-- Basic -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Basic</h2>
                <div class="flex flex-wrap items-center -m-1.5">

                  <!-- Basic Modal -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="basic-modal" @click.stop="basicModalOpen = true">Basic Modal</button>
                    <ModalBasic id="basic-modal" :modalOpen="basicModalOpen" @close-modal="basicModalOpen = false" title="Basic Modal">
                      <!-- Modal content -->
                      <div class="px-5 pt-4 pb-1">
                        <div class="text-sm">
                          <div class="font-medium text-slate-800 dark:text-slate-100 mb-2">Let’s Talk Paragraph</div>
                          <div class="space-y-2">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                          </div>
                        </div>
                      </div>
                      <!-- Modal footer -->
                      <div class="px-5 py-4">
                        <div class="flex flex-wrap justify-end space-x-2">
                          <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="basicModalOpen = false">Close</button>
                          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">I Understand</button>
                        </div>
                      </div>
                    </ModalBasic>
                    <!-- End -->
                  </div>

                  <!-- Modal w/ Scroll Bar -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="scrollbar-modal" @click.stop="scrollbarModalOpen = true">Modal w/ Scroll Bar</button>
                    <ModalBasic id="scrollbar-modal" :modalOpen="scrollbarModalOpen" @close-modal="scrollbarModalOpen = false" title="Modal w/ Scroll Bar">
                      <!-- Modal content -->
                      <div class="px-5 py-4">
                        <div class="text-sm">
                          <div class="font-medium text-slate-800 dark:text-slate-100 mb-2">Let’s Talk Paragraph</div>
                          <div class="space-y-2">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <p>Ullamcorper malesuada proin libero nunc consequat interdum varius sit. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur vitae. Mattis enim ut tellus elementum el fringilla est ullamcorper eget nulla. Enim eu turpis egestas pretium aenean pharetra magna. Aliquam id diam maecenas ultricies mi eget us mauris vitae ultricies leo integer t malesuada fames ac turpis egestas maecenas pharetra volutpat lacus laoreet non.</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <p>Ullamcorper malesuada proin libero nunc consequat interdum varius sit. Nec sagittis aliquam malesuada bibendum arcu vitae elementum curabitur vitae. Mattis enim ut tellus elementum el fringilla est ullamcorper eget nulla. Enim eu turpis egestas pretium aenean pharetra magna. Aliquam id diam maecenas ultricies mi eget us mauris vitae ultricies leo integer t malesuada fames ac turpis egestas maecenas pharetra volutpat lacus laoreet non.</p>
                          </div>
                        </div>
                      </div>
                      <!-- Modal footer -->
                      <div class="sticky bottom-0 px-5 py-4 bg-white dark:bg-slate-800 border-t border-slate-200 dark:border-slate-700">
                        <div class="flex flex-wrap justify-end space-x-2">
                          <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="scrollbarModalOpen = false">Close</button>
                          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">I Understand</button>
                        </div>
                      </div>
                    </ModalBasic>
                    <!-- End -->
                  </div>

                  <!-- Cookies -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="cookies-modal" @click.stop="cookiesModalOpen = true">Cookies</button>
                    <ModalCookies id="cookies-modal" :modalOpen="cookiesModalOpen" @close-modal="cookiesModalOpen = false" title="We use cookies 🍪">
                      <!-- Modal content -->
                      <div class="text-sm mb-5">
                        <div class="space-y-2">
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                          <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                      </div>
                      <!-- Modal footer -->
                      <div class="flex flex-wrap justify-end space-x-2">
                        <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="cookiesModalOpen = false">Decline</button>
                        <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white" @click.stop="cookiesModalOpen = false">I Accept</button>
                      </div>
                    </ModalCookies>
                    <!-- End -->
                  </div>                  
                  
                </div>
              </div>

              <!-- Feedback -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Feedback</h2>
                <div class="flex flex-wrap items-center -m-1.5">

                  <!-- Success Modal -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="success-modal" @click.stop="successModalOpen = true">Success Modal</button>
                    <ModalBlank id="success-modal" :modalOpen="successModalOpen" @close-modal="successModalOpen = false">
                      <div class="p-5 flex space-x-4">
                        <!-- Icon -->
                        <div class="w-10 h-10 rounded-full flex items-center justify-center shrink-0 bg-emerald-100 dark:bg-emerald-400/30">
                          <svg class="w-4 h-4 shrink-0 fill-current text-emerald-500" viewBox="0 0 16 16">
                            <path d="M8 0C3.6 0 0 3.6 0 8s3.6 8 8 8 8-3.6 8-8-3.6-8-8-8zM7 11.4L3.6 8 5 6.6l2 2 4-4L12.4 6 7 11.4z" />
                          </svg>
                        </div>
                        <!-- Content -->
                        <div>
                          <!-- Modal header -->
                          <div class="mb-2">
                            <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">Upgrade your Subscription?</div>
                          </div>
                          <!-- Modal content -->
                          <div class="text-sm mb-10">
                            <div class="space-y-2">
                              <p>Semper eget duis at tellus at urna condimentum mattis pellentesque lacus suspendisse faucibus interdum.</p>
                            </div>
                          </div>
                          <!-- Modal footer -->
                          <div class="flex flex-wrap justify-end space-x-2">
                            <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="successModalOpen = false">Cancel</button>
                            <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Yes, Upgrade it</button>
                          </div>
                        </div>
                      </div>
                    </ModalBlank>
                    <!-- End -->
                  </div>

                  <!-- Danger Modal -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="danger-modal" @click.stop="dangerModalOpen = true">Danger Modal</button>
                    <ModalBlank id="danger-modal" :modalOpen="dangerModalOpen" @close-modal="dangerModalOpen = false">
                      <div class="p-5 flex space-x-4">
                        <!-- Icon -->
                        <div class="w-10 h-10 rounded-full flex items-center justify-center shrink-0 bg-rose-100 dark:bg-rose-500/30">
                          <svg class="w-4 h-4 shrink-0 fill-current text-rose-500" viewBox="0 0 16 16">
                            <path d="M8 0C3.6 0 0 3.6 0 8s3.6 8 8 8 8-3.6 8-8-3.6-8-8-8zm0 12c-.6 0-1-.4-1-1s.4-1 1-1 1 .4 1 1-.4 1-1 1zm1-3H7V4h2v5z" />
                          </svg>
                        </div>
                        <!-- Content -->
                        <div>
                          <!-- Modal header -->
                          <div class="mb-2">
                            <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">Delete 1 customer?</div>
                          </div>
                          <!-- Modal content -->
                          <div class="text-sm mb-10">
                            <div class="space-y-2">
                              <p>Semper eget duis at tellus at urna condimentum mattis pellentesque lacus suspendisse faucibus interdum.</p>
                            </div>
                          </div>
                          <!-- Modal footer -->
                          <div class="flex flex-wrap justify-end space-x-2">
                            <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="dangerModalOpen = false">Cancel</button>
                            <button class="btn-sm bg-rose-500 hover:bg-rose-600 text-white">Yes, Delete it</button>
                          </div>
                        </div>
                      </div>
                    </ModalBlank>
                    <!-- End -->
                  </div>

                  <!-- Info Modal -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="info-modal" @click.stop="infoModalOpen = true">Info Modal</button>
                    <ModalBlank id="info-modal" :modalOpen="infoModalOpen" @close-modal="infoModalOpen = false">
                      <div class="p-5 flex space-x-4">
                        <!-- Icon -->
                        <div class="w-10 h-10 rounded-full flex items-center justify-center shrink-0 bg-indigo-100 dark:bg-indigo-500/30">
                          <svg class="w-4 h-4 shrink-0 fill-current text-indigo-500" viewBox="0 0 16 16">
                            <path d="M8 0C3.6 0 0 3.6 0 8s3.6 8 8 8 8-3.6 8-8-3.6-8-8-8zm1 12H7V7h2v5zM8 6c-.6 0-1-.4-1-1s.4-1 1-1 1 .4 1 1-.4 1-1 1z" />
                          </svg>
                        </div>
                        <!-- Content -->
                        <div>
                          <!-- Modal header -->
                          <div class="mb-2">
                            <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">Create new Event?</div>
                          </div>
                          <!-- Modal content -->
                          <div class="text-sm mb-10">
                            <div class="space-y-2">
                              <p>Semper eget duis at tellus at urna condimentum mattis pellentesque lacus suspendisse faucibus interdum.</p>
                            </div>
                          </div>
                          <!-- Modal footer -->
                          <div class="flex flex-wrap justify-end space-x-2">
                            <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="infoModalOpen = false">Cancel</button>
                            <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Yes, Create it</button>
                          </div>
                        </div>
                      </div>
                    </ModalBlank>
                    <!-- End -->
                  </div>                                    
                  
                </div>
              </div>
              
              <!-- Product -->
              <div>
                <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold mb-6">Product</h2>
                <div class="flex flex-wrap items-center -m-1.5">

                  <!-- Send Feedback -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="feedback-modal" @click.stop="feedbackModalOpen = true">Send Feedback</button>
                    <ModalBasic id="feedback-modal" :modalOpen="feedbackModalOpen" @close-modal="feedbackModalOpen = false" title="Send Feedback">
                      <!-- Modal content -->
                      <div class="px-5 py-4">
                        <div class="text-sm">
                          <div class="font-medium text-slate-800 dark:text-slate-100 mb-3">Let us know what you think 🙌</div>
                        </div>
                        <div class="space-y-3">
                          <div>
                            <label class="block text-sm font-medium mb-1" for="name">Name <span class="text-rose-500">*</span></label>
                            <input id="name" class="form-input w-full px-2 py-1" type="text" required />
                          </div>
                          <div>
                            <label class="block text-sm font-medium mb-1" for="email">Email <span class="text-rose-500">*</span></label>
                            <input id="email" class="form-input w-full px-2 py-1" type="email" required />
                          </div>
                          <div>
                            <label class="block text-sm font-medium mb-1" for="feedback">Message <span class="text-rose-500">*</span></label>
                            <textarea id="feedback" class="form-textarea w-full px-2 py-1" rows="4" required></textarea>
                          </div>
                        </div>
                      </div>
                      <!-- Modal footer -->
                      <div class="px-5 py-4 border-t border-slate-200 dark:border-slate-700">
                        <div class="flex flex-wrap justify-end space-x-2">
                          <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="feedbackModalOpen = false">Cancel</button>
                          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Send</button>
                        </div>
                      </div>
                    </ModalBasic>
                    <!-- End -->
                  </div>

                  <!-- Newsletter -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="newsletter-modal" @click.stop="newsletterModalOpen = true">Newsletter</button>
                    <ModalAction id="newsletter-modal" :modalOpen="newsletterModalOpen" @close-modal="newsletterModalOpen = false">
                      <!-- Modal header -->
                      <div class="mb-2 text-center">
                        <!-- Icon -->
                        <div class="mb-3">
                          <svg class="inline-flex w-12 h-12 rounded-full shrink-0 fill-current" viewBox="0 0 48 48">
                            <rect class="text-indigo-100 dark:text-indigo-500/30" width="48" height="48" rx="24" />
                            <path class="text-indigo-300" d="M19 16h7a8 8 0 110 16h-7V16z" />
                            <path class="text-indigo-500" d="M26 24l-7-6v5h-8v2h8v5z" />
                          </svg>
                        </div>
                        <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">Subscribe to the Newsletter!</div>
                      </div>
                      <!-- Modal content -->
                      <div class="text-center">
                        <div class="text-sm mb-6">
                          Semper eget duis at tellus at urna condimentum mattis pellentesque lacus suspendisse faucibus interdum.
                        </div>
                        <!-- Submit form -->
                        <form class="flex max-w-sm m-auto">
                          <div class="grow mr-2">
                            <label for="subscribe-form" class="sr-only">Leave your Email</label>
                            <input id="subscribe-form" class="form-input w-full px-2 py-1" type="email" />
                          </div>
                          <button type="submit" class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white whitespace-nowrap">Subscribe</button>
                        </form>
                        <div class="text-xs text-slate-500 italic mt-3">
                          I respect your privacy. No spam. Unsubscribe at any time!
                        </div>
                      </div>
                    </ModalAction>
                    <!-- End -->
                  </div>

                  <!-- Announcement -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="announcement-modal" @click.stop="announcementModalOpen = true">Announcement</button>
                    <ModalAction id="announcement-modal" :modalOpen="announcementModalOpen" @close-modal="announcementModalOpen = false">
                      <!-- Modal header -->
                      <div class="mb-2 text-center">
                        <!-- Icon -->
                        <div class="inline-flex rounded-full bg-gradient-to-b from-slate-100 to-slate-200 dark:from-slate-700/30 dark:to-slate-700 mb-2">
                          <img src="../../images/announcement-icon.svg" width="80" height="80" alt="Announcement" />
                        </div>
                        <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">You Unlocked Level 2!</div>
                      </div>
                      <!-- Modal content -->
                      <div class="text-center">
                        <div class="text-sm mb-5">
                          Semper eget duis at tellus at urna condimentum mattis pellentesque lacus suspendisse faucibus interdum.
                        </div>
                        <!-- CTAs -->
                        <div class="space-y-3">
                          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Claim your Reward -&gt;</button>
                          <div>
                            <a class="font-medium text-sm text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0" @click.prevent="announcementModalOpen = false">Not Now!</a>
                          </div>
                        </div>
                      </div>
                    </ModalAction>
                    <!-- End -->
                  </div> 

                  <!-- Integration -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="integration-modal" @click.stop="integrationModalOpen = true">Integration</button>
                    <ModalAction id="integration-modal" :modalOpen="integrationModalOpen" @close-modal="integrationModalOpen = false">
                      <!-- Modal header -->
                      <div class="mb-5 text-center">
                        <!-- Icons -->
                        <div class="inline-flex items-center justify-center space-x-3 mb-4">
                          <!-- Mosaic logo -->
                          <svg width="48" height="48" viewBox="0 0 32 32">
                            <defs>
                              <linearGradient x1="28.538%" y1="20.229%" x2="100%" y2="108.156%" id="nl-a">
                                <stop stop-color="#A5B4FC" stop-opacity="0" offset="0%" />
                                <stop stop-color="#A5B4FC" offset="100%" />
                              </linearGradient>
                              <linearGradient x1="88.638%" y1="29.267%" x2="22.42%" y2="100%" id="nl-b">
                                <stop stop-color="#38BDF8" stop-opacity="0" offset="0%" />
                                <stop stop-color="#38BDF8" offset="100%" />
                              </linearGradient>
                            </defs>
                            <rect fill="#6366F1" width="32" height="32" rx="16" />
                            <path d="M18.277.16C26.035 1.267 32 7.938 32 16c0 8.837-7.163 16-16 16a15.937 15.937 0 01-10.426-3.863L18.277.161z" fill="#4F46E5" />
                            <path d="M7.404 2.503l18.339 26.19A15.93 15.93 0 0116 32C7.163 32 0 24.837 0 16 0 10.327 2.952 5.344 7.404 2.503z" fill="url(#nl-a)" />
                            <path d="M2.223 24.14L29.777 7.86A15.926 15.926 0 0132 16c0 8.837-7.163 16-16 16-5.864 0-10.991-3.154-13.777-7.86z" fill="url(#nl-b)" />
                          </svg>
                          <!-- Arrows -->
                          <svg class="h-4 w-4 fill-current text-slate-400" viewBox="0 0 16 16">
                            <path d="M5 3V0L0 4l5 4V5h8a1 1 0 000-2H5zM11 11H3a1 1 0 000 2h8v3l5-4-5-4v3z" />
                          </svg>
                          <!-- Cruip logo -->
                          <svg width="48" height="48" viewBox="0 0 48 48">
                            <rect class="fill-slate-100 dark:fill-indigo-500/30" width="48" height="48" rx="24" />
                            <path d="M34 24c0-1.38-1.126-2.5-2.515-2.5A2.507 2.507 0 0028.97 24c0 1.38 1.126 2.5 2.515 2.5A2.507 2.507 0 0034 24" fill="#34D399" />
                            <path d="M31.112 31.07a10.024 10.024 0 01-4.582 2.615c-.8.205-1.64.315-2.506.315a10.007 10.007 0 01-7.553-3.426A9.943 9.943 0 0114 24c0-2.517.932-4.816 2.471-6.574A10.007 10.007 0 0124.024 14a10.024 10.024 0 017.088 2.93l-3.544 3.535A5.003 5.003 0 0024.024 19a5.006 5.006 0 00-5.012 5l.001.13A5.007 5.007 0 0024.024 29c1.384 0 2.637-.56 3.544-1.465l3.544 3.536z" fill="#6366F1" />
                          </svg>
                        </div>
                        <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">Connect Mosaic with your Cruip account</div>
                      </div>
                      <!-- Modal content -->
                      <div class="text-sm mb-5">
                        <div class="font-medium text-slate-800 dark:text-slate-100 mb-3">Mosaic would like to:</div>
                        <ul class="space-y-2 mb-5">
                          <li class="flex items-center">
                            <svg class="w-3 h-3 shrink-0 fill-current text-emerald-500 mr-2" viewBox="0 0 12 12">
                              <path d="M10.28 1.28L3.989 7.575 1.695 5.28A1 1 0 00.28 6.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28 1.28z" />
                            </svg>
                            <div>Lorem ipsum dolor sit amet</div>
                          </li>
                          <li class="flex items-center">
                            <svg class="w-3 h-3 shrink-0 fill-current text-emerald-500 mr-2" viewBox="0 0 12 12">
                              <path d="M10.28 1.28L3.989 7.575 1.695 5.28A1 1 0 00.28 6.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28 1.28z" />
                            </svg>
                            <div>Semper eget duis at tellus at urna</div>
                          </li>
                          <li class="flex items-center">
                            <svg class="w-3 h-3 shrink-0 fill-current text-emerald-500 mr-2" viewBox="0 0 12 12">
                              <path d="M10.28 1.28L3.989 7.575 1.695 5.28A1 1 0 00.28 6.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28 1.28z" />
                            </svg>
                            <div>Lorem ipsum dolor sit amet</div>
                          </li>
                          <li class="flex items-center">
                            <svg class="w-3 h-3 shrink-0 fill-current text-emerald-500 mr-2" viewBox="0 0 12 12">
                              <path d="M10.28 1.28L3.989 7.575 1.695 5.28A1 1 0 00.28 6.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28 1.28z" />
                            </svg>
                            <div>Suspendisse faucibus interdum</div>
                          </li>
                        </ul>
                        <div class="text-xs text-slate-500">By clicking on Allow access, you authorize Mosaic to use your information in accordance with its <a class="text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">Privacy Policy</a>. You can stop it at any time on the integrations page of your Mosaic account.</div>
                      </div>
                      <!-- Modal footer -->
                      <div class="flex flex-wrap justify-end space-x-2">
                        <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="integrationModalOpen = false">Cancel</button>
                        <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Allow Access</button>
                      </div>
                    </ModalAction>
                    <!-- End -->
                  </div>
                  
                  <!-- What's New -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="news-modal" @click.stop="newsModalOpen = true">What's New</button>
                    <ModalBlank id="news-modal" :modalOpen="newsModalOpen" @close-modal="newsModalOpen = false">
                      <div class="relative">
                        <img class="w-full" src="../../images/modal-image.jpg" width="460" height="200" alt="New on Mosaic" />
                        <!-- Close button -->
                        <button class="absolute top-0 right-0 mt-5 mr-5 text-slate-50 hover:text-white" @click.stop="newsModalOpen = false">
                          <div class="sr-only">Close</div>
                          <svg class="w-4 h-4 fill-current">
                            <path d="M7.95 6.536l4.242-4.243a1 1 0 111.415 1.414L9.364 7.95l4.243 4.242a1 1 0 11-1.415 1.415L7.95 9.364l-4.243 4.243a1 1 0 01-1.414-1.415L6.536 7.95 2.293 3.707a1 1 0 011.414-1.414L7.95 6.536z" />
                          </svg>
                        </button>
                      </div>
                      <div class="p-5">
                        <!-- Modal header -->
                        <div class="mb-2">
                          <div class="mb-3">
                            <div class="text-xs inline-flex font-medium bg-indigo-100 dark:bg-indigo-500/30 text-indigo-600 dark:text-indigo-400 rounded-full text-center px-2.5 py-1">New on Mosaic</div>
                          </div>
                          <div class="text-lg font-semibold text-slate-800 dark:text-slate-100">Help your team work faster with X 🏃‍♂️</div>
                        </div>
                        <!-- Modal content -->
                        <div class="text-sm mb-5">
                          <div class="space-y-2">
                            <p>You might not be aware of this fact, but every frame, digital video, canvas, responsive design, and image often has a rectangular shape that is exceptionally precise in proportion (or ratio).</p>
                            <p>The ratio has to be well-defined to make shapes fit into different and distinct mediums, such as computer, movies, television and camera screens.</p>
                          </div>
                        </div>
                        <!-- Modal footer -->
                        <div class="flex flex-wrap justify-end space-x-2">
                          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white" @click.stop="newsModalOpen = false">Cool, I Got it</button>
                        </div>
                      </div>                      
                    </ModalBlank>
                    <!-- End -->
                  </div>
                  
                  <!-- Change your Plan -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="feedback-modal" @click.stop="planModalOpen = true">Change your Plan</button>
                    <ModalBasic id="feedback-modal" :modalOpen="planModalOpen" @close-modal="planModalOpen = false" title="Change your Plan">
                      <!-- Modal content -->
                      <div class="px-5 pt-4 pb-1">
                        <div class="text-sm">
                          <div class="mb-4">Upgrade or downgrade your plan:</div>
                          <!-- Options -->
                          <ul class="space-y-2 mb-4">
                            <li>
                              <button class="w-full h-full text-left py-3 px-4 rounded bg-white dark:bg-slate-800 border-2 border-indigo-400 dark:border-indigo-500 shadow-sm duration-150 ease-in-out">
                                <div class="flex items-center">
                                  <div class="w-4 h-4 border-4 bg-white border-indigo-500 rounded-full mr-3"></div>
                                  <div class="grow">
                                    <div class="flex flex-wrap items-center justify-between mb-0.5">
                                      <span class="font-medium text-slate-800 dark:text-slate-100">Mosaic Light <span class="text-xs italic text-slate-500 align-top">Current Plan</span></span>
                                      <span class="text-slate-600"><span class="font-medium text-emerald-600">$39.00</span>/mo</span>
                                    </div>
                                    <div class="text-sm">2 MB · 1 member · 500 block limits</div>
                                  </div>
                                </div>
                              </button>
                            </li>
                            <li>
                              <button class="w-full h-full text-left py-3 px-4 rounded bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm duration-150 ease-in-out">
                                <div class="flex items-center">
                                  <div class="w-4 h-4 border-2 border-slate-300 dark:border-slate-600 rounded-full mr-3"></div>
                                  <div class="grow">
                                    <div class="flex flex-wrap items-center justify-between mb-0.5">
                                      <span class="font-semibold text-slate-800 dark:text-slate-100">Mosaic Basic <span class="text-xs italic text-indigo-500 align-top">Best Value ✨</span></span>
                                      <span class="text-slate-600"><span class="font-medium text-emerald-600">$59.00</span>/mo</span>
                                    </div>
                                    <div class="text-sm">5 MB · 2 members · 1000 block limits</div>
                                  </div>
                                </div>
                              </button>
                            </li>
                            <li>
                              <button class="w-full h-full text-left py-3 px-4 rounded bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 shadow-sm duration-150 ease-in-out">
                                <div class="flex items-center">
                                  <div class="w-4 h-4 border-2 border-slate-300 dark:border-slate-600 rounded-full mr-3"></div>
                                  <div class="grow">
                                    <div class="flex flex-wrap items-center justify-between mb-0.5">
                                      <span class="font-semibold text-slate-800 dark:text-slate-100">Mosaic Plus</span>
                                      <span class="text-slate-600"><span class="font-medium text-emerald-600">$79.00</span>/mo</span>
                                    </div>
                                    <div class="text-sm">10 MB · 5 members · Unlimited block limits</div>
                                  </div>
                                </div>
                              </button>
                            </li>
                          </ul>
                          <div class="text-xs text-slate-500">Your workspace’s Mosaic Light Plan is set to $39 per month and will renew on August 9, 2021.</div>
                        </div>
                      </div>
                      <!-- Modal footer -->
                      <div class="px-5 py-4">
                        <div class="flex flex-wrap justify-end space-x-2">
                          <button class="btn-sm border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 text-slate-600 dark:text-slate-300" @click.stop="planModalOpen = false">Cancel</button>
                          <button class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white">Change Plan</button>
                        </div>
                      </div>
                    </ModalBasic>
                    <!-- End -->
                  </div>

                  <!-- Quick Find -->
                  <div class="m-1.5">
                    <!-- Start -->
                    <button class="btn bg-indigo-500 hover:bg-indigo-600 text-white" aria-controls="quick-find-modal" @click.stop="searchModalOpen = true">Quick Find</button>
                    <ModalSearch id="quick-find-modal" searchId="quick-find" :modalOpen="searchModalOpen" @open-modal="searchModalOpen = true" @close-modal="searchModalOpen = false" />
                    <!-- End -->
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
import ModalBasic from '../../components/ModalBasic.vue'
import ModalCookies from '../../components/ModalCookies.vue'
import ModalBlank from '../../components/ModalBlank.vue'
import ModalAction from '../../components/ModalAction.vue'
import ModalSearch from '../../components/ModalSearch.vue'

export default {
  name: 'ModalPage',
  components: {
    Sidebar,
    Header,
    ModalBasic,
    ModalCookies,
    ModalBlank,
    ModalAction,
    ModalSearch,
  },
  setup() {

    const sidebarOpen = ref(false)
    const basicModalOpen = ref(false)
    const scrollbarModalOpen = ref(false)
    const cookiesModalOpen = ref(false)
    const successModalOpen = ref(false)
    const dangerModalOpen = ref(false)
    const infoModalOpen = ref(false)
    const feedbackModalOpen = ref(false)
    const newsletterModalOpen = ref(false)
    const announcementModalOpen = ref(false)
    const integrationModalOpen = ref(false)
    const newsModalOpen = ref(false)
    const planModalOpen = ref(false)
    const searchModalOpen = ref(false)

    return {
      sidebarOpen,
      basicModalOpen,
      scrollbarModalOpen,
      cookiesModalOpen,
      successModalOpen,
      dangerModalOpen,
      infoModalOpen,
      feedbackModalOpen,
      newsletterModalOpen,
      announcementModalOpen,
      integrationModalOpen,
      newsModalOpen,
      planModalOpen,
      searchModalOpen,
    }  
  }
}
</script>