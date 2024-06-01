package com.dong.review.api.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAndEditRestaurantRequestMenu {
    private String name;
    private Integer price;
}
