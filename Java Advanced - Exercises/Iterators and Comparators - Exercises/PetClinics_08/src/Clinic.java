import java.util.*;

public class Clinic {
    private String name;
    private int rooms;
    private Map<Integer, Pet> infoForRooms;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
        infoForRooms = new HashMap<>();
        for (int i = 0; i < rooms; i++) {
            infoForRooms.put(i, null);
        }

    }

    public boolean add(Pet pet) {
        int index = this.rooms / 2;
        for (int i = 0; i < rooms; i++) {
            if (infoForRooms.get(index - i) == null) {
                if(index - i >= 0) {
                    infoForRooms.put(index - i, pet);
                    return true;
                }
            } else if (infoForRooms.get(index + i) == null) {
                if(index + i < rooms) {
                    infoForRooms.put(index + i, pet);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : infoForRooms.values()) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public String print(){
        StringBuilder result = new StringBuilder();
        for (Pet pet : infoForRooms.values()) {
            if(pet == null){
                result.append("Room empty").append(System.lineSeparator());
            }else{
                result.append(pet.toString()).append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    public String print(int room) {
        Pet pet = infoForRooms.get(room - 1);
        if(pet == null){
            return "Room empty";
        }
        return pet.toString();
    }

    public boolean release(){
        int index = this.rooms / 2;
        for (int i = index; i < rooms; i++) {
            if (infoForRooms.get(i) != null) {
                infoForRooms.put(i, null);
                return true;
            }
        }

        for (int i = index; i >= 0; i--) {
            if (infoForRooms.get(i) != null) {
                infoForRooms.put(i, null);
                return true;
            }
        }
        return false;
    }
}
