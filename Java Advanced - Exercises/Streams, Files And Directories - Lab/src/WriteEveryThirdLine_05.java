import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("writeEveryThirdLine_05.txt"));

        Stream<String> lines = reader.lines();
        List<String> listOfLines = lines.collect(Collectors.toList());
        for (int i = 0; i < listOfLines.size(); i++) {
            if((i + 1) % 3 == 0){
                writer.write(listOfLines.get(i));
                writer.newLine();
            }
            
        }
        writer.close();
    }
}
