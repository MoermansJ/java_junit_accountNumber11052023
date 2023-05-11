package be.intecbrussel;

import java.math.BigInteger;

public class Account {
    //properties
    private String accountNumber;


    //constructors
    public Account(String accountNumber) {
        setAccountNumber(accountNumber);
    }


    //setters & getters
    private void setAccountNumber(String accountNumber) {
        if (accountNumberFormValidation(accountNumber)) {
            this.accountNumber = accountNumber;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    //custom methods
    private boolean accountNumberFormValidation(String accountNumber) {
        if (!accountNumber.matches("\\d{3}/\\d{7}/\\d{2}")) {
            throw new IllegalArgumentException("Incorrect account number");
        }

        long firstTenDigits = Long.parseLong((accountNumber.substring(0, 3) + accountNumber.substring(4, 11)));
        int lastTwoDigits = Integer.parseInt(accountNumber.substring(12));

        return ((firstTenDigits % 97) == lastTwoDigits);
    }
}
