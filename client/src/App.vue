<template>
  <div>
    <div v-if="!inside">
      <Menubar :model="items">
        <template #start>
          <img
            alt="logo"
            src="../src/assets/log.png"
            height="40"
            class="p-mr-2"
          />
        </template>
        <template #end> 
        </template>
      </Menubar>
      <router-view />
    </div>
    <div v-else>
      <Menubar :model="itemins">
        <template #start>
          <img
            alt="logo"
            src="../src/assets/log.png"
            height="40"
            class="p-mr-2"
          />
        </template>
        <template #end>
          <div>
            <div>
              <img
                alt=""
                src="../src/assets/user.png"
                width="70"
                class="p-mr-2"
              />
              Bienvenido {{ user }}
              <!--<SplitButton class="p-button-outlined p-button-success" icon="pi pi-bell" style="font-size: 1.5rem" v-badge="0" :model="items4"></SplitButton>-->
            </div>
          </div>
        </template>
      </Menubar>
      <router-view />
    </div>
    <v-footer>
      <br />
      <div class="footer-container">
        <div class="row">
          <div class="col">
            <div class="row">
              <div class="col letter">
                <div>Carrera 45 #26-85</div>
                <div>Edif. Uriel Gutierrez</div>
                <div>Bogota D.C., Colombia</div>
                <div>(+57 1) 316 50000</div>
              </div>
              <div class="col letter">
                <div>Copyright 2021</div>
                <div>Algunos derechos reservados</div>
                <div>
                  <router-link to="">Acerca de esta pagina</router-link>
                </div>
                <div>Contacto: prolaw@unal.edu.co</div>
              </div>
            </div>
          </div>
          <div class="col">
            <br />
            <img v-bind:src="image" :style="{ width: '500px' }" />
          </div>
        </div>
      </div>
    </v-footer>
  </div>
</template>

<script>

import myjson from "@/jsons/notif.json";
import img from "@/assets/log.png";
export default {
  name: "App",
  created() {
    this.items4 = myjson.data;
  },
  data() {
    return {
      id: "",
      inside: false,
      image: img,
      rol: "",
      user: "",
      items4: [
        { 
          label: "Ver todas las notificaciones",
          to: "/"
        }
      ],
      items: [
        { 
          label: "Home", icon: "pi pi-fw pi-home", to: "/" 
        },
        {
          label: "Registrarse",
          icon: "pi pi-fw pi-user-plus",
          to: "/Register",
        },
        {
          label: "Registrarse como abogado",
          icon: "pi pi-fw pi-user-plus",
          to: "/lawer",
        },
        { label: "Iniciar sesion", icon: "pi pi-fw pi-sign-in", to: "/login" },
      ],
      itemins: [
        { label: "Home", icon: "pi pi-fw pi-home", to: "/" },
        { label: "Edit", icon: "pi pi-fw pi-user", to: "" },
        {
          label: "Logout",
          icon: "pi pi-fw pi-sign-out",
          command: () => {
            this.user = "";
            this.inside = false;
          },
        },
      ],
    };
  },
  methods: {
    actualizar: function () {
      if (localStorage.inside) {
        this.inside = localStorage.inside;
      } else {
        localStorage.inside = this.inside;
      }
      if (localStorage.idU) {
        this.id = localStorage.idU;
      } else {
        localStorage.idU = this.id;
      }
      if (localStorage.user) {
        this.user = localStorage.user;
      } else {
        localStorage.user = this.user;
      }
      if (localStorage.rol) {
        this.rol = localStorage.rol;
      } else {
        localStorage.rol = this.rol;
      }
    },
  },
  components: {},
};
</script>

<style>

.letter {
  color: white;
}

h2,
label {
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
  margin-bottom: 0.83em;
  font-weight: bold;
}

a {
  text-align: end;
  font-size: medium;
}

.bg {
  width: 100%;
  height: 100vh;
  background-size: 100%;
}

.form-container {
  margin: auto;
  width: 40%;
  margin-top: 2%;
  top: 150vh;
  background: #fff;
  padding: 30px;
  border-radius: 5px;
  box-shadow: 0px 0px 5px 0px #000;
}

.search-container {
  margin: auto;
  width: 60%;
  margin-top: 2%;
}

.forum-container {
  margin: auto;
  width: 50%;
  margin-top: 2%;
  background: #fff;
}

.boton {
  width: 5px;
}

ul {
  font-weight: bold;
  font-size: larger;
}

.botonInicioSesion,
.botonRegistro {
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-weight: bold;
  display: block;
  font-size: 15px;

  cursor: pointer;

  background-color: rgb(13, 110, 253);

  border-radius: 14px;
  margin-left: auto;
  margin-right: auto;
}

.home-container {
  margin: auto;
  width: 90%;
  height: 610px;
  margin-top: 2%;
  top: 150vh;
  background: #fff;
  padding: 30px;
  border-radius: 5px;
  box-shadow: 0px 0px 5px 0px #000;
}

.t-container {
  margin: auto;
  width: 90%;
  height: 450px;
  margin-top: 2%;
  top: 150vh;
  background: #fff;
  padding: 30px;
  border-radius: 5px;
  box-shadow: 0px 0px 5px 0px #000;
}

.firma-container {
  margin: auto;
  width: 500px;
  height: 270px;
  margin-top: 1%;
  background: #fff;
  padding: 30px;
  border-radius: 5px;
}

.footer-container {
  width: 100%;
  height: 200px;
  border-radius: 5px;
  background: linear-gradient(to bottom, rgb(89, 168, 241), rgb(64, 0, 240));
}

.p {
  text-align: justify;
}

.pp {
  text-align: justify;
  width: 370px;
}

.menu-container {
  left: 50%;
}

.nav-container {
  margin: auto;
  width: 44%;
  margin-top: 2%;
  top: 150vh;
  padding: 30px;
  border-radius: 5px;
}

.tramite-container {
  margin: auto;
  width: 85%;
  margin-top: 2%;
  top: 150vh;
  padding: 30px;
  border-radius: 5px;
}

.detail-container {
  margin: auto;
  width: 70%;
  margin-top: 2%;
  top: 150vh;
  padding: 30px;
  border-radius: 5px;
}

.pregunta-container {
  margin: auto;
  width: 90%;
  margin-top: 2%;
  top: 150vh;
  padding: 30px;
  border-radius: 5px;
}

.cuadro-container {
  margin: auto;
  width: 200px;
  height: 200px;
  margin-top: 2%;
  top: 150vh;
  padding: 30px;
  border-radius: 5px;
}
</style>