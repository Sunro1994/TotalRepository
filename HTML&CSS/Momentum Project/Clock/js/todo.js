const toDoForm = document.querySelector('#todo-form')
const toDoInput = toDoForm.querySelector('input')
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
   const li = event.target.parentElement;
   li.remove();
}

function paintToDo(newTodo) {
   const li = document.createElement('li');
   li.id = newTodo.id;
   const span = document.createElement('span');
   li.appendChild(span);
   const button = document.createElement('button');
   button.innerText="❌";
   button.addEventListener("click",deleteToDo)
   li.appendChild(button);
   span.innerText=newTodo.text;
   toDoList.appendChild(li);
}


function handleToSubmit(event) {
    event.preventDefault();
    const newTodo = toDoInput.value;
    const newTodoObj = {
        text:newTodo,
        id:Date.now(),
    };
    toDos.push(newTodoObj);
    toDoInput.value="";
    paintToDo(newTodoObj);
    saveToDos();

}

toDoForm.addEventListener("submit",handleToSubmit);



const savedToDos = localStorage.getItem(TODOS_KEY);
console.log('savedToDos :' + savedToDos)
if(savedToDos !== null) {
    const parsedToDos = JSON.parse(savedToDos);
    toDos = parsedToDos;
    parsedToDos.forEach(newTodoObj);
}


/**Date.now()는 밀리세컨드 단위로 우리에게 현재 시간을 제공해준다. */