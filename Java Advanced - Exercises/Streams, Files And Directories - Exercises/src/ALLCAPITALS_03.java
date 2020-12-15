import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ALLCAPITALS_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources//input.txt"));
        List<String> lines = reader.lines().collect(Collectors.toList());
        BufferedWriter writer = new BufferedWriter(new FileWriter("AllCapitals_03.txt"));
        for (int i = 0; i < lines.size(); i++) {

            writer.write(lines.get(i).toUpperCase());

            writer.newLine();
        }
        writer.close();
    }
}
