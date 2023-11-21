const h1 = document.querySelector("div.hello:first-child h1");

// ===은 체크 =은 값을 변경하는 것
function handleTitleClick() {
    const clickedClass = "sexy-font";
    if(h1.className ===clickedClass) {
        h1.className = "";
    } else {
        h1.className = clickedClass;
    }
}

h1.addEventListener("click",handleTitleClick);