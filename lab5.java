interface BankInterface {
    abstract double getBalance();
    abstract double getInterestRate();
}
class BankA implements BankInterface{
    public double Balance;
    public double getDeposit(double deposit){
        if (Balance == 0){
            Balance = deposit;

        }
        else{
             Balance = Balance + deposit;

        }
        return Balance;
    }
    public double Interest = 7;
    public double getBalance(){
        return Balance;
    }
    public double getInterestRate(){
        double intr=Balance*(Interest/100);
        double total = Balance + intr;
        return total;
    }
}
class BankB implements BankInterface{
    public double Balance;
    public double getDeposit(double deposit){
        if (Balance == 0){
            Balance = deposit;

        }
        else{
             Balance = Balance + deposit;

        }
        return Balance;
    }
    public double Interest = 7.4;
    public double getBalance(){
        return Balance;
    }
    public double getInterestRate(){
        double intr=Balance*(Interest/100);
        double total = Balance + intr;
        return total;
    }
}
class BankC implements BankInterface{
    public double Balance;
    public double getDeposit(double deposit){
        if (Balance == 0){
            Balance = deposit;

        }
        else{
             Balance = Balance + deposit;

        }
        return Balance;
    }
    public double Interest = 7.9;
    public double getBalance(){
        return Balance;
    }
    public double getInterestRate(){
        double intr=Balance*(Interest/100);
        double total = Balance + intr;
        return total;
    }
}
class lab5 {
    public static void main(String[] args) {
        BankA A = new BankA();
        A.getDeposit(10000);
        double balA = A.getBalance();
        System.out.println(balA);
        double balance_after_adding_interestA = A.getInterestRate();
        System.out.println("balance of bankA" + balance_after_adding_interestA);
        BankB B = new BankB();
        B.getDeposit(150000);
        double balB = B.getBalance();
        System.out.println(balB);
        double balance_after_adding_interestB = A.getInterestRate();
        System.out.println("balance of bankB" +balance_after_adding_interestB);
        BankC C = new BankC();
        C.getDeposit(200000);
        double balC = C.getBalance();
        System.out.println(balC);
        double balance_after_adding_interestC = A.getInterestRate();
        System.out.println("balance of bankC" +balance_after_adding_interestC);
    }
    
}
