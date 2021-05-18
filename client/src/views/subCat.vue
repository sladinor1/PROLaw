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
                                <p class="p">{{slotProps.data.descripSubcat}}</p>
                                <div class="">
                                    <Button icon="pi pi-info-circle" label="Detalles" class="p-button-info" @click="$router.push({name: 'details' })"/>
                                    <Button icon="pi pi-list" label="Abogados" class="p-button-help" @click="$router.push('')"/>
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
export default {
    mounted() {
        console.log(typeof this.datos.subcategories);
    },
    data (){
        return{
            datos: myjson,
            tramites: [
                {idSubcat: 2,
                nameSubcat: "Procedimiento especial abreviado",
                descripSubcat: "La ley del procedimiento penal abreviado y de acusador privado, o Ley 1826, entró en vigencia desde el pasado 13 de julio de 2017 y tiene 44 artículos que pretenden ayudar a que las víctimas tengan un papel más activo en los procesos relacionados con delitos menores, permitiéndoles investigar y acusar con el apoyo de un abogado profesional o estudiantes de consultorio jurídico. ",
                idsProcedu: "2" },
                { }
            ]
        }
    }    
}
</script>