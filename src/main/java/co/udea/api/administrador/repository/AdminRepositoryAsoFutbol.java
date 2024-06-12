package co.udea.api.administrador.repository;

import co.udea.api.model.AsoFutbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepositoryAsoFutbol extends JpaRepository<AsoFutbol, Integer> {

    
}