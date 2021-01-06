public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind){
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.name).append(" ").append(this.age).append(" ").append(this.kind);
        return result.toString();
    }
}
