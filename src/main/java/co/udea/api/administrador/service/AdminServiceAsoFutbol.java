package co.udea.api.administrador.service;

import co.udea.api.exception.BusinessException;
import co.udea.api.model.AsoFutbol;
import co.udea.api.administrador.repository.AdminRepositoryAsoFutbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceAsoFutbol {

    private final Logger log = LoggerFactory.getLogger(AdminServiceAsoFutbol.class);

    private AdminRepositoryAsoFutbol adminRepositoryAsoFutbol;

    public AdminServiceAsoFutbol(AdminRepositoryAsoFutbol adminRepositoryAsoFutbol) {
        this.adminRepositoryAsoFutbol = adminRepositoryAsoFutbol;
    }

    public AsoFutbol getInfo(Integer id) {
        Optional<AsoFutbol> optionalAsoFutbol = adminRepositoryAsoFutbol.findById(id);
        if (!optionalAsoFutbol.isPresent()) {
            log.info("No se encuentra un Asofutbol con ID: " + id);
            throw new BusinessException("Asofutbol no existe");
        }
        return optionalAsoFutbol.get();
    }

    public AsoFutbol updateInfo(AsoFutbol asofutbol) {

        int id = asofutbol.getId();
        Optional<AsoFutbol> optionalAsoFutbol = adminRepositoryAsoFutbol.findById(id);

        if (!optionalAsoFutbol.isPresent()) {
            log.info("No se encuentra un AsoFutbol registrado con ID: " + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        AsoFutbol existingAsoFutbol = optionalAsoFutbol.get();
        existingAsoFutbol.setTelefono(asofutbol.getTelefono());
        existingAsoFutbol.setCorreo(asofutbol.getCorreo());
        existingAsoFutbol.setDireccion(asofutbol.getDireccion());
        existingAsoFutbol.setSponsor1(asofutbol.getSponsor1());
        existingAsoFutbol.setSponsor2(asofutbol.getSponsor2());
        existingAsoFutbol.setSponsor3(asofutbol.getSponsor3());
        existingAsoFutbol.setFacebook(asofutbol.getFacebook());
        existingAsoFutbol.setX(asofutbol.getX());
        existingAsoFutbol.setInstagram(asofutbol.getInstagram());

        log.info("Actualizando asofutbol: " + existingAsoFutbol.toString());
        return adminRepositoryAsoFutbol.save(existingAsoFutbol);
    }

    public AsoFutbol addInfo(AsoFutbol asofutbol) {
        log.info("Agregando asofutbol: " + asofutbol.toString());
        return adminRepositoryAsoFutbol.save(asofutbol);
    }

}

