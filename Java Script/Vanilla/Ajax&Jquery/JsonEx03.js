const obj = {
	name :"Lee",
	age : 20,
	alive : true,
	hobby : ['traveling', 'tennis']
};

const json = JSON.stringify(obj);

//json포맷의 문자열을 객체로 변환
const parsed = JSON.parse(json);
console.log(typeof parsed,parsed);
//Object타입으로 반환됨


const todos=[
    {id:1, content : 'HTML', completed:false},
    {id:2, content : 'CSS', completed:true},
    {id:3, content : 'JS', completed:false},
]

//배열을 JSON포맷의 문자열로 반환
const json2 = JSON.stringify(todos);
const parsed2 = json.parse(json2);
console.log(typeof parsed2,parsed2); //Ojbect로 반환
