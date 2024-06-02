<template>
    <span v-html="highlightedText"></span>
  </template>
  
  <script>
  export default {
    props: {
      text: {
        type: String,
        required: true
      },
      query: {
        type: String,
        required: true
      }
    },
    computed: {
      highlightedText() {
        if (!this.query) {
          return this.text;
        }
        const regex = new RegExp(`(${this.query})`, 'gi');
        return this.text.replace(regex, '<mark>$1</mark>');
      }
    }
  }
  </script>
  
  <style scoped>
  mark {
    background-color: yellow;
  }
  </style>
  