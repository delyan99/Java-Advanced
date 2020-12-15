import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources//input.txt"));
        PrintWriter writer = new PrintWriter("CountCharacterTypes_04.txt");
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        int next = reader.read();
        while(next != -1){
            char currentSymbol = (char)next;
            if(currentSymbol == 'a' || currentSymbol == 'e' ||currentSymbol == 'i' ||currentSymbol == 'o' || currentSymbol == 'u'){
                vowels++;
            }else if(currentSymbol == '.' || currentSymbol == '?' ||currentSymbol == '!' || currentSymbol == ','){
                punctuation++;
            }else if(currentSymbol != ' ' && currentSymbol != '\r' && currentSymbol != '\n'){
                consonants++;
            }
            next = reader.read();
        }

        writer.println("Vowels: " + vowels);
        writer.println("Consonants: " + consonants);
        writer.println("Punctuation: " + punctuation);
        writer.close();
    }
}
