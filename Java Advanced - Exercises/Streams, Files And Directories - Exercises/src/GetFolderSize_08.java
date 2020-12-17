import java.io.*;

public class GetFolderSize_08 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\SoftUni\\Java\\Java AdvancedSeptember2020\\Java Advanced - Exercises\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File files = new File(path);
        int sum = 0;
        for (File file : files.listFiles()) {
            if(file.isDirectory()){
                for (File innerFile : file.listFiles()) {
                    sum += innerFile.length();
                }
            }else{
                sum += file.length();
            }
        }
        PrintWriter writer = new PrintWriter("getFolderSize_08.txt");
        writer.println("Folder size: " + sum);
        writer.close();
    }
}
