package apiPostgres.ModelosAPI.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiPostgres.ModelosAPI.Repositories.AplicacionRepository;
import apiPostgres.ModelosAPI.models.AplicacionModelo;

@Service
public class AplicacionService {
    @Autowired
    AplicacionRepository aplicacionRepository;
    
    public ArrayList<AplicacionModelo> obtenerAplicaciones(){
        return (ArrayList<AplicacionModelo>) aplicacionRepository.findAll();
    }

    public AplicacionModelo guardarAplicacion(AplicacionModelo Aplicacion){
        return aplicacionRepository.save(Aplicacion);
    }

    public Optional<AplicacionModelo> obtenerPorId(Long id){
        return aplicacionRepository.findById(id);
    }

    public boolean eliminarAplicacion(Long id) {
        try{
            aplicacionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
