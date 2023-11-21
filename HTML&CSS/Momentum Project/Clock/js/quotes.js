const quotes = [
    {
        quote : "죽고자 하면 살것이다.",
        text : "이순신",
    },
    {
        quote : "백문이 불여일문",
        text : "사자성어",
    },
    {
        quote : "사랑은 은하수 다방에서 만나",
        text : "10cm",
    },
    {
        quote : "이건 사랑이 아냐 이건 운명이 아냐 그냥 정이라고 하자",
        text : "Big Naughty",
    },
    {
        quote : "총 맞은 것처럼",
        text : "백지영",
    }
]

const quote = document.querySelector("#quote span:first-child");
const author = document.querySelector("#quote span:last-child");

const todaysQuote = quotes[Math.floor(Math.random()*quotes.length)];

quote.innerText = todaysQuote.quote;
author.innerText = todaysQuote.text;
/* Math.random은 0~1사이의 랜덤 실수를 제공한다. */

/** Math.round()는 반올림 함수 
 * Math.ceil()은 올림 함수
 * Math.floor()은 내림 함수
*/