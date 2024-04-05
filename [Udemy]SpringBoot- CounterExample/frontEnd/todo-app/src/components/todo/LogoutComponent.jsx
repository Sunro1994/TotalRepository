import { useAuth } from "./security/AuthContext";

export default function LogoutComponent() {

 const  authContext = useAuth();
 authContext.logout();
    return (
      <div className="LogoutComponent">
        <h1>You are Logged out!</h1>
        <div>Thank you for using our App.</div>
      </div>
    );
  }