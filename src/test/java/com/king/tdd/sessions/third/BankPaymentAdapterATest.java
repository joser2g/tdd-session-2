package com.king.tdd.sessions.third;

import com.king.tdd.sessions.third.adapter.BankPaymentAdapterA;
import com.king.tdd.sessions.third.bank.BankA;
import org.junit.Before;
import org.junit.Test;
import se.mockachino.annotations.Mock;

import static se.mockachino.Mockachino.setupMocks;
import static se.mockachino.Mockachino.when;

public class BankPaymentAdapterATest {

    private static final String REQUEST_WRONG_MERCHANT_ID = "<xml>\n" +
            "<merchant_id>NOT_CORRECT</merchant_id>\n" +
            "<merchant_transaction_id>XXX</merchant_transaction_id>\n" +
            "<cc_beholder>JRG</cc_beholder>\n" +
            "<cc_number>123456781234</cc_number>\n" +
            "<cc_expiry_month>10</cc_expiry_month>\n" +
            "<cc_expiry_year>2015</cc_expiry_year>\n" +
            "<cc_cvv>100</cc_cvv>\n" +
            "<charge_amount>100,10</charge_amount>\n" +
            "<charge_currency></charge_currency>\n" +
            "<hash>...</hash>\n" +
            "</xml>";
    private static final String RESPONSE_OK = "<xml>\n <success>1</success>\n" +
            "<entity_transaction_id>XXX</entity_transaction_id>\n" +
            "<error_message>0</error_message>\n" +
            "</xml>";

    private static final String RESPONSE_KO = "<xml>\n <success>0</success>\n" +
            "<entity_transaction_id>XXX</entity_transaction_id>\n" +
            "<error_message>wrong merchant code</error_message>\n" +
            "</xml>";
    public static final String MERCHANT_TRANSACTION_ID = "ASLDKJASDLJ-ASDF-00012";
    public static final String MERCHANT_ID = "MCHNT-304x3";
    public static final String MERCHANT_ID_KO = "MCHNT-314x3";

    private BankPaymentAdapterA adapter;

    @Mock
    private BankA bankA;

    @Before
    public void setUp() {
        setupMocks(this);
        adapter = new BankPaymentAdapterA();
    }

    @Test
    public void requestFailsDueToWrongMerchantId() {
        when(bankA.processXmlRequest(REQUEST_WRONG_MERCHANT_ID)).thenReturn(RESPONSE_KO);
        adapter.setBank(bankA);
        adapter.setMerchantId(MERCHANT_ID_KO);
        //set
        adapter.processPayment(createPaymentRequest());
    }

    private PaymentRequest createPaymentRequest() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setApplicationId("APP_ID_FAKE_001");
        paymentRequest.setOrderId("FFFOOOOFFFOOF-OOFO-0001212233");
        paymentRequest.setCcType("VISA");
        paymentRequest.setCcBeholder("JOHN DOE");
        paymentRequest.setCcNumber("1234567812345678");
        paymentRequest.setCcExpiryMonth(10);
        paymentRequest.setCcExpiryYear(2015);
        paymentRequest.setCcCvv(100);
        paymentRequest.setChargeAmount("100.10");
        paymentRequest.setChargeCurrency("EUR");
        paymentRequest.setSecurityKey("xxxx-111");
        paymentRequest.setApiVersion("1");

        return paymentRequest;
    }


}
