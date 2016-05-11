package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Director extends Artist{

	@ManyToMany(mappedBy="directors")
	private List<Movie> movies = new ArrayList<>();
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public void addMovie(Movie movie){
		movie.getDirectors().add(this);
		movies.add(movie);
	}
	public void removeMovie(Movie movie){
		movie.getDirectors().remove(this);
		movies.remove(movie);
	}
	
	@Override
	public String toString() {
		return this.getFirstname() + " " + getLastname();
	}
}
