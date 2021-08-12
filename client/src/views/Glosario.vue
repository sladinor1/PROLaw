<template>
       <div class="glosario-container">
     
        <div class="tramite-container">
            <Fieldset class="p" legend="Glosario" :toggleable="true" :collapsed="false">
                
                <nav aria-label="Page glosary example">
                    <ul class="pagination justify-content-center">
                        <li v-for="letra in letras" v-on:click="getLetra(letra)" class="page-item" 
                            v-bind:class="isActive()" :key="letra"><a class="page-link" href="#">{{letra}}</a></li>                        
                    </ul>
                </nav>
                
                <!--<table class="table">
                    <tr v-for="item in palabrasA" :key="item">
                        <td><strong>{{item.nameGlo}}</strong></td>
                        <td>{{item.descripGlo}}</td>
                    </tr>
                </table>-->
                  

                <DataTable :value="palabrasA" :paginator="true" :rows="10" selectionMode="single" dataKey="id"
                    paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
                    :rowsPerPageOptions="[10,20,50]" responsiveLayout="scroll"
                    currentPageReportTemplate="Mostrando {first} a {last} de {totalRecords}"

                    @rowSelect="selected" :filters="filters2" filterDisplay="menu" 
                    :globalFilterFields="['nameGlo', 'descripGlo']">

                    <template #empty>
                        No se encontraron resultados.
                    </template>
                    <template #loading>
                        Cargando resultados, por favor espere.
                    </template>

                    <span class="p-input-icon-left">
                        <i class="pi pi-search" />
                        <InputText v-model="filters2['hola'].value" placeholder="Nueva Búsqueda" />
                    </span>

                    <Column field="nameGlo" header="Palabra" style="font-weight: bold"></Column>
                    <Column field="descripGlo" header="Descripcion"></Column>

                    <template #paginatorLeft>
                        <Button type="button" icon="pi pi-refresh" class="p-button-text" />
                    </template>
                    <template #paginatorRight>
                        <Button type="button" icon="pi pi-cloud" class="p-button-text" />
                    </template>

                </DataTable>

            </Fieldset>       
            
        </div>  
    </div>
</template>


<script>
import A from "../jsons/A.json";
import GlossaryController from "../controller/GlossaryController.js";
import {FilterMatchMode,FilterOperator} from 'primevue/api';

export default{
	name: "Glosario",
    created(){
        this.glossaryController = new GlossaryController();
        this.initFilters1();
    },
    mounted(){
        //this.loading1 = false;   
        //this.getDataPagina(1);
    },           
	data() {   
        
        return{ 
            paginaActual:1,           
            letras:["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"],
			palabrasA: A.data,
            display: null,
            filters2: null,
            loading1: true,
        }	    
    },
    wordsA :A,
    glossaryController : null,
    
    methods:{
        getLetra(l){
            try{this.glossaryController.getLetter(l).then(data => {
                var info = data.data.data
                this.palabrasA = info;
            })}catch{console.log("Error Connection");}
        },
        getLetter: function(letra) {
            console.log(letra);            
        },
        isActive(numeroPagina){
            return numeroPagina == this.paginaActual ? 'active':'';
        },
        initFilters1() {
            this.filters2 = {
                'hola': {value: null, matchMode: FilterMatchMode.CONTAINS},
                'nameGlo': {operator: FilterOperator.AND, constraints: [{value: null, matchMode: FilterMatchMode.STARTS_WITH}]},
                'descripGlo': {operator: FilterOperator.AND, constraints: [{value: null, matchMode: FilterMatchMode.STARTS_WITH}]},
                'idUserC': {value: null, matchMode: FilterMatchMode.IN}
            }
        }    
    },
}

</script>

<style>
    
</style>