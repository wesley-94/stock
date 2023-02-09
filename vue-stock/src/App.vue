<template>
    <TheHeader></TheHeader> <!-- Header Component -->
<!--  <nav>-->
<!--    <router-link to="/">Home</router-link> |-->
<!--    <router-link to="/about">About</router-link>-->
<!--  </nav>-->
    <router-view/>
    <TheFooter></TheFooter>
</template>

<script>
import TheHeader from '@/components/layouts/TheHeader.vue';
import TheFooter from '@/components/layouts/TheFooter.vue';

export default {
  name: 'App',
  components: {
    TheHeader,
    TheFooter,
  }
}

</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
} */

.container {
  max-width: 940px;
}
</style>
