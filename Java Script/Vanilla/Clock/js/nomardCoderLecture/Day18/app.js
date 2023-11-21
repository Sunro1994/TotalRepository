const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");


//submit은 엔터를 누르거나 버튼을 누를때 발생한다
function onLoginSubmit(tomato) {
    //방금 일어난 event에 대해 정보를 지닌 toamto라는 argument가 생성
    //preventDefault()는 어떤 이벤트든지 기본 행동이 일어나지 않도록 방지해준다.
    //보통 tomato자리에는 event라는 이름의 매개변수로 받는게 관행이다.
tomato.preventDefault();
// const username= loginInput.value;
console.log(tomato);

}

//누군가 form을 submit하면 function을 호출하도록 하고 있다.
loginForm.addEventListener("submit",onLoginSubmit);