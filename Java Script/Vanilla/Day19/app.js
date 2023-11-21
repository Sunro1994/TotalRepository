const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const link = document.querySelector("a");

//submit은 엔터를 누르거나 버튼을 누를때 발생한다
function onLoginSubmit(tomato) {
    //방금 일어난 event에 대해 정보를 지닌 toamto라는 argument가 생성
    //preventDefault()는 어떤 이벤트든지 기본 행동이 일어나지 않도록 방지해준다.
    //보통 tomato자리에는 event라는 이름의 매개변수로 받는게 관행이다.
tomato.preventDefault();
// const username= loginInput.value;
console.log(tomato);
console.log(link);
}
                        //event라는 객체에 정보를 담음
function hanldeLinkClick(event){
    //alert가 다른 페이지로 이동되지 못하게 막아주고있음, ok를 누르면 이동
    //event에 클릭한 좌표 높이 등 다양한 정보가 제공된다.
    //이벤트가 진행되는것을 막아줌
    event.preventDefault();
    console.log(event);
    // //alert에 ok를 눌러야 진행됨
    // alert("Clicked!");

}


//누군가 form을 submit하면 function을 호출하도록 하고 있다.
    //브라우저가 아래 함수를 호출하여 사용하는것!
loginForm.addEventListener("submit",onLoginSubmit);
link.addEventListener("click",hanldeLinkClick)