<template>
    <h3 class="text_center mt-3">거래 등록</h3>
    <hr>
    <template v-if=!isStockExist>
        <p class="text-center py-4 text-muted">No Results</p>
    </template>
    <template v-else>
        <div class="col-md-12">
            <div class="col-md-4">
                <!-- <form role="form" action="/trade" method="post"> -->
                    <div class="form-group">
                        <label for="member">거래 회원</label>
                        <select name="memberId" id="member" class="form-control" v-model="form.memberId">
                            <option v-for='member in memberTable' :key='member.id' :value='member.id'>
                                {{ member.name }}
                            </option>
                        </select>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="stock">주식명</label>
                        <select name="stockId" id="stock" class="form-control" v-model="form.stockId">
                            <option v-for='stock in stockTable' :key='stock.id' :value='stock.id'>
                                {{ stock.stockName }}
                            </option>
                        </select>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="count">거래 수량</label>
                        <input type="number" name="count" class="form-control" id="count" v-model="form.count" placeholder="거래 수량을 입력하세요">
                    </div>
                    <br/>
                    <button class="btn btn-secondary me-2" @click="goHomePage">이전 페이지로</button>
                    <button class="btn btn-primary" @click="tradeSave">등록</button>
                <!-- </form> -->
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
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { http } from '@/api/index.js';
import PostModal from '@/components/posts/PostModal.vue';

const router = useRouter();
const memberTable = ref([]);
const stockTable = ref([]);
const isMemberExist = ref(null);
const isStockExist = ref(null);

const form = ref({
    memberId: null,
    stockId: null,
    count: null,
})

const searchMemberList = async () => {
    const { data } = await http.post('/members', { });
    memberTable.value = data.members;
    isMemberExist.value = (data.members.length > 0);
};

searchMemberList();

const searchStockList = async () => {
    const { data } = await http.post('/stocks', { });
    stockTable.value = data.stocks;
    isStockExist.value = (data.stocks.length > 0);
};

searchStockList();

const goHomePage = () => {
    router.push('/');
}

const tradeSave = async () => {
    if (form.value.memberId == null || form.value.memberId == '') {
        openModal(modalMessage);
        return;
    }

    if (confirm('저장 하시겠습니까?') === false) {
        return;
    }

    try {
        await http.post('/trade', { ...form.value });
        alert('저장이 완료되었습니다.');
        router.push({ name: 'TradeList' });
    } catch (error) {
        console.error(error);
    }
}

// modal
const show = ref(false);
const modalMessage = ref('거래 회원은 필수 입력 값입니다.');

const openModal = () => {
    show.value = true;
}

</script>

<style lang="scss" scoped>

</style>