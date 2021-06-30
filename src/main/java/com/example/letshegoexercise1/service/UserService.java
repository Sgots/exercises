package com.example.letshegoexercise1.service;

import com.example.letshegoexercise1.model.Account;
import com.example.letshegoexercise1.model.Basket;
import com.example.letshegoexercise1.repository.BasketRepository;
import com.example.letshegoexercise1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BasketRepository basketRepository;
    Double net = null;
    public Basket basket(Basket basket) {
        System.out.println(basket);
     // Basket basketExists = basketRepository.findBasketByID(basket.getID());
       Account userExists = userRepository.findAccountByAccountId(basket.getAccount().getAccountId());
       System.out.println(userExists);
     /*   if (basketExists == null) {
            throw new BadRequestException(basket.getID()+ " does not exists.");
        }*/
        if(userExists.getUserType().equals("Employee") && basket.getIncludeGrocery()==false) {
             net = basket.getBill() * 0.3;
        }
     else if(userExists.getUserType().equals("Affiliate") && basket.getIncludeGrocery()==false) {
            net = basket.getBill() * 0.1;
        }
      else if(userExists.getUserType().equals("Customer") && basket.getIncludeGrocery()==false) {
            LocalDate today = LocalDate.now();

            Period p = Period.between(userExists.getJoinDate(), today);
            if (p.getYears() > 2) {
                net = basket.getBill() * 0.5;
            }
        }
          else if(basket.getBill() >= 100){
             net = basket.getBill() % 100 * 0.05;
          }
          else{
              net = basket.getBill();
        }
          basket.setAccount(userExists);
          basket.setNet_payable(net);
          return basket;
        }



}
