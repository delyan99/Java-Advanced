import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    private Random random;

    public RandomArrayList(){
        this.random = new Random();
    }

    public Object getRandomElement(){
        int index = random.nextInt(super.size() - 1);
        return super.remove(index);
    }
}
