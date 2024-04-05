import './App.css';
import TodoApp from './components/todo/TodoApp'
// 중괄호와 중괄호 없이 임포트하는 것의 차이?
// 중괄호를 쓰지 않으면 무조건 기본 컴포넌(default)를 내보낸다.
// import FirstComponent from './components/learning-examples/FirstComponent'
// import { FifthComponent } from './components/learning-examples/FirstComponent';
// import SecondComponent from './components/learning-examples/SecondComponent';
// import ThirdComponent from './components/learning-examples/ThirdComponent'

// 너무 많은 임포트를 하면 코드상 유지보수가 힘들기 떄문에 하나의 컴포넌트에 넣고 {}를 통해 직접 함수또는 클래스를 지명해서
// 간결하게 임포트할 수 있다.
// import LearningComponent from './components/learning-examples/LearningComponent'
// import { FifthComponent,SecondComponent,ThirdComponent } from './components/learning-examples/LearningComponent';
// import LearningJS from './components/learning-examples/LearningJS';
// import Counter from './components/learning-examples/counter/Counter';

function App() {
  return (
    <div className="App">
      {/* <FirstComponent/> */}
      {/* <LearningComponent></LearningComponent>
      <SecondComponent/>
      <ThirdComponent/>
      <FifthComponent/>
      <LearningJS></LearningJS> */}
      {/* <Counter/> */}
      <TodoApp/>
    </div>
  );
}



export default App;
