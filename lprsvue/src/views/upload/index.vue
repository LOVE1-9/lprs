<template>
  <div class="app-container">
    <p>{{ msg }}</p>
    <v-uploader :preview-width="400" :preview-height="300" @done="uploadDone" />
  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  methods: {
    uploadDone(file) {
      this.msg = file[0].plate
    }
  }
}

</script>
