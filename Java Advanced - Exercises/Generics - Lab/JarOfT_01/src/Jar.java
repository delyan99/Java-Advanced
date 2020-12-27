import java.util.ArrayDeque;

public class Jar <T>{
    private ArrayDeque<T> stack;

    public Jar(){
        this.stack = new ArrayDeque<>();
    }

    public void add(T element){
        stack.push(element);
    }

    public <T> Object remove(){
        return stack.pop();
    }
}
