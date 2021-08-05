<template>
    <div>
        <Dialog header="" :visible="display" >
            Usted no posee los permisos para responder a esta pregunta
            <Button label="Ok" icon="pi pi-check" @click="acept" autofocus />
        </Dialog>
        <div class="forum-container">
            <h3>{{pregunta}}</h3>
            <br>
            <div>
                <Textarea v-model="respuesta.descripAns" rows="5" cols="107" placeholder="Escriba aqui su respuesta..." />
                <Button label="Responder" class="p-button-sm" @click="guardar" style="font-weight: bold"/> 
            </div>
            <br>
            <Panel v-if="rtas.length > 0 && rtas[0].nameUser != ''" header="Respuestas">
                <div v-for="i in rtas" :key="i">
                    <div style="display:flex; justify-content: space-between;">
                        <div style="margin: 10px" align="left">
                            <b>{{i.nameUser}}</b>
                        </div>
                        <div align="right" style="color: gray; margin: 10px">
                            {{i.dateAns}}
                        </div>
                    </div>
                    <div>
                        {{i.descripAns}}
                    </div>
                    <Divider align="right">
                        <Button label="Contactar a este abogado" @click="$router.push({name: 'perfil' , params: {id : i.idUserA}})" align="right" style="font-weight: bold"/>
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
        console.log(this.$root.id);
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
            display: null,
            correo: ''
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
        getCase: function(){
            try{this.foroController.getQuestion(localStorage.idC).then(data => {
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
                    this.sendEmail();
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
        sendEmail() {
            emailjs.init('user_PuldBtDHzIERDbKP27eyT');
            this.userController = new UserController();
            try{this.userController.getFirst(this.$root.id).then(data => {
                this.correo = data.data.user.email;
                this.law = data.data.law;
            })}catch{console.log("Error Connection");}
            try {
                emailjs.send("service_0e62a5b","template_nn1v3xc",{
                from: this.$root.user,
                to_name: localStorage.idUserC,
                reply_to: this.correo,
                message: '"' + this.pregunta + '"'
        })
        } catch(error) {
            console.log({error})
        }}
    },
}
</script>