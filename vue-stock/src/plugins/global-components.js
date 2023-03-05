import AppLoading from '@/components/apps/AppLoading.vue';
import AppModal from '@/components/apps/AppModal.vue';
import AppPagination from '@/components/apps/AppPagination.vue';

export default {
    install(app) {
        app.component('AppLoading', AppLoading);
        app.component('AppModal', AppModal);
        app.component('AppPagination', AppPagination);
    }
}