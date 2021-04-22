<template>
  <div class="p-fluid p-formgrid p-grid">
    <div class="p-field p-col-12 p-md-6">
        <label for="email">Ingrese su correo eléctronico<span class="text-danger">*</span></label>
        <InputText id="email" type="email" v-model="email" placeholder="Tu dirección de correo electónico"/>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" v-on:click="newPass">Enviar</button>
    </div>
  </div>
</template>

<script>
/*
import UserController from "../controller/UserController.js";
import emailjs from 'emailjs-com';
export default{
    name: 'Change',
    data () {
        return {
            email: '',
        }
    },
    userController : null,
    created () {
        this.userController = new UserController();
        emailjs.init("user_PuldBtDHzIERDbKP27eyT");
    },
    methods: {
        newPass: function() {
            try {
                emailjs.send('YOUR_SERVICE_ID', 'YOUR_TEMPLATE_ID', this.email,'YOUR_USER_ID', {
            })
            } catch(error) {
                console.log({error});
            }
        },
    },
}
*/
</script>