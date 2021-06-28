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
        <Dropdown v-model="usuario.typeId" :options="idtypes" optionLabel="name" placeholder="Tipo de documento"></Dropdown>
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
        <Dropdown v-model="usuario.city" :options="cities" optionLabel="label" optionGroupLabel="label" 
        optionGroupChildren="items" placeholder="Departamento y Ciudad"></Dropdown>
      </div>  
      <br>
      <div class="">
        <button class="botonRegistro" v-on:click="registrar">Registrarse</button>
      </div>
      <div>
        <Dialog position="top" :visible="d">
          <p>Por favor llenar los espacion correctamente</p>
          <br>
          <Button label="ok" icon="pi pi-check" @click="close" autofocus/>
        </Dialog>
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
        {name: "Tarjeta de identidad", code: "TI"}
      ],
      cities:[{
        label: 'Bogota D.C.', code: 'BOG',
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
      d: false,
      vid: false,
      vn: false,
      vl: false,
      vp: false,
      vps: false,
      vpc: false,
      ve: false,
      usuario: {
        typeId: '',
        id: null,
        names: '',
        lastnames: '',
        phone: '',
        email: '',
        pass: '',
        city: '',
      }
    }
  },
  userController: null,
  created() {
    this.userController = new UserController();
  },
  methods: {
    close: function() {
      this.d = false;
    },
    registrar (){
      if (this.vid && this.vn && this.vl && this.ve && this.vp && this.vps){
            this.usuario.typeId = this.usuario.typeId.code;
            this.usuario.city = this.usuario.city.code;
            this.userController.insert(this.usuario).then(data => {
              console.log(data);
            })
      } else {
        this.d = true;
      }
    },
    validarId: function(){
      if (!/^\d+$/.test(this.usuario.id)) {
        this.vid = false;
        return 'El número de identificacion debe tener solamente valores de caracter numerico (0-9)';
      }else {
        this.vid = true;
        return '';
      }
    },
    validarNombres: function(){
      if (/\d/.test(this.usuario.names)) {
        this.vn = false;
        return 'El nombre solo acepta valores del abecedario (a-b)';
      }else {
        this.vn = true;
        return '';
      }
      },
    validarApellidos: function(){
      if (/\d/.test(this.usuario.lastnames)) {
        this.vl = false;
        return 'Los apellidos solo aceptan valores del abecedario (a-b)';
      }
      if(!/\d/.test(this.usuario.lastnames)){
        this.vl = true;
        return '';
      }
    },
    validarTelefono: function(){
      if (!/^\d+$/.test(this.usuario.phone)) {
        this.vp = false;
        return 'El número de telefono debe tener solamente valores de caracter numerico (0-9)';
      }else {
        this.vp = true;
        return '';
      }
    },
    validarEmail: function() {
      if (!/^([\da-z_.-]+)@([\da-z.-]+)\.([a-z.]{2,6})$/.test(this.usuario.email)){
        this.ve = false;
        return "Por favor ingresar una direccion de correo valida";
      }else {
        this.ve = true;
        return "";
      }
    }, 
    validarContraseña: function(){
      if (this.usuario.pass.length > 7 && this.usuario.pass.length < 16){
        if (/\d/.test(this.usuario.pass)) {
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
      if (this.usuario.pass === this.passc) {
        this.vpc = true;
        return '';
      }else{
        this.vpc = false;
        return 'La confirmación no coincide con la contraseña';
      } 
    }
  }
}
</script>