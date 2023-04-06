package com.example.demo.repository;

import java.util.Map;


public interface TransactionRepository {
    void addTransaction(String paidBy, Map<String,String> txnMap);

    Map<String, String> getTxn(String id);
}
