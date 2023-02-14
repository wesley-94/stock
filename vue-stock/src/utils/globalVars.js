import axios from 'axios';

axios.defaults.baseURL = process.env.VUE_APP_API_URL;
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8';
axios.defaults.headers['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers['Access-Control-Allow-Credentials'] = true;

export default {
    install(Vue) {
        Vue.config.globalProperties.$axios = axios;
    }
}