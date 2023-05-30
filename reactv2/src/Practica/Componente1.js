import React, {useState} from 'react';

export const Componente1 = () => {
    let web = "AlexestahaciendounHPTAproyectoSINSABERCOMOHACERLO.com"

    const [nombre, setNombre] = useState("Alex"); 

    let pendientes = [
      "Hacer el loggeo.",
      "Hacer el registro.",
      "Hacer la nueva base de datos",
      "Hacer algo que consuma esa BD",
      "Crear un front que se vea bonito"
    ]

    const cambiarNombre = (nuevoNombre) => {
        setNombre(nuevoNombre);
    } 

  return (
    <div>
         <h1>Componente1</h1>
         <p>Quiubo reicito</p>
         <p>Mi nombre: {nombre}</p>
         <p>La web: {web} </p>

         <input type = "text" onChange={e => cambiarNombre(e.target.value)} placeholder='cambia el nombre'/>
         <button onClick={e => {
            console.log("El valor guardado en tu estado es: "+ nombre)
         }}>Mostrar valor de estado</button>
         <button onClick={ e => cambiarNombre("Front de api para modelos")}></button>

         <h2>Cursos: </h2>
         <ul>
          {
            pendientes.map( (pendiente, indice) =>{
              return (<li key={indice}>
                {pendiente}
              </li>);
            })
          }
         </ul>
    </div>
  )
}
