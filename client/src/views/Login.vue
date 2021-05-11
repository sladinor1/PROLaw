<template>
<div class="form-container">
    <h2>Inicio de Sesión</h2>

    <div id='form' class="p-fluid p-formgrid p-grid">

        <div class="p-field p-col-12 p-md-6">
            <InputText id="email" type="email" v-model="usuario.email" placeholder="Correo Electrónico"/>
            <label class="text-danger" v-if="usuario.email"></label>
        </div>
        <br>
        <div>
            <Password v-model="usuario.password" placeholder="Contraseña" :feedback="false" />
        </div>

            <p><router-link to="/Register" tag="button" class="btn btn-primary" type="submit">¿Olvidaste tu contraseña?</router-link></p>

        <div class="d-grid gap-2">
            <button class="botonInicioSesion" v-on:click="getLogin">Iniciar Sesión</button>
        </div>
        <div>
            <Dialog position="top" :visible="display">
                <p>Usuario no encontrado, por favor Registrarse</p>
                <br>
                <Button label="ok" icon="pi pi-check" @click="close"/>
            </Dialog>
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
            display: false,
        }
    },
    userController : null,
    created () {
        this.userController = new UserController();
    },
    methods: {
        close: function() {
            this.display = false;
        },
        getLogin: function() {
            //this.$root.inside = true;
            //console.log(this.$root.inside);
            try{ this.userController.login(this.usuario).then(data => {
                console.log(data.data.status);
                if(data.data != null){
                    this.$root.inside = true;
                    this.$root.user = data.data.nameUser +' '+ data.data.lastNameUser;
                    this.$router.push('/');   
                }                
            }).catch( error => {
                this.display = true;
                //console.log(this.display = true);
                console.log(error);
                //throw error;
                //if(error == 'Request failed with status code 404'){
                
                //}
            });}catch{this.$root.user = ""}   
        },
    },
}
</script>

<style>
</style>