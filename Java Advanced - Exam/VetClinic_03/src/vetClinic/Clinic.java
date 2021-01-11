package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.data.size() < capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : data) {
            if(pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        Pet pet = data.get(0);
        for (Pet currentPet : data) {
            if(currentPet.getAge() > pet.getAge()){
                pet = currentPet;
            }
        }
        return pet;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            result.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return result.toString().trim();
    }

}
