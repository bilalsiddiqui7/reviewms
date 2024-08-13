package com.example.reviewms.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByCompanyId(long companyId);
}
