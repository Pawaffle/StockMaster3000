public class Account {
    double balance;

    public Account() {
        balance = 0;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new invalidTransaction("Amount cannot be negative");
        } else {
            balance += amount;
        }
    }

    public double withdraw(double amount) {
        if (amount < 0) {
            throw new invalidTransaction("Amount cannot be negative");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed: Amount exceeds balance");
            return 0.0;
        } else {
            balance -= amount;
            return amount;
        }
    }

    public double getBalance() {
        return balance;
    }

}

