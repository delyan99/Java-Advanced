public enum State {
    INPROGRESS("inProgress"),
    FINISHED("Finished");

    private String name;

    State(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
