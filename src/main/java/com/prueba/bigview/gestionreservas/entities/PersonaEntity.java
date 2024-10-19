package com.prueba.bigview.gestionreservas.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa una persona.
 * 
 * Esta entidad contiene información sobre una persona, incluyendo su nombre, apellido,
 * correo y datos de contacto.
 *     
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "persona", schema = "dbo")
public class PersonaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
	
	@Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
	
	@Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;

	@Basic(optional = false)
	@Column(name = "correo")
	@Email
	private String correo;
    
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    
    @Basic(optional = true)
    @Column(name = "estado")
    private Boolean estado; 
    
    @Basic(optional = true)
    @Column(name = "fecha_creacion", updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    @Basic(optional = true)
    @Column(name = "fecha_modificacion")
    @LastModifiedDate
    private Date fechaModificacion;
	
}
