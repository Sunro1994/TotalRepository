import { useState, useEffect } from "react";


function App() {
  const [toDo, setToDo] = useState("");
  const [toDos, setToDos]=useState([]);
  const onChange = (event)=> setToDo(event.target.value);
  const onSubmit= (event) => {
    event.preventDefault();
    if(toDo===""){
      return;
    }
    setToDo(""); //toDOs,toDO를 직접적으로 수정하지 않는다. toDos.push처럼, 수정하는 함수 setToDOs를 써야 한다.
    // 예시
    // const food = [1,2,3,4]; [6,food] = [6,Array(4)]라고 뜬다.
    // [6, ...food] = [6,1,2,3,4] 이처럼 ...+배열을 입력하면 리스트안에 배열의 내용이 추가되게된다.
    setToDos(currentArray => [toDo, ...currentArray ]); // 그래서 이 함수도 toDO가 있는 리스트에 currentArray의 배열안에있는 값을 추가해준다.
    console.log(toDos);

  }
  return <div>
    <h1>My To Dos ({toDos.length})</h1>
    <form onSubmit={onSubmit}>

    <input 
    type="text" 
    value={toDo} 
    onChange={onChange} 
    placeholder="Write your to do..."
    />
    <button>Add To Do</button>
    </form>
    <hr/>
    <ul>
    {toDos.map((toDo,index)=> <li key={index}>{toDo}</li> )} 
    </ul>
    
  </div>
}

export default App;


//useState가 변할때마다 코드가 새로 실행된다. counter가 변경되었기 떄문
