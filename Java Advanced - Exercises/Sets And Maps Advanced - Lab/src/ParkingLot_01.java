import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> set = new LinkedHashSet<>();
        while(!"END".equals(input)){
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];
            switch(command){
                case "IN":
                    set.add(carNumber);
                    break;
                case "OUT":
                    set.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        for (String number : set) {
            System.out.println(number);
        }
        if(set.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
    }
}
