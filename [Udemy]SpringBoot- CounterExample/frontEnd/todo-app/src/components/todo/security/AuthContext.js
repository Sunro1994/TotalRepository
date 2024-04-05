import { createContext, useContext, useState } from "react";

//create a Context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext)

//Put some state in the context

//Share the create context with other components

export default function AuthProvider({children}){

    const [isAuthenticated, setAuthenticated] = useState(false);

    function login(username, password){
        if (username === "sunro" && password === "12345") {
            //변수사용시 ${}을 사용하고 문자열과 섞을 경우 백틱(`)을 사용한다.
            setAuthenticated(true);
            return true;
          } else {
            return false;
          }
    }

    function logout(){
        setAuthenticated(false)
    }


    return(
            <AuthContext.Provider value={{isAuthenticated,login,logout}}>
                {children}
            </AuthContext.Provider>
    )
}
