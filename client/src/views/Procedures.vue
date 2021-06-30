<template>
    <div class="detail-container">
		<DataTable :value="procedures" selectionMode="single" dataKey="id"
                @rowSelect="$router.push({name: 'details' })" responsiveLayout="scroll">
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