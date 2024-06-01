package com.dong.review.api;

import com.dong.review.api.request.CreateReviewRequest;
import com.dong.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(@RequestBody CreateReviewRequest req) {
        reviewService.createReview(req.getRestaurantId(), req.getContent(), req.getScore());
    }

    @DeleteMapping("/review/{restaurantId}")
    public void deleteReview(@PathVariable("restaurantId") Long review) {
        reviewService.deleleteReview(review);
    }
}
