package workingWithAbstraction.greedyTimes;

public class Gold {
    private long value = -1;

    public Gold() {
        this.value = 0;
    }

    public long getValue() {
        return value;
    }

    public void setNewValue(long value){
        this.value += value;
    }

}
