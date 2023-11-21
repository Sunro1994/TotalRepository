// const loginForm = document.getElementById("login-form");
const loginInput = document.querySelector("#login-form input");
const loginButton = document.querySelector("#login-form button");


function handleLoginBtnClick() {
console.dir(loginInput.value);
}

loginButton.addEventListener("click",handleLoginBtnClick)