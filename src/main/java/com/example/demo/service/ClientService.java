package com.example.demo.service;

import java.util.Set;
import com.example.demo.constants.PaymentMethod;
import com.example.demo.model.Client;
import com.example.demo.model.AddClientResponse;
import com.example.demo.model.ClientPaymentMethod;
import com.example.demo.model.ClientpaymentModeDistribution;


public interface ClientService {
    AddClientResponse addClient(Client client);
    AddClientResponse removeClient(String clientId);

    AddClientResponse hasClient(String clientId);

    ClientPaymentMethod getAllPaymentMethodsSupportedByClient(String clientId);

     ClientPaymentMethod removePaymentMethodsFromClient(String clientId, Set<PaymentMethod> paymentMethods);

    ClientpaymentModeDistribution getRoutingDistribution(String clientId);

    }
