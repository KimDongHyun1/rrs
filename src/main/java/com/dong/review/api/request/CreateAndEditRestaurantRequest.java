package com.dong.review.api.request;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAndEditRestaurantRequest {
    private String name;
    private String address;
    private List<CreateAndEditRestaurantRequestMenu> menus;

    @Override
    public String toString() {
        String strMenus = "";

        for (CreateAndEditRestaurantRequestMenu menu : menus) {
            strMenus += "menuName:" + menu.getName() + ", menuPrice:" + menu.getPrice() + "\n";
        }

        return "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menus=" + strMenus +
                '}';
    }

}
