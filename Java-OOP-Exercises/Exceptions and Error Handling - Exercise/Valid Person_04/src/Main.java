public class Main {
    public static void main(String[] args) {
        try {
            Person peter = new Person("Franco", "Aimee", 19);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            Person noName = new Person("  ", "Aimee", 19);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            Person noLastName = new Person("Franco", null, 19);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            Person negativeAge = new Person("Franco", "Aimee", -1);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            Person tooOldForThisProgram = new Person("Franco", "Aimee", 121);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
