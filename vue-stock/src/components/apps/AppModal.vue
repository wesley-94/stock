<template>
    <!-- Modal -->
    <div v-if="modelValue">
        <div class="modal-backdrop fade show"></div>
        <div class="modal fade show d-block" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <slot name="header">
                            <h4 class="me-2 modal-title" id="exampleModalLabel">{{ title }}</h4>
                            <button type="button" class="btn-close" aria-label="Close" @click="$emit('update:modelValue', false)"></button>
                        </slot>
                    </div>
                    <div class="modal-body">
                        <slot></slot>
                    </div>
                    <div class="modal-footer">
                        <slot name="actions"></slot>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue';

defineProps({
    modelValue: Boolean,
    title: String,
})

defineEmits(['close', 'update:modelValue']);
</script>

<style scoped>
.v-enter-from,
.v-leave-to {
	opacity: 0;
}
.v-enter-active,
.v-leave-active {
	transition: all 0.5s ease;
}
.v-enter-to,
.v-leave-from {
	opacity: 1;
}
</style>