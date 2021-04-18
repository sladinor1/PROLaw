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
import TabMenu from 'primevue/tabmenu';
//import VueFormulate from '@braid/vue-formulate'

const app = createApp(App)

app.use(PrimeVue);
app.component("TabMenu", TabMenu);
app.component("Dropdown", Dropdown);
app.component("Password", Password);
app.component("InputText", InputText);
app.use(VueAxios, axios)
app.use(router)

app.mount('#app')
