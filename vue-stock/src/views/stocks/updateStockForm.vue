<template>
    <AppLoading v-if="loading" />
    <div v-else>
        <h3 class="text_center mt-3">주식 종목 수정</h3>
        <hr>
        <div class="col-md-12">
            <div class="col-md-4">
                <!-- <form> -->
                    <div class="form-group">
                        <label for="id">주식 종목 번호</label>
                        <input type="text" class="form-control" id="id" v-model="form.id" readonly>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="stockName">주식 종목</label>
                        <input type="text" class="form-control" v-model="form.stockName" readonly>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="sector">섹터</label>
                        <input type="text" class="form-control" v-model="form.sector" readonly>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="currentPrice">현재가</label>
                        <input type="number" class="form-control" v-model="form.currentPrice">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="allTimeHighPrice">52주 최고가</label>
                        <input type="number" class="form-control" v-model="form.allTimeHighPrice">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="allTimeLowPrice">52주 최저가</label>
                        <input type="number" class="form-control" v-model="form.allTimeLowPrice">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="priceEarningRatio">주가 수익 비율</label>
                        <input type="number" step="0.01" class="form-control" v-model="form.priceEarningRatio">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="estimatePER">추정 주가 수익 비율</label>
                        <input type="number" step="0.01" class="form-control" v-model="form.estimatePER">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="priceBookValueRatio">주가 순자산 비율</label>
                        <input type="number" step="0.01" class="form-control" v-model="form.priceBookValueRatio">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="dividendRate">배당 수익률</label>
                        <input type="number" step="0.01" class="form-control" v-model="form.dividendRate">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="quantity">수량</label>
                        <input type="number" class="form-control" v-model="form.quantity">
                    </div>
                    <br/>
                    <div class="text_center">
                        <button class="btn btn-secondary me-2" @click="goStock">이전 페이지로</button>
                        <button class="btn btn-primary me-2" @click="updateStock">수정</button>
                        <button class="btn btn-danger" @click="deleteStock">삭제</button>
                    </div>
                <!-- </form> -->
                <br/>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { http } from '@/api/index.js';
import AppLoading from '@/components/apps/AppLoading.vue';

const route = useRoute();
const router = useRouter();
const loading = ref(true);
const form = ref(null);
const stockId = Number(route.params.id);

const searchParam = ref({
    stockId: stockId,
});

const searchList = async () => {
    const { data } = await http.post('/stocks/id', { ...searchParam.value });
    form.value = data;
    loading.value = false;
};

watchEffect(searchList);

const goStock = () => {
    router.push({ name: 'StockList' });
};

const updateStock = async () => {
    if (confirm('저장 하시겠습니까?') === false) {
        return;
    }

    try {
        await http.post('/stocks/update', { ...form.value });
        alert('수정이 완료되었습니다.');
        router.push({ name: 'StockList' });
    } catch (error) {
        console.error(error);
    }
};

const deleteStock = async () => {
    if (confirm('삭제 하시겠습니까?') === false) {
        return;
    }

    try {
        await http.post('/stocks/delete', { ...searchParam.value });
        alert('삭제가 완료되었습니다.');
        router.push({ name: 'StockList' });
    } catch (error) {
        console.error(error);
    }
};

</script>

<style lang="scss" scoped>

</style>