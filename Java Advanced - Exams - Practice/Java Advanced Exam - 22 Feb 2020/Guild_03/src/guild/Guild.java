package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(capacity > roster.size()){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : roster) {
            if(player.getName().equals(name)){
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if(player.getName().equals(name)){
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if(player.getName().equals(name)){
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){

        int counter = 0;
        for (Player player : this.roster) {
            if(player.getClazz().equals(clazz)) {
                counter++;
            }
        }
        Player[] players = new Player[counter];
        counter = 0;
        for (Player player : this.roster) {
            if(player.getClazz().equals(clazz)) {
                players[counter++] = player;
            }
        }
        roster.removeIf(player -> player.getClazz().equals(clazz));
        return players;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder result = new StringBuilder();
        result.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (Player player : roster) {
            result.append(player).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
