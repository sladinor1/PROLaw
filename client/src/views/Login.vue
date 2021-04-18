<template>
  <div class="p-fluid p-formgrid p-grid">
    <h2>Iniciar sesión</h2>
    <p>Ingresa la siguiente información para acceder</p>
    <div class="p-field p-col-12 p-md-6">
        <label for="email">Correo eléctronico<span class="text-danger">*</span></label>
        <InputText id="email" type="email" v-model="usuario.email" placeholder="Tu dirección de correo electónico"/>
    </div>
    <div>
        <label>Contraseña<span class="text-danger">*</span></label>
        <Password v-model="usuario.password" toggleMask></Password>
    </div>
    <p><router-link to="/Register" tag="button" class="btn btn-primary" type="submit">¿Olvidaste tu contraseña?</router-link></p>
    <a>¿No tienes cuenta? </a><router-link to="/Register" tag="button" class="btn btn-primary" type="submit">Registrarse</router-link> 
    <div class="col-12 bg-light">
        <router-view />
    </div>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Recordarme</label>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" v-on:click="getLogin">Iniciar Sesión</button>
    </div>
    <div v-if="inside">
        <label>Bienvenido {{usuario.email}}</label><br><br>
        <router-link to="">
            <span v-on:click="logOut">Cerrar sesion</span>
        </router-link>
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
        console.log(this.$root.inside);
    },
    methods: {
        getLogin: function() {
            try{ this.userController.login(this.usuario).then(data => {
                if(data.data == true){
                    this.$root.inside = true;
                    this.$root.user = this.usuario.email;
                }
            })}catch{console.log("Error Connection");}
        },
        logOut: function(){
            this.usuario.email ='';
            this.usuario.password='';
            this.$root.inside = false;
        }
    },
}
</script>

<style>
</style>
