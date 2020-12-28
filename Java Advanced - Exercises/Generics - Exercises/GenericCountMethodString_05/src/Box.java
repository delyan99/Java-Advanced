import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable>{
    private List<T> data;

    public Box(){
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public int compareTo(T element){
        int counter = 0;
        for (T d : data) {
            if(d.compareTo(element) > 0){
                counter++;
            }
        }
        return counter;
    }
}
