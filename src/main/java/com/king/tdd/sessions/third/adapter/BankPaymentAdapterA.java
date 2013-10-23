package com.king.tdd.sessions.third.adapter;

import com.king.tdd.sessions.third.PaymentRequest;
import com.king.tdd.sessions.third.PaymentResult;

public class BankPaymentAdapterA implements BankPaymentAdapter {
    @Override
    public PaymentResult processPayment(PaymentRequest paymentRequest) {
        PaymentResult toRet = new PaymentResult();
        toRet.setSuccess(1);
        return toRet;
    }

}
