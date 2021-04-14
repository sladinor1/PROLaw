<template>
  <div>
    <h2>Crear cuenta</h2>
    <p>Ingresa la siguiente información para registrarte ó </p> 
    <router-link to="/login">Inicia sesion aqui</router-link>
    <br><br>
    <div class="col-12 bg-light">
      <router-view />
    </div>
    <div>
      <label for="cities">Escoja su ciudad </label>
      <Dropdown v-model="selected" :options="cities" 
        optionLabel="label" optionGroupLabel="label" optionGroupChildren="items">
      </Dropdown>
    </div>
    <div>
      <label>Escoja su tipo de documento </label>
      <Dropdown v-model="selectedid" :options="idtypes" 
        optionLabel="name" placeholder="Escoja su opcion">
      </Dropdown>
    </div>
    <div id='form' class="p-fluid p-formgrid p-grid">
      <div class="p-field p-col-12 p-md-6">
        <label for="id">Identificacion<span class="text-danger">*</span></label>
        <InputText id="id" type="text" v-model="usuario.id" placeholder="Tu numero de Identificacion"/>
        <label class="text-danger" v-if="!vid && usuario.id">{{validarId()}}</label>
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label for="name">Nombres<span class="text-danger">*</span></label>
        <InputText id="name" type="text" v-model="usuario.names" placeholder="Tu(s) nombre(s)"/>
        <label class="text-danger" v-if="!vn && usuario.names">{{validarNombres()}}</label>
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label for="ln">Apellidos<span class="text-danger">*</span></label>
        <InputText id="ln" type="text" v-model="usuario.lastnames" placeholder="Tus apellidos"/>
        <label class="text-danger" v-if="!vl && usuario.lastnames">{{validarApellidos()}}</label>
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label for="phone">Teléfono<span class="text-danger">*</span></label>
        <InputText id="phone" type="text" v-model="usuario.phone" placeholder="Tu número de teléfono"/>
        <label class="text-danger" v-if="!vp && usuario.phone">{{validarTelefono()}}</label>
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label for="email">Correo eléctronico<span class="text-danger">*</span></label>
        <InputText id="email" type="email" v-model="usuario.email" placeholder="Tu dirección de correo electónico"/>
        <label class="text-danger" v-if="!ve && usuario.email">{{validarEmail()}}</label>
      </div>
      <div>
        <label>Contraseña<span class="text-danger">*</span></label>
        <Password v-model="usuario.pass" toggleMask></Password>
        <label class="text-danger" v-if="!vps && usuario.pass">{{validarContraseña()}}</label>
      </div>
      <div> 
        <label>Confirmar Contraseña<span class="text-danger">*</span></label>
        <Password v-model="usuario.passc" toggleMask></Password>
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
      selected: null,
      selectedid: null,
      idtypes:[
        {name: "C.C", code: "C.C"},
        {name: "Targeta de identidad", code: "TI"}
      ],
      cities:[{
        label: 'Bogota D.C.', code: 'BDC',
        items: [
          {
            label:'Bogota D.C.', value: 'Bogota'
          }
        ]
      },{
        label: 'Atlantico', code: 'AT',
        items: [
          {
            label:'Barranquilla', value: 'Barranquilla'
          }
        ]
      },{
        label: 'Antioquia', code: 'AN',
        items: [
          {
            label:'Medellin', value: 'Medellin'
          },{
            label: 'Envigado', value: 'Envigado'
          }
        ]
      },{
        label: 'Valle del cauca', code: 'VC',
        items: [
          {
            label:'Cali', value: 'Cali'
          }
        ]
      }
      ],
      passc:'',
      vid: false,
      vn: false,
      vl: false,
      vp: false,
      vps: false,
      vpc: false,
      ve: false,
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
    validarEmail: function() {
      if (!/^([\da-z_.-]+)@([\da-z.-]+)\.([a-z.]{2,6})$/.test(this.usuario.email)){
        return "Por favor ingresar una direccion de correo valida";
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