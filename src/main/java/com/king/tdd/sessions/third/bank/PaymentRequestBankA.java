package com.king.tdd.sessions.third.bank;

public class PaymentRequestBankA {

    private String merchantId;

    private String merchantTransactionId;

    private String ccBeholder;

    private String ccNumber;

    private int ccExpiryMonth;

    private int getCcExpiryYear;

    private int ccCvv;

    private String chargeAmount;

    private String chargeCurrency;

    private String hash;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public String getCcBeholder() {
        return ccBeholder;
    }

    public void setCcBeholder(String ccBeholder) {
        this.ccBeholder = ccBeholder;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public int getCcExpiryMonth() {
        return ccExpiryMonth;
    }

    public void setCcExpiryMonth(int ccExpiryMonth) {
        this.ccExpiryMonth = ccExpiryMonth;
    }

    public int getGetCcExpiryYear() {
        return getCcExpiryYear;
    }

    public void setGetCcExpiryYear(int getCcExpiryYear) {
        this.getCcExpiryYear = getCcExpiryYear;
    }

    public int getCcCvv() {
        return ccCvv;
    }

    public void setCcCvv(int ccCvv) {
        this.ccCvv = ccCvv;
    }

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getChargeCurrency() {
        return chargeCurrency;
    }

    public void setChargeCurrency(String chargeCurrency) {
        this.chargeCurrency = chargeCurrency;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
