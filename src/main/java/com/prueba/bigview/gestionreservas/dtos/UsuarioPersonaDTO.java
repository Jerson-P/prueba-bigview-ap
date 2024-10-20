package com.prueba.bigview.gestionreservas.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un DTO de un Usuario-Persona.
 * 
 * Este DTO se utiliza para transferir información sobre el los usuarios y personas
 * entre la capa de servicio y la capa de presentación.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPersonaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Atributos de Persona
    
    private String nombre;
    
    private String apellido;
    
    private String correo;
    
    private String telefono;
    
    private Boolean estado;
    
    // Atributos de Usuario
    private String contrasena;
    
    private Boolean activo;
    

}
