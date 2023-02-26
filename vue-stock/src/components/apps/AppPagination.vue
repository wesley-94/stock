<template>
    <nav class="mt-5" aria-label="Page navigation example">
        <div class="pagination justify-content-center">
            <ul class="pagination">
                <li class="page-item" :class="isPrevPage">
                    <a 
                        class="page-link" 
                        href="#" 
                        aria-label="Previous" 
                        @click.prevent="$emit('page', currentPage - 1)"
                    >
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li 
                    v-for="page in pageCount"
                    :key="page"
                    class="page-item"
                    :class="{ active: currentPage === page }"
                >
                    <a class="page-link" href="#" @click.prevent="$emit('page', page)">{{ page }}</a>
                </li>
                <li class="page-item" :class="isNextPage">
                    <a 
                        class="page-link"
                        href="#" 
                        aria-label="Next"
                        @click.prevent="$emit('page', currentPage + 1)">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script setup>
import { computed, defineProps, defineEmits } from 'vue';

const props = defineProps({
    currentPage: {
        type: Number,
        required: true,
    },
    pageCount: {
        type: Number,
        required: true,
    }
});
defineEmits(['page']);
const isPrevPage = computed(() => ({ disabled: !(props.currentPage > 1) }));
const isNextPage = computed(() => ({
    disabled: !(props.currentPage < props.pageCount),
}));

</script>

<style lang="scss" scoped>
</style>