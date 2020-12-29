import java.util.List;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(list.getData().get(i).compareTo(list.getData().get(j)) < 0){
                    list.swap(i, j);
                }
            }
        }
    }
}
