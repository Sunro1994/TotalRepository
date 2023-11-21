
// List 배열의 개념
const mon = "mon";
const tue = "tue";
const wed = "wed";
const thr = "thr";
const sat = "sat";

//배열을 써서 더 간단히 가능

const daysOfWeek = [mon,tue,wed,thr,sat];

//다양한 타입을 한번에 넣을 수 있음
const nonsense = [1,2, "hello", false, true, undefined];

const text = ["mon","ute","wed"];

console.log(daysOfWeek);
console.log(text);

//배열에서 인덱스를 통한 값 찾기

console.log(daysOfWeek[0]);

//배열에 새로운 값을 추가
daysOfWeek.push("sun");
console.log(daysOfWeek)

//===========================================

//Object

const playerName = "nico";
const playerPoints = 121212;
const playerHandsome = false;
const playerFat = "little bit";

//위는 player의 특성을 나타낸다. 이를 한 개체에 담아서 표현할 수 있다.


// 배열로 표현해 보아도 적절하지 않다.
// 각 값이 어떤 의미인지 알 수 없기 때문
const player = ["nico",1212, false, "little bit"];

//{}를 사용한 객체를 만든다.
const player1 = {
    //객체의 내부의 특성을 만들 땐 : 을 사용하고 이어서 속성을 적을 때에는 ,를 사용
    name : "nico",
    points : 10,
    fat : true,
};

console.log(player1);
console.log(player1.name);
//위와 동일한 값을 갖지만 표현이 다름
console.log(player1["name"]);
//constant자체를 변경하려면 오류가 발생할 수 있지만 내부를 바꾸는것은 상관없다.
player1.fat=false;
console.log([player1]);

//새로운 특성을 추가 가능
player1.lastName ="potato";

//원래 값에 있던 수정
console.log(player1.points);
player1.points += 15;

console.log(player1.points);

//설명이 필요하지 않은 데이터 리스트들은 array로,
// 설명이 필요한 정보가 담긴 데이터 리스트들은 object로!