import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        if(authors.length == 0){
            this.authors = new ArrayList<>();
            return;
        }
        this.authors = List.of(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public int compareTo(Book o) {
        int result = 0;
        if(this.year == o.year){
            result = 0;
        }else if(this.year > o.year){
            result = -1;
        }else if(this.year < o.year) {
            result = 1;
        }
        return result;
    }
}
