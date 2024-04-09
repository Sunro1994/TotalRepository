import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import "./TodoApp.css";
import LogoutComponent from "./LogoutComponent";
import FooterComponent from "./FooterComponent";
import HeaderComponent from "./HeaderComponent";
import LoginComponent from "./LoginComponent";
import WelcomeComponent from "./WelcomeComponent";
import ErrorComponent from "./ErrorComponent";
import ListTodosComponent from "./TodoListComponent";
import AuthProvider, { useAuth } from "./security/AuthContext";

function AuthenticatedRoute(props) {
  const authContext = useAuth();
  if (authContext.isAuthenticated) {
    return props.children;
  }
  return <Navigate to="/" />;
}

export default function TodoApp() {
  return (
    <div className="TodoApp">
      {/* <WelcomeComponent/> */}
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />
          <Routes>
            <Route path="/" element={<LoginComponent />} />
            <Route path="/login" element={<LoginComponent />} />
            <Route
              path="/welcome/:username"
              element={
                <AuthenticatedRoute>
                  <WelcomeComponent />
                </AuthenticatedRoute>
              }
            />
            <Route
              path="*"
              element={
                  <ErrorComponent />
              }
            />
            <Route
              path="/todos"
              element={
                <AuthenticatedRoute>
                  <ListTodosComponent />
                </AuthenticatedRoute>
              }
            />
            <Route
              path="/logout"
              element={
                <AuthenticatedRoute>
                  <LogoutComponent />
                </AuthenticatedRoute>
              }
            />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
      <FooterComponent />
    </div>
  );
}
