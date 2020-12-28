import java.util.ArrayList;
import java.util.List;

public class ListOfElements <T>{
    private List<T> data;

    public ListOfElements(){
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }

    public void swap(int firstNumber, int secondNumber){
        T current = data.get(firstNumber);
        data.set(firstNumber, data.get(secondNumber));
        data.set(secondNumber, current);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i).getClass().getName());
            sb.append(": ");
            sb.append(data.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
