import React, { useState, useContext } from "react";
import { getUserEmail } from "../Services/UserService.jsx";
import { useNavigate } from "react-router-dom";
import { UserContext } from "../Functions/UserContext.jsx";

export const Login = (props) => {
  const [email, setEmail] = useState("");
  const [contrasena, setContrasena] = useState("");
  const [user, setUser] = useContext(UserContext);
  const navigate = useNavigate();

  const controlEmail = (e) => {
    setEmail(e.target.value);
  };

  const controlContrasena = (e) => {
    setContrasena(e.target.value);
  };

  const comprobarUsuario = async (email, contrasena) => {
    try {
      const usuario = await getUserEmail(email);
      const size = usuario.length;
      if (size <= 0) {
        console.log("El usuario no existe");
        console.log("No hay ingreso");
        return false;
      } else {
        console.log("El usuario existe:", usuario[0]);
        console.log(
          "El valor guardado en tu estado es: " + email + ", " + contrasena
        );
        const usuarioEnBD = usuario[0];
        console.log(
          "El valor guardado en la BD es: " +
            usuarioEnBD.contrasena +
            ", " +
            usuarioEnBD.email
        );
        if (usuarioEnBD.contrasena === contrasena) {
          console.log("Hay ingreso");
          console.log(usuarioEnBD.nombre);
          setUser(usuarioEnBD);
          return true;
        } else {
          console.log("Diferentes credenciales. No hay ingreso");
          return false;
        }
      }
    } catch (error) {
      console.error(error);
      return false;
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Se realizo el envio");
    console.log(
      "El valor guardado en tu estado es: " + email + ", " + contrasena
    );
  };

  const vemos = (e) => {
    navigate("/lienzo")
  }

  const handleLogin = (email, contrasena) => {
    if(comprobarUsuario(email, contrasena)){
      navigate("/lienzo")
    }
  };

  return (
    <div className="contenedor-login-auth">
      <h1>Login</h1>
      <form className="login-form" onSubmit={handleSubmit}>
        <label htmlFor="email">email: </label>
        <input
          type="email"
          value={email} // Usar value en lugar de onChange para vincular el estado con el input
          onChange={controlEmail}
          placeholder="tucorreo@email.com"
        />

        <label htmlFor="contrasena">contraseña: </label>
        <input
          type="password" // Cambiar el tipo de input a "password" para ocultar la contraseña
          value={contrasena} // Usar value en lugar de onChange para vincular el estado con el input
          onChange={controlContrasena}
          placeholder="************"
        />

        {/*  <button type="button" onClick={consultarAPI}>
          Consultar API
        </button> */}
        <button
          className="btnIngreso"
          onClick={(e) => {
            e.preventDefault();
            handleLogin(email, contrasena);
          }}
        >
          Ingresar
        </button>
      </form>
      <button
        className="Linkbtn"
        onClick={() => props.onFormSwitch("Registro")}
      >
        ¿No tienes una cuenta? Regístrate aquí
      </button>
      <button
          className="btnIngreso"
          onClick={(e) => {
            e.preventDefault();
            vemos();
          }}
        >
          Paso directo
        </button>
    </div>
  );
};
