<template>
    <div>
        <div class="forum-container">
            <h3>{{pregunta}}</h3>
            <br>
            <div>
                <Textarea v-model="respuesta" rows="5" cols="107" placeholder="Escriba aqui su respuesta..." />
                <Button label="Responder" class="p-button-sm" @click="guardar"/> 
            </div>
            <br>
            <Panel header="Respuestas">
                <div v-for="i in rtas" :key="i">
                    <div>
                        {{i}}
                    </div>
                    <Divider >
                        <Button label="contactar" @click="$router.push('perfil')"/>
                    </Divider>
                </div>
            </Panel>
            
        </div>
    </div>
</template>

<script>

export default {
    data(){
        return{
            pregunta: '',
            rtas: [],
            respuesta: ''
        }
    }, 
    mounted() {
        if (localStorage.pregunta) {
            this.pregunta = localStorage.pregunta;
        } else {
            localStorage.pregunta = this.$route.params.qtn;
            //this.pregunta = this.$route.params.qtn;
        }
        if (localStorage.rtas) {
            this.rtas = JSON.parse(localStorage.getItem("rtas"));
            console.log(this.rtas);
        } else {
            localStorage.rtas = this.$route.params.rta;
            //this.rtas = this.$route.params.rta;
        }
    },
    methods: {
        guardar: function(){
            
        }
    },
}
</script>