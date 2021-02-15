package com.example.productapi.payment;

public interface PaymentGateway {

    public String processPayment(String txnId, Double amount);

    public boolean validateTransaction(String transactionId);

}
