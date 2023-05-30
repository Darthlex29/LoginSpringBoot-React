package apiPostgres.ModelosAPI.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiPostgres.ModelosAPI.models.UsuarioModelo;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModelo, Long> {
    public abstract ArrayList<UsuarioModelo> findByEmail(String email);
}
