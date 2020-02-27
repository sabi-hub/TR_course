package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccFilter{

    public static List<Account> filter (List<Account> accounts, Predicate<Account> predicate){
        return accounts.stream()
                .filter( predicate )
                .collect(Collectors.toList());
    }
}
