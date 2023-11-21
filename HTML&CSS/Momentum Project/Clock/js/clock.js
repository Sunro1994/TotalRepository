const clock = document.querySelector("h2#clock");

function getClock() {
    const date = new Date();
    const Hour = String(date.getHours()).padStart(2,"0");
    const minute = String(date.getMinutes()).padStart(2,"0");
    const seconds = String(date.getSeconds()).padStart(2,"0");


    clock.innerHTML = `${Hour}`+':'+`${minute}`+':'+`${seconds}`;
}
/* setintervla(내가실행하고자하는 함수/ 시간간격(millisecond단위)) 
    interval 은 매번 무슨 일이 일어나게 하고 싶을 때 사용한다.
*/
getClock();
setInterval(getClock, 1000) /*5초마다 실행*/ 

/* 현재 시간과 날짜를 가져온다.
문서를 보면 다양한 기능이 많다.*/

/*padStart String에 쓸수 있으며, string의 길이를 조절할 수 있다. 또한 
공백을 원하는 문자열로 챙루 수 있다.
pad를 사용할 수 있는 조건은 String이다. 잊지 말자!*/

"1".padStart(2,"0");/* "1"의 스트링 길이가 2가 되도록 하고 만약 해당 문자열이 매개변수의 
길이보다 적다면 "0"으로 채운다. */

"1".padEnd(2,"0") /*start와 달리 반대로 뒤쪽에 매개변수 2번째 인자를 값으로 채운다. */

