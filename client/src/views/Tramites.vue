<template>
    <div>
        <div class="t-container">
            <Carousel :value="categorias" :numVisible="3" :numScroll="1" :responsiveOptions="responsiveOptions">
                <template #header>
                    <h5 style="text-align: center" >Categorias</h5>
                    <br>
                </template>
                <template #item="slotProps">
                    <div class="">
                        <div class="">
                            <div class="p-mb-3">
                                <img :src="require(`@/assets/${slotProps.data.src}`)" class="" :style="{ width: '250px' , height: '250px'}"/>
                            </div>
                            <div>
                                <h4 class="p-mb-1">{{slotProps.data.name}}</h4>
                                
                                <div class="">
                                   <Button icon="pi pi-info-circle" label="Tramites" class="p-button-info" @click="newtramite(slotProps.data.name)"/>
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
//import img2 from '@/assets/penal.jpg';
//import img3 from '@/assets/fondo.jpg';
export default {
    created(){
        
    },
    methods: {
        newtramite: function(t){
            localStorage.tramite = t;
            this.$router.push({name: 'sub' , params:{ cat: t }});
        }
    },
    data(){
        return{
            categorias: [
                //{src: 'violencia.jpg', name: 'Violencia intrafamiliar', description:'' },
                {src: 'penal.jpg', name: 'Penal', description:''},
                {src: 'fondo.jpg', name: 'Civil', description:''},
                {src: 'fondo.jpg', name: 'NA', description:''},
                {src: 'fondo.jpg', name: 'NA', description:''}
            ],
            responsiveOptions: [
				{
					breakpoint: '1024px',
					numVisible: 3,
					numScroll: 3
				},
				{
					breakpoint: '600px',
					numVisible: 2,
					numScroll: 2
				},
				{
					breakpoint: '480px',
					numVisible: 1,
					numScroll: 1
				}
			]
        }
    }
}
</script>

<style scoped>

</style>