<template>
  <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/Register">Registrarse</router-link> |
      <router-link to="/login">Inicia sesion</router-link>
      <div class="col-12 bg-light">
        <router-view />
      </div>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
</style>
