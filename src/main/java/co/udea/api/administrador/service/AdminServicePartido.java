package co.udea.api.administrador.service;

import co.udea.api.exception.BusinessException;
import co.udea.api.model.Partido;
import co.udea.api.administrador.repository.AdminRepositoryPartido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServicePartido {

    private final Logger log = LoggerFactory.getLogger(AdminServicePartido.class);

    private AdminRepositoryPartido adminRepositoryPartido;

    public AdminServicePartido(AdminRepositoryPartido adminRepositoryPartido) {
        this.adminRepositoryPartido = adminRepositoryPartido;
    }

    /***** SERVICIOS PARA PARTIDO *****/
    public List<Partido> getPartidos() {
        List<Partido> partidosList = adminRepositoryPartido.findAll();
        if (partidosList.isEmpty()) {
            log.info("No se encuentran partidos en la base de datos");
            throw new BusinessException("Los partidos no existen");
        }
        return partidosList;
    }

    public Partido getPartido(Integer id) {
        Optional<Partido> optionalPartido = adminRepositoryPartido.findById(id);
        if (!optionalPartido.isPresent()) {
            log.info("No se encuentra un partido con ID: " + id);
            throw new BusinessException("El partido no existe");
        }
        return optionalPartido.get();
    }

    public List<Partido> getPartidosByEquipo(Integer idEquipo) {
        return adminRepositoryPartido.findByEquipoId(idEquipo);
    }

    public Partido updatePartido(Partido partido) {
        int id = partido.getId();
        Optional<Partido> optionalPartido = adminRepositoryPartido.findById(id);

        if (!optionalPartido.isPresent()) {
            log.info("No se encuentra un partido registrado con ID: " + id);
            throw new BusinessException("El partido no existe");
        }
        Partido existingPartido = optionalPartido.get();
        existingPartido.setId_equipo(partido.getId_equipo());
        existingPartido.setEstado(partido.getEstado());
        existingPartido.setGoles_favor(partido.getGoles_favor());
        existingPartido.setGoles_contra(partido.getGoles_contra());
        existingPartido.setFaltas_cometidas(partido.getFaltas_cometidas());
        existingPartido.setFaltas_recibidas(partido.getFaltas_recibidas());
        existingPartido.setFecha(partido.getFecha());
        existingPartido.setLugar(partido.getLugar());
        existingPartido.setEquipo_rival(partido.getEquipo_rival());

        log.info("Actualizando partido: " + existingPartido.toString());
        return adminRepositoryPartido.save(existingPartido);
    }

    public Partido addPartido(Partido partido) {
        log.info("Agregando partido: " + partido.toString());
        return adminRepositoryPartido.save(partido);
    }

    public void deletePartido(Integer id) {
        Optional<Partido> optionalPartido = adminRepositoryPartido.findById(id);
        if (!optionalPartido.isPresent()) {
            log.info("No se encuentra un partido con ID: " + id);
            throw new BusinessException("El partido no existe");
        }
        adminRepositoryPartido.delete(optionalPartido.get());
    }
}
