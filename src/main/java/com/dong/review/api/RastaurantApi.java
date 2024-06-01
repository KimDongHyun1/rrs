package com.dong.review.api;

import com.dong.review.api.request.CreateAndEditRestaurantRequest;
import com.dong.review.api.response.RestaurantDetailView;
import com.dong.review.api.response.RestaurantView;
import com.dong.review.service.RestaurantService;
import com.dong.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RastaurantApi {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        return restaurantService.getRestaurantDetail(restaurantId);
    }

    @PostMapping("/restaurant")
    public String createRestaurant(@RequestBody CreateAndEditRestaurantRequest req) {
        restaurantService.createRestaurant(req);
        return "createRestaurant" + req.toString();
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(@PathVariable("restaurantId") Long restaurantId, @RequestBody CreateAndEditRestaurantRequest req) throws Exception {
        restaurantService.editRestaurant(restaurantId, req);
        return "editRestaurant" + restaurantId + "," + req.toString();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return "deleteRestaurant : " + restaurantId;
    }

}
