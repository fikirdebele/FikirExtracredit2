package edu.mum.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	public Genre findByType(String type);

}
