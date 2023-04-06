package com.example.demo.model;

import java.util.Map;
import java.util.Set;
import com.example.demo.constants.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class ClientpaymentModeDistribution {

    String clientId;
    Map<PaymentMethod, Set<PaymentModeDistribution>> paymentModeDistribution;

}
