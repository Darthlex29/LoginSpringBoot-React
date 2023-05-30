import React, { createContext, useState } from "react";

// Crea el contexto
export const UserContext = createContext();

// Crea el proveedor del contexto
export const UserProvider = ({ children }) => {
  const [usuario, setUsuario] = useState({});

  return (
    <UserContext.Provider value={[usuario, setUsuario]}>
      {children}
    </UserContext.Provider>
  );
};