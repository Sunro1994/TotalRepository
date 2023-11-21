console.log(2121)
console.log('hahaha');
console.log("hahaha");

// 변하지 않는 상수 const
const a =5;
const b = 2;
//이렇게 긴 이름을 CamelCase라고한다
const vertVeryLongVariableNmae=0;
console.log(a+b);

let myName = "sunro";

//let으로 한번 선언하면 재선언시 let을 생략가능
myName= "runso";

console.log('your new name is' + myName);

/* 변수만들때 let, const, var차이
let 재선언 금지, 재할당 가능
const 재선언 금지, 재할당 금지
var 재선언 가능, 재할당 가능 
var는 실수해도 오류가 뜨지 않기 때문에 잘 사용하지 않는다.

*/

//boolean
const amIfat = true;
console.log(amIfat)

//arrays

const daysOfWeek = ['mon','tue','wed','thu'];

const nonsense = [1,2,'hello',false,null,undefined];

//리스트에 값 추가
daysOfWeek.push('sun');

console.log(daysOfWeek);

//객체 생성

const player = {
    name : "sunro",
    age : 30
}

//객체의 특성을 찾는 두가지 방법
console.log(player.age);
console.log(player["name"])

//객체에 새로운 필드 추가
player.lastName = "lee";
console.log(player);

//function 파트부터 복습
//매개변수안의 인자가 그대로 전달된다.
function sayHello(nameOfPerson,age) {
    console.log(nameOfPerson,age);
}

/* CTRL+ SHIFT +  L : 같은 단어 한번에 변경*/
sayHello("nico",10);
sayHello("dal",10);
sayHello("lynn",10);

//prompt는 입력을 받게 해준다.(하지만 자바스크립트의 작동을 멈추게 한다.
// 또한 css적용도 할 수없다. 아주 오래된 방법)
// const age = parseInt(prompt("how old are you?"));

//typeof를 사용하면 타입을 알려줌
// parseInt를 사용하면 타입변환가능
//String을 입력받고 parseInt를 할때 숫자타입이 아니면 NaN이 뜬다.
// console.log(typeof age, typeof parseInt(age));

// console.log(isNaN(age)); //Nan인지 확인하는 함수

const Qs = parseInt(prompt("나이를 입력해주세요"));


    if(isNaN(Qs)==true)
    console.log("please write a number");
    else{
        console.log("Thank you for writing")
    }
