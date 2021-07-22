<template>
    <div>
        <Dialog header="" :visible="display" >
            Para preguntar por favor loguear
            <Button label="Ok" icon="pi pi-check" @click="acept" autofocus />
        </Dialog>
        <div class="search-container">
            <div class="p-formgroup-inline">
                <div class="p-field">
                    <InputText id="busqueda" type="text" v-model="busqueda" placeholder="Nueva Busqueda"/>
                    <Button icon="pi pi-search" />
                </div>
            </div>
        </div>
        <div class="pregunta-container">
            <div>
                <Button label="Agregar tema" icon="pi pi-plus" class="p-button-raised p-button-rounded p-button-secondary" @click="agregar" />
            </div>
            <div v-if="nuevo">
                <br>
                <Textarea v-model="comentario.descripCas" rows="5" cols="125" placeholder="Escriba aqui su pregunta..." />
                <Button label="Publicar" class="p-button-sm" @click="guardar"/>
                <Button label="Cancelar" class="p-button-danger p-button-sm" @click="{ this.nuevo=false;}"/>
            </div>
            <br>
            <DataTable :value="preguntas" selectionMode="single" dataKey="id"
                    @rowSelect="selected" responsiveLayout="scroll">
                <Column field="" header="Nombre"></Column>
                <Column field="descripCas" header="Pregunta"></Column>
                <Column field="dateAns"  dataType="date" style="min-width: 8rem" header="Fecha"></Column>
            </DataTable>
    </div>
    </div>
</template>

<script>
import myjson from '../jsons/Foro.json';
import ForumController from '../controller/ForumController.js'
export default {
    foroController: null,
    created() {
        this.foroController = new ForumController();
        //this.preguntas = this.foroController.getList();
    },
    data() {
		return {
			busqueda: '',
            comentario: {
                idUserC: '', 
                descripCas: '',
                dateAns: ''
                },
            preguntas: myjson.data,
            nuevo: false,
            display: true
		}
	},
    methods: {
		selected: function(event){
            //console.log(event.data);
            localStorage.pregunta = event.data.descripCas;
            localStorage.setItem("rtas", JSON.stringify(event.data.answers) );
            this.$router.push({name: 'foro'});
		},
        agregar: function(){
            this.nuevo = true;
        },
        guardar: function(){
            if (this.$root.inside){
                this.comentario.idUserC = this.$root.id;
                var today = new Date();
                var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
                this.comentario.dateAns = date;
                this.foroController.saveQuestion(this.comentario);
                this.nuevo=false;
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