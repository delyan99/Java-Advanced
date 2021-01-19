package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Animal(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String produceSound(){
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        sb.append(this.produceSound());
        return sb.toString();
    }
}
