import java.util.ArrayList;
import java.util.List;

public class ListOfElements <T>{
    private List<T> data;

    public ListOfElements(){
        this.data = new ArrayList<>();
    }

    public void addData(T element){
        this.data.add(element);
    }
    public void swap(int firstIndex, int secondIndex){
        T current = this.data.get(firstIndex);
        this.data.set(firstIndex, this.data.get(secondIndex));
        this.data.set(secondIndex, current);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            sb.append(this.data.get(i).getClass().getName());
            sb.append(": ");
            sb.append(data.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
