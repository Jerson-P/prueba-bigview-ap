package com.prueba.bigview.gestionreservas.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un DTO de una persona.
 * 
 * Este DTO se utiliza para transferir información sobre la persona
 * entre la capa de servicio y la capa de presentación.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private String telefono;
	
	private Boolean estado;
	
}
