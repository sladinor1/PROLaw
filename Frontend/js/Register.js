const app = new Vue({
    el: '#form',
    data: {
        names:'',
        lastnames:'',
        phone:'',
        email:'',
        pass:'',
        passc:'',
        vn: false,
        vl: false,
        vp: false,
        vps: false,
        vpc: false
    },
    methods: {
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
                this.vl = true;
                return '';
            }
        },
        validarTelefono: function(){
            if (!/^\d+$/.test(this.phone)) {
                this.vp = false;
                return 'El número de telefono debe tener solamente valores de caracter numerico (0-9)';
            }else {
                this.vp = true;
                return '';
            }
        },
        validarContraseña: function(){
            if (this.pass.length > 7 && this.pass.length < 16){
                if (/\d/.test(this.pass)) {
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
            if (this.pass === this.passc) {
                this.vpc = true;
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