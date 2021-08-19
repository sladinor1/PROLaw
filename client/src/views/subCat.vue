<template>
    <div>
        <br>
        <div class="tramite-container">
            <Fieldset class="p" legend="Descripción" :toggleable="true" :collapsed="false">
                {{datos.descripCate}}
            </Fieldset>
        </div>
        <div class="tramite-container">
            <Carousel :value="tramites" :numVisible="3" :numScroll="1" :responsiveOptions="responsiveOptions">
                <template #header>
                    <h5 style="text-align: center" >Trámites</h5>
                    <br>
                </template>
                <template #item="slotProps">
                    <div class="">
                        <div class="">
                            <div class="p-mb-3">
                                
                            </div>
                            <div>
                                <h4 class="p-mb-1">{{slotProps.data.nameSubcat}}</h4>
                                <p class="pp">{{slotProps.data.descripSubcat}}</p>
                                <div class="">
                                    <Button icon="pi pi-info-circle" label="Detalles" class="p-button-info" @click="$router.push({name: 'prd', params:{ ct: this.$route.params.cat} })"/>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </template>
            </Carousel>
        </div>
    </div>
</template>

<script>
import myjson from '../jsons/prueba.json';
import myjsonc from '../jsons/Civil.json';
export default {
    created() {
        let trm = [];
        for (let i in this.datos.subcategories){
            trm.push(this.datos.subcategories[i]);
        }
        
        this.tramites=trm;
        console.log(trm);
    },
    mounted() {
        //console.log(typeof this.datos.subcategories);
    },
    data (){
        return{
            datos: this.getdata(),
            tramites: [{},
            {}]
        }
    },
    methods: {
        getdata: function(){
            //let c = this.$route.params.cat;
            let c = localStorage.tramite;
            if (c ==  "Penal"){
                return myjson
            } else  if (c == "Civil"){
                return myjsonc
            } else {
                return myjson
            }
        }
    },   
}
</script>