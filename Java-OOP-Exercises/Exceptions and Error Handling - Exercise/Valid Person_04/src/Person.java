public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void setFirstName(String firstName) {
        validateName(firstName, "first");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        validateName(lastName, "last");
        this.lastName = lastName;
    }

    private void setAge(int age) {
        if(age < 0 || age > 120){
            throw new IllegalArgumentException("The age should be in range [0 ... 120]");
        }
        this.age = age;
    }

    private void validateName(String name, String prefixName) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("The " + prefixName + " name cannot be null or empty");
        }
    }
}
