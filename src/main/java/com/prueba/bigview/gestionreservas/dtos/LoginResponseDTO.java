package com.prueba.bigview.gestionreservas.dtos;

import lombok.Data;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un DTO de un LoginResponse.
 * 
 * Este DTO se utiliza para transferir información sobre la persona
 * entre la capa de servicio y la capa de presentación.
 * 
 */

@Data
public class LoginResponseDTO {
	
	private String idUsuario;
	
	private String correo;
	
	private String token;
}
