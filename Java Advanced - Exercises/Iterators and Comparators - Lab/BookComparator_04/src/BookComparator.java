import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int resultTitles = o1.getTitle().compareTo(o2.getTitle());
        if(resultTitles == 0) {
            resultTitles = Integer.compare(o1.getYear(), o2.getYear());
        }
        return resultTitles;
    }
}
