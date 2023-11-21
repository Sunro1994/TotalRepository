document.getElementsByClassName
document.getElementsByTagName
document.getElementsByName
//위 3개의 클래스는 모두 배열로 값을 가져온다.


//class name과 element를 함께 적을 수 있는 querySelector
//단 하나의 h1을 찾아서 출력해준다.
//중복된 h1이 있더라도 가장 처음것만 출력한다.
//css스타일로 검색하는 방법
const title = document.querySelector(".hello h1" );
const title2 = document.querySelector(".hello h1:first-child");//첫번쨰 요소만 가져오는 동일한 의미

//아이디를 통해 찾고 싶다면(id=hello) 아래처럼 사용 가능하다.
const title3 = document.querySelector("#hello");
const title4 = document.getElementById('hello');


//중복된 요소를 모두 가져오는 querySelectorAll
//배여롤 반환
const titleAll = document.querySelectorAll(".hello h1")

console.log(title);
console.dir(title);

console.log(titleAll);