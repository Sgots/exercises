package com.example.letshegoexercise1.repository;

import com.example.letshegoexercise1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Account, Integer> {
    Account findAccountByAccountId(Integer id);

}
