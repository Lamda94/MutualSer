<template>
  <Alcancia/>
</template>

<script>
import Alcancia from './components/Alcancia.vue';

export default {
  name: 'App',
  components: {
    Alcancia
  }
}
</script>

<style>
  body{
    padding-top: 80px;
    background: #ABB2B9;
  }
  th{
    color: white !important;
    background:#212F3D !important;
    border: none !important;
  }

  .p-datatable-wrapper{
    border: solid 1px #212F3D;
    /*border-left: none;*/
  }

  td{
    border-left: solid 1px #212F3D !important;
  }
</style>
