import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    static TemperatureConverter convert;

    @BeforeEach
    void setUp() {
        convert = new TemperatureConverter();
    }

    @Test
    void fahrenheitToCelsius() {
        //Arrange
        double input_zero = 0;
        double input_positive = 4.2;
        double input_negative = -4.2;

        double expected_result_zero = -17.8;
        double expected_result_positive = -15.44;
        double expected_result_negative = -20.11;

        //Act
        double output_zero = convert.fahrenheitToCelsius(input_zero);
        double output_positive = convert.fahrenheitToCelsius(input_positive);
        double output_negative = convert.fahrenheitToCelsius(input_negative);

        //Assert
        assertEquals(expected_result_zero, output_zero, 0.1);
        assertEquals(expected_result_positive, output_positive, 0.1);
        assertEquals(expected_result_negative, output_negative, 0.1);

    }

    @Test
    void celsiusToFahrenheit() {
        // Arrange
        double input_zero = 0;
        double input_positive = 10;
        double input_negative = -10;

        double expected_result_zero = 32;
        double expected_result_positive = 50;
        double expected_result_negative = 14;

        // Act
        double output_zero = convert.celsiusToFahrenheit(input_zero);
        double output_positive = convert.celsiusToFahrenheit(input_positive);
        double output_negative = convert.celsiusToFahrenheit(input_negative);

        // Assert
        assertEquals(expected_result_zero, output_zero, 0.1);
        assertEquals(expected_result_positive, output_positive, 0.1);
        assertEquals(expected_result_negative, output_negative, 0.1);
    }

    @Test
    void isExtremeTemperature() {
        // Test extreme high temperature
        assertTrue(convert.isExtremeTemperature(60));

        // Test extreme low temperature
        assertTrue(convert.isExtremeTemperature(-50));

        // Test non-extreme temperature (within normal range)
        assertFalse(convert.isExtremeTemperature(25));
        assertFalse(convert.isExtremeTemperature(-30));
    }
}
