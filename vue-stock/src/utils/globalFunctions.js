export default {
    install(Vue) {
        // 1. [로컬 스토리지 데이터 저장]
        Vue.config.globalProperties.$setLocalStorage = function(key, value) {
            localStorage.setItem(key, value);
        }

        // 2. [로컬 스토리지 저장 값 호출]
        Vue.config.globalProperties.$getLocalStorage = function(key) {
            return localStorage.getItem(key);
        }

        // 3. [로컬 스토리지 특정 값 삭제]
        Vue.config.globalProperties.$deleteItemLocalStorage = function(key) {
            localStorage.removeItem(key);
        }

        // 4. [로컬 스토리지 전체 데이터 삭제]
        Vue.config.globalProperties.$deleteAllLocalStorage = function() {
            localStorage.clear();
        }
    }
}