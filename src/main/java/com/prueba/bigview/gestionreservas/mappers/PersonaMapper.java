package com.prueba.bigview.gestionreservas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prueba.bigview.gestionreservas.dtos.PersonaDTO;
import com.prueba.bigview.gestionreservas.entities.PersonaEntity;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);
    
    PersonaDTO entityToDto(PersonaEntity personaEntity);
    
    PersonaEntity dtoToEntity(PersonaDTO personaDTO);
}
