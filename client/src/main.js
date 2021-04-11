import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // <---
//import VueFormulate from '@braid/vue-formulate'

const app = createApp(App)

app.use(router)

app.mount('#app')
