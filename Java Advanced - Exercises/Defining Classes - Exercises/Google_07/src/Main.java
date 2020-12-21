import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
        String input = scanner.nextLine();
        while(!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            Person person = new Person();
            String name = tokens[0];
            String command = tokens[1];
            switch (command){
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    if(people.containsKey(name)){
                        Person p = people.get(name);
                        p.setCompany(company);
                        person = p;
                    }else {
                        person.setCompany(company);
                    }

                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    if(people.containsKey(name)){
                        Person getPerson = people.get(name);
                        if(getPerson.getPokemons() != null){
                            getPerson.getPokemons().add(pokemon);
                            person = getPerson;
                        }else{
                            List<Pokemon> pokemons = new ArrayList<>();
                            pokemons.add(pokemon);
                            getPerson.setPokemons(pokemons);
                            person = getPerson;
                        }
                    }else{
                        List<Pokemon> pokemons = new ArrayList<>();
                        pokemons.add(pokemon);
                        person.setPokemons(pokemons);
                    }
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parent parent = new Parent(parentName, parentBirthday);
                    if(people.containsKey(name)){
                        Person getPerson = people.get(name);
                        if(getPerson.getParents() != null){
                            getPerson.getParents().add(parent);
                            person = getPerson;
                        }else{
                            List<Parent> parents = new ArrayList<>();
                            parents.add(parent);
                            getPerson.setParents(parents);
                            person = getPerson;
                        }
                    }else{
                        List<Parent> parents = new ArrayList<>();
                        parents.add(parent);
                        person.setParents(parents);
                    }

                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children children = new Children(childName, childBirthday);
                    if(people.containsKey(name)){
                        Person getPerson = people.get(name);
                        if(getPerson.getChildrens() != null){
                            getPerson.getChildrens().add(children);
                            person = getPerson;
                        }else{
                            List<Children> childrens = new ArrayList<>();
                            childrens.add(children);
                            getPerson.setChildrens(childrens);
                            person = getPerson;
                        }
                    }else{
                        List<Children> childrens = new ArrayList<>();
                        childrens.add(children);
                        person.setChildrens(childrens);
                    }

                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    if(people.containsKey(name)){
                        Person p = people.get(name);
                        p.setCar(car);
                        person = p;
                    }else {
                        person.setCar(car);
                    }
                    break;
            }
            people.put(name, person);
            input = scanner.nextLine();
        }

        String personName = scanner.nextLine();
        for (Map.Entry<String, Person> entry: people.entrySet()) {
            if(entry.getKey().equals(personName)) {
                System.out.println(personName);
                System.out.println("Company:");
                if (entry.getValue().getCompany() != null) {
                    System.out.println(entry.getValue().getCompany().toString());
                }
                System.out.println("Car:");
                if(entry.getValue().getCar() != null){
                    System.out.println(entry.getValue().getCar().toString());
                }
                System.out.println("Pokemon:");
                if(entry.getValue().getPokemons() != null) {
                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        System.out.println(pokemon.toString());
                    }
                }
                System.out.println("Parents:");
                if(entry.getValue().getParents() != null) {
                    for (Parent parent : entry.getValue().getParents()) {
                        System.out.println(parent.toString());
                    }
                }
                System.out.println("Children:");
                if(entry.getValue().getChildrens() != null) {
                    for (Children Children : entry.getValue().getChildrens()) {
                        System.out.println(Children.toString());
                    }
                }
                break;
            }
        }

    }
}
