package com.prueba.bigview.gestionreservas.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.prueba.bigview.gestionreservas.entities.VueloEntity;

public class VueloSpecifications {
	
	public static Specification<VueloEntity> conOrigen(String origen) {
        return (root, query, criteriaBuilder) -> {
            if (origen == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("origen"), origen);
        };
    }

    public static Specification<VueloEntity> conDestino(String destino) {
        return (root, query, criteriaBuilder) -> {
            if (destino == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("destino"), destino);
        };
    }

    public static Specification<VueloEntity> conFechaSalida(Date fechaSalida) {
        return (root, query, criteriaBuilder) -> {
            if (fechaSalida == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("fechaSalida"), fechaSalida);
        };
    }
}
