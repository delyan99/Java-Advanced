import java.util.ArrayList;

public class RandomArrayList extends ArrayList<Object> {

    private Object object;

    public Object getRandomElement(){
        return super.remove(this.object);
    }
}
