package com.example.reviewms.reviews;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> fetchAllReviewsByCompany(Long companyId) {
		List<Review> allReviewsByCompany = reviewRepository.findByCompanyId(companyId);
		return allReviewsByCompany;
	}

	@Override
	public boolean addReview(Review review) {
		if(review != null){
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review getReviewById(Long reviewId) {
		Optional<Review> review = reviewRepository.findById(reviewId);
		if (review.isPresent()) {
			return review.get();
		}
		return null;
	}

	@Override
	public boolean updateReviewById(Long reviewId, Review review) {
		Optional<Review> reviewToUpdate = reviewRepository.findById(reviewId);
		if (reviewToUpdate.isPresent()) {
			review.setId(reviewToUpdate.get().getId());
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteReviewById(Long reviewId) {
		Optional<Review> reviewToDelete = reviewRepository.findById(reviewId);
		if (reviewToDelete.isPresent()) {
				reviewRepository.deleteById(reviewId);
				return true;
		}
		return false;
	}

}
