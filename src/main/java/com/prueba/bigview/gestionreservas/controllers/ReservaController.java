package com.prueba.bigview.gestionreservas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bigview.gestionreservas.dtos.ReservaDTO;
import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.serviceImpl.ReservaServiceImpl;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Controlador que expone los servicios para trabajar con objeto(s) de
 *          tipo (Reserva).
 */

@RestController
@RequestMapping("/api/v1/reserva")
@Tag(name = "Reserva - Controller", description = "Controller encargado de gestionar las operaciones de las reservas.")
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequiredArgsConstructor
public class ReservaController {

	private final ReservaServiceImpl reservaService;

    @Operation(summary = "Operación que permite crear una reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha guardado satisfactoriamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @PostMapping
    public ResponseEntity<ResponseDTO> guardarReserva(@RequestBody ReservaDTO reservaDTO) {
        return this.reservaService.guardarReserva(reservaDTO);
    }

    @Operation(summary = "Operación que permite obtener todas las reservas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se consulta exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> obtenerReservas() {
        return this.reservaService.obtenerReservas();
    }

    @Operation(summary = "Operación que permite obtener una reserva por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se consulta exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> obtenerReservaPorId(@PathVariable Integer id) {
        return this.reservaService.obtenerReservaPorId(id);
    }

    @Operation(summary = "Operación que permite actualizar una reserva por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se actualiza exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> actualizarReserva(@PathVariable Integer id, @RequestBody ReservaDTO reservaDTO) {
        return this.reservaService.actualizarReserva(id, reservaDTO);
    }

    @Operation(summary = "Operación que permite eliminar una reserva por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha procesado exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> eliminarReserva(@PathVariable Integer id) {
        return this.reservaService.eliminarReserva(id);
    }
}
