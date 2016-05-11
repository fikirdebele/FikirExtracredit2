package edu.mum.cs544.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.domain.Director;
import edu.mum.cs544.domain.MovieCharacter;
import edu.mum.cs544.repository.CharacterRepository;

@Service
@Transactional
public class CharacterService {
	@Autowired
	private CharacterRepository characterRepository;
	
	public Long saveCharactere(edu.mum.cs544.domain.MovieCharacter movieCharacter){
		characterRepository.save(movieCharacter);
		return movieCharacter.getId();
		
	}
	public List<MovieCharacter> findAll() {
		return characterRepository.findAll();
	}
	public MovieCharacter findByName(String name) {
		return characterRepository.findByName(name);
		 
	}
}
