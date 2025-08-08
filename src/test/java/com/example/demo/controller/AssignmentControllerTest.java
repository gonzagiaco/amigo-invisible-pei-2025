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

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;

class AssignmentControllerTest {
    @Mock
    private AssignmentService assignmentService;

    @InjectMocks
    private AssignmentController assignmentController;

    public AssignmentControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAssignments() {
        when(assignmentService.getAllAssignments()).thenReturn(Arrays.asList(new Assignment()));
        assertFalse(assignmentController.getAllAssignments().isEmpty());
    }

    @Test
    void testGetAssignmentFound() {
        Assignment a = new Assignment();
        when(assignmentService.getAssignment(1L)).thenReturn(Optional.of(a));
        ResponseEntity<Assignment> response = assignmentController.getAssignment(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(a, response.getBody());
    }

    @Test
    void testGetAssignmentNotFound() {
        when(assignmentService.getAssignment(1L)).thenReturn(Optional.empty());
        ResponseEntity<Assignment> response = assignmentController.getAssignment(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateAssignment() {
        Assignment a = new Assignment();
        when(assignmentService.saveAssignment(a)).thenReturn(a);
        assertEquals(a, assignmentController.createAssignment(a));
    }

    @Test
    void testUpdateAssignmentFound() {
        Assignment a = new Assignment();
        when(assignmentService.getAssignment(1L)).thenReturn(Optional.of(a));
        when(assignmentService.saveAssignment(a)).thenReturn(a);
        ResponseEntity<Assignment> response = assignmentController.updateAssignment(1L, a);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdateAssignmentNotFound() {
        Assignment a = new Assignment();
        when(assignmentService.getAssignment(1L)).thenReturn(Optional.empty());
        ResponseEntity<Assignment> response = assignmentController.updateAssignment(1L, a);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testDeleteAssignment() {
        doNothing().when(assignmentService).deleteAssignment(1L);
        ResponseEntity<Void> response = assignmentController.deleteAssignment(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
