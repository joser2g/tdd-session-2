package com.king.tdd.sessions.third;

public class PaymentRequest {

    private String applicationId;

    private String orderId;

    private String ccType;

    private String ccBeholder;

    private String ccNumber;

    private int ccExpiryMonth;

    private int ccExpiryYear;

    private int ccCvv;

    private String chargeAmount;

    private String chargeCurrency;

    private String securityKey;

    private String ipnEndpoint;

    private String apiVersion;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
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

    public int getCcExpiryYear() {
        return ccExpiryYear;
    }

    public void setCcExpiryYear(int ccExpiryYear) {
        this.ccExpiryYear = ccExpiryYear;
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

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getIpnEndpoint() {
        return ipnEndpoint;
    }

    public void setIpnEndpoint(String ipnEndpoint) {
        this.ipnEndpoint = ipnEndpoint;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
