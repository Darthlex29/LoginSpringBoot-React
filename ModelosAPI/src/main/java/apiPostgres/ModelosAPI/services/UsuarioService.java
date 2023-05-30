package apiPostgres.ModelosAPI.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiPostgres.ModelosAPI.Repositories.UsuarioRepository;
import apiPostgres.ModelosAPI.models.UsuarioModelo;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModelo> obtenerUsuarios(){
        return (ArrayList<UsuarioModelo>) usuarioRepository.findAll();
    }

    public ArrayList<UsuarioModelo> obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioModelo guardarUsuario(UsuarioModelo usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModelo> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
