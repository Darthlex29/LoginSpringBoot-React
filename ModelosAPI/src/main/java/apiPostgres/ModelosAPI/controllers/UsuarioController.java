package apiPostgres.ModelosAPI.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apiPostgres.ModelosAPI.models.UsuarioModelo;
import apiPostgres.ModelosAPI.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/allusers")
    public ArrayList<UsuarioModelo> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModelo guardarUsuario(@RequestBody UsuarioModelo usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/id/{idUsuario}")
    public Optional<UsuarioModelo> obtenerUsuarioPorId(@PathVariable("idUsuario") Long idUsuario) {
        return this.usuarioService.obtenerPorId(idUsuario);
    }

    @GetMapping( path = "/email/{emailUsuario}")
    public ArrayList<UsuarioModelo> obtenerUsuarioPorId(@PathVariable("emailUsuario") String emailUsuario) {
        return this.usuarioService.obtenerPorEmail(emailUsuario);
    }

    @DeleteMapping( path = "/delete/{idUsuario}")
    public String eliminarPorId(@PathVariable("idUsuario") Long idUsuario){
        boolean ok = this.usuarioService.eliminarUsuario(idUsuario);
        if (ok){
            return "Se eliminó el usuario con id " + idUsuario;
        }else{
            return "No pudo eliminar el usuario con id" + idUsuario;
        }
    }
}
