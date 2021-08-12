<template>
    <Card class="form-container">
        <template #header>
            <img alt="" src="@/assets/user.png" width="8%" class="p-mr-2">
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
            <Button icon="pi pi-send" label="Contactar" class="p-button-primary p-button-sm" style="margin-left: .5em ; font-weight: bold"/>
            <Button label="Cancelar" class="p-button-danger p-button-sm" style="margin-left: .5em ; font-weight: bold" icon="pi pi-times-circle" />
        </template>
    </Card>
</template>

<script>
import json from '../jsons/Perfiles.json';
import UserController from "../controller/UserController.js";
export default {
    userController: null,
    created() {
        this.id = this.$route.params.id;
        this.userController = new UserController();
        this.user = this.userController.getFirst(this.id).then(data => {
              console.log(data);
            })
    },
    data(){
        return {
            l:"hola",
            profile:json.data[0],
            id: '',
            user: null
        }
    }
}
</script>
