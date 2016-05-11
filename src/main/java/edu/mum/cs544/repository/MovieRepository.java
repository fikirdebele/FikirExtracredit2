package edu.mum.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

//	@Query("select m from Movie m where m.name = ?1")
	List<Movie> findByTitleLike(String name);

}
