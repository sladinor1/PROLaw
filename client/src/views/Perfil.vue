<template>
    <Card class="form-container">
        <template #header>
            <img alt="" src="@/assets/user.png" width="10%" class="p-mr-2">
        </template>
        <template #title>
            {{profile.names}} {{ profile.lastnames}}
        </template>
        <template #subtitle>
            {{profile.especialidad}}
        </template>
        <template #content>
            Telefono: {{profile.phone}}
            <br>
            Email: {{profile.email}}
            <br>
            Ciudad: {{profile.city}}
        </template>
        <template #footer>
            <Button icon="" label="Contactar" />
            <Button icon="" label="Cancelar" class="p-button-secondary" style="margin-left: .5em" />
        </template>
    </Card>
</template>

<script>
import json from '../jsons/Perfiles.json';
export default {
    created() {
        
    },
    data(){
        return {
            l:"hola",
            profile:json.data[0]
        }
    }
}
</script>
