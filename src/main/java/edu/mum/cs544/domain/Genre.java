package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private Long id;
	private String type;
	private String description;
	@ManyToMany(mappedBy="genres")
	List<Movie> movies = new ArrayList<>();
	
	public Genre(){}
	
	public Genre(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public void addMovie(Movie movie){
		movie.getGenres().add(this);
		movies.add(movie);
	}
	public void removeMovie(Movie movie){
		movie.getGenres().remove(this);
		movies.remove(movie);
	}
	
}
