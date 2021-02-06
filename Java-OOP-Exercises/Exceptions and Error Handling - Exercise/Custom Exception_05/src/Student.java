public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    private void setName(String name) {
        isValid(name);
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void isValid(String name) {
        for (int i = 0; i < name.length(); i++) {
            if(Character.isDigit(name.charAt(i))){
                throw new InvalidPersonNameException("Its not allowed to use any special character or numeric value in a name!");
            }
        }
    }
}
