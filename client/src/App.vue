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
      inside: false,
      user: '',
      items: [
        {label: 'Home', icon: 'pi pi-fw pi-home', to: '/'},
        {label: 'Registrarse', icon: 'pi pi-fw pi-user-plus', to: '/Register'},
        {label: 'Iniciar sesion', icon: 'pi pi-fw pi-sign-in', to: '/login'},
      ],
      itemins: [
        {label: 'Home', icon: 'pi pi-fw pi-home', to: '/'},
        {label: 'Registrarse', icon: 'pi pi-fw pi-user-plus', to: '/Register'},
        {label: 'Iniciar sesion', icon: 'pi pi-fw pi-sign-in', to: '/login'},
        {label: this.user, icon: 'pi pi-fw pi-user', to: ''},
        {label: 'Logout', icon: 'pi pi-fw pi-sign-out', command: () => {this.inside=false;}},
      ]
    }
  },
  methods: {
    logout: function(){
      this.inside=false;
    }
  },
  components: {
  }
}
</script>

<style>
</style>
