import {
  useParams,
  Link
} from "react-router-dom";

export default function WelcomeComponent() {
  //안에 속해있는 객체로 받는 방법, param.username과 동일하다
  const { username } = useParams();

  console.log(username);
  return (
    <div>
      <h1>Welcome Test Page!</h1>
      <div className="Welcome">Welcome Component</div>
      <div>
        Manage Your todos. <Link to="/todos">Go here</Link>
      </div>
    </div>
  );
}