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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa una reserva de vuelo.
 * 
 * Esta entidad contiene información sobre la reserva, incluyendo detalles del vuelo, 
 * datos del cliente y el estado de la reserva.   
 *     
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reserva", schema = "dbo")
public class ReservaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_vuelo", referencedColumnName = "id")
    @ManyToOne
    private VueloEntity vuelo;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private PersonaEntity persona;

    @Basic(optional = false)
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;

    @Basic(optional = true)
    @Column(name = "estado")
    private String estado;
    
    @Basic(optional = true)
    @Column(name = "fecha_creacion", updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    @Basic(optional = true)
    @Column(name = "fecha_modificacion")
    @LastModifiedDate
    private Date fechaModificacion;
}
