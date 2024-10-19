package com.prueba.bigview.gestionreservas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 * Clase que representa un vuelo.
 * 
 * Esta entidad contiene información sobre el vuelo, incluyendo el origen, destino, 
 * fecha y la capacidad disponible.
 * 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vuelo", schema = "dbo")
public class VueloEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "origen")
    private String origen;

    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;

    @Basic(optional = false)
    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Basic(optional = false)
    @Column(name = "fecha_llegada")
    private Date fechaLlegada;

    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;

    @Basic(optional = false)
    @Column(name = "disponibilidad")
    private Integer disponibilidad;
    
    @Basic(optional = true)
    @Column(name = "fecha_creacion", updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    @Basic(optional = true)
    @Column(name = "fecha_modificacion")
    @LastModifiedDate
    private Date fechaModificacion;
}