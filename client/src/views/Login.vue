<template>
<div class="form-container">
    <h2>Inicio de Sesión</h2>

    <div id='form' class="p-fluid p-formgrid p-grid">

        <div class="p-field p-col-12 p-md-6">
            <InputText id="email" type="email" v-model="usuario.email" placeholder="Correo Electrónico"/>
<<<<<<< HEAD
            <label class="text-danger" v-if="usuario.email">{{validarEmail()}}</label>
        </div>
        <br>
        <div>
            <Password v-model="usuario.pass" placeholder="Contraseña" toggleMask></Password>
            <label class="text-danger" v-if="usuario.pass">{{validarContraseña()}}</label>
=======
            <label class="text-danger" v-if="usuario.email"></label>
        </div>
        <br>
        <div>
            <Password v-model="usuario.password" placeholder="Contraseña" :feedback="false" />
>>>>>>> aba8eb87382c1ab9739c4912111e65d40b0601b3
        </div>

            <p><router-link to="/Register" tag="button" class="btn btn-primary" type="submit">¿Olvidaste tu contraseña?</router-link></p>

        <div class="d-grid gap-2">
            <button class="botonInicioSesion" v-on:click="getLogin">Iniciar Sesión</button>
        </div>
<<<<<<< HEAD
        <div v-if="inside">
            <label>Bienvenido {{usuario.email}}</label><br><br>
            <router-link to="">
                <span v-on:click="logOut">Cerrar sesion</span>
            </router-link>
        </div>
=======
        
        <a href="{@/oauth2/authorization/google}">Login with Google</a>
>>>>>>> aba8eb87382c1ab9739c4912111e65d40b0601b3
      
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
            //this.$root.inside = true;
            //console.log(this.$root.inside);
            try{ this.userController.login(this.usuario).then(data => {
<<<<<<< HEAD
                console.log(data.data);
                //if(data.data != null){
                    //this.$root.inside = true;
                    //this.$root.user = this.usuario.email;
                //}
=======
                //console.log(data.data);
                if(data.data != null){
                    this.$root.inside = true;
                    this.$root.user = data.data.nameUser +' '+ data.data.lastNameUser;
                    console.log(data.data.nameUser +' '+ data.data.lastNameUser);
                    console.log(this.$root.user);
                }
>>>>>>> aba8eb87382c1ab9739c4912111e65d40b0601b3
            })}catch{console.log("Error Connection");}
        },
    },
}
</script>

<style>
</style>
