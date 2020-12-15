import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader readerFromFirstFile = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        BufferedReader readerFromSecondFile = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        PrintWriter writer = new PrintWriter("mergeTwoFiles_07.txt");
        List<String> linesFromFirstFile = readerFromFirstFile.lines().collect(Collectors.toList());
        List<String> linesFromSecondFile = readerFromSecondFile.lines().collect(Collectors.toList());
        for (String line : linesFromFirstFile) {
            writer.println(line);
        }

        for (String line : linesFromSecondFile) {
            writer.println(line);
        }
        writer.close();
    }
}
