import java.util.Comparator;

public class ComparePersonByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(Integer.compare(o1.getName().length(), o2.getName().length()) < 0){
            return -1;
        }else if(Integer.compare(o1.getName().length(), o2.getName().length()) > 0){
            return 1;
        }else{
            char o1Char = o1.getName().charAt(0);
            char o2Char = o2.getName().charAt(0);
            if (Character.isLowerCase(o1Char) && Character.isUpperCase(o2Char)) {
                return -1;
            } else if(o1.getName().compareTo(o2.getName()) < 0){
                return -1;
            }
            return 1;

        }
    }
}
