import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> coinInformation = new TreeMap<>();
        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoinCounter = 0;
            while (targetSum >= coins[i]){
                targetSum -= coins[i];
                currentCoinCounter++;
                coinInformation.put(coins[i], currentCoinCounter);
                if(targetSum == 0){
                    break;
                }
            }
            if(targetSum == 0){
                break;
            }
        }

        return coinInformation;
    }
}