
package co.udea.api.administrador.repository;

import co.udea.api.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryLogin extends JpaRepository<Login, Long> {
    @Query(value = "SELECT * FROM login WHERE correo = :correo AND contraseña = crypt(:contraseña, contraseña)", nativeQuery = true)
    Login findByCorreo(@Param("correo") String correo, @Param("contraseña") String contraseña);
}



