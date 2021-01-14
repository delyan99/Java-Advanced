import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] reservationInfo = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(reservationInfo[0]);
        int numberOfDays = Integer.parseInt(reservationInfo[1]);
        Season season = Season.valueOf(reservationInfo[2]);
        DiscountType discountType = DiscountType.valueOf(reservationInfo[3]);
        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
        System.out.printf("%.2f", priceCalculator.getTotalPrice(pricePerDay, numberOfDays, season, discountType));

    }
}
