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
