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

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;

class GameServiceTest {
    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    public GameServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGames() {
        when(gameRepository.findAll()).thenReturn(Arrays.asList(new Game()));
        assertFalse(gameService.getAllGames().isEmpty());
    }

    @Test
    void testGetGameFound() {
        Game g = new Game();
        when(gameRepository.findById(1L)).thenReturn(Optional.of(g));
        assertTrue(gameService.getGame(1L).isPresent());
    }

    @Test
    void testGetGameNotFound() {
        when(gameRepository.findById(1L)).thenReturn(Optional.empty());
        assertFalse(gameService.getGame(1L).isPresent());
    }

    @Test
    void testSaveGame() {
        Game g = new Game();
        when(gameRepository.save(g)).thenReturn(g);
        assertEquals(g, gameService.saveGame(g));
    }

    @Test
    void testDeleteGame() {
        doNothing().when(gameRepository).deleteById(1L);
        gameService.deleteGame(1L);
        verify(gameRepository, times(1)).deleteById(1L);
    }
}
