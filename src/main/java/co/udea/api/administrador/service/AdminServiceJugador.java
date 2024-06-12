package co.udea.api.administrador.service;

import co.udea.api.exception.BusinessException;
import co.udea.api.model.Jugador;
import co.udea.api.administrador.repository.AdminRepositoryJugador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceJugador {

    private final Logger log = LoggerFactory.getLogger(AdminServiceJugador.class);

    private AdminRepositoryJugador adminRepositoryJugador;

    public AdminServiceJugador(AdminRepositoryJugador adminRepositoryJugador) {
        this.adminRepositoryJugador = adminRepositoryJugador;
    }

    /***** SERVICIOS PARA JUGADOR *****/

    public List<Jugador> getJugadores() {
        List<Jugador> JugadoresList = adminRepositoryJugador.findAll();
        if (JugadoresList.isEmpty()) {
            log.info("No se encuentran Jugadores en la base de datos");
            throw new BusinessException("Los Jugadores no existen. ");
        }
        return JugadoresList;
    }

    public Jugador getJugador(Integer id) {
        Optional<Jugador> optionalJugador;
        optionalJugador = adminRepositoryJugador.findById(id);
        if (!optionalJugador.isPresent()) {
            log.info("No se encuentra un Jugador con ID: " + id);
            throw new BusinessException("El Jugador no existe");
        }
        return optionalJugador.get();
    }

    public List<Jugador> getJugadoresByEquipo(Integer idEquipo) {
        return adminRepositoryJugador.findByEquipoId(idEquipo);
    }

    public List<Jugador> getJugadoresByFilter(String filtro) {
        return adminRepositoryJugador.findByFiltro(filtro);
    }

    /*
    public List<Jugador> searchJugadores(String nombre) {
        List<Jugador> jugadores = adminRepositoryJugador.findByNameContaining(nombre);
        if (jugadores.isEmpty()) {
            log.info("No se encuentra un Jugador con nombre :" + nombre);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        return jugadores;

    }
    */

    public Jugador updateJugador(Jugador jugador) {
        int id = jugador.getId();

        Optional<Jugador> optionalJugador = adminRepositoryJugador.findById(id);
        if (!optionalJugador.isPresent()) {
            log.info("No se encuentra un Jugador registrado con ID: " + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }

        Jugador existingJugador = optionalJugador.get();
        existingJugador.setId_equipo(jugador.getId_equipo());
        existingJugador.setNombre(jugador.getNombre());
        existingJugador.setEdad(jugador.getEdad());
        existingJugador.setCategoria(jugador.getCategoria());
        existingJugador.setNombre_equipo(jugador.getNombre_equipo());
        existingJugador.setPosicion(jugador.getPosicion());
        existingJugador.setN_camiseta(jugador.getN_camiseta());
        existingJugador.setTelefono(jugador.getTelefono());
        existingJugador.setCorreo(jugador.getCorreo());
        existingJugador.setFoto(jugador.getFoto());

        log.info("Actualizando jugador: " + existingJugador.toString());
        return adminRepositoryJugador.save(existingJugador);
    }

    public Jugador addJugador(Jugador jugador) {
        log.info("Agregando jugador: " + jugador.toString());
        return adminRepositoryJugador.save(jugador);
    }

    public void deleteJugador(Integer id) {
        Optional<Jugador> optionalJugador = adminRepositoryJugador.findById(id);
        if (!optionalJugador.isPresent()) {
            log.info("No se encuentra un Jugador con ID:" + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        adminRepositoryJugador.delete(optionalJugador.get());
    }
}
