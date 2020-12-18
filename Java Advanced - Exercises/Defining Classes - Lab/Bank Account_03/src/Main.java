import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
        int counter = 1;
        while(!input.equals("End")){

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Create":
                    bankAccounts.put(counter, new BankAccount());
                    System.out.println(String.format("Account ID%d created", counter++));
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if(bankAccounts.containsKey(id)) {
                        BankAccount currentBankAccount = bankAccounts.get(id);
                        currentBankAccount.deposit(amount);
                        System.out.println(String.format("Deposited %d to ID%d", amount, id));
                    }else{
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int idGetInterest = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if(bankAccounts.containsKey(idGetInterest)){
                        BankAccount bankAccount = bankAccounts.get(idGetInterest);
                        System.out.println(String.format("%.2f",bankAccount.getInterest(years)));
                    }else{
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
