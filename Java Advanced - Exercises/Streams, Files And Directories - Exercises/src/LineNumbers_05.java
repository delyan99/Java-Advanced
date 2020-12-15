import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class LineNumbers_05 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        PrintWriter writer = new PrintWriter("LineNumbers_05.txt");
        List<String> lines = reader.lines().collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            int currentLine = i + 1;
            writer.println(currentLine + ". " + lines.get(i));
        }

        writer.close();
    }
}
