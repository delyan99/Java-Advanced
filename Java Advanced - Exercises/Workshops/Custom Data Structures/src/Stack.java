import java.util.function.Consumer;

public class Stack {

    private static class Node{
        private int element;
        private Node previous;

        private Node(int element){
            this.element = element;
        }
    }
    private int size;
    private Node top;

    public void push(int element){
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.previous = this.top;
        }
        this.top = newNode;
        this.size++;
    }

    public int pop(){
        validate();
        int lastNumber = this.top.element;
        this.top = this.top.previous;
        this.size--;
        return lastNumber;
    }

    private void validate() {
        if(this.top == null){
            throw new IllegalArgumentException("Empty stack!");
        }
    }

    public int peek(){
        validate();
        return this.top.element;
    }

    public void forEach(Consumer<Integer> consumer){
        validate();
        Node current = this.top;
        while (current != null){
            consumer.accept(current.element);
            current = current.previous;
        }
    }
}
