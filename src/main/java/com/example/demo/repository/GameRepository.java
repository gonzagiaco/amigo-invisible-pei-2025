package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
