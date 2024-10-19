package com.prueba.bigview.gestionreservas.serviceImpl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.dtos.UsuarioDTO;
import com.prueba.bigview.gestionreservas.entities.UsuarioEntity;
import com.prueba.bigview.gestionreservas.mappers.UsuarioMapper;
import com.prueba.bigview.gestionreservas.repositories.UsuarioRepository;
import com.prueba.bigview.gestionreservas.service.IUsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Clase que implementa la interfaz de la lógica de negocio.
 */


@Service
@Slf4j
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {
	
	private final UsuarioRepository usuarioRepository;
    
    @Override
    public ResponseEntity<ResponseDTO> guardarUsuario(final UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = UsuarioMapper.INSTANCE.dtoToEntity(usuarioDTO);
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        UsuarioDTO savedUsuarioDTO = UsuarioMapper.INSTANCE.entityToDto(usuarioEntity);
        log.info("entra");
        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Usuario creado exitosamente")
                .objectResponse(savedUsuarioDTO)
                .build()
        );
    }
    
    @Override
    public ResponseEntity<ResponseDTO> obtenerUsuarioPorId(final Integer id) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuarioDTO usuarioDTO = UsuarioMapper.INSTANCE.entityToDto(usuarioOpt.get());
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Usuario obtenido exitosamente")
                    .objectResponse(usuarioDTO)
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Usuario no encontrado")
                    .build()
            );
        }
    }
    
    @Override
    public ResponseEntity<ResponseDTO> autenticarUsuario(String correo, String contrasena) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByPersonaCorreo(correo);
        if (usuarioOpt.isPresent()) {
            UsuarioEntity usuarioEntity = usuarioOpt.get();
            if (usuarioEntity.getContrasena().equals(contrasena)) {
                UsuarioDTO usuarioDTO = UsuarioMapper.INSTANCE.entityToDto(usuarioEntity);
                return ResponseEntity.ok(
                    ResponseDTO.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Autenticación exitosa")
                        .objectResponse(usuarioDTO)
                        .build()
                );
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ResponseDTO.builder()
                        .statusCode(HttpStatus.UNAUTHORIZED.value())
                        .message("Contraseña incorrecta")
                        .build()
                );
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Usuario no encontrado")
                    .build()
            );
        }
    }

}
