package com.telran;

public class Account {
    String number;
    Long balance;
    Boolean isLocked;

    public Account(String number, Long balance, Boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }
//
//    public Account() {
//        this.number = number;
//        this.balance = balance;
//        this.isLocked = isLocked;
//    }

    public String getNumber() {
        return number;
    }

    public Long getBalance() {
        return balance;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", isLocked=" + isLocked +
                '}';
    }
}
