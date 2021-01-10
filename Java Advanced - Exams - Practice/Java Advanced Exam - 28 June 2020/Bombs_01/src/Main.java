import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> bombCasing = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int daturaBombs = 40;
        int cherryBombs = 60;
        int smokeDecoyBombs = 120;

        int daturaBombsCounter = 0;
        int cherryBombsCounter = 0;
        int smokeDecoyBombsCounter = 0;
        int minSize = Integer.min(bombEffects.size(), bombCasing.size());
        Collections.reverse(bombCasing);
        boolean isFilled = false;
        for (int i = 0; i < minSize; i++) {
            int bombSum = bombEffects.get(i) + bombCasing.get(i);
            boolean isRemoved = false;
            while (bombSum >= 40) {
                if (bombSum == smokeDecoyBombs) {
                    smokeDecoyBombsCounter++;
                    isRemoved = true;
                    break;
                } else if (bombSum == cherryBombs) {
                    cherryBombsCounter++;
                    isRemoved = true;
                    break;
                } else if (bombSum == daturaBombs) {
                    daturaBombsCounter++;
                    isRemoved = true;
                    break;
                }
                bombSum -= 5;
            }
            if (isRemoved) {
                bombEffects.remove(i);
                bombCasing.remove(i);
                i--;
                minSize--;
                if(daturaBombsCounter >= 3 && cherryBombsCounter >= 3 && smokeDecoyBombsCounter >= 3){
                    isFilled = true;
                    break;
                }
            }
        }

        if(isFilled){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if(bombEffects.isEmpty()){
            System.out.print("empty");
            System.out.println();
        }else{
            for (int i = 0; i < bombEffects.size(); i++) {
                if(bombEffects.size() - 1 == i){
                    System.out.println(bombEffects.get(i));
                }else{
                    System.out.print(bombEffects.get(i) + ", ");
                }
            }
        }
        System.out.print("Bomb Casings: ");
        if(bombCasing.isEmpty()){
            System.out.print("empty");
            System.out.println();
        }else{
            Collections.reverse(bombCasing);
            for (int i = 0; i < bombCasing.size(); i++) {
                if(bombCasing.size() - 1 == i){
                    System.out.println(bombCasing.get(i));
                }else{
                    System.out.print(bombCasing.get(i) + ", ");
                }
            }
        }
        System.out.println("Cherry Bombs: " + cherryBombsCounter);
        System.out.println("Datura Bombs: " + daturaBombsCounter);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombsCounter);
    }
}
