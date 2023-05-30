package apiPostgres.ModelosAPI.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiPostgres.ModelosAPI.Repositories.RolRepository;
import apiPostgres.ModelosAPI.models.RolModelo;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public ArrayList<RolModelo> obtenerRoles(){
        return (ArrayList<RolModelo>) rolRepository.findAll();
    }

    public RolModelo guardarRol(RolModelo Rol){
        return rolRepository.save(Rol);
    }

    public Optional<RolModelo> obtenerPorId(Long id){
        return rolRepository.findById(id);
    }

    public boolean eliminarRol(Long id) {
        try{
            rolRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
