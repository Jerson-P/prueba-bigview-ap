package com.prueba.bigview.gestionreservas.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un DTO de un vuelo.
 * 
 * Este DTO se utiliza para transferir información sobre el vuelo
 * entre la capa de servicio y la capa de presentación.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VueloDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String origen;
	
	private String destino;
	
	private Date fechaSalida;
	
	private Date fechaLlegada;
	
	private BigDecimal precio;
	
	private Integer disponibilidad;
	
}
