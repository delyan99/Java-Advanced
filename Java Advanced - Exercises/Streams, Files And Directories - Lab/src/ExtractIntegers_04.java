import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "extractIntegers_04.txt";
        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);
        PrintWriter writer = new PrintWriter(outputStream);
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.close();
    }
}
