package com.prueba.bigview.gestionreservas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.dtos.VueloDTO;
import com.prueba.bigview.gestionreservas.serviceImpl.VueloServiceImpl;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Controlador que expone los servicios para trabajar con objeto(s) de
 *          tipo (Vuelo).
 */

@RestController
@RequestMapping("/api/v1/vuelo")
@Tag(name = "Vuelo - Controller", description = "Controller encargado de gestionar las operaciones de los vuelos.")
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequiredArgsConstructor
public class VueloController {
	
	private final VueloServiceImpl vueloService;

    @Operation(summary = "Operación que permite crear un vuelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha guardado satisfactoriamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @PostMapping
    public ResponseEntity<ResponseDTO> guardarVuelo(@RequestBody VueloDTO vueloDTO) {
        return this.vueloService.guardarVuelo(vueloDTO);
    }

    @Operation(summary = "Operación que permite obtener todos los vuelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se consulta exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> obtenerVuelos() {
        return this.vueloService.obtenerVuelos();
    }

    @Operation(summary = "Operación que permite obtener un vuelo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se consulta exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> obtenerVueloPorId(@PathVariable Integer id) {
        return this.vueloService.obtenerVueloPorId(id);
    }

    @Operation(summary = "Operación que permite actualizar un vuelo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se actualiza exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> actualizarVuelo(@PathVariable Integer id, @RequestBody VueloDTO vueloDTO) {
        return this.vueloService.actualizarVuelo(id, vueloDTO);
    }

    @Operation(summary = "Operación que permite eliminar un vuelo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha procesado exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> eliminarVuelo(@PathVariable Integer id) {
        return this.vueloService.eliminarVuelo(id);
    }
    
    @Operation(summary = "Operación que permite filtrar vuelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha procesado exitosamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @PostMapping("/buscar")
    public ResponseEntity<ResponseDTO> buscarVuelos(@RequestBody VueloDTO vueloDTO) {
        return vueloService.buscarVuelos(vueloDTO);
    }
}
