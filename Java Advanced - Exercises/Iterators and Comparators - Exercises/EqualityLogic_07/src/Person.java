import java.util.Comparator;

public class Person implements Comparator<Person>{
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        int thisHashCode = this.hashCode();
        int objHashCode = obj.hashCode();
        if(thisHashCode == objHashCode){
            return true;
        }
        return obj == this;
    }

    @Override
    public int hashCode(){
        int result = 17;
        if (this.name != null) {
            for (int i = 0; i < this.name.length(); i++) {
                result *= this.name.charAt(i);
            }
        }
        if(this.age != 0){
            result += this.age;
        }
        return result;
    }
}
