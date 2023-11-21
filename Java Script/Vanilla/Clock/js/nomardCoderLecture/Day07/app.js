// const age = prompt("How old are you?")
//age(String타입) 을 int로 바꿔줌
const age1 = parseInt(prompt("how old are you?"));

console.log(age1);
console.log(typeof age1);

// 정수가 아닌 String을 넣으면 'NaN'가 나온다.
const age2 = parseInt(prompt("How old are you?"))

//boolean을 반환하는 isNaN
//문자를 적을 경우 true를 반환한다.
//NaN이 맞는지 확인하는 메서드
if(isNaN(age2)) {
    console.log("Please Write a number");
}






