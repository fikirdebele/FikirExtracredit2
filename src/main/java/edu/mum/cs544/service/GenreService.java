package edu.mum.cs544.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.domain.Genre;
import edu.mum.cs544.repository.GenreRepository;

@Service
@Transactional
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	public Long saveGenre(Genre genre){
		genreRepository.save(genre);
		return genre.getId();
	}
	
	public Genre findByGenreType(String type){
		return genreRepository.findByType(type);
	}
	
	public Genre findByGenreId(Long id){
		return genreRepository.findOne(id);
	}
	
	public void deleteGenre(Long id){
		genreRepository.delete(id);
	}

	public GenreRepository getGenreRepository() {
		return genreRepository;
	}

	public void setGenreRepository(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}
	
	
}
