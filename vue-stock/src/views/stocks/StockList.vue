<template>
    <AppLoading v-if="loading" />
    <div v-else>
        <h3 class="text_center mt-3">주식 종목 정보</h3>
        <hr>
        <!-- 표시 건수 제한 -->
        <PostFilter
            :limit="searchParam.pageLimit"
            @update:limit="changeLimit"
        />
        <template v-if=!isExist>
            <p class="text-center py-4 text-muted">No Results</p>
        </template>
        <template v-else>
            <div class="mt-3 col-md-12">
                <!-- 목록 출력 영역 -->
                <table class="table table-striped">
                    <thead class="thead-strong">
                        <th v-for='(item, index) in title' :key='index'>{{ item }}</th>
                    </thead>
                    <tbody id="tbody">
                        <tr v-for='(item, index) in dataTable' :key='index'>
                            <td>{{ item.id }}</td>
                            <td @click="updateItem(item.id)"><u>{{ item.stockName }}</u></td>
                            <td>{{ item.sector }}</td>
                            <td>{{ item.currentPrice }}</td>
                            <td>{{ item.allTimeHighPrice }}</td>
                            <td>{{ item.allTimeLowPrice }}</td>
                            <td>{{ item.priceEarningRatio }}</td>
                            <td>{{ item.estimatePER }}</td>
                            <td>{{ item.priceBookValueRatio }}</td>
                            <td>{{ item.dividendRate }}</td>
                            <td>{{ item.quantity }}</td>
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
            
            <div class="mt-2 text_center">
                <button class="btn btn-secondary me-2" @click="goHomePage">메인 페이지로 이동</button>
            </div>
        </template>
    </div>
</template>

<script setup>
import { ref, computed, watchEffect } from 'vue';
import { useRouter } from 'vue-router';
import { http } from '@/api/index.js';
import PostFilter from '@/components/posts/PostFilter.vue';

const router = useRouter();
const dataTable = ref([]);
const totalCount = ref(null);
const isExist = ref(null);
const loading = ref(true);

const title = ["ID", "주식 종목", "섹터", "현재가", "52주 최고가", "52주 최저가", "주가 수익 비율", "추정 주가 수익 비율", "주가 순자산 비율", "배당 수익률", "수량"];

const searchParam = ref({
    // pagination vars
    currentPage: 1, // 초기값
    pageLimit: 5, // 초기값
});

const changeLimit = value => {
    searchParam.value.pageLimit = parseInt(value);
    searchParam.value.currentPage = 1;
}

const searchList = async () => {
    const { data } = await http.post('/stocks', { ...searchParam.value });
    totalCount.value = data.count;
    dataTable.value = data.stocks;
    isExist.value = (data.stocks && data.stocks.length > 0);
    loading.value = false;
};

watchEffect(searchList);

const pageCount = computed(() => 
    Math.ceil(totalCount.value / searchParam.value.pageLimit),
);

const goHomePage = () => {
    router.push('/');
};

const updateItem = (id) => {
    router.push({
        name: 'UpdateStock',
        params: {
            id,
        }
    });
};

</script>

<style>
.text_right {
    text-align: right;
}
</style>