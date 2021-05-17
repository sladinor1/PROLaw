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
import Dialog from 'primevue/dialog';
import FileUpload from 'primevue/fileupload';
import TabMenu from 'primevue/tabmenu';
import TabView from 'primevue/tabview';
import TabPanel from 'primevue/tabpanel';
import Fieldset from 'primevue/fieldset';
import Carousel from 'primevue/carousel';
import ScrollTop from 'primevue/scrolltop';
import ScrollPanel from 'primevue/scrollpanel';

const app = createApp(App)

app.use(PrimeVue);
app.use(VueCookies);
app.component("ScrollPanel", ScrollPanel);
app.component("ScrollTop", ScrollTop);
app.component("Fieldset", Fieldset);
app.component("TabView", TabView);
app.component("TabPanel", TabPanel);
app.component("Carousel", Carousel);
app.component("TabMenu", TabMenu);
app.component("Dialog", Dialog);
app.component("Checkbox", Checkbox);
app.component("FileUpload", FileUpload);
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
