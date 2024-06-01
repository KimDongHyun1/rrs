package com.dong.review.service;

import com.dong.review.api.response.RestaurantDetailView;
import com.dong.review.api.response.RestaurantView;
import com.dong.review.model.MenuEntity;
import com.dong.review.model.RestaurantEntity;
import com.dong.review.repository.MenuRepository;
import com.dong.review.repository.RestaurantRepository;
import com.dong.review.api.request.CreateAndEditRestaurantRequest;
import com.dong.review.api.request.CreateAndEditRestaurantRequestMenu;
import com.dong.review.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void createRestaurant(CreateAndEditRestaurantRequest req) {
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .name(req.getName())
                .address(req.getAddress())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        restaurantRepository.save(restaurant);

        for (CreateAndEditRestaurantRequestMenu menu : req.getMenus()) {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        }

    }

    @Transactional
    public void editRestaurant(Long restaurantId, CreateAndEditRestaurantRequest req) {
        RestaurantEntity restaurantEntity =
                restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는 레스토랑입니다."));

        restaurantEntity.changeNameAndAddress(req.getName(), req.getAddress());

        restaurantRepository.save(restaurantEntity);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

        for (CreateAndEditRestaurantRequestMenu menu : req.getMenus()) {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurantEntity.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        }
    }

    @Transactional
    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);

        menuRepository.deleteAll(menus);

        reviewRepository.deleteById(restaurantId);

    }

    public List<RestaurantView> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();

        return restaurants.stream()
                .map(restaurant -> RestaurantView.builder()
                    .id(restaurant.getId())
                    .name(restaurant.getName())
                    .address(restaurant.getAddress())
                    .createdAt(restaurant.getCreatedAt())
                    .updatedAt(restaurant.getUpdatedAt())
                    .build()
                )
                .toList();
    }

    public RestaurantDetailView getRestaurantDetail(Long restaurantId) {
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();

        List<RestaurantDetailView.Menu> list = menuRepository.findAllByRestaurantId(restaurantId).stream()
                .map(menu -> RestaurantDetailView.Menu.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .createdAt(menu.getCreatedAt())
                        .updatedAt(menu.getUpdatedAt())
                        .build())
                .toList();

        return RestaurantDetailView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdAt(restaurant.getCreatedAt())
                .updatedAt(restaurant.getUpdatedAt())
                .menus(list)
                .build();
    }
}
