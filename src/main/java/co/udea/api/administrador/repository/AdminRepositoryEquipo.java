package co.udea.api.administrador.repository;

import co.udea.api.model.Equipo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepositoryEquipo extends JpaRepository<Equipo, Integer> {

   @Query("SELECT e FROM Equipo e WHERE e.nombre_equipo LIKE %:nombre%")
   Optional<Equipo> findByNameContaining(String nombre);
}
