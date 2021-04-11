const app = new Vue({
    el: '#form',
    data: {
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
    },
    methods: {
        validarId: function(){
            if (!/^\d+$/.test(this.id)) {
                this.id = false;
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
        },
        registrar: function(){

        }
    }
});