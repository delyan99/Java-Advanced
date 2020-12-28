import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list){
        validate(list);
        T min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int result = min.compareTo(list.get(i));
            if(result > 0){
                min = list.get(i);
            }
        }

        return min;
    }

    private static <T extends Comparable<T>> void validate(List<T> list) {
        if(list.size() == 0){
            throw new IllegalArgumentException("List is empty!");
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        validate(list);
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int result = max.compareTo(list.get(i));
            if(result < 0){
                max = list.get(i);
            }
        }

        return max;
    }
}
