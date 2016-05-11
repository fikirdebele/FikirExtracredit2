package edu.mum.cs544.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.mum.cs544.domain.Director;
import edu.mum.cs544.service.DirectorService;

public class StringToDirector implements Converter<String, Director> {
	
	@Autowired
	private DirectorService directorService;
	
	@Override
	public Director convert(String name) {
		String[] tokens = name.split(" ");
		return directorService.findByFirstnameAndLastname(tokens[0], tokens[1]);
	}

	public DirectorService getDirectorService() {
		return directorService;
	}

	public void setDirectorService(DirectorService directorService) {
		this.directorService = directorService;
	}
	
}
