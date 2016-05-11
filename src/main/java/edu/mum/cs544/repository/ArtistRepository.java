package edu.mum.cs544.repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
