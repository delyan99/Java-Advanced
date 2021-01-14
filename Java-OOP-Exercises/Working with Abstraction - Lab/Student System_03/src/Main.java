import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if(studentSystem.parseCommand(input).equals("Exit")){
                break;
            }else if(studentSystem.parseCommand(input) != null && 
                    !studentSystem.parseCommand(input).equals("Exit")) {
                System.out.println(studentSystem.parseCommand(input));
            }
        }
    }
}
