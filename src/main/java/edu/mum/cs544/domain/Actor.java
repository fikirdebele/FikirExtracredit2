package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Actor extends Artist {
	private String role;
	@OneToMany(mappedBy="actor")
	private List<MovieCharacter> movieCharacters = new ArrayList<>();

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<MovieCharacter> getCharacters() {
		return movieCharacters;
	}
	public void setCharacters(List<MovieCharacter> movieCharacters) {
		this.movieCharacters = movieCharacters;
	}
	public void addCharacter(MovieCharacter movieCharacter){
		movieCharacter.setActor(this);
		movieCharacters.add(movieCharacter);
	}
	
	public void removeCharacter(MovieCharacter movieCharacter){
		movieCharacter.setActor(null);
		movieCharacters.remove(movieCharacter);
	}

}
