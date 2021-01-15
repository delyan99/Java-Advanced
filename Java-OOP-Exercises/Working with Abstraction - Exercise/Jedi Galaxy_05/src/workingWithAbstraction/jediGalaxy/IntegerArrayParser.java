package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;

public class IntegerArrayParser {
    public static int[] parseToIntArray(String input){
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
