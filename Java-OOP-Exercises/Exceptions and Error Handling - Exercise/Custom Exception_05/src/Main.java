public class Main {
    public static void main(String[] args) {
        try {
        Student student = new Student("4avdar", "4havdar@abv.bg");
        } catch (InvalidPersonNameException exception){
            System.out.println(exception.getMessage());
        }
    }
}
