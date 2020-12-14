import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles_07 {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Delyan\\Documents\\GitHub\\Java-Advanced\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = directory.listFiles();
        for (File file : files) {
            if(!file.isDirectory()){
                System.out.println(file.getName() + ": [" + file.length() + "]");
            }
        }

    }
}
