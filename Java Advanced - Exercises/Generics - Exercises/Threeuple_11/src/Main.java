import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstInput = scanner.nextLine().split("\\s+");
        String firstAndLastName = firstInput[0] + " " + firstInput[1];
        String address = firstInput[2];
        String town = firstInput[3];
        Threeuple<String, String, String> firstTuple = new Threeuple<>(firstAndLastName, address, town);
        System.out.println(firstTuple);

        String[] secondInput = scanner.nextLine().split("\\s+");
        String name = secondInput[0];
        int litersOfBeer = Integer.parseInt(secondInput[1]);
        String drunkOrNot = secondInput[2];
        boolean isDrunk = false;
        if(drunkOrNot.equals("drunk")){
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> secondTuple = new Threeuple<>(name, litersOfBeer, isDrunk);
        System.out.println(secondTuple);

        String[] thirdInput = scanner.nextLine().split("\\s+");
        String nameFromThirdInput = thirdInput[0];
        double doubleInput = Double.parseDouble(thirdInput[1]);
        String bankName = thirdInput[2];
        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(nameFromThirdInput, doubleInput, bankName);
        System.out.println(thirdTuple);

    }
}
