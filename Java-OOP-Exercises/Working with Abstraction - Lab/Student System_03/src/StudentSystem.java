import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByNames;

    public StudentSystem()
    {
        this.studentsByNames = new HashMap<>();
    }

    public Map<String, Student> getStudentsByNames() {
        return this.studentsByNames;
    }

    public String parseCommand( String[] command)
    {
        String result = null;
        if (command[0].equals("Create")) {
            String name = command[1];
            int age = Integer.parseInt(command[2]);
            double grade = Double.parseDouble(command[3]);
            Student student = new Student(name, age, grade);
            this.studentsByNames.putIfAbsent(name,student);
        }
        else if (command[0].equals("Show")) {
            String name = command[1];
            if (this.studentsByNames.containsKey(name)) {
                Student student = this.studentsByNames.get(name);
                result = student.toString();
            }

        }else if(command[0].equals("Exit")){
            result = "Exit";
        }
        return result;
    }
}
