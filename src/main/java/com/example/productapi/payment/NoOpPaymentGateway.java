package com.example.productapi.payment;

import org.springframework.stereotype.Component;

@Component
public class NoOpPaymentGateway implements PaymentGateway {

    public static final String DUMMY_TXN_ID="0";

    @Override
    public String processPayment(String txnId, Double amount) {

        return DUMMY_TXN_ID;

    }

    @Override
    public boolean validateTransaction(String transactionId) {
        return true;
    }
}
