package org.example;

import microsoft.exchange.webservices.data.core.exception.misc.ArgumentOutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    public void Debit_WithValidAmount_UpdatesBalance() throws Exception {

        // Arrange
        double beginningBalance = 11.99;
        double debitAmount = 4.55;
        double expected = 7.44;
        BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);
        // Act
        account.Debit(debitAmount);
        // Assert
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.001);

    }

    @Test
    public void Debit_WithNegativeAmount() throws Exception {

        // Arrange
        double beginningBalance = 11.99;
        final double debitAmount = -4.55;
        final BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

        // Act
        Exception exception = assertThrows(ArgumentOutOfRangeException.class, () -> account.Debit(debitAmount));

        // Assert
        assertEquals("Debit amount is less than zero", exception.getMessage());
    }

    @Test
    public void Debit_WithExceededAmount() throws Exception {

        // Arrange
        double beginningBalance = 11.99;
        final double debitAmount = 18.55;
        final BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

        // Act
        Exception exception = assertThrows(ArgumentOutOfRangeException.class, () -> account.Debit(debitAmount));

        // Assert
        assertEquals("Debit amount exceeds balance", exception.getMessage());
    }

    @Test
    public void Credit_WithValidAmount() throws Exception {

        // Arrange
        double beginningBalance = 10.99;
        double creditAmount = 16;
        double expected = 26.99;
        BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

        // Act
        account.Credit(creditAmount);

        // Assert
        double actual = account.getBalance();
        assertEquals(expected, actual, 0.001);

    }

    @Test
    public void Credit_WithNegativeAmount() throws Exception {

        // Arrange
        double beginningBalance = 10.99;
        double creditAmount = -16;

        final BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

        // Act
        Exception exception = assertThrows(ArgumentOutOfRangeException.class, () -> account.Credit(creditAmount));

        // Assert
        assertEquals("Credit amount less than zero", exception.getMessage());
    }

}