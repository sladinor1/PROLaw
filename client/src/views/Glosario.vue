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
                <DataTable :value="palabrasA" :paginator="true" :rows="10"
                paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
                :rowsPerPageOptions="[10,20,50]" responsiveLayout="scroll"
                currentPageReportTemplate="Mostrando {first} a {last} de {totalRecords}">
                    <Column field="nameGlo" header="Palabra"></Column>
                    <Column field="descripGlo" header="Descripcion"></Column>
                    <template #paginatorLeft>
                        <Button type="button" icon="pi pi-refresh" class="p-button-text" />
                    </template>
                    <template #paginatorRight>
                        <Button type="button" icon="pi pi-cloud" class="p-button-text" />
                    </template>
                </DataTable>

                <!--<DataTable :value="data" :paginator="true" :rows="10">
                    
                    <Column field="brand" header="Brand"></Column>
                    <Column field="color" header="Color"></Column>
                </DataTable>-->

                <!--<Paginator :rows="10" :totalRecords="totalRecords2"></Paginator>-->

                <!--<nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-end">
                        <li class="page-item" v-if="paginaActual != 1" v-on:click="getPreviosPage()"><a class="page-link outline-primary" href="#">Anterior</a></li>
                        <li v-for="pagina in totalPaginas()" :key="pagina" v-on:click="getDataPagina(pagina)" class="page-item" v-bind:class="isActive(pagina)"><a class="page-link" href="#">{{pagina}}</a></li>
                        <li class="page-item" v-on:click="getNextPage()"><a class="page-link" href="#">Siguiente</a></li>
                    </ul>
                </nav>-->
            </Fieldset>       
            
        </div>  
    </div>
</template>


<script>
import GlossaryController from "../controller/GlossaryController.js";
import A from "../jsons/A.json";
export default{
	name: "Glosario",           
	data() {   
        
        return{ 
            totalRecords: 120,
            totalRecords2: 12,
            paginaActual:1,          
            elementosPorPagina:10, 
            contador: 0, 
            datosPaginados:[],     
            letras:["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"],
            datosPaginadosByLetra: [],   
			palabrasA: A.data
        }	    
    },
    wordsA :A,
    glossaryController : null,
    created(){
        this.glossaryController = new GlossaryController();
    },
    mounted(){
        this.getDataPagina(1);
    },
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
        totalPaginas(){
            console.log(this.palabrasA.length);
            return Math.ceil(this.palabrasA.length / this.elementosPorPagina)
        },
        getDataPagina(noPagina){
            this.paginaActual = noPagina;
            this.datosPaginados = [];
            let ini =(noPagina * this.elementosPorPagina) - this.elementosPorPagina;
            let fin =(noPagina * this.elementosPorPagina);
            this.datosPaginados = this.palabrasA.slice(ini,fin);
        },
        getPreviosPage(){
            if(this.paginaActual > 1){
                this.paginaActual--;
            }
            this.getDataPagina(this.paginaActual);
        },
        getNextPage(){
            if(this.paginaActual < this.totalPaginas()){
                this.paginaActual++;
            }
            this.getDataPagina(this.paginaActual);
        },
        isActive(numeroPagina){
            return numeroPagina == this.paginaActual ? 'active':'';
        }    
    },
}

</script>

<style>
    
</style>