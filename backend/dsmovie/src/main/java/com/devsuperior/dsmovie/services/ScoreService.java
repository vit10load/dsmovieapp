package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entity.Movie;
import com.devsuperior.dsmovie.entity.Score;
import com.devsuperior.dsmovie.entity.User;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class ScoreService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		scoreRepository.saveAndFlush(score);
		
		double sum = 0;
		
		for(Score scoreObj: movie.getScores()) {
			sum += scoreObj.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(String.valueOf(avg));
		movie.setCount(movie.getScores().size());
		
		
		return new MovieDTO(movieRepository.save(movie));
		
	}
	
	
}
