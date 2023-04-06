package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.example.demo.constants.PaymentMethod;
import com.example.demo.model.MakePaymentRequest;


public class ClientToPaymentModeRepository {
    Map<String, Set<PaymentMethod>> clientTopaymentMethods = new HashMap();


    public Set<PaymentMethod> addpaymentmethodsToClient(String clientId, Set<PaymentMethod> paymentMethodSet){
        clientTopaymentMethods.put(clientId, paymentMethodSet);
        return clientTopaymentMethods.get(clientId);
    }
    public Set<PaymentMethod> removePaymentMethodsFromClient(String id, Set<PaymentMethod> paymentMethodSet){
        Set<PaymentMethod> paymentMethods = getPaymenytMethods(id);
        paymentMethods.remove(paymentMethodSet);
        return getPaymenytMethods(id);
    }

    public void removeClient(String id){
        clientTopaymentMethods.remove(id);
    }

    public Set<PaymentMethod> getPaymenytMethods(final String clientId) {
        return clientTopaymentMethods.get(clientId);
    }
}
