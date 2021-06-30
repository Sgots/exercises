package com.example.letshegoexercise1.controller;

import com.example.letshegoexercise1.model.Basket;
import com.example.letshegoexercise1.repository.BasketRepository;
import com.example.letshegoexercise1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;
@RestController
public class UserController {
    private BasketRepository basketRepository;

    @Autowired
    UserService userService;
    @PostMapping(value = "/bill")
    public ResponseEntity<?> bill(@Valid  @RequestBody Basket basket) {
        Integer id = basket.getAccount().getAccountId();
        System.out.println(id);
      //  basketRepository.save(basket);
      /*  if (basketRepository.findBasketByID(basket.getID())== null) {
            return new ResponseEntity<String>("Bill of id " + basket.getID() + " not found.",
                    HttpStatus.NOT_FOUND);
        }*/
        userService.basket(basket);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "billing", basket));
    }

}
