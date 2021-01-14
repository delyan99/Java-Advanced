import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];
        Point bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);
        Point topRightPoint = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] points = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int currentX = points[0];
            int currentY = points[1];
            Point comparePoint = new Point(currentX, currentY);
            System.out.println(rectangle.contains(comparePoint));
        }
    }
}
