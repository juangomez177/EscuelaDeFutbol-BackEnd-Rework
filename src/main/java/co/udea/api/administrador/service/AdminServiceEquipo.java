package co.udea.api.administrador.service;

import co.udea.api.exception.BusinessException;
import co.udea.api.model.Equipo;
import co.udea.api.administrador.repository.AdminRepositoryEquipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceEquipo {

    private final Logger log = LoggerFactory.getLogger(AdminServiceEquipo.class);

    private AdminRepositoryEquipo adminRepositoryEquipo;


    public AdminServiceEquipo(AdminRepositoryEquipo adminRepositoryEquipo) {
        this.adminRepositoryEquipo = adminRepositoryEquipo;

    }

    /***** SERVICIOS PARA EQUIPO *****/
    public List<Equipo> getEquipos() {
        List<Equipo> EquiposList = adminRepositoryEquipo.findAll();
        if (EquiposList.isEmpty()) {
            log.info("No se encuentran Equipos en la base de datos");
            throw new BusinessException("Los Equipos no existen. ");
        }
        return EquiposList;
    }

    public Equipo getEquipo(Integer id) {
        Optional<Equipo> optionalEquipo = adminRepositoryEquipo.findById(id);
        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo con ID: " + id);
            throw new BusinessException("El Equipo no existe");
        }
        return optionalEquipo.get();
    }

    
    public Equipo searchEquipos(String nombre_equipo) {
        Optional<Equipo> optionalEquipo = adminRepositoryEquipo.findByNameContaining(nombre_equipo);
        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo con nombre :" + nombre_equipo);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        log.info(optionalEquipo.get().toString());
        return optionalEquipo.get();
    }
    

    public Equipo updateEquipo(Equipo equipo) {

        int id = equipo.getId();
        Optional<Equipo> optionalEquipo = adminRepositoryEquipo.findById(id);

        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo registrado con ID: " + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        Equipo existingEquipo = optionalEquipo.get();
        existingEquipo.setNombre_equipo(equipo.getNombre_equipo());
        existingEquipo.setCategoria(equipo.getCategoria());
        existingEquipo.setDescripcion(equipo.getDescripcion());
        existingEquipo.setCapitan(equipo.getCapitan());
        existingEquipo.setEntrenador(equipo.getEntrenador());
        existingEquipo.setLogo(equipo.getLogo());


        log.info("Actualizando equipo: " + existingEquipo.toString());
        return adminRepositoryEquipo.save(existingEquipo);
    }

    public Equipo addEquipo(Equipo equipo) {
        log.info("Agregando equipo: " + equipo.toString());
        return adminRepositoryEquipo.save(equipo);
    }

    public void deleteEquipo(Integer id) {
        Optional<Equipo> optionalEquipo = adminRepositoryEquipo.findById(id);
        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo con ID:" + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        adminRepositoryEquipo.delete(optionalEquipo.get());
    }
}
