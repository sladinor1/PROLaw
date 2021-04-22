<template>
  <div class="p-fluid p-formgrid p-grid">
    <p>Ingresa la nueva contraseña</p>
    <div class="p-field p-col-12 p-md-6">
        <label>Contraseña<span class="text-danger">*</span></label>
        <Password v-model="password" toggleMask></Password>
        <label class="text-danger" v-if="password">{{validarContraseña()}}</label>
    </div>
    <div>
        <label>Repetir Contraseña<span class="text-danger">*</span></label>
        <Password v-model="passwordr" toggleMask></Password>
        <label class="text-danger" v-if="passwordr">{{validarContraseñac()}}</label>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" v-on:click="changePassword">Cambiar</button>
    </div>
  </div>
</template>

<script>
/*
import UserController from "../controller/UserController.js";
export default{
    name: 'Login',
    data () {
        return {
            email: '',
            password: '',
            passwordr: '',
            vps: false,
            vpc: false,
        }
    },
    userController : null,
    created () {
        this.userController = new UserController();
    },
    methods: {
        changePassword: function() {
            //if (this.vps && this.vpc){
                
            //}
        },
        validarContraseña: function(){
            if (this.password.length > 7 && this.password.length < 16){
                if (/\d/.test(this.password)) {
                    this.vps = true;
                    return '';
            }else {
                this.vps = false;
                return 'La contraseña debe tener entre 8 y 15 caracteres inclyendo un numero';
            }
            }else {
                this.vps = false;
                return  'La contraseña debe tener entre 8 y 15 caracteres inclyendo un numero';
            }
        },
        validarContraseñac: function(){
            if (this.password === this.passwordr) {
                this.vpc = true;
                return '';
            }else{
                this.vpc = false;
                return 'La confirmación no coincide con la contraseña';
            } 
        }
    },
}*/
</script>