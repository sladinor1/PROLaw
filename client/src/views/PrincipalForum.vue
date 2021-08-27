<template>
    <div>
        <Dialog header="" :visible="display" >
            Para preguntar por favor iniciar sesión<br><br>
            <Button icon="pi pi-check" label="Ok" @click="acept" autofocus />
        </Dialog>
        
        <div class="pregunta-container">                      
            
            <div v-if="nuevo">
                <br>
                <Textarea v-model="comentario.topicCas" rows="1" cols="150" placeholder="Asunto" />
                <Textarea v-model="comentario.descripCas" rows="5" cols="150" placeholder="Escriba aquí su pregunta..." />
                <Button label="Preguntar" class="p-button-success p-button-sm" @click="guardar" style="font-weight: bold" icon="pi pi-send"/>
                <Button label="Cancelar" class="p-button-danger p-button-sm" @click="{ this.nuevo=false;}" style="font-weight: bold" icon="pi pi-times-circle"/>
            </div>
            <br>
            
            <div style=" display:flex; justify-content: space-between;">
                    <div style="margin: 10px">                
                        <Button label="Hacer una pregunta" icon="pi pi-question-circle" class="p-button p-button-rounded p-button-primary" @click="agregar" style="font-weight: bold"/>
                    </div>
                    <div style="margin: 10px">
                        <!--<InputText id="busqueda" type="text" v-model="busqueda" placeholder="Nueva Búsqueda"/>-->
                        <InputText v-model="filters1['global'].value" placeholder="Nueva Búsqueda" />
                        <Button icon="pi pi-search" />  
                    </div>         
                </div>

            <DataTable :value="preguntas" :paginator="true" :rows="10" selectionMode="single" dataKey="id"
                    @rowSelect="selected" :filters="filters1" filterDisplay="menu" :loading="loading1" responsiveLayout="scroll"
                    :globalFilterFields="['topicCas', 'subcatCas','idUserC']">
                    
                    <template #empty>
                        Aún no hay respuestas.
                    </template>
                    <template #loading>
                        Cargando respuestas, por favor espere.
                    </template>

                <Column field="topicCas" header="Tema" style="font-weight: bold"></Column>
                <Column field="dateAns"  dataType="date" style="min-width: 8rem" header="Fecha"></Column>
                <Column field="idsAns" header="Respuestas"></Column>
                <Column field="nameUser" header="Autor">Nombre</Column>
            </DataTable>
    </div>
    </div>
</template>

<script>
//import FilterMatchMode from 'primevue/api';
//import myjson from '../jsons/Foro.json';
import ForumController from '../controller/ForumController.js'
import {FilterMatchMode,FilterOperator} from 'primevue/api';

export default {
    foroController: null,
    created() {
        this.foroController = new ForumController();
        this.getList();
        this.initFilters1();
        if(localStorage.inside == true ){
            this.$root.inside = true;
        }
    },
    mounted() {        
            this.loading1 = false;    
        
    },
    data() {
		return {
			busqueda: '',
            comentario: {
                idUserC: this.$root.id,
                descripCas: '',
                nameUser: this.$root.user,
                topicCas: ''
                },
            preguntas: [],
            nuevo: false,
            display: null,
            filters1: null,
            loading1: true,
            info: null
            
		}
	},
    methods: {
        getList: function(){
            
        try{this.foroController.getList().then(data => {
            console.log(JSON.parse(JSON.stringify(data.data)));
            this.preguntas = data.data;
            console.log(typeof(this.preguntas));
            console.log(this.preguntas);
        })}catch{console.log("Error Connection");}
        //let p = this.foroController.getList();
        
        },
		selected: function(event){
            //console.log(event.data);
            localStorage.pregunta = event.data.descripCas;
            localStorage.idUserC = event.data.idUserC;
            localStorage.setItem("rtas", JSON.stringify(event.data.answers) );
            localStorage.idC = event.data.idCase;
            localStorage.topic = event.data.topicCas;
            console.log(localStorage.topic);
            this.$router.push({name: 'foro'});

		},
        agregar: function(){
            this.nuevo = true;
        },
        guardar: function(){
            if (this.$root.inside){
                
                this.foroController.saveQuestion(this.comentario).then( data => {
                    //this.$root.actualizar();
                    this.getList();
                    console.log(data);
                })
                this.nuevo=false;
                
            }else{
                this.display = true;
            }     
        },
        acept: function(){
            this.display = false;
        },
        initFilters1() {
            this.filters1 = {
                'global': {value: null, matchMode: FilterMatchMode.CONTAINS},
                'topicCas': {operator: FilterOperator.AND, constraints: [{value: null, matchMode: FilterMatchMode.STARTS_WITH}]},
                'subcatCas': {operator: FilterOperator.AND, constraints: [{value: null, matchMode: FilterMatchMode.STARTS_WITH}]},
                'idUserC': {value: null, matchMode: FilterMatchMode.IN}
            }
        }
	},
}
</script>