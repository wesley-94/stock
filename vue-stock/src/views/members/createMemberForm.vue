<template>
    <h1 class="text_center mt-3">회원 등록</h1>
    <hr>
    <div class="col-md-12">
        <div class="col-md-4">
            <form>
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="city">도시</label>
                    <input type="text" class="form-control" id="city" placeholder="도시를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="street">거리</label>
                    <input type="text" class="form-control" id="street" placeholder="거리를 입력하세요" />
                </div>
                <br/>
                <div class="form-group">
                    <label for="zipcode">우편번호</label>
                    <input type="text" class="form-control" id="zipcode" placeholder="우편번호를 입력하세요" />
                </div>
                <br/>
                <div class="text_center">
                    <button class="btn btn-secondary me-2" @click="goHomePage">이전 페이지로</button>
                    <!-- 등록 기능 구현 예정 -->
                    <button type="button" class="btn btn-primary" id="btn-memberSave">등록</button>
                </div>
            </form>
            <br/>
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