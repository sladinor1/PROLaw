import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // <---
import axios from 'axios'
import VueAxios from 'vue-axios'
import PrimeVue from "primevue/config";
import InputText from "primevue/inputtext";
import 'primevue/resources/primevue.min.css'
import 'primevue/resources/themes/bootstrap4-light-blue/theme.css'
import Password from 'primevue/password';
import Dropdown from 'primevue/dropdown';
import 'primeicons/primeicons.css'
import Menubar from 'primevue/menubar';
import VueCookies from 'vue3-cookies';
import Card from 'primevue/card';
import Button from 'primevue/button';
import Checkbox from 'primevue/checkbox';
//import gAuth from 'vue3-google-auth';
import Dialog from 'primevue/dialog';
import FileUpload from 'primevue/fileupload';
//import GoogleLogin from 'vue-google-login';
//import VueFormulate from '@braid/vue-formulate'
 
/*const $gAuth = gAuth.createGAuth({
  clientId: YOUR_CLIENT_ID,
  scope: YOUR_SCOPE,
  prompt: YOUR_PROMPT,
});*/

const app = createApp(App)

app.use(PrimeVue);
app.use(VueCookies);
//app.use(GoogleLogin);
app.component("Dialog", Dialog)
app.component("Checkbox", Checkbox)
app.component("FileUpload", FileUpload)
app.component("Button", Button);
app.component("Card", Card);
app.component("Menubar", Menubar);
app.component("Dropdown", Dropdown);
app.component("Password", Password);
app.component("InputText", InputText);
app.use(VueAxios, axios);
app.use(router);
//app.use($gAuth);

app.mount('#app')
