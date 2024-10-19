package com.prueba.bigview.gestionreservas.dtos;

import java.io.Serializable;

import com.prueba.bigview.gestionreservas.entities.PersonaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un DTO de usuario.
 * 
 * Este DTO se utiliza para transferir información sobre el usuario
 * entre la capa de servicio y la capa de presentación.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private PersonaDTO persona;
	private String contrasena;
	private Boolean activo;

}
