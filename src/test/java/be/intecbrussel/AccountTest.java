package be.intecbrussel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    //properties
    private Account account;


    //testing methods
    //Account(String accountNumber) <---- CONSTRUCTOR
    @Test
    void shouldReturnEqualsWhenCreatingAccountWithCorrectAccountNumber() {
        //given
        String accountNumber = "123/1234567/84";

        //when
        account = new Account(accountNumber);

        //then
        assertEquals(account.getAccountNumber(), accountNumber);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenCreatingAccountWithIncorrectAccountNumber() {
        //given
        String accountNumber = "23/1234567/12";

        //when
        Executable executable = () -> new Account(accountNumber);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }

}