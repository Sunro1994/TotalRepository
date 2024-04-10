import { useState } from "react";
import {
  useNavigate,
} from "react-router-dom";
import "./TodoApp.css";
import { useAuth } from "./security/AuthContext";


export default function LoginComponent() {
    const [username, setUsername] = useState("sunro");
  
    const [password, setPassword] = useState("");
    const [showErrorMessgae, setShowErrorMessgaae] = useState(false);
    const navigate = useNavigate("");

    const authContext = useAuth();
    function handleUsernameChange(event) {
      setUsername(event.target.value);
    }
    function handlePasswordChange(event) {
      setPassword(event.target.value);
    }
   async  function handleSubmit(event) {
      if (await authContext.login(username,password)) {
        //변수사용시 ${}을 사용하고 문자열과 섞을 경우 백틱(`)을 사용한다.
        navigate(`/welcome/${username}`);
        setUsername(username);
      } else {
        setShowErrorMessgaae(true);
        setUsername(null);
        return false;
      }
    }
  
    return (
      <div className="Login">
        <h1>Time to Login</h1>
        {showErrorMessgae && (
          <div className="errorMessage">
            Authenticated Failed. Please Check your credentials.
          </div>
        )}
        <div className="LoginForm">
          <div>
            <label>User Name</label>
            {/* value값을 바꾸는 법 : 1. useState 2. value에 값을 직접 입력 */}
            <input
              type="text"
              name="username"
              value={username}
              onChange={handleUsernameChange}
            />
          </div>
          <div>
            <label>Password</label>
            <input
              type="password"
              name="password"
              value={password}
              onChange={handlePasswordChange}
            />
          </div>
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            login
          </button>
        </div>
      </div>
    );
  }