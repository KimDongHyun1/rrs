package com.dong.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDetailView {
    private Long id;
    private String name;
    private String address;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private List<Menu> menus;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Menu {
        private Long id;
        private String name;
        private Integer price;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
    }

}
