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
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import ColumnGroup from 'primevue/columngroup';  
import Paginator from 'primevue/paginator';
import Divider from 'primevue/divider';
import Panel from 'primevue/panel';
import Textarea from 'primevue/textarea';
import {FilterService} from 'primevue/api';
import Badge from 'primevue/badge';
import BadgeDirective from 'primevue/badgedirective';
import Toolbar from 'primevue/toolbar';
import SplitButton from 'primevue/splitbutton';


const app = createApp(App)

app.directive('badge', BadgeDirective);
app.use(PrimeVue);
app.use(VueCookies);
app.component("ScrollPanel", ScrollPanel);
app.component("SplitButton", SplitButton);
app.component("Toolbar", Toolbar);
app.component("Badge", Badge);
app.component("Textarea", Textarea);
app.component("Panel", Panel);
app.component("Divider", Divider);
app.component("Column", Column);
app.component("DataTable", DataTable);
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
app.component("DataTable", DataTable);
app.component("Column", Column);
app.component("ColumnGroup", ColumnGroup);
app.component("Paginator", Paginator);
app.component("FilterService", FilterService);
app.use(VueAxios, axios);
app.use(router);
//app.use($gAuth);

app.mount('#app')
