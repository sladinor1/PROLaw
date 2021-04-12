<template>
  <div>
    <div id='form'>
      <h2>Crear cuenta</h2>
      <p>Ingresa la siguiente información para registrarte ó </p> 
      <router-link to="/login">Inicia sesion aqui</router-link>
      <br><br>
      <div class="col-12 bg-light">
        <router-view />
      </div>
      <div>
        <label>Identificacion<span class="text-danger">*</span></label>
        <input type="text" v-model="usuario.id" placeholder="Tu numero de Identificacion">
        <label class="text-danger" v-if="!vid && usuario.id">{{validarId()}}</label>
      </div>
      <br><br>
      <div>
        <label>Nombres<span class="text-danger">*</span></label>
        <input type="text" v-model="usuario.names" placeholder="Tu(s) nombre(s)">
        <label class="text-danger" v-if="!vn && usuario.names">{{validarNombres()}}</label>
      </div>
      <br><br>
      <div>
        <label>Apellidos<span class="text-danger">*</span></label>
        <input type="text" v-model="usuario.lastnames" placeholder="Tus apellidos">
        <label class="text-danger" v-if="!vl && usuario.lastnames">{{validarApellidos()}}</label>
      </div>
      <br><br>
      <div>
        <label>Teléfono<span class="text-danger">*</span></label>
        <input type="text" v-model="usuario.phone" placeholder="Tu número de teléfono">
        <label class="text-danger" v-if="!vp && usuario.phone">{{validarTelefono()}}</label>
      </div>
      <br><br>
      <div>
        <label>Correo eléctronico<span class="text-danger">*</span></label>
        <input type="text" v-model="usuario.email" placeholder="Tu dirección de correo electónico">
      </div>
      <br><br>
      <div>
        <label>Contraseña<span class="text-danger">*</span></label>
        <input type="password" v-model="usuario.pass" placeholder="Ingresa una contraseña">
        <label class="text-danger" v-if="!vps && usuario.pass">{{validarContraseña()}}</label>
      </div>
      <br><br>
      <div>
        <label>Confirmar Contraseña<span class="text-danger">*</span></label>
        <input type="password" v-model="passc" placeholder="Confirma la contraseña">
        <label class="text-danger" v-if="!vpc && passc">{{validarContraseñac()}}</label>
      </div>
      <div class="">
        <button class="btn btn-primary" v-on:click="registrar">Registrarse</button>
      </div>
    </div>
  </div>
</template>

<script>
import UserController from "../controller/UserController.js";
export default {
  name: 'App',
  components: {
    
  },
  data() {
    return {
      items:[
        {
          label: "¿Quienes somos?"
        },
        {
          label: "iniciar sesion"
        },
        {
          label: "Crear cuenta"
        }
      ],
      passc:'',
      vid: false,
      vn: false,
      vl: false,
      vp: false,
      vps: false,
      vpc: false,
      usuario: {
        id: null,
        names: '',
        lastnames: '',
        phone: '',
        email: '',
        pass: '',
      }
    }
  },
  userController: null,
  created() {
    this.userController = new UserController();
  },
  methods: {
    registrar (){
      this.userController.insert(this.usuario).then(data => {
        console.log(data);
      })
    },
    validarId: function(){
      if (!/^\d+$/.test(this.usuario.id)) {
        this.vid = false;
        return 'El número de identificacion debe tener solamente valores de caracter numerico (0-9)';
      }else {
        return '';
      }
    },
    validarNombres: function(){
      if (/\d/.test(this.usuario.names)) {
        this.vn = false;
        return 'El nombre solo acepta valores del abecedario (a-b)';
      }else {
                
        return '';
      }
      },
    validarApellidos: function(){
      if (/\d/.test(this.usuario.lastnames)) {
        this.vl = false;
        return 'Los apellidos solo aceptan valores del abecedario (a-b)';
      }
      if(!/\d/.test(this.usuario.lastnames)){
        return '';
      }
    },
    validarTelefono: function(){
      if (!/^\d+$/.test(this.usuario.phone)) {
        this.vp = false;
        return 'El número de telefono debe tener solamente valores de caracter numerico (0-9)';
      }else {
        return '';
      }
    },
    validarContraseña: function(){
      if (this.usuario.pass.length > 7 && this.usuario.pass.length < 16){
        if (/\d/.test(this.usuario.pass)) {
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
      if (this.usuario.pass === this.passc) {
        return '';
      }else{
        this.vpc = false;
        return 'La confirmación no coincide con la contraseña';
      } 
    }
  }
}
</script>