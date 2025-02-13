package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerON() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerON();
    }

    @AfterAll
    public static void testPowerOFF() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOFF();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0, calculator.getResult(), DELTA, "Reset failed");
    }

    @ParameterizedTest(name = "Testing square root of {0}")
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    public void testSquareRoot(int number) {
        double expectedResult = Math.sqrt(number);
        calculator.squareRoot(number);
        assertEquals(expectedResult, calculator.getResult(), DELTA, "Square root failed");
    }

    @Test
    //@DisplayName("Test negative square root")
    public void testSquareRootNegative() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.squareRoot(0));
        assertEquals("Cannot square root of negative or zero", exception.getMessage());
    }
}
