package com.prueba.bigview.gestionreservas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prueba.bigview.gestionreservas.dtos.VueloDTO;
import com.prueba.bigview.gestionreservas.entities.VueloEntity;

@Mapper(componentModel = "spring")
public interface VueloMapper {
    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);
    
    VueloDTO entityToDto(VueloEntity vueloEntity);
    
    VueloEntity dtoToEntity(VueloDTO vueloDTO);
}
