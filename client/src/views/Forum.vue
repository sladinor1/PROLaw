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
            <Panel header="Respuestas">
                <div v-for="i in rtas" :key="i">
                    <div style="display:flex; justify-content: space-between;">
                        <div style="margin: 10px" align="left">
                            <b>{{i.idUserA}}</b>
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
export default {
    foroController: null,
    created() {
        this.foroController = new ForumController();
    },
    data(){
        return{
            pregunta: '',
            rtas: [],
            respuesta: {
                idUserA: '',
                descripAns: '',
                dateAns: ''
            },
            display: null
        }
    }, 
    mounted() {
        if (localStorage.pregunta) {
            this.pregunta = localStorage.pregunta;
        } else {
            localStorage.pregunta = this.$route.params.qtn;
            //this.pregunta = this.$route.params.qtn;
        }
        if (localStorage.rtas) {
            this.rtas = JSON.parse(localStorage.getItem("rtas"));
            //console.log(this.rtas);
        } else {
            localStorage.rtas = this.$route.params.rta;
            //this.rtas = this.$route.params.rta;
        }
    },
    methods: {
        guardar: function(){
            if (this.$route.role == 'L'){
                this.respuesta.idUserA = this.$root.id;
                var today = new Date();
                var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
                this.respuesta.dateAns = date;
                this.foroController.saveAnswer(this.respuesta);
            }else{
                this.display = true;
            }
        },
        acept: function(){
            this.display = false;
        }
    },
}
</script>