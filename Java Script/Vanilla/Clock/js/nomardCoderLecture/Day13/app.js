// h1 html element mdn이라고 검색한다.
// web APIS 에서 내용을 볼 수 있다.
//이게 너무 복잡하다면 console.dir(title)에서 내용을 찾아보자!
const title = document.querySelector('.hello:first-child h1');

console.log(title);

//if else를 통해 색 변환하기
function handleTitleClick() {
    const currentColor = title.style.color;

    if (currentColor === "blue") {
        newColor = "tomato";
    }
    else {newColor = "blue";
}
    title.style.color= newColor;
}

title.addEventListener("click",handleTitleClick);








