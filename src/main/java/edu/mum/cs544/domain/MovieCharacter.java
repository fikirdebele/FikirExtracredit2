package edu.mum.cs544.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieCharacter {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	@ManyToOne
	@JoinColumn(name="ActorId")
	private Actor actor;
	@ManyToOne
	@JoinColumn(name="MovieId")
	private Movie movie;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
		actor.getCharacters().add(this);
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@Override
	public String toString() {
		return this.getName();
	}
	
}
