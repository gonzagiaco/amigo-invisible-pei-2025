package com.example.demo.service;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Participant;
import com.example.demo.repository.ParticipantRepository;

class ParticipantServiceTest {
    @Mock
    private ParticipantRepository participantRepository;

    @InjectMocks
    private ParticipantService participantService;

    public ParticipantServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllParticipants() {
        when(participantRepository.findAll()).thenReturn(Arrays.asList(new Participant()));
        assertFalse(participantService.getAllParticipants().isEmpty());
    }

    @Test
    void testGetParticipantFound() {
        Participant p = new Participant();
        when(participantRepository.findById(1L)).thenReturn(Optional.of(p));
        assertTrue(participantService.getParticipant(1L).isPresent());
    }

    @Test
    void testGetParticipantNotFound() {
        when(participantRepository.findById(1L)).thenReturn(Optional.empty());
        assertFalse(participantService.getParticipant(1L).isPresent());
    }

    @Test
    void testSaveParticipant() {
        Participant p = new Participant();
        when(participantRepository.save(p)).thenReturn(p);
        assertEquals(p, participantService.saveParticipant(p));
    }

    @Test
    void testDeleteParticipant() {
        doNothing().when(participantRepository).deleteById(1L);
        participantService.deleteParticipant(1L);
        verify(participantRepository, times(1)).deleteById(1L);
    }
}
