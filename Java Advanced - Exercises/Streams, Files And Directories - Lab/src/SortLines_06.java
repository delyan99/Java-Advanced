import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        List<String> lines = Files.readAllLines(path);
        lines = lines.stream().filter(l -> !l.isBlank()).collect(Collectors.toList());
        Collections.sort(lines);
        Files.write(Paths.get("sortLines_06.txt"), lines);
    }
}
