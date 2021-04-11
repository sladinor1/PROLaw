import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // <---
import axios from 'axios'
import VueAxios from 'vue-axios'
//import VueFormulate from '@braid/vue-formulate'

const app = createApp(App)

app.use(VueAxios, axios)
app.use(router)

app.mount('#app')
