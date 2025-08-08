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

import com.example.demo.entity.Assignment;
import com.example.demo.repository.AssignmentRepository;

class AssignmentServiceTest {
    @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private AssignmentService assignmentService;

    public AssignmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAssignments() {
        when(assignmentRepository.findAll()).thenReturn(Arrays.asList(new Assignment()));
        assertFalse(assignmentService.getAllAssignments().isEmpty());
    }

    @Test
    void testGetAssignmentFound() {
        Assignment a = new Assignment();
        when(assignmentRepository.findById(1L)).thenReturn(Optional.of(a));
        assertTrue(assignmentService.getAssignment(1L).isPresent());
    }

    @Test
    void testGetAssignmentNotFound() {
        when(assignmentRepository.findById(1L)).thenReturn(Optional.empty());
        assertFalse(assignmentService.getAssignment(1L).isPresent());
    }

    @Test
    void testSaveAssignment() {
        Assignment a = new Assignment();
        when(assignmentRepository.save(a)).thenReturn(a);
        assertEquals(a, assignmentService.saveAssignment(a));
    }

    @Test
    void testDeleteAssignment() {
        doNothing().when(assignmentRepository).deleteById(1L);
        assignmentService.deleteAssignment(1L);
        verify(assignmentRepository, times(1)).deleteById(1L);
    }
}
