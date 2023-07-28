/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside.controller;

import com.serverside.model.Review;
import com.serverside.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/review")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAll(){
        return new ResponseEntity(reviewService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(@PathVariable Long id){
        return new ResponseEntity(reviewService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return new ResponseEntity(reviewService.create(review),HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Review> Update(@PathVariable Long id,@RequestBody Review review){
        return new ResponseEntity(reviewService.update(id,review), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Review> Delete(@PathVariable Long id){
        return new ResponseEntity(reviewService.delete(id), HttpStatus.OK);
    }
}