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
        if (accountNumberValidation(accountNumber)) {
            this.accountNumber = accountNumber;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    //custom methods
    private boolean accountNumberValidation(String accountNumber) {
        //Form validation -> regex for XXX/XXXXXXX/XX where X is a number 0 - 9
        if (!accountNumber.matches("\\d{3}-\\d{7}-\\d{2}")) {
            throw new IllegalArgumentException("Incomplete account number");
        }

        //Splitting up & converting String accountNumber
        long firstTenDigits = Long.parseLong((accountNumber.substring(0, 3) + accountNumber.substring(4, 11)));
        int lastTwoDigits = Integer.parseInt(accountNumber.substring(12));

        //Mathematical validation
        if ((firstTenDigits % 97) != lastTwoDigits) {
            throw new IllegalArgumentException("Incorrect account number");
        }

        return (firstTenDigits % 97) == lastTwoDigits;
    }
}
