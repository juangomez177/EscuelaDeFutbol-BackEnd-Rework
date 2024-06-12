package co.udea.api.administrador.repository;

import co.udea.api.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdminRepositoryJugador extends JpaRepository<Jugador, Integer> {

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo" , nativeQuery = true)
    List<Jugador> findByEquipoId(@Param("idEquipo") Integer idEquipo);

    @Query(value = "SELECT * FROM jugador WHERE " +
            "nombre_equipo LIKE %:filtro% OR " +
            "nombre LIKE %:filtro% OR " +
            "CAST(edad AS TEXT) LIKE %:filtro% OR " +
            "CAST(categoria AS TEXT) LIKE %:filtro% OR " +
            "posicion LIKE %:filtro% OR " +
            "CAST(n_camiseta AS TEXT) LIKE %:filtro% OR " +
            "CAST(telefono AS TEXT) LIKE %:filtro% OR " +
            "correo LIKE %:filtro%",
            nativeQuery = true)
    List<Jugador> findByFiltro(@Param("filtro") String filtro);
}
