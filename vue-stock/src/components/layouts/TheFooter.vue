<template>
    <hr py-4 />
    <div class="text_center">{{ showText }}
    </div> 
</template>

<script>
export default {
    name: "TheFooter",
    data() {
        return {
            showText: "© 2023 Company, Inc. All rights reserved.",
        }
    }
}
</script>

<style>
.text_center {
    text-align: center;
}
</style>