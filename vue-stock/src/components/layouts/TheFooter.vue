<template>
    <hr />
    <div class="container">
        <p>&nbsp;&nbsp;Copyright © 2023</p>
        <ul>
            <li>Contact: {{ email }}</li>
        </ul>
    </div>
</template>

<script>
export default {
    name: "TheFooter",
    data() {
        return {
            email: "rladhlthf123@naver.com",
        }
    }
}
</script>

<style lang="scss" scoped>
</style>