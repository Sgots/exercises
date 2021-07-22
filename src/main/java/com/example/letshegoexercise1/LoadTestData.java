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

        repository.save(loadUser(1,"Employee",
                LocalDate.now()));
        repository.save(loadUser(2,"Customer",
                LocalDate.now()));
        repository.save(loadUser(3,"Affiliate",
                LocalDate.now()));
    }

    private Account loadUser(Integer userid, String type, LocalDate localDate) {
        Account account = new Account();
        account.setAccountId(userid);
        account.setUserType(type);
        account.setJoinDate(localDate);

        return account;
    }


}
