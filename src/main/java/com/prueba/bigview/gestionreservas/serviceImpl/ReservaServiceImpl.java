package com.prueba.bigview.gestionreservas.serviceImpl;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.bigview.gestionreservas.dtos.ReservaDTO;
import com.prueba.bigview.gestionreservas.dtos.ReservaRequestDTO;
import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.entities.PersonaEntity;
import com.prueba.bigview.gestionreservas.entities.ReservaEntity;
import com.prueba.bigview.gestionreservas.entities.VueloEntity;
import com.prueba.bigview.gestionreservas.mappers.ReservaMapper;
import com.prueba.bigview.gestionreservas.repositories.PersonaRepository;
import com.prueba.bigview.gestionreservas.repositories.ReservaRepository;
import com.prueba.bigview.gestionreservas.repositories.VueloRepository;
import com.prueba.bigview.gestionreservas.service.IReservaService;

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
public class ReservaServiceImpl implements IReservaService {
	
    private final ReservaRepository reservaRepository;

    private final VueloRepository vueloRepository;

    private final PersonaRepository personaRepository;
    
    @Override
    public ResponseEntity<ResponseDTO> guardarReserva(final ReservaRequestDTO reservaRequestDTO) {
        VueloEntity vueloEntity = vueloRepository.findById(reservaRequestDTO.getIdVuelo())
            .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        PersonaEntity personaEntity = personaRepository.findById(reservaRequestDTO.getIdPersona())
            .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        ReservaEntity reservaEntity = ReservaEntity.builder()
            .vuelo(vueloEntity)
            .persona(personaEntity)
            .fechaReserva(reservaRequestDTO.getFechaReserva())
            .estado(reservaRequestDTO.getEstado())
            .build();

        reservaEntity = reservaRepository.save(reservaEntity);

        ReservaDTO savedReservaDTO = ReservaMapper.INSTANCE.entityToDto(reservaEntity);

        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Reserva creada exitosamente")
                .objectResponse(savedReservaDTO)
                .build()
        );
    }


    @Override
    public ResponseEntity<ResponseDTO> obtenerReservas() {
        List<ReservaEntity> reservas = reservaRepository.findAll();
        List<ReservaDTO> reservaDTOs = reservas.stream()
            .map(ReservaMapper.INSTANCE::entityToDto)
            .collect(Collectors.toList());

        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Lista de reservas obtenida")
                .objectResponse(reservaDTOs)
                .build()
        );
    }

    @Override
    public ResponseEntity<ResponseDTO> obtenerReservaPorId(final Integer id) {
        Optional<ReservaEntity> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            ReservaDTO reservaDTO = ReservaMapper.INSTANCE.entityToDto(reservaOpt.get());
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Reserva obtenida exitosamente")
                    .objectResponse(reservaDTO)
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Reserva no encontrada")
                    .build()
            );
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> actualizarReserva(final Integer id, final ReservaDTO reservaDTO) {
        Optional<ReservaEntity> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            ReservaEntity reservaToUpdate = ReservaMapper.INSTANCE.dtoToEntity(reservaDTO);
            reservaToUpdate.setId(id);
            ReservaEntity updatedReserva = reservaRepository.save(reservaToUpdate);
            ReservaDTO updatedReservaDTO = ReservaMapper.INSTANCE.entityToDto(updatedReserva);
            
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Reserva actualizada exitosamente")
                    .objectResponse(updatedReservaDTO)
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Reserva no encontrada para actualizar")
                    .build()
            );
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> eliminarReserva(final Integer id) {
        Optional<ReservaEntity> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            reservaRepository.deleteById(id);
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Reserva eliminada exitosamente")
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Reserva no encontrada para eliminar")
                    .build()
            );
        }
    }
    
    @Override
    public ResponseEntity<ResponseDTO> obtenerReservasPorPersonaId(final Integer idPersona) {
        List<ReservaEntity> reservas = reservaRepository.findByPersona_Id(idPersona);
        
        if (reservas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("No se encontraron reservas para la persona con ID " + idPersona)
                    .build()
            );
        }

        List<ReservaDTO> reservaDTOs = reservas.stream()
            .map(ReservaMapper.INSTANCE::entityToDto)
            .collect(Collectors.toList());

        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Reservas obtenidas exitosamente")
                .objectResponse(reservaDTOs)
                .build()
        );
    }


}
