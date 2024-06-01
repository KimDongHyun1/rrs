package com.dong.review.api.request;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewRequest {
    private Long restaurantId;
    private String content;
    private Double score;
}
