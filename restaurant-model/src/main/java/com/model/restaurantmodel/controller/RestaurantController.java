package com.model.restaurantmodel.controller;

import com.model.restaurantmodel.model.Restaurant;
import com.model.restaurantmodel.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("all")
    public List<Restaurant> getAllRestaurants() {
       return restaurantService.getAllRestaurants();
    }

    @GetMapping("res/{id}")
    public Restaurant getRestaurantById(@PathVariable Integer id)
    {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping("addMany")
    public String addRestaurants(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.addRestaurants(restaurants);
    }

    @PostMapping("addOne")
    public String addRestaurant(@RequestBody Restaurant restaurant) {
         return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("update/{id}")
    public String updateRestaurant(@PathVariable Integer id , @RequestBody Restaurant restaurant)
    {
        return restaurantService.updateRestaurant(id , restaurant);
    }

    @DeleteMapping("delete/{id}")
    public String deleteRestaurant(@PathVariable Integer id)
    {
        return restaurantService.deleteRestaurant(id);
    }
}