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

import com.example.demo.entity.Game;
import com.example.demo.service.GameService;

class GameControllerTest {
    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    public GameControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGames() {
        when(gameService.getAllGames()).thenReturn(Arrays.asList(new Game()));
        assertFalse(gameController.getAllGames().isEmpty());
    }

    @Test
    void testGetGameFound() {
        Game g = new Game();
        when(gameService.getGame(1L)).thenReturn(Optional.of(g));
        ResponseEntity<Game> response = gameController.getGame(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(g, response.getBody());
    }

    @Test
    void testGetGameNotFound() {
        when(gameService.getGame(1L)).thenReturn(Optional.empty());
        ResponseEntity<Game> response = gameController.getGame(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateGame() {
        Game g = new Game();
        when(gameService.saveGame(g)).thenReturn(g);
        assertEquals(g, gameController.createGame(g));
    }

    @Test
    void testUpdateGameFound() {
        Game g = new Game();
        when(gameService.getGame(1L)).thenReturn(Optional.of(g));
        when(gameService.saveGame(g)).thenReturn(g);
        ResponseEntity<Game> response = gameController.updateGame(1L, g);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdateGameNotFound() {
        Game g = new Game();
        when(gameService.getGame(1L)).thenReturn(Optional.empty());
        ResponseEntity<Game> response = gameController.updateGame(1L, g);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testDeleteGame() {
        doNothing().when(gameService).deleteGame(1L);
        ResponseEntity<Void> response = gameController.deleteGame(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
