//console에 document를 입력하면, 작성한 HTML을 가져올 수 있어.
// document는 브라우저에 존재하는 object
// console에 console.dir(document)를 호출해 보면, document.title이 HTML에서 정의한 title이랑 같다.
// JS에서 HTML document 객체로 부터 title을 가져올 수 있다.
// JS는 HTML에 접근하고 읽을 수 있게 설정되어 있어.
// js를 통해 html를 바꿀 수도 있다. document.title = "HO";
// 모든 것들은 document로부터 시작해. web site를 의미하기 때문.
// document.body를 호풀하면 body항목만 가지고 온다.


document.getElementById("title");

//console로 document를 보면 다른 객체와 같은 형식을 보여준다.
// console.dir(document) 와 console.log(document)의차이
//console.dir(document) => dir은 객체의 속성을 확인
//console.log(document) => log는 객체의 요소를 확인
console.dir(document)

//1. document에서 한가지 요소를 가져오기
const title = document.getElementById("title");

//2. 요소의 변경
title.innerText = "got you!";


//Html에서 변경하지 않고 JS에서 변경하는 이유
//Html은 정적인 요소이기 때문에 변경이 불간으 하다.
//하지만 결과를 상황에 따라 변경하는게 필요하기 때문에 js를 사용한다.
