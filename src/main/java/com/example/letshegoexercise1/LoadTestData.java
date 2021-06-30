package com.example.letshegoexercise1;

import com.example.letshegoexercise1.model.Account;
import com.example.letshegoexercise1.repository.BasketRepository;
import com.example.letshegoexercise1.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadTestData {

    private final UserRepository repository;
    private final BasketRepository basketRepository;

    public LoadTestData(UserRepository repository, BasketRepository basketRepository) {
        this.repository = repository;
        this.basketRepository = basketRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        loadUsers();
    }

    private void loadUsers() {

        repository.save(loadUser("Employee",
                LocalDate.now()));
        repository.save(loadUser("Customer",
                LocalDate.now()));
        repository.save(loadUser("Affiliate",
                LocalDate.now()));
    }

    private Account loadUser(String type, LocalDate localDate) {
        Account account = new Account();
        account.setUserType(type);
        account.setJoinDate(localDate);

        return account;
    }


}
