<template>
    <div>
        <Dialog header="" :visible="display" >
            Usted no posee los permisos para responder a esta pregunta. <br>
            <Button label="OK" icon="pi pi-check" @click="acept" autofocus />
        </Dialog>
        <div class="forum-container">
            <h3>{{pregunta}}</h3>
            <br>
            <div style="text-align: right">                
                <Button label="Editar" class="p-button-sm" @click="editar" style="font-weight: bold" icon="pi pi-pencil"/> 
                <Button label="Eliminar" class="p-button-danger p-button-sm" @click="eliminar" style="font-weight: bold" icon="pi pi-trash" /> 
            </div>
            <br>
            <div style="text-align: right">
                <Textarea v-model="respuesta.descripAns" rows="5" cols="90" placeholder="Escriba aqui su respuesta..." />
                <Button label="Responder" class="p-button-success p-button-sm" @click="guardar" style="font-weight: bold" icon="pi pi-send" /> 

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
                    {{i.descripAns}} <br>
                    <div style="text-align: right">
                        
                        <Button label="Editar" class="p-button-sm" @click="editarL" style="font-weight: bold" icon="pi pi-pencil"/> 
                        <Button label="Eliminar" class="p-button-danger p-button-sm" @click="eliminarL" style="font-weight: bold" icon="pi pi-trash" />
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
        editar: function(){
            if (this.$route.role == 'U'){
                this.respuesta.idUserA = this.$root.id;
                var today = new Date();
                var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
                this.respuesta.dateAns = date;
                this.foroController.editQuestion(this.respuesta);
            }else{
                this.display = true;
            }
        },
        eliminar: function(){
            if (this.$route.role == 'U'){
                this.respuesta.idUserA = this.$root.id;
                var today = new Date();
                var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
                this.respuesta.dateAns = date;
                this.foroController.deleteQuestion(this.respuesta);
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