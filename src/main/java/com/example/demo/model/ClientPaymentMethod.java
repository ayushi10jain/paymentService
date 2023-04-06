package com.example.demo.model;

import java.util.Set;
import com.example.demo.constants.PaymentMethod;
import lombok.Builder;


@Builder
public class ClientPaymentMethod {
   String clientId;
   Set<PaymentMethod> paymentMethodSet;

}
