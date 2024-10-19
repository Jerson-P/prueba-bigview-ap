package com.prueba.bigview.gestionreservas.serviceImpl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.bigview.gestionreservas.dtos.PersonaDTO;
import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.entities.PersonaEntity;
import com.prueba.bigview.gestionreservas.mappers.PersonaMapper;
import com.prueba.bigview.gestionreservas.repositories.PersonaRepository;
import com.prueba.bigview.gestionreservas.service.IPersonaService;

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
public class PersonaServiceImpl implements IPersonaService {

	private final PersonaRepository personaRepository;

    @Override
    public ResponseEntity<ResponseDTO> guardarPersona(final PersonaDTO personaDTO) {
        PersonaEntity personaEntity = PersonaMapper.INSTANCE.dtoToEntity(personaDTO);
        personaEntity = personaRepository.save(personaEntity);
        PersonaDTO savedPersonaDTO = PersonaMapper.INSTANCE.entityToDto(personaEntity);
        log.info("sigue");
        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Persona creada exitosamente")
                .objectResponse(savedPersonaDTO)
                .build()
        );
    }
    
    @Override
    public ResponseEntity<ResponseDTO> obtenerPersonaPorId(final Integer id) {
        Optional<PersonaEntity> personaOpt = personaRepository.findById(id);
        if (personaOpt.isPresent()) {
            PersonaDTO personaDTO = PersonaMapper.INSTANCE.entityToDto(personaOpt.get());
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Persona obtenida exitosamente")
                    .objectResponse(personaDTO)
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Persona no encontrada")
                    .build()
            );
        }
    }

}
