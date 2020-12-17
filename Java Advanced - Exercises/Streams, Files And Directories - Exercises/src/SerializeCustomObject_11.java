import java.io.*;

public class SerializeCustomObject_11 {
    public static class Course implements Serializable{
         private String name;
         private int numberOfStudents;

        public String getName() {
            return name;
        }

        public int getNumberOfStudents() {
            return numberOfStudents;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumberOfStudents(int numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        course.setName("First");
        course.setNumberOfStudents(11);
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("course.ser"));
        writer.writeObject(course);
        writer.close();
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream("course.ser"));
        Object readObject = reader.readObject();
        Course readCourse = ((Course) readObject);
        System.out.println(readCourse.getName());
        System.out.println(readCourse.getNumberOfStudents());
    }
}
