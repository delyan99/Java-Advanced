import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile_02 {
    public static void main(String[] args) {
        String path = "C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("writeToFile_02.txt");
            int next = inputStream.read();
            while(next != -1){
                char currentSymbol = (char)(next);
                if(currentSymbol == ',' || currentSymbol == '.' || currentSymbol == '?' || currentSymbol == '!'){
                    next = inputStream.read();
                    continue;
                }
                outputStream.write(currentSymbol);
                next = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
