package com.prueba.bigview.gestionreservas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prueba.bigview.gestionreservas.dtos.ReservaDTO;
import com.prueba.bigview.gestionreservas.entities.ReservaEntity;

@Mapper(uses = { VueloMapper.class, PersonaMapper.class })
public interface ReservaMapper {
    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);
    
    ReservaDTO entityToDto(ReservaEntity reservaEntity);
    
    ReservaEntity dtoToEntity(ReservaDTO reservaDTO);
}
