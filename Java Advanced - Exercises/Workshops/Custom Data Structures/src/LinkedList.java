import java.util.function.Consumer;

public class LinkedList {
    private static class Node{
        private int element;
        private Node previous;
        private Node next;

        public Node(int element){
            this.element = element;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }

    public void addFirst(int element){
        Node newNode = new Node(element);
        if(size > 0){
            newNode.next = this.head;
            this.head.previous = newNode;
        }

        this.head = newNode;
        if(size == 0){
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(int element){
        if(this.isEmpty()){
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        size++;
    }

    public int get(int index){
        validateIndex(index);
        Node currentNode = this.head;
        int result = 0;
        int counter = 0;
        while (currentNode != null){
            if(index == counter++){
                result = currentNode.element;
            }

            currentNode = currentNode.next;
        }
        return result;
    }

    private void validateIndex(int index) {
        if(index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound from LinkedList with " + this.size + " size.");
        }
    }

    public int removeFirst(){
        validateListSize();
        int removedElement = this.head.element;
        this.head = this.head.next;
        if(this.size <= 1){
            this.tail = this.head;
        }
        if(this.size > 1) {
            this.head.previous = null;
        }
        this.size--;
        return removedElement;
    }

    public int removeLast(){
        validateListSize();
        int removedElement = this.tail.element;
        if(this.size > 1){
            this.tail = this.tail.previous;
            this.tail.next = null;
        }
        if(this.size == 1){
            this.tail = this.head;
        }
        this.size--;
        return removedElement;
    }

    private void validateListSize() {
        if(this.isEmpty()){
            throw new IllegalArgumentException("Linked List is empty.");
        }
    }

    public void forEach(Consumer<Integer> consumer){
        validateListSize();
        Node newNode = this.head;

        while (newNode != null){
            consumer.accept(newNode.element);
            newNode = newNode.next;
        }
    }

    public int[] toArray(){
        int[] result = new int[this.size];

        Node newNode = this.head;
        int index = 0;
        while (newNode != null){
            result[index++] = newNode.element;
            newNode = newNode.next;
        }

        return result;
    }


}
