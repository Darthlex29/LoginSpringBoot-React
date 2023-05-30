package apiPostgres.ModelosAPI.Repositories;

import org.springframework.stereotype.Repository;

import apiPostgres.ModelosAPI.models.AplicacionModelo;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AplicacionRepository extends CrudRepository<AplicacionModelo, Long>{
    
}
