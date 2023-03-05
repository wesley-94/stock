<template>
    <h3 class="text_center mt-3">회원 등록</h3>
    <hr>
    <div class="col-md-12">
        <div class="col-md-4">
            <!-- <form> -->
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" v-model="form.name" placeholder="이름을 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="city">도시</label>
                    <input type="text" class="form-control" v-model="form.city" placeholder="도시를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="street">거리</label>
                    <input type="text" class="form-control" v-model="form.street" placeholder="거리를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="zipcode">우편번호</label>
                    <input type="text" class="form-control" v-model="form.zipcode" placeholder="우편번호를 입력하세요" />
                </div>
                <br/>
                <div class="text_center">
                    <button class="btn btn-secondary me-2" @click="goHomePage">이전 페이지로</button>
                    <button class="btn btn-primary" @click="memberSave">등록</button>
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

// import { useAxios } from '@/hooks/useAxios';

const router = useRouter();
const form = ref({
    name: null,
    city: null,
    street: null,
    zipcode: null,
});

// 등록 함수
const memberSave = async () => {
    if (form.value.name == null || form.value.name == '') {
        openModal(modalMessage);
        return;
    }

    if (confirm('저장 하시겠습니까?') === false) {
        return;
    }

    try {
        await http.post('/members/new', { ...form.value });
        alert('저장이 완료되었습니다.');
        router.push({ name: 'MemberList' });
    } catch (error) {
        console.error(error);
    }
}

const goHomePage = () => {
    router.push('/');
};

// modal
const show = ref(false);
const modalMessage = ref('이름은 필수 입력 값입니다.');

const openModal = () => {
    show.value = true;
}

</script>

<style lang="scss" scoped>
</style>