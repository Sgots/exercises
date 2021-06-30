package com.example.letshegoexercise1.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "basket_id", nullable = false)
    private Integer ID;
    private Boolean includeGrocery;
    private Double bill;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    private Double net_payable;
    public  Basket(){
        net_payable = 0.0;
        account = new Account();
     //   account.setID(account.getID());
    }
    public Basket(Integer id,Double bill,Boolean includeGrocery, Account account){
        this.account= account;
        this.bill = bill;
        this.includeGrocery = includeGrocery;
    }
}
