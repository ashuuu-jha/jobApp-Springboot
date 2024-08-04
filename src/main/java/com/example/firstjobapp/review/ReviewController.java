package com.example.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyid}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.getAllReviews(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){

        boolean isReviewSaved =  reviewService.addReview(companyId,review);
        if(isReviewSaved) {
            return new ResponseEntity<String>("Review added successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Review not saved",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
           return new ResponseEntity<>(reviewService.getReview(companyId,reviewId) , HttpStatus.OK);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId , @PathVariable Long reviewId , @RequestBody Review review){
        boolean isReviewUpdated =  reviewService.addReview(companyId,review);
        if(isReviewUpdated) {
            return new ResponseEntity<String>("Review updated successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Review not updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId , @PathVariable Long reviewId){
        boolean isReviewDeleted =  reviewService.deleteReview(companyId,reviewId);
        if(isReviewDeleted) {
            return new ResponseEntity<String>("Review deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Review not deleted",HttpStatus.NOT_FOUND);
        }
    }

}
