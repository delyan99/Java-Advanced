import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                set.add(input[j]);
            }
        }
        for (int i = 0; i < set.size(); i++) {
            System.out.print(set.iterator().next() + " ");
            set.remove(set.iterator().next());
            i = -1;
        }
    }
}
