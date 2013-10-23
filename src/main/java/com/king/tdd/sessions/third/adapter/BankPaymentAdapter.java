package com.king.tdd.sessions.third.adapter;

import com.king.tdd.sessions.third.PaymentRequest;
import com.king.tdd.sessions.third.PaymentResult;

public interface BankPaymentAdapter {

    PaymentResult processPayment(PaymentRequest paymentRequest);

}
