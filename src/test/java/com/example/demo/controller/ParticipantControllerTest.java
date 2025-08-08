package com.example.demo.controller;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Participant;
import com.example.demo.service.ParticipantService;

class ParticipantControllerTest {
    @Mock
    private ParticipantService participantService;

    @InjectMocks
    private ParticipantController participantController;

    public ParticipantControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllParticipants() {
        when(participantService.getAllParticipants()).thenReturn(Arrays.asList(new Participant()));
        assertFalse(participantController.getAllParticipants().isEmpty());
    }

    @Test
    void testGetParticipantFound() {
        Participant p = new Participant();
        when(participantService.getParticipant(1L)).thenReturn(Optional.of(p));
        ResponseEntity<Participant> response = participantController.getParticipant(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(p, response.getBody());
    }

    @Test
    void testGetParticipantNotFound() {
        when(participantService.getParticipant(1L)).thenReturn(Optional.empty());
        ResponseEntity<Participant> response = participantController.getParticipant(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateParticipant() {
        Participant p = new Participant();
        when(participantService.saveParticipant(p)).thenReturn(p);
        assertEquals(p, participantController.createParticipant(p));
    }

    @Test
    void testUpdateParticipantFound() {
        Participant p = new Participant();
        when(participantService.getParticipant(1L)).thenReturn(Optional.of(p));
        when(participantService.saveParticipant(p)).thenReturn(p);
        ResponseEntity<Participant> response = participantController.updateParticipant(1L, p);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdateParticipantNotFound() {
        Participant p = new Participant();
        when(participantService.getParticipant(1L)).thenReturn(Optional.empty());
        ResponseEntity<Participant> response = participantController.updateParticipant(1L, p);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testDeleteParticipant() {
        doNothing().when(participantService).deleteParticipant(1L);
        ResponseEntity<Void> response = participantController.deleteParticipant(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
