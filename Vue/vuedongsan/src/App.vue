<template>
  <div class="menu"> <!--a 태그 반복문 설정하기-->
 
    <a v-for="(작명,i) in 메뉴들" :key="작명">{{ 작명+i }}</a> 
    
  </div>
  <div class="black-bg" v-if="모달창열렸니">
    <div class="white-bg">
      <h4>상세페이지</h4>
      <p>상세페이지 내용</p>
      <button @click="모달창열렸니=false">모달창닫기</button>
    </div>
  </div>
  <div>
    <img src="./assets/room0.jpg" class="room-img">
    <h4 @click="모달창열렸니=true">  {{ products[0] }}</h4> 
    <p>50만원</p>  
    <button @click="신고수[0]++">허위매물신고</button> <span>신고수 : {{ 신고수[0] }}</span>
  </div>
  <div>
    <img src="./assets/room1.jpg" class="room-img">
    <h4>{{ products[1] }}</h4>
    <p>70만원</p> 
    <button @click="신고수[1]++">허위매물신고</button> <span>신고수 : {{ 신고수[1] }}</span>
  </div>
  <div>
    <img src="./assets/room2.jpg" class="room-img">
    <h4>{{ products[2] }}</h4>
    <p>100만원</p>
    <button @click="신고수[2]++">허위매물신고</button> <span>신고수 : {{ 신고수[2] }}</span>
  </div>


  <div>
    <img :src="원룸들[0].image" class="room-img">
    <h4>{{ 원룸들[0].title }}</h4>
    <p>{{ 원룸들[0].price }}</p>
  </div>
</template>

<script>



export default {
  name: 'App',
  data(){ 
    return{
      원룸들 : data, //data를 임포트
      모달창열렸니 : false,
      신고수 : [0,0,0],
      스타일 : 'color : blue', //HTML속성도 바인딩이 가능하다
      products : ['역삼동 원룸','천호동 원룸','마포구 원룸'],
      메뉴들 : ['Home','Shop','About']
    }
  },
  methods : { //함수를 넣는 공간
      increase(){
        this.신고수 ++; //this를 써주지 않으면 신고수란 객체값을 이해하지 못한다.
      }
  },
  components: {
  }
}

import data from './assets/oneroom.js'; //작명은 내 마음대로 가능

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.menu{
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}
.menu a {
  color: white;
  padding: 10px;

}

.room-img{
  widows: 100%;
  margin-top: 40px;;
}

body{
  margin: 0;
}

div{
  box-sizing: border-box;
}
.black-bg{
  width: 100%;
  height: 100%;
  background: rgba(0,0,0,0.5);
  position: fixed;
  padding: 20px;
}
.white-bg{
  width: 100%;
  background: white;
  border-radius: 8px;
  padding:20px;
}
</style>
