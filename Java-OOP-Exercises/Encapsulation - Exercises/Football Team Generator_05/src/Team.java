import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name){
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String playerName){
        for (Player player : players) {
            if(player.getName().equals(playerName)){
                this.players.remove(player);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
    }

    public double getRating(){
        double teamRating = 0.0;
        for (Player player : players) {
            teamRating += player.overallSkillLevel();
        }
        return teamRating / players.size();
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name , Math.round(this.getRating()));
    }
}
