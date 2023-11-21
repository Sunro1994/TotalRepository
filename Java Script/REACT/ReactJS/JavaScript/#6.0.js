import Button from "./Button"
import styles from "./App.module.css"
import { useState } from "react";
function App() {
  const [counter,setValue] = useState(0); //counter는 value, setValue는 modiferFunction counter는 0으로 지정
  const onClick= () => setValue((prev) => prev+1)
  console.log("render")
  return (
   <div>
    <h1 className={styles.title}>{counter}</h1>
    <button onClick={onClick}>click me</button>
    <Button text="Hello"/>
   </div>
  );
}

export default App;


//useState가 변할때마다 코드가 새로 실행된다. counter가 변경되었기 떄문
