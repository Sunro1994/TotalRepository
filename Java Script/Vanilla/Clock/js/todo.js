//입력 폼
const toDoForm = document.querySelector('#todo-form')
//입력
const toDoInput = toDoForm.querySelector('input')
//출력할 ul요소
const toDoList = document.querySelector('#todo-list')

/**localstorage에는 오직 text만 저장 가능하다. */
let toDos = [];
const TODOS_KEY = "todos";


function saveToDos() {
    /** JSON.stringify(값) : 어떤 object든 String으로 바꿔준다. 
     * 반대로 JSON.parse() 는 어떤 문자열을 javascript가 사용할 수 있는 내용으로 바꿔준다.
     * 예시 : JSON.parse(localStorage.getItem("todos")) >> 결과값 ["a","b","c"]
     * 
    */
    localStorage.setItem(TODOS_KEY,JSON.stringify(toDos));
}

/** click시 버튼은 event에 담겨있다. 그리고 path라는 요소를 보면 클릭된 위치를 알려주고 있다.
 *  event는 property를 갖고 있다.
 *  이것들 중 parentNode는 해당 요소의 부모 요소를 가리킨다.
 * 
 */
function deleteToDo(event) {
   const li = event.target.parentElement;           //누른button의 부모요소인 li를 불러온다.
   toDos= toDos.filter(todo => todo.id != parseInt(li.id));
   console.log(li);
   li.remove();                                     // li를 제거
   saveToDos();

}

function paintToDo(newTodo) {
   const li = document.createElement('li');         //li요소를 불러옴         
   li.id = newTodo.id;                              //li의 id 는 newTodo.id;
   const span = document.createElement('span');     //span의요소를 불러옴
   li.appendChild(span);                            //li에 span추가
   const button = document.createElement('button'); //button요소를 불러옴
   button.innerText="❌";                           //button내용 추가
   button.addEventListener("click",deleteToDo)      //button클릭시 deleteToDo가 수행됨
   li.appendChild(button);                          //버튼을 li에 추가
   span.innerText=newTodo.text;                     //span의 내용은 newTodo에서 입력한 텍스트
   toDoList.appendChild(li);                        //toDolist(ul)에 li를 추가
}


function handleToSubmit(event) {
    event.preventDefault();                         //모든 이벤트 중단
    const newTodo = toDoInput.value;                //input의 내용을 담은 newTodo
    const newTodoObj = {                            //각 입력을 구분하기 위해 text와 id를 함꼐 담음
        text:newTodo,
        id:Date.now(),                              //Date.now는 밀리세컨단위로 현재 시간을 알 수 있다.
    };
    toDos.push(newTodoObj);                         //할일 목록을 배열에 담음
    toDoInput.value="";                             //내용 초기화
    paintToDo(newTodoObj);                          //화면에 출력
    saveToDos();                                    //배열을 저장

}
//입력form에서 submit 이벤트가 발생하는 경우 handleToSubmit함수 실행
toDoForm.addEventListener("submit",handleToSubmit);

const savedToDos = localStorage.getItem(TODOS_KEY); //localStage에 TODOS_KEY문자를 저장
console.log('savedToDos :' + savedToDos)        
if(savedToDos !== null) {                           //만약 saveToDos가 비어있다면
    const parsedToDos = JSON.parse(savedToDos);     //savedToDos를 문자열로 바꿈
    toDos = parsedToDos;                            //바꾼 문자열을 toDos에 저장
    parsedToDos.forEach(paintToDo);                //문자열로 바꾼 내용이 담겨있는 parsedToDos의 각 요소를에 대해 newToObj로 변환
}

//filter

//function sexyFilter() {return ture}
//[1,2,3,4,5].filter(sexyFilter)
//이와 같이 모두 true를 반환하는 필터는 [1,2,3,4,5]를 그대로 담아 반환한다.



/**Date.now()는 밀리세컨드 단위로 우리에게 현재 시간을 제공해준다. */