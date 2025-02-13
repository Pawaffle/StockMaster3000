package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/*
 * JUnit 5
 */

public class CalculatorTest { // The class name should end with Test

    // Fixture: all tests use the same calculator,
    // which is reset before each test.
    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    // The test method name can be anything, annotated with @Test
    @Test
    public void testAdd() {
        calculator.add(1);
        calculator.add(2);
        assertEquals(3, calculator.getResult(), DELTA,  "The sum of 1 and 2 is incorrect");
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(2);
        assertEquals(8, calculator.getResult(), DELTA, "The difference between 10 and 2 is incorrect");
    }

    @Test
    @DisplayName("Test division 8 / 2")
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult(), DELTA, "Division 8/2 is incorrect");
    }

    // The correct test result is that division by zero throws an exception,
    // the caller can handle it as desired
    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testMultiply() {
        calculator.add(2);
        calculator.multiply(2);
        assertEquals(4, calculator.getResult(), DELTA, "Multiplication 2*2 is incorrect");
        calculator.multiply(3);
        assertEquals(12, calculator.getResult(), DELTA, "Multiplication 4*3 is incorrect");
    }
}
