package com.telran;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Application {

    public static void main(String[] args) {
	// write your code here
        Account account1 = new Account("123asd", 12132l, true);
        Account account2 = new Account("2f3asd", 567l, false);
        Account account3 = new Account("3f3asd", 0l, false);
        Account account4 = new Account("124asd", 53215l, true);
        Account account5 = new Account("2f56sd", 124563l, true);
        Account account6 = new Account("346asd", 345346l, false);
        Account account7 = new Account("7656sd", 0l, true);
        Account account8 = new Account("3454sd", 346l, false);

        List<Account> accounts = new ArrayList<>(Arrays.asList(account1,account2,account3,account4,account5,account6,account7,account8));

        Predicate<Account> balanceMoreZero = account -> account.getBalance()>0;
        Predicate<Account> balanceMoreZeroNoLock =account -> account.isLocked!=true&& account.getBalance()>0;

        System.out.println(AccFilter.filter(accounts,balanceMoreZero));
        System.out.println(AccFilter.filter(accounts,balanceMoreZeroNoLock));
    }
}
