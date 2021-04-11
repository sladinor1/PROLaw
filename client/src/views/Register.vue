<template>
  <div>
    <div id='form'>
      <h2>Crear cuenta</h2>
      <p>Ingresa la siguiente información para registrarte ó </p> 
      <router-link to="/login">Inicia sesion aqui</router-link>
      <div class="col-12 bg-light">
        <router-view />
      </div>
      <div>
        <label>Identificacion<span class="text-danger">*</span></label>
        <input type="text" v-model="id" placeholder="Tu numero de Identificacion">
        <label class="text-danger" v-if="!vid && id">{{validarId()}}</label>
      </div>
      <div>
        <label>Nombres<span class="text-danger">*</span></label>
        <input type="text" v-model="names" placeholder="Tu(s) nombre(s)">
        <label class="text-danger" v-if="!vn && names">{{validarNombres()}}</label>
      </div>
      <div>
        <label>Apellidos<span class="text-danger">*</span></label>
        <input type="text" v-model="lastnames" placeholder="Tus apellidos">
        <label class="text-danger" v-if="!vl && lastnames">{{validarApellidos()}}</label>
      </div>
      <div>
        <label>Teléfono<span class="text-danger">*</span></label>
        <input type="text" v-model="phone" placeholder="Tu número de teléfono">
        <label class="text-danger" v-if="!vp && phone">{{validarTelefono()}}</label>
      </div>
      <div>
        <label>Correo eléctronico<span class="text-danger">*</span></label>
        <input type="text" v-model="email" placeholder="Tu dirección de correo electónico">
      </div>
      <div>
        <label>Contraseña<span class="text-danger">*</span></label>
        <input type="password" v-model="pass" placeholder="Ingresa una contraseña">
        <label class="text-danger" v-if="!vps && pass">{{validarContraseña()}}</label>
      </div>
      <div>
        <label>Confirmar Contraseña<span class="text-danger">*</span></label>
        <input type="password" v-model="passc" placeholder="Confirma la contraseña">
        <label class="text-danger" v-if="!vpc && passc">{{validarContraseñac()}}</label>
      </div>
    </div>
  </div>
</template>

<script>
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
      id:'',
      names:'',
      lastnames:'',
      phone:'',
      email:'',
      pass:'',
      passc:'',
      vid: false,
      vn: false,
      vl: false,
      vp: false,
      vps: false,
      vpc: false
    }
  },
  methods: {
    validarId: function(){
      if (!/^\d+$/.test(this.id)) {
        this.vid = false;
        return 'El número de identificacion debe tener solamente valores de caracter numerico (0-9)';
      }else {
        return '';
      }
    },
    validarNombres: function(){
      if (/\d/.test(this.names)) {
        this.vn = false;
        return 'El nombre solo acepta valores del abecedario (a-b)';
      }else {
                
        return '';
      }
      },
    validarApellidos: function(){
      if (/\d/.test(this.lastnames)) {
        this.vl = false;
        return 'Los apellidos solo aceptan valores del abecedario (a-b)';
      }
      if(!/\d/.test(this.lastnames)){
        return '';
      }
    },
    validarTelefono: function(){
      if (!/^\d+$/.test(this.phone)) {
        this.vp = false;
        return 'El número de telefono debe tener solamente valores de caracter numerico (0-9)';
      }else {
        return '';
      }
    },
    validarContraseña: function(){
      if (this.pass.length > 7 && this.pass.length < 16){
        if (/\d/.test(this.pass)) {
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
      if (this.pass === this.passc) {
        return '';
      }else{
        this.vpc = false;
        return 'La confirmación no coincide con la contraseña';
      } 
    }
  }
}
</script>