import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;
    private int iteratorIndex;

    public ListyIterator(List<String> data){
        this.data = data;
        this.index = 0;
        this.iteratorIndex = 0;
    }

    public boolean move(){
        if(this.index + 1 < this.data.size()){
            this.index++;
            return true;
        }
        return false;
    }

    public String print(){
        String result = "";
        if(isEmpty()){
            return "Invalid Operation!";
        }
        if(this.index < this.data.size()){
            result = this.data.get(this.index);
        }
        return result;
    }

    public boolean hasNext(){
        if(this.index + 1 < this.data.size()){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(this.data.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return iteratorIndex < data.size();
            }

            @Override
            public String next() {
                String result = data.get(iteratorIndex);
                iteratorIndex++;
                return result;
            }
        };
    }

    public void PrintAll(){
        while (iterator().hasNext()){
            String next = iterator().next();
            System.out.print(next + " ");
        }
        this.iteratorIndex = 0;
        System.out.println();
    }
}
