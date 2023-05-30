package apiPostgres.ModelosAPI.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiPostgres.ModelosAPI.models.RolModelo;

@Repository
public interface RolRepository extends CrudRepository<RolModelo, Long> {
    
}
