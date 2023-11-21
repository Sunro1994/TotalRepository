import React from "react";
import {
  BrowserRouter as Router, 
  Routes,
  Route,
} from "react-router-dom";
import Home from "./routes/Home"
import Detail from "./routes/Detail"

// movie/:id는 movie/뒤에 변수를 포함해서 보낼 수 있게 된다.
function App() {
    return <Router>
    <Routes>
    <Route path="/" element={<Home />} />
    <Route path="/movie/:id" element={<Detail />} />
    </Routes>
    </Router>
}

export default App;


