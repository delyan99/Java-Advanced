import java.util.*;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize = array[0];
        int secondSetSize = array[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            int elementFirstSet = Integer.parseInt(scanner.nextLine());
            firstSet.add(elementFirstSet);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int elementSecondSet = Integer.parseInt(scanner.nextLine());
            secondSet.add(elementSecondSet);
        }

        for (int i = 0; i < firstSet.size(); i++) {
            int firstSetElementElement = firstSet.iterator().next();
            firstSet.remove(firstSetElementElement);
            for (int j = 0; j < secondSet.size(); j++) {
                if (secondSet.contains(firstSetElementElement)) {
                    System.out.print(firstSetElementElement + " ");
                    break;
                }
            }
            i = -1;
        }
    }
}
