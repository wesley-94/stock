<template>
  <!-- <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div> -->
  <!-- <div class="container"> -->
    <br />
    <div class="form">
      <h1 class="text_center">&lt; 주식 종목 정보 서비스 &gt;</h1>
      <br>
      <p class="lead">회원 기능</p>
      <p class="lead">
        <a class="btn btn-lg btn-secondary me-2" href="/members/new">회원 가입</a>
        <a class="btn btn-lg btn-secondary" href="/members">회원 목록</a>
      </p>
      <br my-4>
      <p class="lead">종목 기능</p>
      <p class="lead">
        <a class="btn btn-lg btn-dark me-2" href="/stocks/new">주식 등록</a>
        <a class="btn btn-lg btn-dark" href="/stocks">주식 목록</a>
      </p>
      <br my-4>
      <p class="lead">거래 기능</p>
      <p class="lead">
        <a class="btn btn-lg btn-info me-2" href="/trade">주식 거래</a>
        <a class="btn btn-lg btn-info" href="/trades">거래 내역</a>
      </p>
    </div>
  <!-- </div> -->
</template>

<script>
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    // HelloWorld 
  }
}
</script>

<style>
.text_center {
  text-align: center;
}
.lead {
  text-align: center;
}
</style>