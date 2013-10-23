package com.king.tdd.sessions.third;

import com.king.tdd.sessions.third.adapter.BankPaymentAdapter;

import java.util.Map;

public class PaymentSystemProviderImpl implements PaymentSystemProvider {

    private Map<String, BankPaymentAdapter> adapters;

    public PaymentSystemProviderImpl(Map<String, BankPaymentAdapter> adapters) {
        this.adapters = adapters;
    }

    @Override
    public PaymentResult processPayment(PaymentRequest paymentRequest) {
        BankPaymentAdapter adapter = adapters.get(paymentRequest.getCcType());
        PaymentResult toRet;
        if (adapter == null) {
            toRet = new PaymentResult();
            toRet.setSuccess(0);
            toRet.setErrorMessage("adapter doesn't exist");
        } else {
            toRet = adapter.processPayment(paymentRequest);
        }
        return toRet;
    }
}
