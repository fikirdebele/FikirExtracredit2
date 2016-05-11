package edu.mum.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.MovieReview;
@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

}
