
package com.serverside.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serverside.model.Review;
import com.serverside.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review getById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review dengan id " + id + " tidak ditemukan!!"));
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

//    public Review create(Review review) {
//        Review existingReview = reviewRepository.findByName(review.getComment()).orElse(null);
//        if (existingReview == null && review.getId() == null) {
//            return reviewRepository.save(review);
//        } else {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama review sudah ada!");
//        }
//    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public Review update(Long id, Review review) {
        getById(id);
        review.setId(id);
        return reviewRepository.save(review);
    }

    public Review delete(Long id) {
        Review review = getById(id);
        reviewRepository.delete(review);
        return review;
    }

}

