import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumLines_01 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources//input.txt"));
        Stream<String> linesOfStream = reader.lines();
        List<String> lines = linesOfStream.collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            int current = 0;
            for (int j = 0; j < lines.get(i).length(); j++) {
                current += (int) lines.get(i).charAt(j);
            }
            System.out.println(current);
        }
    }
}
