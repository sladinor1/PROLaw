<template>
    <div>
        <Dialog header="" :visible="display" >
            Usted no posee los permisos para responder a esta pregunta. <br>
            <Button label="OK" icon="pi pi-check" @click="acept" autofocus />
        </Dialog>
        <Dialog position="top" header=" EDITA TU PREGUNTA" :visible="display2" :style="{width: '40vw'}" >
            Asunto. <br>
            <Textarea v-model="comment.topicCas" :style="{width: '37vw'}" /> <br>
            Descripcion. <br>
            <Textarea v-model="comment.descripCas" :style="{width: '37vw'}" />  <br>
            <Button label="OK" icon="pi pi-check" @click="editar" autofocus />
        </Dialog>
        <div class="forum-container">
            <h3>{{pregunta}}</h3>
            <br>
            <div style="text-align: right">                
                <Button label="Editar" class="p-button-sm" @click="mostrar" style="font-weight: bold" icon="pi pi-pencil"/> 
                <Button label="Eliminar" class="p-button-danger p-button-sm" @click="eliminar" style="font-weight: bold" icon="pi pi-trash" /> 
            </div>
            <br>
            <div style="text-align: right">
                <Textarea v-model="respuesta.descripAns" rows="5" cols="90" placeholder="Escriba aqui su respuesta..." />
                <Button label="Responder" class="p-button-success p-button-sm" @click="guardar" style="font-weight: bold" icon="pi pi-send" /> 

            </div>
            <br>
            <Panel  v-if="show"  header="Respuestas" >
                <div v-for="i in rtas" :key="i">
                    <div style="display:flex; justify-content: space-between;">
                        <div style="margin: 10px" align="left">
                            <b>{{i.nameUser}}</b>
                        </div>
                        <div align="right" style="color: gray; margin: 10px">
                            {{i.dateAns}}
                        </div>
                    </div>
                    {{i.descripAns}} <br>
                    <div style="text-align: right">
                        
                        <!--<Button label="Editar" class="p-button-sm" @click="editarL" style="font-weight: bold" icon="pi pi-pencil"/> 
                        <Button label="Eliminar" class="p-button-danger p-button-sm" @click="eliminarL" style="font-weight: bold" icon="pi pi-trash" />-->
                    </div>
                    <Divider align="right">
                        <Button label="Contactar a este abogado" @click="$router.push({name: 'perfil' , params: {id : i.idUserA}})" align="right" style="font-weight: bold" icon="pi pi-info-circle"/>
                    </Divider>
                </div>
            </Panel>
            
        </div>
    </div>
</template>

<script>
import ForumController from '../controller/ForumController.js'
import UserController from "../controller/UserController.js";
import emailjs from 'emailjs-com';
export default {
    foroController: null,
    created() {
        this.foroController = new ForumController();
        this.getCase();
    },
    data(){
        return{
            pregunta: '',
            rtas: [
                {
                    nameUser: '',
                    dateAns: '',
                    descripAns: ''
                }
            ],
            respuesta: {
                id: '',
                idC: '',
                idUserA: this.$root.id,
                descripAns: '',
                nameUser: this.$root.user
            },
            comment :{
                idC : localStorage.idC,
                topicCas : localStorage.topic,
                descripCas: localStorage.pregunta
            },
            display: null,
            display2: null,
            correo: '',
            idAuthor: '',
            nombre: '',
            show: false
        }
    }, 
    mounted() {
        if (localStorage.pregunta) {
            this.pregunta = localStorage.pregunta;
        } else {
            localStorage.pregunta = this.$route.params.qtn;
            //this.pregunta = this.$route.params.qtn;
        }
        /*if (localStorage.rtas) {
            this.rtas = JSON.parse(localStorage.getItem("rtas"));
            //console.log(this.rtas);
        } else {
            localStorage.rtas = this.$route.params.rta;
            //this.rtas = this.$route.params.rta;
        }*/
        if (localStorage.idC) {
            this.respuesta.idC = localStorage.idC;
        } else {
            localStorage.pregunta = this.$route.params.id;
            //this.pregunta = this.$route.params.qtn;
        }
    },
    methods: {
        mostrar: function(){
            this.display2 = true;
        },
        eliminar: function(){
            let comment = {
                idC : localStorage.idC
            }
            if (this.$root.rol == "U"){
                this.foroController.deletedCase(comment);
                //console.log(comment);
                 this.$router.push('/foros');
            }
           
        },
        editar: function(){
            if (this.$root.rol == "U"){
                this.foroController.editedCase(this.comment);
                console.log(this.comment);
                this.display2 = null;
                this.$router.push('/foros');
            }
           
        },
        getCase: function(){
            try{this.foroController.getQuestion(localStorage.idC).then(data => {
                if(data.data.idsAns == '0'){
                    this.show = false;
                } else{
                    this.show = true;
                }
                this.idAuthor = data.data.idUserC;
                this.nombre = data.data.nameUser;
                //console.log(data.data);
              if(data.data.answers[0] != null){
                this.rtas = data.data.answers;
                console.log(this.rtas);
              }
        })}catch{console.log("Error Connection");}
        },
        guardar: function(){
            if (this.$root.rol == "L"){
                this.foroController.saveAnswer(this.respuesta).then( data => {
                    this.getCase();
                    this.getEmail();
                    this.respuesta.descripAns = '';
                    console.log(data);
                })
            }else{
                this.display = true;
            }
        },
        acept: function(){
            this.display = false;
        },
        sendEmail(email) {
            emailjs.init('user_PuldBtDHzIERDbKP27eyT');
            try {
                console.log("Entro:" + email);
                emailjs.send("service_0e62a5b","template_nn1v3xc",{
                reply_to: email, //"gmojica@unal.edu.co",// //,Correo
                from: this.$root.user, //Nombre abogado
                to_name: this.nombre, //A quien va
                message: '"' + this.pregunta + '"', //Pregunta
                to_email: email
        })
        } catch(error) {
            const email = this.correo;
            console.log(email);
            console.log({error})
            
        }},
        getEmail: function(){
            this.userController = new UserController();
            try{this.userController.getUser(this.idAuthor).then(data => {
                this.correo = data.data.user.emailUser.trim();
                console.log("---------------EMAIL---------------")
                console.log(this.correo);
                this.sendEmail(this.correo);
            })}catch{console.log("Error Connection");}
        }
    },
}
</script>