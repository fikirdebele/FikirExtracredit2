package edu.mum.cs544.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.mum.cs544.domain.MovieCharacter;
import edu.mum.cs544.service.CharacterService;

public class StringToCharacter implements Converter<String, MovieCharacter> {

	@Autowired
	private CharacterService characterService;
	
	
	@Override
	public MovieCharacter convert(String name) {
		return characterService.findByName(name);
	}

}
