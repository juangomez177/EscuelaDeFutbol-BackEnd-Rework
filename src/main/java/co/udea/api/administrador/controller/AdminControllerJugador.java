package co.udea.api.administrador.controller;

import co.udea.api.model.Jugador;
import co.udea.api.administrador.service.AdminServiceJugador;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdminControllerJugador {
    private final Logger log = LoggerFactory.getLogger(AdminControllerJugador.class);

    private AdminServiceJugador adminServiceJugador;

    public AdminControllerJugador(AdminServiceJugador adminServiceJugador) {
        this.adminServiceJugador = adminServiceJugador;
    }

    /***** SERVICIOS PARA JUGADOR *****/

    /**
     * GET: get Jugador for id from the server
     * (http://localhost:8080/app_web_futbol/jugador/1) Se envía un Integer mediante la solicitud GET
     */
    @GetMapping("/jugador/{id}")
    @ApiOperation(value = "Busca  por su id", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Jugador> getJugador(@PathVariable Integer id) {
        log.info("Rest request buscar Jugador por id: " + id);
        return ResponseEntity.ok(adminServiceJugador.getJugador(id));
    }

    /**
     * GETALL: get all Jugadores from the server
     * (http://localhost:8080/app_web_futbol/jugador)
     */
    @GetMapping("/jugador")
    @ApiOperation(value = "Buscar todos los Jugadores", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugadores encontrado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Jugador>> getJugadores() {
        log.info("Rest request buscar Jugadores");
        return ResponseEntity.ok(adminServiceJugador.getJugadores());
    }

    /**
     * GET: get Jugador for id_equipo from the server
     * (http://localhost:8080/app_web_futbol/jugador/equipo/1) Se envía un Integer mediante la solicitud GET
     **/
    @GetMapping("/jugador/equipo/{idEquipo}")
    @ApiOperation(value = "Buscar jugadores por ID de equipo", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugadores encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Jugador>> getJugadoresByEquipo(@PathVariable Integer idEquipo) {
        log.info("Rest request buscar Jugadores por ID de equipo: " + idEquipo);
        List<Jugador> jugadores = adminServiceJugador.getJugadoresByEquipo(idEquipo);
        return ResponseEntity.ok(jugadores);
    }

    /** 
     * GET: get Jugadores by a filter from the server 
     * (http://localhost:8080/app_web_futbol/jugador/filtro/a1b) Se envía un String mediante la solicitud GET
    **/
    @GetMapping("/jugador/filtro/{filtro}")
    @ApiOperation(value = "Jugadores Encontrdaos",  response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugadores encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Jugador>> getJugadoresByFilter(@PathVariable String filtro){
        log.info("Rest request buscar Jugadores por filtro ");
        return ResponseEntity.ok(adminServiceJugador.getJugadoresByFilter(filtro));
    }

    /**
     * PUT: update the Jugador on the server
     * (http://localhost:8080/app_web_futbol/jugador) Se envía un json heroe mediante la solicitud PUT
     */
    @PutMapping("/jugador")
    @ApiOperation(value = "Jugador actualizado", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador actualizado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Jugador> updateJugador(@RequestBody Jugador jugador) {
        log.info("Rest request actualizar Jugador");
        return ResponseEntity.ok(adminServiceJugador.updateJugador(jugador));
    }

    /**
     * POST: add a new Jugador to the server
     * (http://localhost:8080/app_web_futbol/jugador) Se envía un json heroe mediante la solicitud POST
     */
    @PostMapping("/jugador")
    @ApiOperation(value = "Agregar Jugador", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador agregado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Jugador> addJugador(@RequestBody Jugador jugador) {
        log.info("Rest request agregar Jugador");
        return ResponseEntity.ok(adminServiceJugador.addJugador(jugador));
    }

    /**
     * DELETE: delete the Jugador from the server
     * (http://localhost:8080/app_web_futbol/jugador/1) Se envía un Integer mediante la solicitud DELETE
     */
    @DeleteMapping("/jugador/{id}")
    @ApiOperation(value = "Jugador eliminado", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador eliminado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Object> deleteJugador(@PathVariable Integer id) {
        log.info("Rest request eliminar Jugador");
        adminServiceJugador.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }

}
