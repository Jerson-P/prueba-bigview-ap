package com.prueba.bigview.gestionreservas.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;
import java.util.Optional;

import com.prueba.bigview.gestionreservas.dtos.ReservaRequestDTO;
import com.prueba.bigview.gestionreservas.entities.PersonaEntity;
import com.prueba.bigview.gestionreservas.entities.VueloEntity;
import com.prueba.bigview.gestionreservas.repositories.PersonaRepository;
import com.prueba.bigview.gestionreservas.repositories.VueloRepository;
import com.prueba.bigview.gestionreservas.serviceImpl.ReservaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservaServiceImpl reservaService;

    @MockBean
    private VueloRepository vueloRepository;

    @MockBean
    private PersonaRepository personaRepository;

    @InjectMocks
    private ReservaController reservaController;

    private ReservaRequestDTO reservaRequestDTO;
    private VueloEntity vueloEntity;
    private PersonaEntity personaEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        reservaRequestDTO = new ReservaRequestDTO();
        reservaRequestDTO.setIdVuelo(1);
        reservaRequestDTO.setIdPersona(1);
        reservaRequestDTO.setFechaReserva(new Date());
        reservaRequestDTO.setEstado("pendiente");

        vueloEntity = new VueloEntity();
        vueloEntity.setId(1);
        vueloEntity.setOrigen("Bogotá");
        vueloEntity.setDestino("Medellín");

        personaEntity = new PersonaEntity();
        personaEntity.setId(1);

        when(vueloRepository.findById(1)).thenReturn(Optional.of(vueloEntity));
        when(personaRepository.findById(1)).thenReturn(Optional.of(personaEntity));
    }

    @Test
    public void testGuardarReserva() throws Exception {
        when(reservaService.guardarReserva(any(ReservaRequestDTO.class)))
                .thenReturn(ResponseEntity.ok().build());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(reservaRequestDTO)))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
