package calculator;

public class Calculator {

    private double result;    // Variable for the result

    public void reset() { result = 0; }

    public double getResult() { return result; }

    public void add(double n) { result += n; }

    public void subtract(double n) { result -= n; }

    public void multiply(double n) { result *= n; }

    public void divide(double n) {
        if (n == 0) throw new ArithmeticException("Cannot divide by zero");
        result /= n;
    }

    public void square(double n) { result = n*n; }

    public void squareRoot(double n) {
        if (n <= 0) throw new ArithmeticException("Cannot square root of negative or zero");
        result = Math.sqrt(n);
    }

    public void powerON() {
        // Initialization steps could be added here
        result = 0;
    }

    public void powerOFF() {
        // Finalization steps could be added here
    }
}
