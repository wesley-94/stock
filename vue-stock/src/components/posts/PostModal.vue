<template>
    <AppModal v-model="show" title="알림">
        <template #default>
            <div class="row g-3">
                <div class="text-muted">{{ message }}</div>
            </div>
        </template>
        <template #actions>
            <button type="button" class="btn btn-primary" @click="closeModal">확인</button>
            <button type="button" class="btn btn-secondary" @click="closeModal">닫기</button>
        </template>
    </AppModal>
</template>

<script setup>
import AppModal from '@/components/apps/AppModal.vue';
import { computed, defineProps, defineEmits } from 'vue';
const props = defineProps({
    modelValue: Boolean,
    message: String,
});
const emit = defineEmits(['update:modelValue']);

const show = computed({
    get() {
        return props.modelValue
    },
    set(value) {
        emit('update:modelValue', value);
    },
})

const closeModal = () => (show.value = false);
</script>

<style lang="scss" scoped></style>