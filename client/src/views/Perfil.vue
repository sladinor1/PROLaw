<template>
  <div>
    <Dialog :visible="display">
      <label>Ingrese aca su telefono</label>
      <br>
      <label>¡Tambien puedes contactarlo tu!</label>
      <br>
      <InputText type="text" v-model="telefono" />
      <Button icon="" label="Contactar" @click="sendEmail" />
    </Dialog>
    <Card class="form-container">
      <template #header>
        <img alt="" src="@/assets/user.png" width="10%" class="p-mr-2" />
      </template>
      <template #title>
        {{ profile.nameUser }} {{ profile.lastNameUser }}
      </template>
      <template #subtitle>
        {{ law.espeLaw }}
      </template>
      <template #content>
        Telefono: {{ profile.celUser }}
        <br />
        Email: {{ profile.emailUser }}
        <br />
        Ciudad: {{ profile.idCity }}
      </template>
      <template #footer>
        <Button icon="" label="Contactar" @click="activate" />
        <!--<Button icon="" label="Cancelar" class="p-button-secondary" style="margin-left: .5em" />-->
      </template>
    </Card>
  </div>
</template>

<script>
//import json from '../jsons/Perfiles.json';
import UserController from "../controller/UserController.js";
import emailjs from "emailjs-com";
export default {
  userController: null,
  created() {
    this.id = this.$route.params.id;
    this.userController = new UserController();
    try {
      this.userController.getFirst(this.id).then((data) => {
        this.profile = data.data.user;
        this.law = data.data.law;
        console.log(this.profile);
      });
    } catch {
      console.log("Error Connection");
    }
  },
  data() {
    return {
      l: "hola",
      profile: {
        nameUser: "",
        lastNameUser: "",
        celUser: "",
        emailUser: "",
        idCity: "",
      },
      id: "",
      law: {
        espeLaw: "",
      },
      telefono: '',
      display: false
    };
  },
  methods: {
    sendEmail() {
      emailjs.init("user_PuldBtDHzIERDbKP27eyT");
      try {
        emailjs.send("service_0e62a5b", "template_akw775l", {
          to_name: this.profile.nameUser,
          reply_to: this.profile.emailUser,
          numero: this.telefono,
          asunto: localStorage.pregunta
        });
      } catch (error) {
        console.log({ error });
      }
      this.display = false;
    },
    activate: function(){
        this.display = true;
    }
  },
};
</script>
