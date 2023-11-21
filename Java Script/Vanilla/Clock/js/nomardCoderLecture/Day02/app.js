
/*
let 재선언 금지, 재할당 가능
const 재선언 금지, 재할당 금지
var 재선언 가능, 재할당 가능
*/

const a = 5;
const b = 2;
let myName = "nico";

//이처럼 let은 변수만 호출하여 값을 변경(update)할 수 있다.
myName = "nicolas";

console.log("your new name is " + myName);

//재선언 재할당이 가능한 var는 언어의 보호를 받지 못한다.
//잘못된 경우라도 경고를 해주지 않음
var a1 = 5;
var a2 = 6;