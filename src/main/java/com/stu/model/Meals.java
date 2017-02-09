package com.stu.model;

import org.springframework.stereotype.Component;

/**
 * Created by huser
 * On 17/2/8.
 */
@Component
public class Meals {
    private String owner;
    private String balance;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Meals{" +
                "owner='" + owner + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
