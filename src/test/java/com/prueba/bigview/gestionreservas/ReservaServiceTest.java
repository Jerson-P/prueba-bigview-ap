package com.prueba.bigview.gestionreservas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import com.prueba.bigview.gestionreservas.dtos.ReservaRequestDTO;
import com.prueba.bigview.gestionreservas.entities.ReservaEntity;
import com.prueba.bigview.gestionreservas.entities.VueloEntity;
import com.prueba.bigview.gestionreservas.entities.PersonaEntity;
import com.prueba.bigview.gestionreservas.repositories.ReservaRepository;
import com.prueba.bigview.gestionreservas.repositories.VueloRepository;
import com.prueba.bigview.gestionreservas.repositories.PersonaRepository;
import com.prueba.bigview.gestionreservas.serviceImpl.ReservaServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private VueloRepository vueloRepository;

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    private ReservaRequestDTO reservaRequest;

    @BeforeEach
    void setUp() {
        reservaRequest = new ReservaRequestDTO();
        reservaRequest.setIdVuelo(1);
        reservaRequest.setIdPersona(1);
        reservaRequest.setFechaReserva(new Date());
        reservaRequest.setEstado("pendiente");
    }

    @Test
    void testGuardarReserva() {
        VueloEntity vueloEntity = new VueloEntity(); 
        PersonaEntity personaEntity = new PersonaEntity(); 
        ReservaEntity reservaEntity = new ReservaEntity();

        when(vueloRepository.findById(reservaRequest.getIdVuelo())).thenReturn(Optional.of(vueloEntity));
        when(personaRepository.findById(reservaRequest.getIdPersona())).thenReturn(Optional.of(personaEntity));
        when(reservaRepository.save(any(ReservaEntity.class))).thenReturn(reservaEntity);

        ResponseEntity<?> response = reservaService.guardarReserva(reservaRequest);

        assertEquals(200, response.getStatusCodeValue());
        verify(reservaRepository, times(1)).save(any(ReservaEntity.class));
    }
}