<template>
    <div class="detail-container">
		<DataTable :value="procedures" selectionMode="single" dataKey="idPro"
                @rowSelect="selected" responsiveLayout="scroll">
            <Column field="namePro" header="Nombre"></Column>
        </DataTable>
    </div>
</template>

<script>
import myjsonc from '../jsons/Civil.json';
import myjson from '../jsons/prueba.json';
export default {
	name: "TramiteDetail",
	props:{
		
	},
	methods: {
		selected: function(event){
			this.$router.push({name: 'details' , params:{ c: this.$route.params.ct, id: event.data.idPro }});
		}, 
		getdata: function(){
            let c = localStorage.tramite;
            if (c ==  "Penal"){
                return myjson.subcategories[0].procedures
            } else  if (c == "Civil"){
                return myjsonc.subcategories[0].procedures
            } else {
                return myjson.subcategories[0].procedures
            }
        }
	},
	data() {
		return {
			id: null,
            procedures: this.getdata()
		}
	}
}
</script>

<style>
    
</style>