import axios from 'axios';

axios.defaults.baseURL = process.env.VUE_APP_API_URL;
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8';
axios.defaults.headers['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers['Access-Control-Allow-Credentials'] = true;

const axiosInstance = axios.create();

export default {
    install(Vue) {
        // 1. axios 변수 설정
        Vue.config.globalProperties.$axios = axios;

        // 2. axiosInstance 변수 설정
        Vue.config.globalProperties.$axiosInstance = axiosInstance;
    }
}