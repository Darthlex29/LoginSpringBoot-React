package apiPostgres.ModelosAPI.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apiPostgres.ModelosAPI.models.AplicacionModelo;
import apiPostgres.ModelosAPI.services.AplicacionService;


@RestController
@RequestMapping("/api/aplicacion")
@CrossOrigin("*")
public class AplicacionController {
    @Autowired
    AplicacionService aplicacionService;

    @GetMapping()
    public ArrayList<AplicacionModelo> obtenerAplicaciones(){
        return aplicacionService.obtenerAplicaciones();
    }

    @PostMapping()
    public AplicacionModelo guardarAplicacion(@RequestBody AplicacionModelo aplicacion){
        return this.aplicacionService.guardarAplicacion(aplicacion);
    }

    @DeleteMapping( path = "/{idAplicacion}")
    public String eliminarPorId(@PathVariable("id") Long idAplicacion){
        boolean ok = this.aplicacionService.eliminarAplicacion(idAplicacion);
        if (ok){
            return "Se eliminó el aplicacion con id " + idAplicacion;
        }else{
            return "No pudo eliminar el aplicacion con id" + idAplicacion;
        }
    }
}
