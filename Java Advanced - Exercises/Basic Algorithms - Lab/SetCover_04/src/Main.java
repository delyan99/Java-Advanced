import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> universeSet = new LinkedHashSet<>();
        for (int u : universe) {
            universeSet.add(u);
        }
        while (!universeSet.isEmpty()) {
            int[] chosenSet = sets.get(0);
            int notChosenCounter = 0;
            for (int[] currentSet : sets) {
                int counter = 0;
                for (int set : currentSet) {
                    if (universeSet.contains(set)) {
                        counter++;
                    }
                }

                if (notChosenCounter < counter) {
                    notChosenCounter = counter;
                    chosenSet = currentSet;
                }
            }
            result.add(chosenSet);
            for (int i : chosenSet) {
                universeSet.removeIf(integer -> i == integer);
            }
        }
        return result;
    }
}
