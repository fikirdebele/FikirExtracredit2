package edu.mum.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.MovieCharacter;

@Repository
public interface CharacterRepository extends JpaRepository<edu.mum.cs544.domain.MovieCharacter, Long> {

	MovieCharacter findByName(String name);


}
