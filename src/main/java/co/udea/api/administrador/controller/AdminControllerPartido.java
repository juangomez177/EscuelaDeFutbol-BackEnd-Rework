package co.udea.api.administrador.controller;

import co.udea.api.model.Partido;
import co.udea.api.administrador.service.AdminServicePartido;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdminControllerPartido {
    private final Logger log = LoggerFactory.getLogger(AdminControllerPartido.class);

    private AdminServicePartido adminServicePartido;

    public AdminControllerPartido(AdminServicePartido adminServicePartido) {
        this.adminServicePartido = adminServicePartido;
    }

    /***** SERVICIOS PARA PARTIDO *****/

    /**
     * GET: get Partido for id from the server
     * (http://localhost:8080/app_web_futbol/partido/1) Se envía un Integer mediante la solicitud GET
     */
    @GetMapping("/partido/{id}")
    @ApiOperation(value = "Buscar partido por su id", response = Partido.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partido encontrado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Partido> getPartido(@PathVariable Integer id) {
        log.info("Rest request buscar Partido por id: " + id);
        return ResponseEntity.ok(adminServicePartido.getPartido(id));
    }

    /**
     * GETALL: get all Partido from the server
     * (http://localhost:8080/app_web_futbol/partido) 
     */
    @GetMapping("/partido")
    @ApiOperation(value = "Buscar todos los partidos", response = Partido.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partidos encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Partido>> getPartidos() {
        log.info("Rest request buscar Partidos");
        return ResponseEntity.ok(adminServicePartido.getPartidos());
    }

    /**
     * GET: get Partido for id_equipo from the server
     * (http://localhost:8080/app_web_futbol/partido/equipo/1) Se envía un Integer mediante la solicitud GET
     **/
    @GetMapping("/partido/equipo/{idEquipo}")
    @ApiOperation(value = "Buscar partidos por ID de equipo", response = Partido.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partidos encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Partido>> getPartidosByEquipo(@PathVariable Integer idEquipo) {
        log.info("Rest request buscar Partidos por ID de equipo: " + idEquipo);
        List<Partido> partidos = adminServicePartido.getPartidosByEquipo(idEquipo);
        return ResponseEntity.ok(partidos);
    }

    /**
     * PUT: update the Partido on the server
     * (http://localhost:8080/app_web_futbol/partido) Se envía un json heroe mediante la solicitud PUT
     */
    @PutMapping("/partido")
    @ApiOperation(value = "Partido actualizado", response = Partido.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partido actualizado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Partido> updatePartido(@RequestBody Partido partido) {
        log.info("Rest request actualizar Partido");
        return ResponseEntity.ok(adminServicePartido.updatePartido(partido));
    }

    /**
     * POST: add a new Partido to the server
     * (http://localhost:8080/app_web_futbol/partido) Se envía un json heroe mediante la solicitud POST
     */
    @PostMapping("/partido")
    @ApiOperation(value = "Agregar Partido", response = Partido.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partido agregado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Partido> addPartido(@RequestBody Partido partido) {
        log.info("Rest request agregar Partido");
        return ResponseEntity.ok(adminServicePartido.addPartido(partido));
    }

    /**
     * DELETE: delete the Partido from the server
     * (http://localhost:8080/app_web_futbol/partido/1) Se envía un Integer mediante la solicitud DELETE
     */
    @DeleteMapping("/partido/{id}")
    @ApiOperation(value = "Partido eliminado", response = Partido.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partido eliminado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Void> deletePartido(@PathVariable Integer id) {
        log.info("Rest request eliminar Partido");
        adminServicePartido.deletePartido(id);
        return ResponseEntity.noContent().build();
    }
}
