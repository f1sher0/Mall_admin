<template>
  <div class="grow px-4 sm:px-6 md:px-5 py-6">
    <!-- Chat msg -->
    <div class="flex items-start mb-4 last:mb-0">
      <img class="rounded-full mr-4" src="../../images/user-40-11.jpg" width="40" height="40" alt="User 01" />
      <div>
        <div class="text-sm bg-white dark:bg-slate-800 text-slate-800 dark:text-slate-100 p-3 rounded-lg rounded-tl-none border border-slate-200 dark:border-slate-700 shadow-md mb-1">
          Can anyone help? I have a question about Acme Professional
        </div>
        <div class="flex items-center justify-between">
          <div class="text-xs text-slate-500 font-medium">2:40 PM</div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'MessagesBody',
}
</script>