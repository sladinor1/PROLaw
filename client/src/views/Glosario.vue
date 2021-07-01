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
                currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
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
import B from "../jsons/B.json";
import C from "../jsons/C.json";
import D from "../jsons/D.json";
import E from "../jsons/E.json";
import F from "../jsons/F.json";
import G from "../jsons/G.json";
import H from "../jsons/H.json";
import I from "../jsons/I.json";
import J from "../jsons/J.json";
import K from "../jsons/K.json";
import L from "../jsons/L.json";
import M from "../jsons/M.json";
import N from "../jsons/N.json";
import O from "../jsons/O.json";
import P from "../jsons/P.json";
import Q from "../jsons/Q.json";
import R from "../jsons/R.json";
import S from "../jsons/S.json";
import T from "../jsons/T.json";
import U from "../jsons/U.json";
import V from "../jsons/V.json";
export default{
	name: "Glosario",           
	data() {   
        
        return{ 
            pal: {},
            A: A.data,
            B : B.data,
            C: C.data,
            D: D.data,
            E: E.data,
            F :F.data,
            G :G.data,
            H:H.data,
            I:I.data,
            J:J.data,
            K:K.data,
            L:L.data,
            M:M.data,
            N:N.data,
            O:O.data,
            P:P.data,
            Q:Q.data,
            R:R.data,
            S:S.data,
            T:T.data,
            U:U.data,
            V:V.data,
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
            
            this.pal = this.glossaryController.getLetter(l);
            console.log(this.pal);
            
            if(l == "A") {this.palabrasA= this.A;}
            if(l == "B") {this.palabrasA= this.B;}
            if(l == "C") {this.palabrasA = this.C;}
            if(l == "D") {this.palabrasA= this.D;}
            if(l == "E") {this.palabrasA= this.E;}
            if(l == "F") {this.palabrasA = this.F;}
            if(l == "G") {this.palabrasA= this.G;}
            if(l == "H") {this.palabrasA= this.H;}
            if(l == "I") {this.palabrasA = this.I;}
            if(l == "J") {this.palabrasA= this.J;}
            if(l == "K") {this.palabrasA= this.K;}
            if(l == "L") {this.palabrasA = this.L;}
            if(l == "M") {this.palabrasA= this.M;}
            if(l == "N") {this.palabrasA= this.N;}
            if(l == "O") {this.palabrasA = this.O;}
            if(l == "P") {this.palabrasA= this.P;}
            if(l == "Q") {this.palabrasA= this.Q;}
            if(l == "R") {this.palabrasA = this.R;}
            if(l == "S") {this.palabrasA= this.S;}
            if(l == "T") {this.palabrasA= this.T;}
            if(l == "U") {this.palabrasA = this.U;}
            if(l == "V") {this.palabrasA = this.V;}
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