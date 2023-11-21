import PropTypes from "prop-types";
import styles from "./Button.module.css"

function Button({text}) {
    return <button className={styles.btn}>{text}</button>
}

//propTypes와 ProptTypes의 차이를 알아야한다.
Button.propTypes = {
    text: PropTypes.string.isRequired //필수로 있어야 하는 문자열 타입으로 체크해준다.
}


export default Button;


/*
1. (08:42)
css 코드를 자바스크립트 객체로 변환시켜줌
import styles from "./~";

styles가 css 코드를 가지고 있는 객체로 넘어옴
따라서 해당 css코드에 작성된 class name(여기서는 btn)을 프로퍼티 접근 연산자(.)를 사용해서 이용가능해짐.

< Button style={styles.btn} / >
위와 같이 작성해서 해당 css 스타일링을 사용할 수 있음.

브라우저를 통해 html 코드를 확인해보면 해당 컴포넌트에 무작위의 class name이 붙음.
요소가 각각의 클래스네임을 가지게 돼서 일일이 class name을 기억해서 스타일링 할 필요가 없음

- 1 컴포넌트 당 1개의 .js 파일을 가질 수 있어서 모듈화가 가능하다.
- 컴포넌트별 스타일은 .module.css 파일을 생성 + import 하여 사용
=> 여기서 스타일은 className이나 id로 import한 스타일 객체의
property를 전달하여 적용된다는 것! 이는 기존의 "어떤 class나 id에 적용할 스타일"이 아닌 "특정 jsx element에 적용할 스타일"로 생각할 수 있다~ react 컴파일 과정 중 random class나 id가 생성되기 때문에 .css 파일의 class, id 이름을 굳이 외울 필요없다
- create-react-app을 사용하면 React 앱 스캐폴딩을 생성해준다~
*/