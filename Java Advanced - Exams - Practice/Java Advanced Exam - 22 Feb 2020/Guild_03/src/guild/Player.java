package guild;

public class Player {
    private  String name;
	private String clazz;
	private String rank;
	private String description;

    public Player(String name, String clazz){
	    this.name = name;
	    this.clazz = clazz;
	    this.rank = "Trial";
	    this.description = "n/a";
    }

    public String getName() {
        return this.name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getClazz() {
        return clazz;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }


    @Override
    public String toString() {
        return String.format("Player %s: %s%nRank: %s%nDescription: %s", this.name, this.clazz, this.rank, this.description);
    }
}