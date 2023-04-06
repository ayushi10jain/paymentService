package com.example.demo.model;

import java.util.List;
import com.example.demo.constants.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Builder
@Getter
public class MakePaymentRequest {
 String payoutId;
 Instrument instrumentDetails;
 Amount amount;

}
