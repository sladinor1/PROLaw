<template>
  <div >
    <div v-if="!inside">
      <Menubar :model="items">
        <template #start>
          <img alt="logo" src="../src/assets/logo.jpg" height="40" class="p-mr-2">
        </template>
        <template #end>

        </template>
      </Menubar>
      <router-view />
    </div>
    <div v-else>
      <Menubar :model="itemins">
        <template #start>
          <img alt="logo" src="../src/assets/logo.jpg" height="40" class="p-mr-2">
        </template>
        <template #end>

        </template>
      </Menubar>
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

  },
  components: {
  }
}
</script>

<style>
</style>
