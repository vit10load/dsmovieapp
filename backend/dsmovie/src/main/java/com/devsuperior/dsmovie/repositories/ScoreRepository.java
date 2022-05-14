package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}
