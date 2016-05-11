package edu.mum.cs544.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.domain.Movie;
import edu.mum.cs544.repository.MovieRepository;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Long saveMovie(Movie movie){
		return movieRepository.save(movie).getId();
	}

	public MovieRepository getMovieRepository() {
		return movieRepository;
	}

	public void setMovieRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public Movie findOne(Long id) {
		return movieRepository.findOne(id);
	}

	public List<Movie> findByName(String name) {
		return movieRepository.findByTitleLike(name);
	}
	
	
}
