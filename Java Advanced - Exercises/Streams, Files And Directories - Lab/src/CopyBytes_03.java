import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "copyBytes_02.txt";
        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int nextByte = inputStream.read();
        while (nextByte != -1){
            if(nextByte == ' ' || nextByte == '\n'){
                outputStream.write(nextByte);
            }else{
                outputStream.write(String.valueOf(nextByte).getBytes());
            }

            nextByte = inputStream.read();
        }


    }
}
