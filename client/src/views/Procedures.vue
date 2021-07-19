<template>
    <div class="detail-container">
		<DataTable :value="procedures" selectionMode="single" dataKey="idPro"
                @rowSelect="selected" responsiveLayout="scroll">
            <Column field="namePro" header="Nombre"></Column>
        </DataTable>
    </div>
</template>

<script>
import myjson from '../jsons/prueba.json';
export default {
	name: "TramiteDetail",
	props:{
		
	},
	methods: {
		selected: function(event){
			this.$router.push({name: 'details' , params:{ id: event.data.idPro }});
		}
	},
	data() {
		return {
			id: null,
            procedures: myjson.subcategories[0].procedures
		}
	}, 
}
</script>

<style>
    
</style>