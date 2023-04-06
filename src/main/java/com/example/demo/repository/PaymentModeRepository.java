package com.example.demo.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.example.demo.constants.PaymentMode;
import com.example.demo.constants.PaymentMethod;
import com.example.demo.model.PaymentModeDistribution;


public class PaymentModeRepository {

    public void getPaymentModes(){
        HashMap<PaymentMethod, Set<PaymentModeDistribution>>  paymentModeMap = new HashMap<>();

        Set<PaymentModeDistribution> paymentModeSet = new HashSet();
        PaymentModeDistribution paymentModeDistribution =
                new PaymentModeDistribution(PaymentMode.AXIS, 30);
        paymentModeSet.add(paymentModeDistribution);
        paymentModeSet.add(new PaymentModeDistribution(PaymentMode.ICICI, 70));

        Set<PaymentModeDistribution> paymentModeSet2 = new HashSet();
        paymentModeSet2.add(new PaymentModeDistribution(PaymentMode.ICICI, 100));
        paymentModeMap.put(PaymentMethod.NET_BANKING, paymentModeSet2);
    }
}
