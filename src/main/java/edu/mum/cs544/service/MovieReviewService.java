package edu.mum.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.domain.MovieReview;
import edu.mum.cs544.repository.MovieReviewRepository;

@Service
public class MovieReviewService {
	@Autowired
	private MovieReviewRepository movieReviewRepository;
	
	public Long save(MovieReview movieReview){
		return movieReviewRepository.save(movieReview).getId();
	}
}
