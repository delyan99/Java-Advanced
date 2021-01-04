import java.util.Iterator;

public class Stack implements Iterable<Integer>{
    private java.util.Stack<Integer> data;

    public Stack(){
        data = new java.util.Stack<>();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = data.size() - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return data.get(index--);
            }
        };
    }

    public void push(Integer element){
        data.push(element);
    }

    public void pop(){
        if(data.size() == 0){
            System.out.println("No elements");
            return;
        }
        data.pop();
    }

    public int size(){
        return this.data.size();
    }
}
