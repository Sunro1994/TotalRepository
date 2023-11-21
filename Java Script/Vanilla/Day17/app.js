// const loginForm = document.getElementById("login-form");
const loginInput = document.querySelector("#login-form input");
const loginButton = document.querySelector("#login-form button");


function handleLoginBtnClick() {
const value = loginInput.value;
console.log(value);
//  유효성을 검사하는 것은 좋은 방법이지만 브라우저에서 사용할 수 있는 기능이 있다.
    // if(value===""){
    //     alert("Please write yout name ");
    // }else if(value.length >15 ) {
    //     alert("Your name is too long");
    // }
}

loginButton.addEventListener("click",handleLoginBtnClick)