//context는 기본적으로 브러쉬, ctx로 줄여서 씀
//canvas에서 그릴 수 있는 ctx가 생긴것
const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");
const lineWidth = document.getElementById("lineWidth");
console.log(lineWidth);

//클릭하면서 뗄 때까지 선이 이어지는 기능 만들기

canvas.width = 800;
canvas.height = 800;
ctx.lineWidth = 2;
ctx.moveTo(200,200);
ctx.lineTo(400,400);
ctx.stroke();
let isPainting = false;
function onMove(event) {
    if(isPainting) {
        ctx.lineTo(event.offsetX,event.offsetY);
        ctx.stroke();
        return;
    }
    ctx.moveTo(event.offsetX, event.offsetY);
}

function startPainting(){
    
    isPainting = true;
    
}
function cancelPainting(){
    isPainting = false;
}
function onLineWidthChange(event){
   ctx.lineWidth = event.target.value;
}
canvas.addEventListener("mousemove",onMove);
canvas.addEventListener("mousedown",startPainting);
canvas.addEventListener("mouseup",cancelPainting);
canvas.addEventListener("mouseleave",cancelPainting);

