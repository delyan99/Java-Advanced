import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> traners = new LinkedHashMap<>();
        while (!"Tournament".equals(input)) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            traners.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer trainer = traners.get(trainerName);
            trainer.getPokemons().add(pokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            for (Trainer trainer : traners.values()) {
                List<Pokemon> pokemonList = trainer.getPokemons();
                boolean flag = false;
                for (Pokemon pokemon : pokemonList) {
                    if (pokemon.getElement().equals(input)) {
                        trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    if (trainer.getPokemons() != null) {
                        List<Pokemon> trainerPokemons = trainer.getPokemons();
                        if (trainerPokemons.size() > 0) {
                            for (int i = 0; i < trainerPokemons.size(); i++) {
                                trainerPokemons.get(i).setHealth(trainerPokemons.get(i).getHealth() - 10);
                                if(trainerPokemons.get(i).getHealth() <= 0){
                                    trainerPokemons.remove(trainerPokemons.get(i));
                                    i--;
                                }
                                if(trainerPokemons.size() == 0){
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        traners.entrySet()
                .stream()
                .sorted((l, r) -> Integer.compare(r.getValue().getNumberOfBadges(), l.getValue().getNumberOfBadges()))
                .forEach(p -> System.out.println(p.getValue().getName() + " " + p.getValue().getNumberOfBadges() + " " + p.getValue().getPokemons().size()));

    }
}
