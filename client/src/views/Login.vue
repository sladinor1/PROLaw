<template>
  <div class="form-container">
    <h2>Crear cuenta</h2>

    <div id='form' class="p-fluid p-formgrid p-grid">

      <div class="p-field p-col-12 p-md-6">
        <InputText id="email" type="email" v-model="usuario.email" placeholder="Correo Electrónico"/>
        <label class="text-danger" v-if="usuario.email">{{validarEmail()}}</label>
      </div>
      <br>
      <div>
        <Password v-model="usuario.pass" placeholder="Contraseña" toggleMask></Password>
        <label class="text-danger" v-if="usuario.pass">{{validarContraseña()}}</label>
      </div>
      <br>
      <div>
        <Dropdown v-model="selectedid" :options="idtypes" optionLabel="name" placeholder="Tipo de documento"></Dropdown>
      </div>
      <br>
      <div class="p-field p-col-12 p-md-6">
        <InputText id="id" type="text" v-model="usuario.id" placeholder="Número de documento"/>
        <label class="text-danger" v-if="usuario.id">{{validarId()}}</label>
      </div>
      <br>
      <div class="p-field p-col-12 p-md-6">
        <InputText id="name" type="text" v-model="usuario.names" placeholder="Nombre(s)"/>
        <label class="text-danger" v-if="usuario.names">{{validarNombres()}}</label>
      </div>
      <br>
      <div class="p-field p-col-12 p-md-6">
        <InputText id="ln" type="text" v-model="usuario.lastnames" placeholder="Apellidos"/>
        <label class="text-danger" v-if="usuario.lastnames">{{validarApellidos()}}</label>
      </div>
      <br>
      <div class="p-field p-col-12 p-md-6">
        <InputText id="phone" type="text" v-model="usuario.phone" placeholder="Número de teléfono"/>
        <label class="text-danger" v-if="usuario.phone">{{validarTelefono()}}</label>
      </div>
      <br>
      <div>
        <Dropdown v-model="selected" :options="cities" optionLabel="label" optionGroupLabel="label" 
        optionGroupChildren="items" placeholder="Departamento y Ciudad"></Dropdown>
      </div>  
      <br>
      <div class="">
        <button class="botonRegistro" v-on:click="registrar">Registrarse</button>
      </div>
    </div>
  </div>
</template>

<script>
import UserController from "../controller/UserController.js";
export default{
    name: 'Login',
    data () {
        return {
            usuario: {
                email: '',
                password: ''
            },
        }
    },
    userController : null,
    created () {
        this.userController = new UserController();
    },
    methods: {
        getLogin: function() {
            this.$root.inside = true;
            console.log(this.$root.inside);
            try{ this.userController.login(this.usuario).then(data => {
                if(data.data == true){
                    this.$root.inside = true;
                    this.$root.user = this.usuario.email;
                }
            })}catch{console.log("Error Connection");}
        },
    },
}
</script>

<style>
</style>
