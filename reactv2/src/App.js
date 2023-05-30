import React from "react";
import "./Styles/App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { UserProvider } from "./Functions/UserContext"; // Importa el UserProvider
import AuthApp from "./Components/AuthApp";
/* import Paint from "./Components/Paint"; */
import DrawingPage from "./Components/DrawingPage";

function App() {
  return (
    <div>
      <Router>
        <UserProvider>
          {" "}
          {/* Agrega el UserProvider aquí */}
          <Routes>
            <Route path="/" element={<AuthApp />} />
            {/* <Route path="/lienzo" element={<Paint />} /> */}
            <Route path="/lienzo" element={<DrawingPage />} />
          </Routes>
        </UserProvider>{" "}
        {/* Cierra el UserProvider aquí */}
      </Router>
    </div>
  );
}

export default App;
