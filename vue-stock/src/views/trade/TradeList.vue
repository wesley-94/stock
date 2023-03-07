<template>
    <h3 class="text_center mt-3">거래 정보</h3>
    <hr>
    <!-- 표시 건수 제한 -->
    <PostFilter
        :limit="searchParam.pageLimit"
        @update:limit="changeLimit"
    />
    <div>
        <div style="float:left; width: 25%; margin-left: 10px; margin-right: 10px;">
                <label for="member">거래 회원</label>
                <input type="text" class="form-control" v-model="searchParam.name" placeholder="회원명" />
        </div>
        <div style="float:left; width: 25%; margin-left: 10px; margin-right: 10px;">
            <label for="trade">거래 상태</label>
            <select class="form-control" v-model="searchParam.status">
                <option value="TRADE">거래</option>
                <option value="CANCEL">취소</option>
            </select>
        </div>
    </div>
    <div>
        <template v-if="isExist">
            <div class="mt-4 col-md-12">
                <!-- 목록 출력 영역 -->
                <table class="table table-striped">
                    <thead class="thead-strong">
                        <th v-for='(item, index) in title' :key='index'>{{ item }}</th>
                    </thead>
                    <tbody id="tbody">
                        <tr v-for='(item, index) in dataTable' :key='index'>
                            <td>{{ item[0] }}</td>
                            <td>{{ item[1] }}</td>
                            <td>{{ item[2] }}</td>
                            <td>{{ item[3] }}</td>
                            <td>{{ item[4] }}</td>
                            <td>{{ item[5] }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        
            <!-- Pagination -->
            <AppPagination 
                :current-page="searchParam.currentPage"
                :page-count="pageCount"
                @page="page => (searchParam.currentPage = page)"
            />
        </template>
        <template v-else>
            <div style="padding:250px;">
                <p class="text-center py-4">No Results</p>
            </div>
        </template>
    </div>
    
    <div class="mt-2 text_center">
        <button class="btn btn-secondary me-2" @click="goHomePage">메인 페이지로 이동</button>
        <button class="btn btn-primary" @click="searchList">검색</button>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import { http } from '@/api/index.js';
import PostFilter from '@/components/posts/PostFilter.vue';
import AppPagination from '@/components/apps/AppPagination.vue';

const router = useRouter();
const dataTable = ref([]);
const totalCount = ref(null);
const isExist = ref(null);

const title = ["ID", "회원명", "거래 종목 이름", "거래 종목 가격", "거래 수량", "상태"];

const searchParam = ref({
    // searchCondition
    name: null,
    status: null,

    // pagination vars
    currentPage: 1, // 초기값
    pageLimit: 5, // 초기값
});

const changeLimit = value => {
    searchParam.value.pageLimit = parseInt(value);
    searchParam.value.currentPage = 1;
}

const searchList = async () => {
    if (searchParam.value.name == null || searchParam.value.name == '') {
        openModal(modalMessage);
        return;
    }

    if (confirm('검색 하시겠습니까?') === false) {
        return;
    }

    const { data } = await http.post('/trades', { ...searchParam.value });
    totalCount.value = data.count;
    dataTable.value = data.trades;
    isExist.value = (data.trades && data.trades.length > 0);
};

// watchEffect(searchList);

const pageCount = computed(() => 
    Math.ceil(totalCount.value / searchParam.value.pageLimit),
);

const goHomePage = () => {
    router.push('/');
}

// modal
const show = ref(false);
const modalMessage = ref('이름은 필수 입력 값입니다.');

const openModal = () => {
    show.value = true;
}

</script>

<style>
.text_left {
    text-align: left;
}
.text_right {
    text-align: right;
}
</style>