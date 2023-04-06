package com.example.demo.model;

import java.util.Set;
import com.example.demo.constants.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class Client {
    String Id;
    com.example.demo.constants.Client name;
    String key;
    Set<PaymentMethod> paymentMethodSet;
}
