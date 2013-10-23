package com.king.tdd.sessions.third;

import com.king.tdd.sessions.third.adapter.BankPaymentAdapter;
import com.king.tdd.sessions.third.adapter.BankPaymentAdapterA;
import org.junit.Before;
import org.junit.Test;
import se.mockachino.annotations.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PaymentSystemProviderTest {

    private PaymentSystemProvider paymentSystemProvider;


    @Mock
    private BankPaymentAdapter adapter;

    @Before
    public void setUp() {
        Map<String, BankPaymentAdapter> adapters = new HashMap<String, BankPaymentAdapter>();
        adapters.put("VISA", new BankPaymentAdapterA());
        paymentSystemProvider = new PaymentSystemProviderImpl(adapters);
    }

    @Test
    public void paymentBankAFailsIfNoTypeIsSet() {
        PaymentRequest request = new PaymentRequest();
        PaymentResult result = paymentSystemProvider.processPayment(request);
        assertTrue(result.getSuccess() == 0);
    }

    @Test
    public void paymentBankAOkf() {
        PaymentRequest request = new PaymentRequest();
        request.setCcType("VISA");
        PaymentResult result = paymentSystemProvider.processPayment(request);
        assertTrue(result.getSuccess() == 1);
    }


}
