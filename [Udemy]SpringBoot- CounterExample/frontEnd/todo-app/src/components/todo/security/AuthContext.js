import { createContext, useContext, useState } from "react";

import { apiClient } from "../api/ApiClient";
import { executeJwtAuthenticationService } from "../api/AuthenticationApiService";

//create a Context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

//Put some state in the context

//Share the create context with other components

export default function AuthProvider({ children }) {
  const [isAuthenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);
  const[token,setToekn] = useState(null);

  // function login(username, password){
  //     if (username === "sunro" && password === "12345") {
  //         //변수사용시 ${}을 사용하고 문자열과 섞을 경우 백틱(`)을 사용한다.
  //         setAuthenticated(true);
  //         setUsername(username);
  //         return true;
  //       } else {
  //         return false;
  //       }
  // }

  // async function login(username, password) {
  //   const baToken = "Basic " + window.btoa(username + ":" + password);

  //   try {
  //     const response = await executeBasicAuthenticationService(baToken);

  //     setAuthenticated(false);

  //     if (response.status === 200) {
  //       //변수사용시 ${}을 사용하고 문자열과 섞을 경우 백틱(`)을 사용한다.
  //       setAuthenticated(true);
  //       setUsername(username);
  //       setToekn(baToken);

  //       apiClient.interceptors.request.use(
  //           (config) => {
  //               console.log('intercepting and adding a token')
  //               config.headers.Authorization=baToken
  //               return config
  //           }
  //       )



  //       return true;
  //     } else {
  //       setAuthenticated(false);
  //       setUsername(null);
  //       setToekn(null)
  //       return false;
  //     }
  //   } catch (error) {
  //     setAuthenticated(false);
  //     setUsername(null);
  //     setToekn(null)
  //   }
  // }

  
  async function login(username, password) {
    // const baToken = "Basic " + window.btoa(username + ":" + password);

    try {
      const response = await executeJwtAuthenticationService(username,password);

      setAuthenticated(false);

      if (response.status === 200) {
        const jwtToken = 'Bearer '+response.data.token;
        //변수사용시 ${}을 사용하고 문자열과 섞을 경우 백틱(`)을 사용한다.
        setAuthenticated(true);
        setUsername(username);
        setToekn(jwtToken);

        apiClient.interceptors.request.use(
            (config) => {
                console.log('intercepting and adding a token')
                config.headers.Authorization=jwtToken
                return config
            }
        )



        return true;
      } else {
        setAuthenticated(false);
        setUsername(null);
        setToekn(null)
        return false;
      }
    } catch (error) {
      setAuthenticated(false);
      setUsername(null);
      setToekn(null)
    }
  }

  function logout() {
    setAuthenticated(false);
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout, username,token }}>
      {children}
    </AuthContext.Provider>
  );
}
