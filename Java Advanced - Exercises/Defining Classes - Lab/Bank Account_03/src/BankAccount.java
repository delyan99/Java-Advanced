public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCounter = 1;
    private int id;
    private double balance;


    BankAccount(){
        this.id = bankAccountCounter++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
}
