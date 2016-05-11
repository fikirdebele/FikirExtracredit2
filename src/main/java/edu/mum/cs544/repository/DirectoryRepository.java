package edu.mum.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Director;

@Repository
public interface DirectoryRepository extends JpaRepository<Director, Long> {

	Director findByFirstnameAndLastname(String firstname, String lastname);

}
