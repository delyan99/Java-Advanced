import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> data;
    private int index;
    private int lastIndex;

    public Lake(List<Integer> data){
        this.data = data;
        this.index = 0;
        this.lastIndex = data.size() % 2 == 0 ? data.size() - 2 : data.size() - 1;
    }

    private class Frog implements Iterator<Integer>{
        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public Integer next() {
            Integer result = data.get(index);
            index += 2;
            if(lastIndex + 2 == index){
                index = 1;
            }
            return result;
        }
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public int size(){
        return this.data.size();
    }
}
