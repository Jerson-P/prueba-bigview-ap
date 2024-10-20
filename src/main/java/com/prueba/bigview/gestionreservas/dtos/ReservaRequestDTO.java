package com.prueba.bigview.gestionreservas.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un DTO de una ReservaRequest.
 * 
 * Este DTO se utiliza para transferir información sobre la persona
 * entre la capa de servicio y la capa de presentación.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaRequestDTO {
	    
    private Integer id;
    private Integer idVuelo;  
    private Integer idPersona;  
    private Date fechaReserva;
    private String estado;
}
