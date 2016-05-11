package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private int year;
	@OneToMany(mappedBy="movie")
	private List<MovieCharacter> movieCharacters = new ArrayList<>();
	@ManyToMany
	@JoinTable(name="Movie_Director", joinColumns=@JoinColumn(name="movieId"), 
			inverseJoinColumns=@JoinColumn(referencedColumnName="id"))
	private List<Director> directors = new ArrayList<>();
	@ManyToMany
	@JoinTable(name="MOVIE_GENRE",
				joinColumns=@JoinColumn(name="movieId"),
				inverseJoinColumns=@JoinColumn(referencedColumnName="id"))
	private Set<Genre> genres = new HashSet<>();
	private double rating;
	@OneToMany(mappedBy="movie", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<MovieReview> movieReviews = new ArrayList<>();
	@Transient
	private MultipartFile poster;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String name) {
		this.title = name;
	}
	public List<MovieCharacter> getMovieCharacters() {
		return movieCharacters;
	}
	public void setMovieCharacters(List<MovieCharacter> movieCharacters) {
		this.movieCharacters = movieCharacters;
	}
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	public Set<Genre> getGenres() {
		return genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<MovieReview> getMovieReviews() {
		return movieReviews;
	}
	public void setMovieReviews(List<MovieReview> movieReviews) {
		this.movieReviews = movieReviews;
	}
	public void addCharacter(MovieCharacter movieCharacter){
		movieCharacter.setMovie(this);
		movieCharacters.add(movieCharacter);
	}
	public void removeCharacter(MovieCharacter movieCharacter){
		movieCharacter.setMovie(null);
		movieCharacters.remove(movieCharacter);
	}
	public void addDirector(Director director){
		director.getMovies().add(this);
		directors.add(director);
	}
	public void removeDirector(Director director){
		director.getMovies().remove(this);
		directors.remove(director);
	}
	public void addGenre(Genre genre){
		genre.getMovies().add(this);
		genres.add(genre);
	}
	public void removeGenre(Genre genre){
		genre.getMovies().remove(this);
		genres.remove(genre);
	}
	public void addMovieReview(MovieReview movieReview){
		movieReview.setMovie(this);
		this.movieReviews.add(movieReview);
	}
	public void removeMovieReview(MovieReview movieReview){
		movieReview.setMovie(null);
		this.movieReviews.remove(movieReview);
	}
	public MultipartFile getPoster() {
		return poster;
	}
	public void setPoster(MultipartFile poster) {
		this.poster = poster;
	}
	
}
