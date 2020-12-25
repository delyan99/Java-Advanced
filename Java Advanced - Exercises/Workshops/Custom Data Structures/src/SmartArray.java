import java.util.function.Consumer;

public class SmartArray {
    private static int CAPACITY = 4;
    private int[] elements;
    private int size;

    public SmartArray(){
        this.elements = new int[CAPACITY];
        this.size = 0;
    }

    public void add(int element){
        resize();
        this.elements[this.size] = element;
        this.size++;
    }

    private void resize() {
        if (CAPACITY == this.size) {
            CAPACITY = this.size * 2;
            int[] newElementsWithBiggerCapacity = new int[CAPACITY];
            for (int i = 0; i < this.size; i++) {
                newElementsWithBiggerCapacity[i] = this.elements[i];
            }
            this.elements = newElementsWithBiggerCapacity;
        }
    }

    public int size(){
        return this.size;
    }

    public int get(int index){
        validateIndex(index);
        return this.elements[index];
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= this.size){
            String message = String.format("Index %d out of bounds for length %d", index, size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int remove(int index){
        validateIndex(index);
        int removedNumber = this.elements[index];
        for (int i = index; i < size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.elements.length - 1] = 0;
        size--;
        shrink();
        return removedNumber;
    }

    private void shrink() {
        if(CAPACITY == size * 4){
            CAPACITY = CAPACITY / 2;
            int[] newElementsWithBiggerCapacity = new int[CAPACITY];
            for (int i = 0; i < this.size; i++) {
                newElementsWithBiggerCapacity[i] = this.elements[i];
            }
            this.elements = newElementsWithBiggerCapacity;
        }
    }

    public boolean contains(int element){
        for (int i = 0; i < this.size; i++) {
            if(this.elements[i] == element){
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element){
        validateIndex(index);
        this.size++;
        resize();
        int currentNumber = this.elements[index];
        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.elements[i]);
        }
    }
}
