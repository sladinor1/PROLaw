<template>
       <div class="glosario-container">
     
        <div class="tramite-container">
            <Fieldset class="p" legend="Glosario" :toggleable="true" :collapsed="false">
                
                <nav aria-label="Page glosary example">
                    <ul class="pagination justify-content-center">
                        <li v-for="letra in letras" v-on:click="getLetter" class="page-item" 
                            v-bind:class="isActive()" :key="letra"><a class="page-link" href="#">{{letra}}</a></li>                        
                    </ul>
                </nav>
                
                <table class="table">
                    <tr v-for="item in palabrasA" :key="item">
                        <td><strong>{{item.nameGlo}}</strong></td>
                        <td>{{item.descripGlo}}</td>
                    </tr>
                </table>   

                <DataTable :value="data" :paginator="ture" :rows="10">
                    <Column field="vin" header="Vin"></Column>
                    <Column field="year" header="Year"></Column>
                    <Column field="brand" header="Brand"></Column>
                    <Column field="color" header="Color"></Column>
                </DataTable>

                <Paginator :rows="10" :totalRecords="totalRecords2"></Paginator>

                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-end">
                        <li class="page-item" v-if="paginaActual != 1" v-on:click="getPreviosPage()"><a class="page-link outline-primary" href="#">Anterior</a></li>
                        <li v-for="pagina in totalPaginas()" :key="pagina" v-on:click="getDataPagina(pagina)" class="page-item" v-bind:class="isActive(pagina)"><a class="page-link" href="#">{{pagina}}</a></li>
                        <li class="page-item" v-on:click="getNextPage()"><a class="page-link" href="#">Siguiente</a></li>
                    </ul>
                </nav>
            </Fieldset>       
            
        </div>  
    </div>
</template>


<script>
import GlossaryController from "../controller/GlossaryController.js";
import GetData from "../controller/GetData.js";
import A from "../jsons/A.json";
import B from "../jsons/B.json";
export default{
	name: "Glosario",           
	data() {   
        
        return{ 
            datos:B,
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
    getData: null,
    glossaryController : null,
    created(){
        this.glossaryController = new GlossaryController();
        this.getData = new GetData();
    },
    mounted(){
        this.getDataPagina(1);
    },
    methods:{
        getLetter: function() {
            this.palabrasA= this.datos.data;
            
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