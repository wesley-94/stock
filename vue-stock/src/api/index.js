import axios from "axios";

export const http = axios.create({
    baseURL: process.env.VUE_APP_API_URL,
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=utf-8',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': true,
    },
    timeout: 1000 * 180,
    // withCredentials: true,
});