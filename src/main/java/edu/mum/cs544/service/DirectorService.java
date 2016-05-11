package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.domain.Director;
import edu.mum.cs544.repository.DirectoryRepository;

@Service
public class DirectorService {

	@Autowired
	private DirectoryRepository directoryRepository;
	public Long saveDirector(Director director){
		return directoryRepository.save(director).getId();
	}
	public List<Director> findAll() {
		return directoryRepository.findAll();
	}
	public Director findByFirstnameAndLastname(String firstname, String lastname) {
		return directoryRepository.findByFirstnameAndLastname(firstname, lastname);
	}
}
