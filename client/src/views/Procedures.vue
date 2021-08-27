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
import myjsonc from '../jsons/Civil.json';

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
	methods: {
        getdata: function(){
            let c = this.$route.params.ct;
            if (c ==  "Penal"){
                return myjson.subcategories[0].procedures
            } else  if (c == "Civil"){
                return myjsonc.subcategories[0].procedures
            } else {
                return myjson.subcategories[0].procedures
            }
        }
    },
}
</script>

<style>
    
</style>