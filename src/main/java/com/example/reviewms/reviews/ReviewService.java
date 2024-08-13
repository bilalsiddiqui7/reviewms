package com.example.reviewms.reviews;

import java.util.List;

public interface ReviewService {

	List<Review> fetchAllReviewsByCompany(Long companyId);

	boolean addReview(Review review);

	Review getReviewById(Long reviewId);

	boolean updateReviewById(Long reviewId, Review review);

	boolean deleteReviewById(Long reviewId);

}
