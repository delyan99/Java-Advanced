import java.io.*;

public class CopyAPicture_09 {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream("C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\picture.jpg");
        FileOutputStream writer = new FileOutputStream("picture-copy.jpg");
        byte[] bytes = reader.readAllBytes();
        for (byte aByte : bytes) {
            writer.write(aByte);
        }
        writer.close();
    }
}
