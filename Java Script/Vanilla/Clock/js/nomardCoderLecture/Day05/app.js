//Functions part one

//function이란?
// 재사용이 가능한 코드

console.log("Hello");
console.log("Hello");
console.log("Hello");
console.log("Hello");
console.log("Hello");
console.log("Hello");

//위처럼 반복되는 기능을 직접 쓰지않고 최소한으로 적고 사용하고 싶을 때 function을 사용한다.
// 어떤 코드를 캡슐화해서 재사용한다.


// 매개변수는 fucntion안에서만 존재하는 변수이다.
function sayHello(/* 매개변수를 넣는 공간 */nameOfPerson, age) {
    console.log(nameOfPerson,age);
    console.log('Hello my name is ' +nameOfPerson + 'and I\'m' + age );
}

sayHello("nico", 14);
sayHello("dal",15);
sayHello("lynn",31);

function plus(a,b) {
    console.log(a+b)
}
function divide(a,b) {
    console.log(a/b);
}

plus(1,2);
plus();
divide(60,20);
