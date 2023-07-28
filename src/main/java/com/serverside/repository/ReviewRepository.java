package com.serverside.repository;

import com.serverside.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
//    Optional<Review> findByName(String review);

}

