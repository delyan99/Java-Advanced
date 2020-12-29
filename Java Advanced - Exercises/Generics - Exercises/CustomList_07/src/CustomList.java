import java.util.ArrayList;
import java.util.List;

public class CustomList <T extends Comparable>{
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public CustomList(){
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }

    public T remove(int index){
        return this.data.remove(index);
    }

    public boolean contains(T element){
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T current = this.data.get(firstIndex);
        data.set(firstIndex, this.data.get(secondIndex));
        data.set(secondIndex, current);
    }

    public int countGreaterThan(T element){
        int counter = 0;
        for (T d : this.data) {
            if((element.compareTo(d)) < 0){
                counter++;
            }
        }
        return counter;
    }


    public T getMax(){
        T max = this.data.get(0);
        for (T d : this.data) {
            if(d.compareTo(max) > 0){
                max = d;
            }
        }
        return max;
    }

    public T getMin(){
        T min = this.data.get(0);
        for (T d : this.data) {
            if(d.compareTo(min) < 0){
                min = d;
            }
        }
        return min;
    }
}
