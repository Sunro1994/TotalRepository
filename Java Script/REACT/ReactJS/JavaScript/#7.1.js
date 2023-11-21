import { useState, useEffect } from "react";

function Hello(){
  useEffect(()=>{
    console.log("created : )")
    return () => console.log("destroyed :(") //return문이 clean up function이다. 해당 컴포넌트가 없어질 때 발생 
    //return이 destroy function인 이윤는 해당 바디의 구현문을 모두 수행하고나면 해당 컴포넌트는 소멸되기 때문에 return에 적는것
  },[])
  return <h1>Hello</h1>;
}
function App() {
  const [showing, setShowing] = useState(false);
  const onClick = () => setShowing((prev)=> !prev);
   //click할때마다 Hello가 create,destory가 반복된다.
  return (<div>
   {showing ? <Hello/> : null} 
  <button onClick={onClick}>{showing ? "Hide" : "Show"}</button>
 </div>)
}

export default App;


//useState가 변할때마다 코드가 새로 실행된다. counter가 변경되었기 떄문
