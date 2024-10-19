package com.prueba.bigview.gestionreservas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.dtos.UsuarioPersonaDTO;
import com.prueba.bigview.gestionreservas.serviceImpl.UsuarioPersonaFacadeImpl;

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
 *          tipo (Usuario-Persona).
 */

@RestController
@RequestMapping("/api/v1/usuario-persona")
@Tag(name = "Usuario-Persona - Controller", description = "Controller encargado de gestionar la creación conjunta de usuario y persona.")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
@RequiredArgsConstructor
public class UsuarioPersonaFacadeController {
	
	private final UsuarioPersonaFacadeImpl usuarioPersonaFacade;

    @Operation(summary = "Operación que permite crear un usuario y una persona a la vez")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha guardado satisfactoriamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presentó una condición inesperada que impidió completar la petición", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
    @PostMapping
    public ResponseEntity<ResponseDTO> crearUsuarioPersona(@RequestBody UsuarioPersonaDTO usuarioPersonaDTO) {
        return this.usuarioPersonaFacade.crearUsuarioPersona(usuarioPersonaDTO);
    }


}
