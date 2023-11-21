const todos=[
    {id:1, content : 'HTML', completed:false},
    {id:2, content : 'CSS', completed:true},
    {id:3, content : 'JS', completed:false},
]

//배열을 JSON포맷의 문자열로 반환
const json = JSON.stringify(todos,null,2);
console.log(typeof json,json);