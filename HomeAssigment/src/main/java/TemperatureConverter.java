import static java.lang.Math.round;

public class TemperatureConverter {

    public double fahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit - 32) * 5/9);
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public boolean isExtremeTemperature(double temperature) {
        return temperature > 50 || temperature < -40;
    }
}
