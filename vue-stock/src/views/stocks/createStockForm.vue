<template>
    <h1 class="text_center mt-3">주식 종목 등록</h1>
    <hr>
    <div class="col-md-12">
        <div class="col-md-4">
            <!-- <form> -->
                <div class="form-group">
                    <label for="stockName">주식 종목</label>
                    <input type="text" class="form-control" v-model="form.stockName" placeholder="주식 종목을 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="sector">섹터</label>
                    <input type="text" class="form-control" v-model="form.sector" placeholder="섹터를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="currentPrice">현재가</label>
                    <input type="number" class="form-control" v-model="form.currentPrice" placeholder="현재가를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="allTimeHighPrice">52주 최고가</label>
                    <input type="number" class="form-control" v-model="form.allTimeHighPrice" placeholder="52주 최고가를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="allTimeLowPrice">52주 최저가</label>
                    <input type="number" class="form-control" v-model="form.allTimeLowPrice" placeholder="52주 최저가를 입력하세요">
                </div>
                <br/>
                <div class="form-group">
                    <label for="priceEarningRatio">주가 수익 비율</label>
                    <input type="number" step="0.01" class="form-control" v-model="form.priceEarningRatio" placeholder="주가 수익 비율을 입력하세요">
                </div>
                <br/>
                <div class="form-group">
                    <label for="estimatePER">추정 주가 수익 비율</label>
                    <input type="number" step="0.01" class="form-control" v-model="form.estimatePER" placeholder="추정 주가 수익 비율을 입력하세요">
                </div>
                <br/>
                <div class="form-group">
                    <label for="priceBookValueRatio">주가 순자산 비율</label>
                    <input type="number" step="0.01" class="form-control" v-model="form.priceBookValueRatio" placeholder="주가 순자산 비율을 입력하세요">
                </div>
                <br/>
                <div class="form-group">
                    <label for="dividendRate">배당 수익률</label>
                    <input type="number" step="0.01" class="form-control" v-model="form.dividendRate" placeholder="배당 수익률을 입력하세요">
                </div>
                <br/>
                <div class="form-group">
                    <label for="quantity">수량</label>
                    <input type="number" class="form-control" v-model="form.quantity" placeholder="수량을 입력하세요" />
                </div>
                <br/>
                <div class="text_center">
                    <button class="btn btn-secondary me-2" @click="goHomePage">이전 페이지로</button>
                    <button class="btn btn-primary" @click="stockSave">등록 완료</button>
                </div>
            <!-- </form> -->
            <br/>
        </div>
    </div>

    <!-- Modal -->
    <Teleport to="#modal">
        <PostModal
            v-model="show"
            :message="modalMessage"
        />
    </Teleport>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { http } from '@/api/index.js';
import PostModal from '@/components/posts/PostModal.vue';

const router = useRouter();
const form = ref({
    stockName: null,
    sector: null,
    currentPrice: null,
    allTimeHighPrice: null,
    allTimeLowPrice: null,
    priceEarningRatio: null,
    estimatePER: null,
    priceBookValueRatio: null,
    dividendRate: null,
    quantity: null,
});

// 등록 함수
const stockSave = async () => {
    if (form.value.stockName == null || form.value.stockName == '') {
        openModal(modalMessage);
        return;
    }

    if (confirm('저장 하시겠습니까?') === false) {
        return;
    }

    try {
        await http.post('/stocks/new', { ...form.value });
        alert('저장이 완료되었습니다.');
        router.push({ name: 'StockList' });
    } catch (error) {
        console.error(error);
    }
}

const goHomePage = () => {
    router.push('/');
};

// modal
const show = ref(false);
const modalMessage = ref('주식 종목은 필수 입력 값입니다.');

const openModal = () => {
    show.value = true;
}

</script>

<style lang="scss" scoped>
</style>