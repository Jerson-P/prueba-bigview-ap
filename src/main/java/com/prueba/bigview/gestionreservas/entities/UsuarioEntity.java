package com.prueba.bigview.gestionreservas.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un usuario.
 * 
 * Esta entidad contiene información sobre el usuario, incluyendo su nombre, 
 * identificación y datos de contacto.
 * 
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuario", schema = "dbo")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
    private PersonaEntity persona;

    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;

    @Basic(optional = true)
    @Column(name = "activo")
    private Boolean activo; 
    
    @Basic(optional = true)
    @Column(name = "fecha_creacion", updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    @Basic(optional = true)
    @Column(name = "fecha_modificacion")
    @LastModifiedDate
    private Date fechaModificacion;
}
