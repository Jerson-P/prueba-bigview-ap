package com.prueba.bigview.gestionreservas.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.bigview.gestionreservas.dtos.PersonaDTO;
import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.dtos.UsuarioDTO;
import com.prueba.bigview.gestionreservas.dtos.UsuarioPersonaDTO;
import com.prueba.bigview.gestionreservas.service.IPersonaService;
import com.prueba.bigview.gestionreservas.service.IUsuarioPersonaFacade;
import com.prueba.bigview.gestionreservas.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Clase que implementa la interfaz de la lógica de negocio.
 */


@Service
@RequiredArgsConstructor
public class UsuarioPersonaFacadeImpl implements IUsuarioPersonaFacade {

    private final IPersonaService personaService;
    private final IUsuarioService usuarioService;

    @Override
    public ResponseEntity<ResponseDTO> crearUsuarioPersona(UsuarioPersonaDTO usuarioPersonaDTO) {
        PersonaDTO personaDTO = PersonaDTO.builder()
                .nombre(usuarioPersonaDTO.getNombre())
                .apellido(usuarioPersonaDTO.getApellido())
                .correo(usuarioPersonaDTO.getCorreo())
                .telefono(usuarioPersonaDTO.getTelefono())
                .estado(usuarioPersonaDTO.getEstado())
                .build();

        ResponseEntity<ResponseDTO> personaResponse = personaService.guardarPersona(personaDTO);

        if (personaResponse.getStatusCode() == HttpStatus.OK && personaResponse.getBody() != null && personaResponse.getBody() != null && personaResponse.getBody() != null) {
            PersonaDTO personaCreada = (PersonaDTO) personaResponse.getBody().getObjectResponse();
            Integer personaId = personaCreada.getId();  
            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                    .persona(PersonaDTO.builder().id(personaId).build())  
                    .contrasena(usuarioPersonaDTO.getContrasena())
                    .activo(usuarioPersonaDTO.getActivo())
                    .build();

            ResponseEntity<ResponseDTO> usuarioResponse = usuarioService.guardarUsuario(usuarioDTO);
            
            if (usuarioResponse.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(
                    ResponseDTO.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Usuario y Persona creados exitosamente")
                        .build()
                );
            }
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResponseDTO.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Error al crear Usuario y Persona")
                .build()
        );
    }

}