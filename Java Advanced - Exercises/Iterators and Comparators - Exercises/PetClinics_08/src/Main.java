import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> pets = new LinkedHashMap<>();
        Map<String, Clinic> clinics = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Create":
                    String petOrClinic = tokens[1];
                    String name = tokens[2];
                    switch (petOrClinic){
                        case "Pet":
                            int ageCreate = Integer.parseInt(tokens[3]);
                            String kind = tokens[4];
                            Pet pet = new Pet(name, ageCreate, kind);
                            pets.put(name, pet);
                            break;
                        case "Clinic":
                            int rooms = Integer.parseInt(tokens[3]);
                            if(rooms % 2 == 0){
                                System.out.println("Invalid Operation!");
                                continue;
                            }
                            Clinic clinic = new Clinic(name, rooms);
                            clinics.put(name, clinic);
                            break;
                    }
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    Pet petForAdd = pets.get(petName);
                    Clinic clinicForAdd = clinics.get(clinicName);
                    System.out.println(clinicForAdd.add(petForAdd));
                    break;
                case "Release":
                    String clinicNameRelease = tokens[1];
                    Clinic clinicForRelease = clinics.get(clinicNameRelease);
                    System.out.println(clinicForRelease.release());
                    break;
                case "HasEmptyRooms":
                    String clinicNameHasEmptyRooms = tokens[1];
                    Clinic clinicRooms = clinics.get(clinicNameHasEmptyRooms);
                    System.out.println(clinicRooms.hasEmptyRooms());
                    break;
                case "Print":
                    String clinicNameForPrint = tokens[1];
                    Clinic clinicPrint = clinics.get(clinicNameForPrint);
                    if(tokens.length == 2){
                        System.out.println(clinicPrint.print());
                    }else if(tokens.length == 3){
                        int room = Integer.parseInt(tokens[2]);
                        System.out.println(clinicPrint.print(room));
                    }
                    break;
            }

        }
    }
}
