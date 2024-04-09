import {
  useParams,
  Link
} from "react-router-dom";
import { useState } from "react";
import {  retrieveHelloWorldPathVariable } from "./api/HellowWorldApiService";

export default function WelcomeComponent() {
  //안에 속해있는 객체로 받는 방법, param.username과 동일하다
  const { username } = useParams();

  const [message, setMessage]  = useState(null);

  function callHelloWorldRestApi(){

    retrieveHelloWorldPathVariable('surno')
    .then((response)=> successfulResponse(response))
    .catch((error) => errorResponse(error))
    .finally( () => console.log('clean up'))

  }

  function successfulResponse(response){
    console.log(response)
    setMessage(response.data.message);
  }
  function errorResponse(error){
    console.log(error)
  }

  console.log(username);
  return (
    <div>
      <h1>Welcome Test Page!</h1>
      <div className="Welcome">Welcome Component</div>
      <div>
        Manage Your todos. <Link to="/todos">Go here</Link>
      </div>
      <div>
        <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>Call hello World Rest API</button>
      </div>
      <div className="text-info">{message} </div>
    </div>
  );
}