package apiPostgres.ModelosAPI.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiPostgres.ModelosAPI.models.PermisoModelo;


@Repository
public interface PermisoRepository  extends CrudRepository<PermisoModelo, Long>{
    
}
