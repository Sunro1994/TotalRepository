const obj = {
	name :"Lee",
	age : 20,
	alive : true,
	hobby : ['traveling', 'tennis']
};

//객체를 JSON포맷의 문자열로 변환
const json = JSON.stringify(obj);
console.log(typeof json, json);
//string{"name":"Lee",...,"hobby":["traveling","tennis"]}

//객체를  JSON포맷의 문자열로 변환하면서 들여쓰기 한다.
const prettyJson = JSON.stringify(obj,null,2);

//replacer함수. 값의 타입이 Number이면 필터링되어 반환하지 않는다.
function filter(key,value){
    //undefined:반환하지 않음
    return typeof value === 'number' ? undefined : value;
}

//JSON.stringify 메서드에 두 번째 인수로 replacer함수를 전달
const strFilteredObject = JSON.stringify(obj,filter,2);
console.log(typeof strFilteredObject,strFilteredObject);

//JSON.stringify메서드는 객체뿐만 아니라 배열도 문자열로 반환
