package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entity.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		
		Page<Movie> movies = movieRepository.findAll(pageable);
		
		Page<MovieDTO> moviDTOPage = movies.map(movie -> new MovieDTO(movie));
		
		return moviDTOPage;
		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO buscarPorId(Long id){
		
		Movie movie = movieRepository.findById(id).get();
		
		MovieDTO movieDTO = new MovieDTO(movie);
		
		return movieDTO;
		
	}
	
}
