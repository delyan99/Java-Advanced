import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader wordReader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources//words.txt"));
        BufferedReader textReader = new BufferedReader(new FileReader("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources//text.txt "));
        PrintWriter writer = new PrintWriter("WordCount_06.txt");
        int next = wordReader.read();
        Map<String, Integer> wordsOutput = new LinkedHashMap<>();
        List<String> words = new ArrayList<>();
        String currentWord = "";
        while (next != -1){
            if(next == ' ' || next == '\n'){
                words.add(currentWord);
                currentWord = "";

            }else{
                currentWord += (char)next;
            }

            next = wordReader.read();
        }
        words.add(currentWord);

        int textSymbolFromText = textReader.read();
        List<String> wordsFromText = new ArrayList<>();
        String currentWordFromText = "";
        while (textSymbolFromText != -1){
            if(textSymbolFromText == ' ' || textSymbolFromText == '\n'){
                wordsFromText.add(currentWordFromText);
                currentWordFromText = "";

            }else{
                currentWordFromText += (char)textSymbolFromText;
            }

            textSymbolFromText = textReader.read();
        }
        wordsFromText.add(currentWordFromText);

        for (String word : words) {
            for (String wordFromText : wordsFromText) {
                if(word.equals(wordFromText)){
                    wordsOutput.putIfAbsent(word, 0);
                    int counter = wordsOutput.get(word) + 1;
                    wordsOutput.put(word, counter);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : wordsOutput.entrySet()) {
            writer.println(entry.getKey() + " - " + entry.getValue());
        }
        writer.close();
    }
}
