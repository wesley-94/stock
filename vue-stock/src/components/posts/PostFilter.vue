<template>
    <!-- 표시 건수 제한 -->
    <div class="row g-3">
        <div class="col"></div>
        <div class="col-1">
            <select 
                :value="limit"
                @input="$emit('update:limit', $event.target.value)"
                class="form-select"
            >
                <option value=1>1건</option>
                <option value=3>3건</option>
                <option value=5>5건</option>
                <option value=10>10건</option>
            </select>
        </div>
    </div>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue';

defineProps({
    limit: [Number, String],
})

defineEmits(['update:limit']);

</script>

<style lang="scss" scoped>
</style>