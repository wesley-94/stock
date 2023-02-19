<template>
    <div class="col-md-12">
        <!-- 목록 출력 영역 -->
        <table class="table table-striped">
            <thead class="thead-strong">
            <tr>
                <th>ID</th> 
                <th>이름</th> 
                <th>도시</th> 
                <th>거리</th> 
                <th>우편번호</th> 
            </tr>
            </thead>
            <tbody id="tbody">
                <!-- members 정보 가져와야 함 / 현재는 하드코딩 -->
                <tr v-for='(item, index) in dataTable' :key='index'>
                    <td>{{ item.id }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.address.city }}</td>
                    <td>{{ item.address.street }}</td>
                    <td>{{ item.address.zipcode }}</td>
                </tr>
            </tbody>
        </table>
        <div class="text_center">
            <button class="btn btn-secondary" @click="goHomePage">메인 페이지로 이동</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { http } from '@/api/index.js';

const router = useRouter();
const dataTable = ref([]);

const searchList = async () => {
    const { data } = await http.get('/members', {});
    dataTable.value = data;
};

searchList();

const goHomePage = () => {
    router.push('/');
}
</script>

<style lang="scss" scoped>
</style>