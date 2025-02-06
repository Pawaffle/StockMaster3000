import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void initialBalance() {
        assertEquals(0, account.getBalance());
    }

    @Test
    void depositAndGetBalance() {
        //Arrange
        double input_zero = 0;
        double input_positive = 4.2;
        double input_negative = -4.2;

        double expected_result_zero = 0;
        double expected_result_positive = 4.2;
        double expected_result_negative = 4.2;

        //Assert & Act
        account.deposit(input_zero);
        assertEquals(expected_result_zero, account.getBalance());

        account.deposit(input_positive);
        assertEquals(expected_result_positive, account.getBalance());

        assertThrows(
                invalidTransaction.class,
                () -> account.deposit(input_negative)
        );
        assertEquals(expected_result_negative, account.getBalance());
    }


    @Test
    void withdraw() {
        // Arrange
        double input_zero = 0;
        double input_positive = 4.2;
        double input_negative = -4.2;
        double exceed_the_balance = 1000;

        double expected_result_zero =0;
        double expected_result_positive = 4.2;

        // Act

        account.deposit(42);
        double output_zero = account.withdraw(input_zero);
        double output_positive = account.withdraw(input_positive);
        double output_exceed = account.withdraw(exceed_the_balance);

        // Assert

        assertEquals(expected_result_zero, output_exceed);
        assertEquals(expected_result_zero, output_zero, 0.01);
        assertEquals(expected_result_positive, output_positive, 0.01);

        assertThrows(
                invalidTransaction.class,
                () -> account.withdraw(input_negative)
        );

    }
}