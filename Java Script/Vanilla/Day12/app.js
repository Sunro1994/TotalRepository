// h1 html element mdn이라고 검색한다.
// web APIS 에서 내용을 볼 수 있다.
//이게 너무 복잡하다면 console.dir(title)에서 내용을 찾아보자!
const title = document.querySelector('.hello:first-child h1');

console.log(title);

function handleTitleClick() {
    title.style.color = "blue";
    console.log("clicked");
}

function handleMouseEnter() {
    title.innerText = "Mouse is here!"
    // console.log("mouse is here ");
}

function hanldeMouseLeave() {
    title.innerText = "Mouse is gone!"
}
//클릭시 로그
title.addEventListener("click",handleTitleClick);

//마우스가 지나갈 경우 로그
title.addEventListener("mouseenter",handleMouseEnter);

title.addEventListener("mouseleave",hanldeMouseLeave);

//이런 방법도 있다.
title.onclick = handleTitleClick;
title.onmouseenter = handleMouseEnter;
title.onmouseleave = hanldeMouseLeave;


//window 방법을 사용
function handleWindowResize() {
    document.body.style.backgroundColor = "tomato";
}
function handleWindowCopy() {
    alert('copier!');
}

function handleWindowOffLine() {
    alert("SOS no WIFI");
}

function handleWindoOnline() {
    alert('Online');
}
// 화면이 조절될때 이벤트 실행
window.addEventListener("resize",handleWindowResize);

//오타시 수해잉 안되기 때문에 꼭 확인할 것

//복사하려고하면 알람이 뜸
window.addEventListener("copy",handleWindowCopy);

//element를 찾아서 이벤트 리스너를 통해 이와 같은 패턴을 수행하면 된다.

//우리가 wifi가 연결되어 있는지 확인하는 event

window.addEventListener("offline",handleWindowOffLine);
window.addEventListener("online", handleWindoOnline);