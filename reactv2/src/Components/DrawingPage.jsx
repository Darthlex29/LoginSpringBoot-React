import React, { useContext } from "react";
import "../Styles/Paint.css"; // Importar el archivo CSS
import Paint from "./PaintCanvas";
import { UserContext } from "../Functions/UserContext.jsx";

function DrawingPage() {
  const [usuario] = useContext(UserContext); // Obtener el valor del usuario del contexto
  return (
    <div className="DrawingPage">
      <div className="DatosUsuarios">
        <h1>Bienvenido {usuario.nombre}</h1>
        <h1>Aquí se realizará el lienzo</h1>
      </div>
      <div className="Lienzo-contenedor">
        <Paint />
        <button>Limpiar</button>
      </div>
    </div>
  );
}

export default DrawingPage;
