import Button from "./Button"
import styles from "./App.module.css"
import { useState } from "react";
import { useEffect } from "react";
function App() {
  const [counter,setValue] = useState(0); //counter는 value, setValue는 modiferFunction counter는 0으로 지정
  const [keyword, setKeyword] = useState("")
  const onClick= () => setValue((prev) => prev+1)
  const onChange = (event) => setKeyword(event.target.value);
  console.log("i run all the time");
  useEffect(()=>{
    console.log("i run only Once")
  },[])//한 번만 실행될 코드를 넣어준다.
  useEffect(()=>{
   console.log("i run when 'keyword' changes.")
  },[keyword]) //두 번쨰인자 : 오직 keyword가 변할때만 렌더링을 하도록 수행하는 것
  useEffect(()=>{
   console.log("i run when 'counter' changes.")
  },[counter]) //두 번쨰인자 : 오직 counter가 변할때만 렌더링을 하도록 수행하는 것
  useEffect(()=>{
   console.log("i run when 'keyword & counter' changes.")
  },[keyword,counter]) //두 번쨰인자 : 오직 counter가 변할때만 렌더링을 하도록 수행하는 것
  return (
   <div>
    <input 
     onChange={onChange}
     value={keyword}
     type="text" 
     placeholder="Search here..." />
    <h1 className={styles.title}>{counter}</h1>
    <button onClick={onClick}>click me</button>
    <Button text="Hello"/>
   </div>
  );
}

export default App;


/*
  react.js의 장점 : 컴포넌트의 변화가 있을 때 새로고침을 해준다.
  새로운 데이터가 들어올때마다 ui를 refresh해준다.
  한번만 실행하고 싶은 코드와 아닌 코드들을 구분시켜줄 수 있다.
  component안의 특정 데이터가 변화할때만 변화시킬 수 있다.
*/