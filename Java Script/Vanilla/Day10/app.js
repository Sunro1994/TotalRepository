// doucment가 Html이  app.js를 load하기 때문에 존재하는 것
// 그다움 borwser가 우리 document에 접근하게 해준다.

// div의  아이디가 hello인 것중 첫 번째 h1
const title = document.querySelector("div.hello:first-child h1");
const title2 = document.querySelector(".hello:first-child h1" );


console.dir(title);
console.dir(title2);

// title.style.color = "blue";
//수 많은 object를 보여준다.  내부에 있는 property들의 내용 변경 가능
//style의 내용을 보면 전부 js로 되어 있다.

//event
//click을  listen해보기

//HTML element를 js로 가져오기
// 무슨 이벤트를 listen하고 싶은지 알고싶은것



// ======클릭 이벤트 감지하기====
function handleTitleClick(){
    const ranColor=["blue","red","green","yellow","black"];
    let num = Math.floor(Math.random()* ranColor.length);
    title.style.color=ranColor[num];
    console.log("title was clicked!");
}
// //click이벤트가 발생하면 handleTitleClick이 발생한다.
// // handleTitleClick()이라고 적으면 바로 실행하지만 우리가 원하는건 
// // user가 click한 경우 java가 실행버튼을 눌러주길 기다리는 것.
title.addEventListener("click", handleTitleClick);

function Randomcolor() {
    r = Math.floor(Math.random()*255+1).toString(16);
    g = Math.floor(Math.random()*255+1).toString(16);
    b = Math.floor(Math.random()*255+1).toString(16);
    let rgb = r + g + b;
    return rgb;
}

function clickHeadTwo() {
    title.style.color = '#'+Randomcolor();
}
title.addEventListener('click',clickHeadTwo);


//결론
//타이틀의 object 내부를 보면 많은 것을 변경할 수 있다.
//event를 listen하는 법을 배웠다.


//math.floor = 소수점을 버리는 함수
//math.random() = 0~1미만 사이 숫자