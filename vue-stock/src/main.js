import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import { createPinia } from 'pinia';
import globalComponents from './plugins/global-components.js';

const app = createApp(App);

app.use(router);
app.use(globalComponents);
app.use(createPinia());
app.mount('#app');