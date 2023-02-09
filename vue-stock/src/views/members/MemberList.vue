<template>
    <div class="col-md-12">
        <!-- 목록 출력 영역 -->
        <table class="table table-striped">
            <thead class="thead-strong">
            <tr>
                <th>#</th> 
                <th>이름</th> 
                <th>도시</th> 
                <th>거리</th> 
                <th>우편번호</th> 
            </tr>
            </thead>
            <tbody id="tbody">
                <!-- members 정보 가져와야 함 / 현재는 하드코딩 -->
                <tr>
                    <td>1</td>
                    <td>김외솔</td>
                    <td>서울특별시</td>
                    <td>은평구 진관1로</td>
                    <td>03310</td>
                </tr>
            </tbody>
        </table>
        <div class="text_center">
            <button class="btn btn-secondary" @click="goHomePage">메인 페이지로 이동</button>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();
const goHomePage = () => {
    router.push('/');
}
</script>

<style lang="scss" scoped>
</style>