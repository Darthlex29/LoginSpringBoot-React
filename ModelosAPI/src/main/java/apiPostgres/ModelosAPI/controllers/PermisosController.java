package apiPostgres.ModelosAPI.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apiPostgres.ModelosAPI.models.PermisoModelo;
import apiPostgres.ModelosAPI.services.PermisoService;

@RestController
@RequestMapping("/api/permisos")
@CrossOrigin("*")
public class PermisosController {
    @Autowired
    PermisoService permisoService;

    @GetMapping()
    public ArrayList<PermisoModelo> obtenerPermisos(){
        return permisoService.obtenerPermisos();
    }

    @PostMapping()
    public PermisoModelo guardarPermiso(@RequestBody PermisoModelo permiso){
        return this.permisoService.guardarPermiso(permiso);
    }

    @GetMapping( path = "/{idPermiso}")
    public Optional<PermisoModelo> obtenerPermisoPorId(@PathVariable("idPermiso") Long idPermiso) {
        return this.permisoService.obtenerPorId(idPermiso);
    }

    @DeleteMapping( path = "/{idPermiso}")
    public String eliminarPorId(@PathVariable("idPermiso") Long idPermiso){
        boolean ok = this.permisoService.eliminarPermiso(idPermiso);
        if (ok){
            return "Se eliminó el permiso con id " + idPermiso;
        }else{
            return "No pudo eliminar el permiso con id" + idPermiso;
        }
    }
}
