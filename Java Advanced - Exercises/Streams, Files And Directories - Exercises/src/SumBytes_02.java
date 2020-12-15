import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources//input.txt"));
        long counter = 0;
        Stream<String> stringStream = reader.lines();
        List<String> lines = stringStream.collect(Collectors.toList());

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                counter += lines.get(i).charAt(j);
            }
        }
        System.out.println(counter);
    }
}
