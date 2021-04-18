<template>
  <div >
    <div v-if="!inside">
      <TabMenu :model="items" />
      <router-view />
    </div>
    <div v-else>
      <TabMenu :model="itemins" />
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return {
      inside: true,
      user: '',
      items: [
        {label: 'Home', icon: 'pi pi-fw pi-home', to: '/'},
        {label: 'Registrarse', icon: 'pi pi-fw pi-user-plus', to: '/Register'},
        {label: 'Iniciar sesion', icon: 'pi pi-fw pi-user', to: '/login'},
      ],
      itemins: [
        {label: 'Home', icon: 'pi pi-fw pi-home', to: '/'},
        {label: 'Registrarse', icon: 'pi pi-fw pi-user-plus', to: '/Register'},
        {label: 'Iniciar sesion', icon: 'pi pi-fw pi-sign-in', to: '/login'},
        {label: this.user, icon: 'pi pi-fw pi-user', to: ''},
        {label: 'Logout', icon: 'pi pi-fw pi-sign-out', to: '/login'},
      ]
    }
  },
  methods: {
  },
  components: {
  }
}
</script>

<style>
</style>
