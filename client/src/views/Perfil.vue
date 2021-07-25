<template>
    <Card class="form-container">
        <template #header>
            <img alt="" src="@/assets/user.png" width="10%" class="p-mr-2">
        </template>
        <template #title>
            {{profile.nameUser}} {{ profile.lastNameUser}}
        </template>
        <template #subtitle>
            {{law.espeLaw}}
        </template>
        <template #content>
            Telefono: {{profile.celUser}}
            <br>
            Email: {{profile.emailUser}}
            <br>
            Ciudad: {{profile.idCity}}
        </template>
        <template #footer>
            <Button icon="" label="Contactar" />
            <Button icon="" label="Cancelar" class="p-button-secondary" style="margin-left: .5em" />
        </template>
    </Card>
</template>

<script>
//import json from '../jsons/Perfiles.json';
import UserController from "../controller/UserController.js";
export default {
    userController: null,
    created() {
        this.id = this.$route.params.id;
        this.userController = new UserController();
        try{this.userController.getFirst(this.id).then(data => {
              this.profile = data.data.user;
              this.law = data.data.law;
              console.log(this.profile);
        })}catch{console.log("Error Connection");}
    },
    data(){
        return {
            l:"hola",
            profile: null,
            id: '',
            law: null
        }
    }
}
</script>
