const canvas = document.querySelector("canvas")

//context는 기본적으로 브러쉬, ctx로 줄여서 씀
//canvas에서 그릴 수 있는 ctx가 생긴것
const ctx = canvas.getContext("2d")


canvas.width = 800;
canvas.height = 800;

//canvas의 좌표 시스템은 가장 왼쪽 위 구석 0,0에서 시작한다.
//아래로는 y 가로로는 x

/* Chapter 01
사각형 만들기
fillRect(x시작지점,y시작지점, 가로길이, 세로길이)
속이 차있는 사각형
/fillRect는 사실 단축함수다. 선택은 fill과 stroke
ctx.fillRect(50, 50, 100, 200);
// 속이 빈 사각형
ctx.strokeRect(150, 150, 100, 200);
*/

/* Chapter 02
//선을 그리는 함수 rect 이 또한 단축함수다.
ctx.rect(50 ,50,100,100);
//색을 채우는 함수
ctx.fill();
// beginPath를 구분으로 경계가 끊긴다.
ctx.beginPath();
ctx.rect(350,350,100,100);
//모든 선에 영향이 일어난다. 모든 연결을 끊고 새로 시작하는 법 > beginPath();
ctx.fillStyle =  "red";
ctx.fill();

//5초 뒤에 색이 칠해지게 하기
setTimeout(()=>{
    ctx.fill();
}, 5000);
*/

/* Chapter 03
//선을 그리는 함수 rect 이 또한 단축함수다.
//1. x와 y를 이동(선을 긋지 않음)
ctx.moveTo(50,50);
//2. 내가 있는 곳에서 어디론가 선을 긋는다.
// x로 5부터 150만큼, y로 
ctx.lineTo(150,50);
ctx.lineTo(150,150);
ctx.lineTo(50,150);
ctx.lineTo(50,50);
ctx.fill();*/

/**Chapter 04
 * ctx.fillRect(200,200,50,200);
ctx.fillRect(400,200,50,200);
ctx.lineWidth=2;
ctx.strokeRect(300,300,50,100);
ctx.fillRect(200,200,200, 20);
ctx.moveTo(200,200);
ctx.lineTo(325,100);
ctx.lineTo(450,200);

ctx.fill();
 * 
 */

/**Chapter 05
 * 
ctx.fillRect(210-40,200-30,15,100);
ctx.fillRect(350-40,200-30,15,100);
ctx.fillRect(260-40,200-30,60,200);

//ctx.arc(x,y,지름,0(시작점),(종점))
// 2*Math.PI를 하면 완벽한 원이 만들어진다.
ctx.arc(250, 100, 50, 0, 2*Math.PI);
ctx.fill();

//새로운 path를 만들어 경계를 만들어준다.
ctx.beginPath();
ctx.fillStyle = "white";
ctx.arc(270, 80, 8, Math.PI, 2*Math.PI);
ctx.arc(230, 80, 8, Math.PI, 2*Math.PI);
ctx.fill();
 * 
 * 
 */

/**Chapter 06
 * 
 * 
ctx.lineWidth = 2;
const colors = [
    "#ff3838",
    "#ffb8b8",
    "#c56cf0",
    "#ff9f1a",
    "#fff200",
    "#32ff7e",
    "#7efff5",
    ]

function onClick(event) {
    ctx.beginPath();
    ctx.moveTo(Math.floor(Math.random()*canvas.width),0);
    const color = colors[Math.floor(Math.random()*colors.length)];
    ctx.strokeStyle = color;
    ctx.lineTo(event.offsetX, event.offsetY);
    ctx.stroke();
}


canvas.addEventListener("mousemove",onClick);
 */