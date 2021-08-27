<template>
    <div class="detail-container">
        <TabView ref="tabview1">
			<TabPanel header="Descripcion">
				<ScrollPanel style="width: 100%; height: 300px">
					<p class="p">{{procedures.descripPro}}</p>
				</ScrollPanel>
			</TabPanel>
			<TabPanel header="¿Que hacer?">
				<ScrollPanel style="width: 100%; height: 300px">
					<p class="p" v-html="procedures.actionPro"></p>
				</ScrollPanel>
			</TabPanel>
			<TabPanel header="Instituciones">
				<ScrollPanel style="width: 100%; height: 300px">
					<p class="p" v-html="procedures.placePro"></p>
				</ScrollPanel>
			</TabPanel>
			<TabPanel header="Normatividad">
				<ScrollPanel style="width: 100%; height: 300px">
					<div v-for="item in procedures.normativity" :key="item">
                        <p class="p"><a :href="item.link" target="_blank" rel="noopener">{{item.nameNor}}</a></p>
					</div>
				</ScrollPanel>	
			</TabPanel>
		</TabView>
    </div>
</template>

<script>
import myjsonc from '../jsons/Civil.json';
import myjson from '../jsons/prueba.json';
export default {
	name: "TramiteDetail",
	created() {
        this.id = this.$route.params.id;
    },
	props:{
		
	},
	data() {
		return {
			id: '',
            procedures: this.getdata()
		}
	}, 
	mounted() {
		console.log(this.id);
	},
	methods: {
        getdata: function(){
            let c = localStorage.tramite;
            if (c ==  "Penal"){
                return myjson.subcategories[0].procedures[0];
            } else  if (c == "Civil"){
                return myjsonc.subcategories[0].procedures[0];
            } else {
                return myjson.subcategories[0].procedures[0];
            }
        }
    },
}
</script>

<style>
    
</style>