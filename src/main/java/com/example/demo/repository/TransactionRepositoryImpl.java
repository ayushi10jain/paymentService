package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;


public class TransactionRepositoryImpl implements TransactionRepository{
    Map<String,Map<String, String>> userTxnMap = new HashMap<>();
    @Override public void addTransaction(final String paidBy, final Map<String, String> txnMap) {
        userTxnMap.put(paidBy,txnMap);
    }

    @Override public Map<String, String> getTxn(final String id) {
        return userTxnMap.get(id);
    }
}
