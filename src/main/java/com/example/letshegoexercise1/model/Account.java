package com.example.letshegoexercise1.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private Integer accountId;
    private String userType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private List<Basket> basket;
    private LocalDate joinDate;

    public Account() {
    }
public Account(Integer accountId, LocalDate date, String userType){
        this.accountId = accountId;
        this.joinDate = date;
        this.userType = userType;
}
    public Integer getAccountId() {
        return this.accountId;
    }

    public String getUserType() {
        return this.userType;
    }

    public List<Basket> basket() {
        return this.basket;
    }

    public LocalDate getJoinDate() {
        return this.joinDate;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }


    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$accountId = this.getAccountId();
        final Object other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !this$accountId.equals(other$accountId)) return false;
        final Object this$userType = this.getUserType();
        final Object other$userType = other.getUserType();
        if (this$userType == null ? other$userType != null : !this$userType.equals(other$userType)) return false;

        final Object this$joinDate = this.getJoinDate();
        final Object other$joinDate = other.getJoinDate();
        if (this$joinDate == null ? other$joinDate != null : !this$joinDate.equals(other$joinDate)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Account;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $accountId = this.getAccountId();
        result = result * PRIME + ($accountId == null ? 43 : $accountId.hashCode());
        final Object $userType = this.getUserType();
        result = result * PRIME + ($userType == null ? 43 : $userType.hashCode());
        final Object $joinDate = this.getJoinDate();
        result = result * PRIME + ($joinDate == null ? 43 : $joinDate.hashCode());
        return result;
    }


}
