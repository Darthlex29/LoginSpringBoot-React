package apiPostgres.ModelosAPI.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apiPostgres.ModelosAPI.models.RolModelo;
import apiPostgres.ModelosAPI.services.RolService;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin("*")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping()
    public ArrayList<RolModelo> obtenerRoles(){
        return rolService.obtenerRoles();
    }

    @PostMapping()
    public RolModelo guardarRol(@RequestBody RolModelo rol){
        return this.rolService.guardarRol(rol);
    }

    @GetMapping( path = "/{idRol}")
    public Optional<RolModelo> obtenerRolPorId(@PathVariable("idRol") Long idRol) {
        return this.rolService.obtenerPorId(idRol);
    }

    @DeleteMapping( path = "/{idRol}")
    public String eliminarPorId(@PathVariable("idRol") Long idRol){
        boolean ok = this.rolService.eliminarRol(idRol);
        if (ok){
            return "Se eliminó el rol con id " + idRol;
        }else{
            return "No pudo eliminar el rol con id" + idRol;
        }
    }
}
