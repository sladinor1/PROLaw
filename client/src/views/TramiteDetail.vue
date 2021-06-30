<template>
    <div class="detail-container">
		<div>{{id}}</div>
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
import myjson from '../jsons/prueba.json';
export default {
	name: "TramiteDetail",
	props:{
		
	},
	data() {
		return {
			id: null,
            procedures: myjson.subcategories[0].procedures[0]
		}
	}, 
}
</script>

<style>
    
</style>