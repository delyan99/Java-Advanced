public enum TrafficLightSignals {
    YELLOW("RED"),
    RED("GREEN"),
    GREEN("YELLOW");

    private String newValue;

    TrafficLightSignals(String newValue){
        this.newValue = newValue;
    }

    public String getNewValue() {
        return this.newValue;
    }
}
