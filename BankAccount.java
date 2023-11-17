public class BankAccount {

    private static int numberOfAccounts = 0;
    private static double totalBalance = 0;

    private String accountHolder;
    private double balance;
    private double initialBalance;
    public BankAccount(String accountHolder,double balance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;

        numberOfAccounts--;
        totalBalance = initialBalance;
    }

    public static int  getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static double getTotalBalance() {
        return totalBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        totalBalance += amount;
        System.out.println("Deposit: $" + amount + " | New Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            totalBalance += amount;  
            System.out.println("Withdrawal: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", 1000.0);
        BankAccount account2 = new BankAccount("Jane Doe", 500.0);

        System.out.println("Number of Accounts: " + BankAccount.getNumberOfAccounts());
        System.out.println("Total Balance: $" + BankAccount.getTotalBalance());

        account1.deposit(200.0);
        account2.withdraw(1000.0);  

        System.out.println("\nNumber of Accounts: " + BankAccount.getNumberOfAccounts());
        System.out.println("Total Balance: $" + BankAccount.getTotalBalance());
    }
}