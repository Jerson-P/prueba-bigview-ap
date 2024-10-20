package com.prueba.bigview.gestionreservas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prueba.bigview.gestionreservas.dtos.UsuarioDTO;
import com.prueba.bigview.gestionreservas.entities.UsuarioEntity;

@Mapper(uses = PersonaMapper.class)
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    
    UsuarioDTO entityToDto(UsuarioEntity usuarioEntity);
    
    UsuarioEntity dtoToEntity(UsuarioDTO usuarioDTO);
}
