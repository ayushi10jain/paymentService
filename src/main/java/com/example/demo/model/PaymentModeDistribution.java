package com.example.demo.model;

import com.example.demo.constants.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class PaymentModeDistribution {
    PaymentMode paymentMode;
    Integer distributionPercenatge;


}
