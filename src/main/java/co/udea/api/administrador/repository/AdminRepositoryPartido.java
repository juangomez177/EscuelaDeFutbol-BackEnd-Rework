package co.udea.api.administrador.repository;

import co.udea.api.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdminRepositoryPartido extends JpaRepository<Partido, Integer> {

    @Query(value = "SELECT * FROM partido WHERE id_equipo = :idEquipo" , nativeQuery = true)
    List<Partido> findByEquipoId(@Param("idEquipo") Integer idEquipo);
    
}
