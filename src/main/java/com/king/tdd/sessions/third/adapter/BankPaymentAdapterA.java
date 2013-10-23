package com.king.tdd.sessions.third.adapter;

import com.king.tdd.sessions.third.PaymentRequest;
import com.king.tdd.sessions.third.PaymentResult;
import com.king.tdd.sessions.third.bank.BankA;
import com.king.tdd.sessions.third.utils.DateTimeProvider;
import com.king.tdd.sessions.third.utils.UUIDGenerator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BankPaymentAdapterA implements BankPaymentAdapter {

    private BankA bank;

    private String merchantId;

    private UUIDGenerator uuidGenerator;

    private DateTimeProvider dateTimeProvider;


    @Override
    public PaymentResult processPayment(PaymentRequest paymentRequest) {

        try {
            String bankARequest = generateBankARequestFromPaymentRequest(paymentRequest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            //TODO build error reply
        }

        PaymentResult toRet = new PaymentResult();
        toRet.setSuccess(1);
        return toRet;
    }

    private String generateBankARequestFromPaymentRequest(PaymentRequest paymentRequest) throws NoSuchAlgorithmException {
        final String merchantTransactionId = generateMerchantTransactionId();
        return "<xml>\n" +
                "<merchant_id>" + merchantId + "</merchant_id>\n" +
                "<merchant_transaction_id>" + merchantTransactionId + "</merchant_transaction_id>\n" +   //check
                "<cc_beholder>" + paymentRequest.getCcBeholder() + "</cc_beholder>\n" +
                "<cc_number>" + paymentRequest.getCcNumber() + "</cc_number>\n" +
                "<cc_expiry_month>" + paymentRequest.getCcExpiryMonth() + "</cc_expiry_month>\n" +
                "<cc_expiry_year>" + paymentRequest.getCcExpiryYear() + "</cc_expiry_year>\n" +
                "<cc_cvv>" + paymentRequest.getCcCvv() + "</cc_cvv>\n" +
                "<charge_amount>" + paymentRequest.getChargeAmount() + "</charge_amount>\n" +
                "<charge_currency>" + paymentRequest.getChargeCurrency() + "</charge_currency>\n" +
                "<hash>" + generateHash(merchantId, merchantTransactionId, paymentRequest.getCcBeholder()) + "</hash>\n" +
                "</xml>";
    }

    private String generateMerchantTransactionId() {
        return uuidGenerator.generateUUID();
    }

    private String generateHash(final String merchantId, final String merchantTranscationId, final String ccBeholder) throws NoSuchAlgorithmException {
//        hash : sha1 of the next concatenated values : merchant_id+merchant_transaction_id+cc_beholder+datetime (example 2013-10-30_12:59:59)
        final String valueToEncrypt = merchantId + merchantTranscationId + ccBeholder + dateTimeProvider.getTime().toString();
        MessageDigest cript = null;
        cript = MessageDigest.getInstance("SHA-1");
        cript.reset();
        cript.update(valueToEncrypt.getBytes());
        return new BigInteger(1, cript.digest()).toString(16);

    }

    public BankA getBank() {
        return bank;
    }

    public void setBank(BankA bank) {
        this.bank = bank;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public UUIDGenerator getUuidGenerator() {
        return uuidGenerator;
    }

    public void setUuidGenerator(UUIDGenerator uuidGenerator) {
        this.uuidGenerator = uuidGenerator;
    }

    public DateTimeProvider getDateTimeProvider() {
        return dateTimeProvider;
    }

    public void setDateTimeProvider(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }
}
