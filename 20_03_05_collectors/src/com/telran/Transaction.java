package com.telran;

public class Transaction {
    private String uuId;
    private long sum;
    private int accId;

    public Transaction(String uuId, long sum, int accId) {
        this.uuId = uuId;
        this.sum = sum;
        this.accId = accId;
    }

    public String getUuId() {
        return uuId;
    }

    public long getSum() {
        return sum;
    }

    public int getAccId() {
        return accId;
    }
}
