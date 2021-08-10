package org.example;

import microsoft.exchange.webservices.data.core.exception.misc.ArgumentOutOfRangeException;

public class BankAccount {

    private String m_customerName;
    private double m_balance;

    public BankAccount() {
    }

    public BankAccount(String m_customerName, double m_balance) {
        this.m_customerName = m_customerName;
        this.m_balance = m_balance;
    }

    public String getCustomerName() {
        return m_customerName;
    }

    public double getBalance() {
        return m_balance;
    }

    public void Debit(double amount) throws Exception {
        if(amount > this.m_balance) throw new ArgumentOutOfRangeException("Debit amount exceeds balance");
        if(amount < 0) throw new ArgumentOutOfRangeException("Debit amount is less than zero");
        this.m_balance -= amount;
    }

    public void Credit(double amount) throws Exception {
        if (amount < 0) throw new ArgumentOutOfRangeException("amount");
        this.m_balance += amount;
    }

}
