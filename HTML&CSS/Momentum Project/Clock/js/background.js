const images = [
"라봉 (1).jpg","라봉 (2).jpg","라봉 (3).jpg","라봉 (4).jpg","라봉 (5).jpg","라봉 (6).jpg","라봉 (7).jpg","라봉 (8).jpg"];

const chosenImage = images[Math.floor(Math.random()*images.length)];
const bgimg = document.createElement('img');
const body =document.querySelector('body');

console.log(chosenImage)


bgimg.src = `img/${chosenImage}`;
body.appendChild(bgimg);
