package co.udea.api.administrador.controller;

import co.udea.api.model.AsoFutbol;
import co.udea.api.administrador.service.AdminServiceAsoFutbol;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class AdminControllerAsoFutbol {
    private final Logger log = LoggerFactory.getLogger(AdminControllerAsoFutbol.class);

    private AdminServiceAsoFutbol adminServiceAsoFutbol;

    public AdminControllerAsoFutbol( AdminServiceAsoFutbol adminServiceAsoFutbol) {
        this.adminServiceAsoFutbol = adminServiceAsoFutbol;
    }

    /**
     * GET: get AsoFutbol for id from the server
     * (http://localhost:8080/app_web_futbol/asofutbol/1) Se envía un Integer mediante la solicitud GET
     */
    @GetMapping("/asofutbol/{id}")
    @ApiOperation(value = "Busca  por su id", response = AsoFutbol.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AsoFutbol encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<AsoFutbol> getInfo(@PathVariable Integer id) {
        log.info("Rest request buscar AsoFutbol por id: " + id);
        return ResponseEntity.ok(adminServiceAsoFutbol.getInfo(id));
    }

    /**
     * PUT: update the AsoFutbol on the server
     * (http://localhost:8080/app_web_futbol/asofutbol) Se envía un json mediante la solicitud PUT
     */
    @PutMapping("/asofutbol")
    @ApiOperation(value = "AsoFutbol actualizado", response = AsoFutbol.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AsoFutbol actualizado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<AsoFutbol> updateInfo(@RequestBody AsoFutbol asofutbol) {
        log.info("Rest request actualizar Equipo");
        return ResponseEntity.ok(adminServiceAsoFutbol.updateInfo(asofutbol));
    }

    /**
     * POST: add a new AsoFutbol to the server
     * (http://localhost:8080/app_web_futbol/asofutbol) Se envía un json mediante la solicitud POST
     */
    @PostMapping("/asofutbol")
    @ApiOperation(value = "Agregar AsoFutbol", response = AsoFutbol.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AsoFutbol agregado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<AsoFutbol> addInfo(@RequestBody AsoFutbol asofutbol) {
        log.info("Rest request agregar Equipo");
        return ResponseEntity.ok(adminServiceAsoFutbol.addInfo(asofutbol));
    }





}
