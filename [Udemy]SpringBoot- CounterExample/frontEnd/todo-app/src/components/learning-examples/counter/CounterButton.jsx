import {PropTypes} from 'prop-types'


export default function CounterButton({by,incrementMethod }) {
  
  // const buttonStyle = {
    //     fontSize:"16px",
    //     backgroundColor: "#00a5ab",
    //     width:"100px",
    //     color:"white",
    //     padding:"15px",
    //     borderRadius:"30px"
    // }
    
    //[0,f] 첫번째는 초기상태 값, 두 번째는  dispatchState  함수
    
    
    

  return (
    <div className="Counter">
      <div>
        <button
          className="counterButton"
          onClick={ ()=>incrementMethod(by) }
        >
          increment
        </button>
        <button
        className='counterButton'
        onClick={  ()=> incrementMethod(-by)}>
            decrement
        </button>
      </div>
    </div>
  );
  //onclick에 incrementCounterFunction()을 넣으면 결과값이 반환되는것이기 떄문에 참조개념이 아님

}
CounterButton.prototype={
    by: PropTypes.number
}

//기본값을 지정 가능
CounterButton.defaultProps={
    by:1
}