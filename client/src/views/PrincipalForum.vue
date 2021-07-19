<template>
    <div>
        <div class="search-container">
            <div class="p-formgroup-inline">
                <div class="p-field">
                    <InputText id="busqueda" type="text" v-model="busqueda" placeholder="Nueva Busqueda"/>
                    <Button icon="pi pi-search" />
                </div>
            </div>
        </div>
        <div class="detail-container">
            <div>
                <Button label="Agregar tema" icon="pi pi-plus" class="p-button-raised p-button-rounded p-button-secondary" @click="agregar" />
            </div>
            <div v-if="nuevo">
                <br>
                <Textarea v-model="coment" rows="5" cols="107" placeholder="Escriba aqui su pregunta..." />
                <Button label="Publicar" class="p-button-sm" @click="guardar"/>
                <Button label="Cancelar" class="p-button-danger p-button-sm" @click="{ this.nuevo=false;}"/>
            </div>
            <br>
            <DataTable :value="preguntas" selectionMode="single" dataKey="id"
                    @rowSelect="selected" responsiveLayout="scroll">
                <Column field="pregunta" header="Pregunta"></Column>
            </DataTable>
    </div>
    </div>
</template>

<script>
import myjson from '../jsons/Foro.json';
export default {
    data() {
		return {
			busqueda: '',
            comentario: '',
            preguntas: myjson.data,
            nuevo: false,
		}
	},
    methods: {
		selected: function(event){
            //console.log(event.data);
            localStorage.pregunta = event.data.pregunta;
            localStorage.setItem("rtas", JSON.stringify(event.data.respuestas) );
            this.$router.push({name: 'foro'});
		},
        agregar: function(){
            this.nuevo = true;
        },
        guardar: function(){
            this.nuevo=false;
        }
	},
}
</script>