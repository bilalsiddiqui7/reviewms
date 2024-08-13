package com.example.reviewms.reviews;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@PostMapping
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		boolean isReviewAdded = reviewService.addReview(review);
		if (isReviewAdded)
			return new ResponseEntity<String>("Review added !", HttpStatus.OK);
		return new ResponseEntity<String>("Review not added, conmany does not exist !", HttpStatus.OK);

	}

	@GetMapping()
	public ResponseEntity<List<Review>> getAllReviewsByCompany(@RequestParam Long companyId) {
		List<Review> allReviewsByCompany = reviewService.fetchAllReviewsByCompany(companyId);
		if (allReviewsByCompany != null)
			return new ResponseEntity<List<Review>>(allReviewsByCompany, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
		Review review = reviewService.getReviewById(reviewId);
		if (review != null) {
			return new ResponseEntity<Review>(review, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{reviewId}")
	public ResponseEntity<String> updateReviewById(@PathVariable Long reviewId,
			@RequestBody Review review) {
		boolean isUpdated = reviewService.updateReviewById(reviewId, review);
		if (isUpdated)
			return new ResponseEntity<String>("Review updated !", HttpStatus.OK);
		return new ResponseEntity<String>("Review not updated !", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId) {
		boolean isDeleted = reviewService.deleteReviewById(reviewId);
		if (isDeleted)
			return new ResponseEntity<String>("Review deleted !", HttpStatus.OK);
		return new ResponseEntity<String>("Review not deleted !", HttpStatus.NOT_FOUND);
	}
}
