package com.prueba.bigview.gestionreservas.serviceImpl;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.dtos.VueloDTO;
import com.prueba.bigview.gestionreservas.entities.VueloEntity;
import com.prueba.bigview.gestionreservas.mappers.VueloMapper;
import com.prueba.bigview.gestionreservas.repositories.VueloRepository;
import com.prueba.bigview.gestionreservas.service.IVueloService;
import com.prueba.bigview.gestionreservas.specifications.VueloSpecifications;

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
public class VueloServiceImpl implements IVueloService {

	private final VueloRepository vueloRepository;
	
	private final VueloMapper vueloMapper;

    @Override
    public ResponseEntity<ResponseDTO> guardarVuelo(final VueloDTO vueloDTO) {
    	System.out.print(vueloDTO);
        VueloEntity vueloEntity = VueloMapper.INSTANCE.dtoToEntity(vueloDTO);
        vueloEntity = vueloRepository.save(vueloEntity);
        VueloDTO savedVueloDTO = VueloMapper.INSTANCE.entityToDto(vueloEntity);
        log.info("Acción realizada");
        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Vuelo creado exitosamente")
                .objectResponse(savedVueloDTO)
                .build()
        );
    }

    @Override
    public ResponseEntity<ResponseDTO> obtenerVuelos() {
        // Usamos la inyección de VueloMapper en lugar de INSTANCE
        List<VueloEntity> vuelos = vueloRepository.findAll();
        List<VueloDTO> vueloDTOs = vuelos.stream()
            .map(vueloMapper::entityToDto)  // Usamos el mapper inyectado
            .collect(Collectors.toList());

        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Lista de vuelos obtenida")
                .objectResponse(vueloDTOs)
                .build()
        );
    }
    
    @Override
    public ResponseEntity<ResponseDTO> buscarVuelos(final VueloDTO vueloDTO) {
        List<VueloEntity> vuelos;

        // Usamos las especificaciones combinadas según los valores de VueloDTO
        Specification<VueloEntity> spec = Specification.where(
            VueloSpecifications.conOrigen(vueloDTO.getOrigen())
        ).and(VueloSpecifications.conDestino(vueloDTO.getDestino()))
         .and(VueloSpecifications.conFechaSalida(vueloDTO.getFechaSalida()));

        vuelos = vueloRepository.findAll(spec);

        List<VueloDTO> vueloDTOs = vuelos.stream()
            .map(VueloMapper.INSTANCE::entityToDto)
            .collect(Collectors.toList());

        if (vueloDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("No se encontraron vuelos con los criterios proporcionados")
                    .build()
            );
        }

        return ResponseEntity.ok(
            ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Vuelos encontrados")
                .objectResponse(vueloDTOs)
                .build()
        );
    }


    @Override
    public ResponseEntity<ResponseDTO> obtenerVueloPorId(final Integer id) {
        Optional<VueloEntity> vueloOpt = vueloRepository.findById(id);
        if (vueloOpt.isPresent()) {
            VueloDTO vueloDTO = VueloMapper.INSTANCE.entityToDto(vueloOpt.get());
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Vuelo obtenido exitosamente")
                    .objectResponse(vueloDTO)
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Vuelo no encontrado")
                    .build()
            );
        }
    }


	@Override
	public ResponseEntity<ResponseDTO> actualizarVuelo(Integer id, VueloDTO vueloDTO) {
	
		Optional<VueloEntity> vueloOpt = vueloRepository.findById(id);
        if (vueloOpt.isPresent()) {
            VueloEntity vueloToUpdate = VueloMapper.INSTANCE.dtoToEntity(vueloDTO);
            vueloToUpdate.setId(id); 
            VueloEntity updatedVuelo = vueloRepository.save(vueloToUpdate);
            VueloDTO updatedVueloDTO = VueloMapper.INSTANCE.entityToDto(updatedVuelo);
            
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Vuelo actualizado exitosamente")
                    .objectResponse(updatedVueloDTO)
                    .build()
            );
        } else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseDTO.builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message("Vuelo no encontrado para Actualizar")
                        .build()
                );
        }
        
	}

	@Override
	public ResponseEntity<ResponseDTO> eliminarVuelo(Integer id) {
		Optional<VueloEntity> vueloOpt = vueloRepository.findById(id);
        if (vueloOpt.isPresent()) {
        	vueloRepository.deleteById(id);
            return ResponseEntity.ok(
                ResponseDTO.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Vuelo eliminado exitosamente")
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Vuelo no encontrado para eliminar")
                    .build()
            );
        }
	}

}
