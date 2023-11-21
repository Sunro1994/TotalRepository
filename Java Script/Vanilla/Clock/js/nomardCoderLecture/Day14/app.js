//css가 수행되지 않는 이유 : 링크를 통해 연결시켜주지않음 , 공백이 들어있어 설정이 이루어지지 않음
const h1 = document.querySelector("div.hello:first-child h1");

// ===은 체크 =은 값을 변경하는 것
//classList의 contains를 사용하면 해당 클래스값만  해당하게 수행
function handleTitleClick() {
    const clickedClass = "clicked";
    if(h1.classList.contains(clickedClass)) {
        h1.classList.remove(clickedClass);
    } else {
        h1.classList.add(clickedClass);
    }
}

//위 함수를 한번에 수행해주는 toggle 없으면 추가, 있으면 삭제
function handleTitleClick2() {
    h1.classList.toggle("clicked");
}



h1.addEventListener("click",handleTitleClick);