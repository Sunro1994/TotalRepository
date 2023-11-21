const a= 5;
const isNicoFat =true;

console.log(a);
//constant로 만들었기 때문에 오류가 발생한다.
// isNicoFat = false;

let isNicoFat2 = true;

//변수를 업데이트 하고 싶다면 let을 사용해야 한다.
//const를 사용하되 가끔 let을사용하고 var는 사용하지 말것!
isNicoFat2 = false;


//비어있음을 의미
const b= null;

//undefined는 변수에 값을 부여하지 않은 상태
let hello;
console.log(hello); // 이겨우 defiend가 발생, hello에 대한 값을 지정해줘야 한다.

hello = null;

// const days = [d,1,'Hi',null, undefined, me]; 어떤 타입이든 배열에 넣을 수 있다.

const toBuy = ["potato", "tomato", "pizza"];

toBuy[2]; // pizza

console.log(toBuy[2]);

toBuy[2] = "water";
console.log(toBuy[2]);

//새로운 값을 추가하는 법
toBuy.push("one");

const player = {
    name : "player",
    age : 23
};

console.log(player,console);

console.log(player);
//지역변수를 변경하는 법
player.name="nincolas";
console.log(player);

//player라는 객체에 새로운 특성을 생성
player.sexy= "soon";
console.log(player);

//function 은 capuslation을 실행하여 재사용하는 것

function plus(a,b) {
    console.log(a+b);
}

plus(50,2);

// potato란 매개변수는 오직 minusFive 라는 function에서만 사용된다.
function minusFive(poatato) {
    console.log(poatato-5);
}
// 매개변수가 하나이기 때문에 오직 첫번째 매개변수만 받는다.
minusFive(5,10,12,34,4,5,6,7);


const calculator = {
    add : function(a,b) {
        console.log(a+b);
    },
    minus : function(a,b) {
        console.log(a-b);
    },
    divide : function(a,b) {
        console.log(a/b);
    },
    multi : function(a,b) {
        console.log(a*b);
    },
    powerOf : function(a,b) {
        console.log(a**b);
    },

};

calculator.add(5,1);
calculator.powerOf(2,4);


//과제
//a/b 또는 a**b 또는 a+b
// calcuator.add(1,2) calculator.powerof(1,2)...



//해당 값은 결괏값이 없다.
console.log(calculator.add(a,b));



