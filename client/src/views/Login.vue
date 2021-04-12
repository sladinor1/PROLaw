<template>
  <div>
    <h2>Iniciar sesión</h2>
    <p>Ingresa la siguiente información para acceder</p>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Correo eléctronico<span class="text-danger">*</span></label>
        <input type="email" v-model="usuario.email" placeholder="Tu dirección de correo electónico">                          
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Contraseña<span class="text-danger">*</span></label>
        <input type="password" v-model="usuario.password" placeholder="Ingresa tu contraseña">
    </div>      
    <a href="#">¿Olvidaste tu contraseña?</a>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Recordarme</label>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" v-on:click="getLogin">Iniciar Sesión</button>
        <router-link to="/Register" tag="button" class="btn btn-primary" type="submit">Registrarse</router-link> 
        <div class="col-12 bg-light">
            <router-view />
        </div>
    </div>
    <div v-if="inside">
        <label>Bienvenido {{usuario.email}}</label><br><br>
        <button v-on:click="logOut">Cerrar Sesion</button>
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
        inside : false
        }
    },
    userController : null,
    created () {
        this.userController = new UserController();
    },
    methods: {
        getLogin: function() {
            try{ this.userController.login(this.usuario).then(data => {
                 console.log(data.data);
                 if(data.data == true){this.inside = true}
            })}catch{console.log("Error Connection");}
        },
        logOut: function(){
            this.usuario.email ='';
            this.usuario.password='';
            this.inside = false
        }
    }

}

</script>

<style>
</style>
