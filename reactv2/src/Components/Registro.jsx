import React, { useState } from "react";
import {
  BuscarApi,
  getAllUsers,
  getUserID,
  deleteUser,
  createUser,
  getUserEmail,
} from "../Services/UserService.jsx";

export const Registro = (props) => {
  const [nombre, setNombre] = useState("");
  const [email, setEmail] = useState("");
  const [contrasena, setContrasena] = useState("");

  const controlEmail = (e) => { // Corregir el nombre de la función a "controlEmail"
    setEmail(e.target.value); // Utilizar e.target.value para obtener el valor del input
  };

  const controlContrasena = (e) => { // Corregir el nombre de la función a "controlContrasena"
    setContrasena(e.target.value); // Utilizar e.target.value para obtener el valor del input
  };

  const controlNombre = (e) => { // Corregir el nombre de la función a "controlNombre"
    setNombre(e.target.value); // Utilizar e.target.value para obtener el valor del input
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("Se realizó el envío");
    console.log("El valor guardado en tu estado es: " + nombre + ", " + email + ", " + contrasena);

    const usuario = {
      nombre: nombre,
      email: email,
      contrasena: contrasena
    };

    try {
      const response = await createUser(usuario);
      console.log(response); // Puedes mostrar o manejar la respuesta del backend
    } catch (error) {
      console.error(error);
    }
  }; 

  return (
    <div className="contenedor-registro-auth">
      <h1>Registro</h1>
      <form className="registro-form" onSubmit={handleSubmit}>
        <label htmlFor="nombre">nombre completo: </label>
        <input
          type="text" // Corregir el tipo de input a "text"
          placeholder="Ingresa tu nombre"
          value={nombre} // Usar value en lugar de onChange para vincular el estado con el input
          onChange={controlNombre}
        />

        <label htmlFor="email">email: </label>
        <input
          type="email"
          placeholder="tucorreo@email.com"
          value={email} // Usar value en lugar de onChange para vincular el estado con el input
          onChange={controlEmail}
        />

        <label htmlFor="contrasena">contraseña: </label>
        <input
          type="password" // Cambiar el tipo de input a "password" para ocultar la contraseña
          placeholder="************"
          value={contrasena} // Usar value en lugar de onChange para vincular el estado con el input
          onChange={controlContrasena}
        />

        <button className="btnRegistro" type="submit">Ingresar</button>
      </form>
      <button className="Linkbtn" onClick={() => props.onFormSwitch("Login")}>
        ¿Ya tienes una cuenta? Ingresa aquí
      </button>
    </div>
  );
};
