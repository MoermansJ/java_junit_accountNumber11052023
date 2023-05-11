package be.intecbrussel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    //properties
    private Account account;


    //testing methods
    //Account(String accountNumber) <---- CONSTRUCTOR
    @Test
    void shouldReturnEqualsWhenCreatingAccountWithCorrectAccountNumber() {
        //given
        String accountNumber = "123-1234567-84";

        //when
        account = new Account(accountNumber);

        //then
        assertEquals(account.getAccountNumber(), accountNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123-1234567-12", "23-12345678-12", "000-0000001-99"})
    void shouldThrowIllegalArgumentExceptionWhenCreatingAccountWithIncorrectAccountNumber(String incorrectAccountNumber) {
        //when
        Executable executable = () -> new Account(incorrectAccountNumber);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }
}