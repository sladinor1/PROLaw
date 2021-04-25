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
<<<<<<< HEAD
        {label: 'Registrarse', icon: 'pi pi-fw pi-user-plus', to: '/Register'},
        {label: 'Iniciar sesion', icon: 'pi pi-fw pi-sign-in', to: '/login'},
        {label: this.user, icon: 'pi pi-fw pi-user', to: ''},
        {label: 'Logout', icon: 'pi pi-fw pi-sign-out', command: () => {this.inside=false;}},
=======
        {label: this.user , icon: 'pi pi-fw pi-user', to: ''},
        {label: 'Logout', icon: 'pi pi-fw pi-sign-out', command: () => {
          this.user = '';
          this.inside=false;}},
>>>>>>> aba8eb87382c1ab9739c4912111e65d40b0601b3
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
h2, label {
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
    margin-bottom: 0.83em;
    font-weight: bold;
  }

a{
    text-align: end;
    font-size: medium;
}

.bg{    
    width: 100%;
    height: 100vh; 
    background-size: 100%;
}

.form-container{
    margin: auto;
    width: 40%;
    margin-top: 2%;
    top: 150vh;
    background: #fff;
    padding: 30px;
    border-radius: 5px;
    box-shadow: 0px 0px 5px 0px #000;

}

ul{
    font-weight: bold;
    font-size:larger;

}

.botonInicioSesion, .botonRegistro{
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-weight: bold;
  display: block;
  font-size: 15px;
  
  cursor: pointer;

  background-color: rgb(13, 110, 253);

  border-radius: 14px;
  margin-left: auto;
  margin-right: auto;
}
</style>