<template>
  <article class="bg-white dark:bg-slate-800 shadow-md rounded border border-slate-200 dark:border-slate-700 p-5">
    <!-- Breadcrumbs -->
    <div class="mb-2">
      <ul class="inline-flex flex-wrap text-sm font-medium">
        <li class="flex items-center">
          <router-link class="text-slate-500 dark:text-slate-400 hover:text-indigo-500 dark:hover:text-indigo-500" to="/community/forum">Home</router-link>
          <svg class="h-4 w-4 fill-current text-slate-400 dark:text-slate-500 mx-2" viewBox="0 0 16 16">
            <path d="M6.6 13.4L5.2 12l4-4-4-4 1.4-1.4L12 8z" />
          </svg>
        </li>
        <li class="flex items-center">
          <a class="text-slate-500 dark:text-slate-400 hover:text-indigo-500 dark:hover:text-indigo-500" href="#0">Discussion</a>
        </li>
      </ul>
    </div>
    <!-- Header -->
    <header class="pb-4">
      <!-- Title -->
      <div class="flex items-start space-x-3 mb-3">
        <h2 class="text-2xl text-slate-800 dark:text-slate-100 font-bold">Besides Product Hunt, where else should I promote my new project? 🤔</h2>
        <!-- Upvote button -->
        <div class="shrink-0">
          <button class="text-xs font-semibold text-center h-12 w-12 border border-slate-200 dark:border-slate-700 hover:border-slate-300 dark:hover:border-slate-600 rounded-sm flex flex-col justify-center items-center">
            <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
              <path d="m0 6 6-6 6 6z" />
            </svg>
            <div>44</div>
          </button>
        </div>
      </div>
      <!-- Meta -->
      <div class="flex flex-wrap text-sm">
        <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
          <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">katemerlu</a>
        </div>
        <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
          <span class="text-slate-500">2h</span>
        </div>
        <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
          <span class="text-slate-500">17 Comments</span>
        </div>
      </div>
    </header>
    <!-- Content -->
    <div class="space-y-4 mb-6">
      <p>Looking for new ideas to get users, receive feedback, and increase exposure! Besides PH, where else do you showcase your product?</p>
      <p>Please advise 🙌</p>
    </div>
    <!-- Comment form -->
    <div>
      <div class="flex items-start space-x-3 mb-3">
        <img class="rounded-full shrink-0" src="../../images/user-40-02.jpg" width="40" height="40" alt="User 02" />
        <div class="grow">
          <label for="comment" class="sr-only">Write a comment…</label>
          <textarea id="comment" class="form-textarea w-full focus:border-slate-300" rows="4" placeholder="Write a comment…"></textarea>
        </div>
      </div>
      <div class="text-right">
        <button type="submit" class="btn-sm bg-indigo-500 hover:bg-indigo-600 text-white whitespace-nowrap">Reply -&gt;</button>
      </div>
    </div>
    <!-- Comments -->
    <div class="mt-4">
      <h3 class="font-semibold text-slate-800 dark:text-slate-100 mb-4">Comments</h3>
      <ul class="space-y-5">
        <!-- Comment -->
        <li class="relative pl-9 space-y-5">
          <!-- Comment wrapper -->
          <div class="flex items-start">
            <!-- Comment upvote -->
            <div class="absolute top-0 left-0">
              <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500">
                <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                  <path d="m0 6 6-6 6 6z" />
                </svg>
                <div>44</div>
              </button>
            </div>
            <!-- Comment content -->
            <div>
              <!-- Comment text -->
              <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                <p>We've also had the same question to be honest. And for Appy.com launch we decided to go with Twitter as a primary medium and then Product Hunt as the other one. And I have to say that it led to some great results as Twitter allows you to be super active and engage in many conversations.</p>
                <p>Also, users are there and everything is super active. So that will be my advice - invest time in Twitter</p>
              </div>
              <!-- Comment footer -->
              <div class="flex flex-wrap text-xs">
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="block mr-2" href="#0">
                    <img class="rounded-full" src="../../images/user-28-02.jpg" width="24" height="24" alt="User 02" />
                  </a>
                  <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">ekuplu89</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                </div>
              </div>
            </div>
          </div>
          <!-- Nested comments -->
          <ul class="space-y-5">
            <!-- Comment -->
            <li class="relative pl-9 space-y-5">
              <!-- Comment wrapper -->
              <div class="flex items-start">
                <!-- Comment upvote -->
                <div class="absolute top-0 left-0">
                  <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500">
                    <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                      <path d="m0 6 6-6 6 6z" />
                    </svg>
                    <div>2</div>
                  </button>
                </div>
                <!-- Comment content -->
                <div>
                  <!-- Comment text -->
                  <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                    <p>That's great advice, <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">@ekuplu89</a> 👏</p>
                  </div>
                  <!-- Comment footer -->
                  <div class="flex flex-wrap text-xs">
                    <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="block mr-2" href="#0">
                        <img class="rounded-full" src="../../images/user-28-05.jpg" width="24" height="24" alt="User 05" />
                      </a>
                      <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">ellielong</a>
                    </div>
                    <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                    </div>
                    <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                    </div>
                  </div>
                </div>
              </div>
            </li>
          </ul>
        </li>
        <!-- Comment -->
        <li class="relative pl-9 space-y-5">
          <!-- Comment wrapper -->
          <div class="flex items-start">
            <!-- Comment upvote -->
            <div class="absolute top-0 left-0">
              <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300">
                <svg class="inline-flex fill-indigo-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                  <path d="m0 6 6-6 6 6z" />
                </svg>
                <div>27</div>
              </button>
            </div>
            <!-- Comment content -->
            <div>
              <!-- Comment text -->
              <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                <p>If you are a SaaS product and are looking for early adopters, AppSumo seems to be a great place to list on. Most of the users there seem to be early-adopters. Life-time deals seem to be the norm there.</p>
              </div>
              <!-- Comment footer -->
              <div class="flex flex-wrap text-xs">
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="block mr-2" href="#0">
                    <img class="rounded-full" src="../../images/user-28-01.jpg" width="24" height="24" alt="User 01" />
                  </a>
                  <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">markcuttik</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                </div>
              </div>
            </div>
          </div>
        </li>
        <!-- Comment -->
        <li class="relative pl-9 space-y-5">
          <!-- Comment wrapper -->
          <div class="flex items-start">
            <!-- Comment upvote -->
            <div class="absolute top-0 left-0">
              <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500">
                <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                  <path d="m0 6 6-6 6 6z" />
                </svg>
                <div>24</div>
              </button>
            </div>
            <!-- Comment content -->
            <div>
              <!-- Comment text -->
              <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                <p>Thank you very much for all the people who are posting other alternatives! I will launch my free product design course in February and I will make a notion template with all this information! :)</p>
              </div>
              <!-- Comment footer -->
              <div class="flex flex-wrap text-xs">
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="block mr-2" href="#0">
                    <img class="rounded-full" src="../../images/user-28-09.jpg" width="24" height="24" alt="User 09" />
                  </a>
                  <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">davidp1</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                </div>
              </div>
            </div>
          </div>
          <!-- Nested comments -->
          <ul class="space-y-5">
            <!-- Comment -->
            <li class="relative pl-9 space-y-5">
              <!-- Comment wrapper -->
              <div class="flex items-start">
                <!-- Comment upvote -->
                <div class="absolute top-0 left-0">
                  <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500">
                    <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                      <path d="m0 6 6-6 6 6z" />
                    </svg>
                    <div>2</div>
                  </button>
                </div>
                <!-- Comment content -->
                <div>
                  <!-- Comment text -->
                  <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                    <p>That sounds like an excellent idea. I'd love to take a look when you're ready!</p>
                  </div>
                  <!-- Comment footer -->
                  <div class="flex flex-wrap text-xs">
                    <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="block mr-2" href="#0">
                        <img class="rounded-full" src="../../images/user-28-05.jpg" width="24" height="24" alt="User 05" />
                      </a>
                      <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">ellielong</a>
                    </div>
                    <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                    </div>
                    <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                      <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                    </div>
                  </div>
                </div>
              </div>
              <!-- Nested comments -->
              <ul class="space-y-5">
                <!-- Comment -->
                <li class="relative pl-9 space-y-5">
                  <!-- Comment wrapper -->
                  <div class="flex items-start">
                    <!-- Comment upvote -->
                    <div class="absolute top-0 left-0">
                      <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500">
                        <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                          <path d="m0 6 6-6 6 6z" />
                        </svg>
                        <div>1</div>
                      </button>
                    </div>
                    <!-- Comment content -->
                    <div>
                      <!-- Comment text -->
                      <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                        <p>Expect it! 👊</p>
                      </div>
                      <!-- Comment footer -->
                      <div class="flex flex-wrap text-xs">
                        <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                          <a class="block mr-2" href="#0">
                            <img class="rounded-full" src="../../images/user-28-09.jpg" width="24" height="24" alt="User 09" />
                          </a>
                          <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">davidp1</a>
                        </div>
                        <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                          <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                        </div>
                        <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                          <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </li>
        <!-- Comment -->
        <li class="relative pl-9 space-y-5">
          <!-- Comment wrapper -->
          <div class="flex items-start">
            <!-- Comment upvote -->
            <div class="absolute top-0 left-0">
              <button class="text-xs font-semibold text-left w-6 rounded-sm flex flex-col justify-center items-center text-slate-600 dark:text-slate-300 hover:text-indigo-500 dark:hover:text-indigo-500">
                <svg class="inline-flex fill-slate-400 dark:fill-slate-500 mt-1.5 mb-1.5" width="12" height="6" xmlns="http://www.w3.org/2000/svg">
                  <path d="m0 6 6-6 6 6z" />
                </svg>
                <div>19</div>
              </button>
            </div>
            <!-- Comment content -->
            <div>
              <!-- Comment text -->
              <div class="grow text-sm text-slate-800 dark:text-slate-100 space-y-2 mb-2">
                <p>Social Media (channels based on your target audience), and Slack channels</p>
              </div>
              <!-- Comment footer -->
              <div class="flex flex-wrap text-xs">
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="block mr-2" href="#0">
                    <img class="rounded-full" src="../../images/user-28-10.jpg" width="24" height="24" alt="User 10" />
                  </a>
                  <a class="font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400" href="#0">patrick2</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Reply</a>
                </div>
                <div class="flex items-center after:block after:content-['·'] last:after:content-[''] after:text-sm after:text-slate-400 dark:after:text-slate-600 after:px-2">
                  <a class="font-medium text-slate-500 hover:text-slate-600 dark:hover:text-slate-400" href="#0">Share</a>
                </div>
              </div>
            </div>
          </div>
        </li>
      </ul>
      <!-- View more link -->
      <div class="text-center mt-5">
        <button class="text-sm font-medium text-indigo-500 hover:text-indigo-600 dark:hover:text-indigo-400">View More Comments</button>
      </div>
    </div>
  </article>
</template>

<script>
export default {
  name: 'ForumEntry',
}
</script>