
package co.udea.api.administrador.controller;

import co.udea.api.administrador.repository.AdminRepositoryLogin;
import co.udea.api.administrador.service.AdminServiceLogin;
import co.udea.api.model.ChangeLogin;
import co.udea.api.model.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AdminControllerLogin {
    private static final Logger logger = LoggerFactory.getLogger(AdminControllerLogin.class);

    private final AdminServiceLogin adminServiceLogin;

    @Autowired
    public AdminControllerLogin(AdminServiceLogin adminServiceLogin) {
        this.adminServiceLogin = adminServiceLogin;
    }
    /**
     * POST: Get and validate Login from the server
     * (http://localhost:8080/app_web_futbol/login) Se envía un JSON mediante la solicitud POST
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login request) {
        try {
            String result = adminServiceLogin.login(request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
    /**
 * PUT: Change user password
 * (http://localhost:8080/app_web_futbol/change-password)
 */
@PutMapping("/change_password")
public ResponseEntity<String> changePassword(@RequestBody ChangeLogin request) {
    try {
        adminServiceLogin.changePassword(request);
        return ResponseEntity.ok("Contraseña cambiada exitosamente");
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contraseña no cambiada");
    }
}


}


