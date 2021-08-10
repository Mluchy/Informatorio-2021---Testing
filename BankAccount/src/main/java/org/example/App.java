package org.example;

/**
 * Bank Account!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        BankAccount ba = new BankAccount("Mr. Bryan Walton", 11.99);

        ba.Credit(5.77);
        ba.Debit(11.99);

        System.out.printf("Current balance is: $%.2f", ba.getBalance());
    }
}
