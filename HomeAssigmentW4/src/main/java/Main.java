import calculator.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.powerON();
        System.out.println("...Power on...");

        calculator.add(500);
        System.out.println("Add 500    = " + calculator.getResult());

        calculator.add(200);
        System.out.println("Add 200    = " + calculator.getResult());

        calculator.subtract(100);
        System.out.println("Subtract 100  = " + calculator.getResult());

        calculator.divide(2);
        System.out.println("Divide by 2    = " + calculator.getResult());

        calculator.multiply(10);
        System.out.println("Multiply by 10 = " + calculator.getResult());

        System.out.println("...Resetting...");
        calculator.reset();

        calculator.add(500);
        System.out.println("Add 500    = " + calculator.getResult());

        calculator.powerOFF();
        System.out.println("...Power off...");
    }
}
