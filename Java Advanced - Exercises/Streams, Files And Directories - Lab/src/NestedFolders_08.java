import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders_08 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Delyan\\Documents\\GitHub\\Java-Advanced\\Java Advanced - Exercises\\Streams, Files And Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        int counter = 0;

        Deque<File> deque = new ArrayDeque();

        deque.add(file);

        while (!deque.isEmpty()){
            File f = deque.poll();
            counter++;
            System.out.println(f.getName());
            File[] nestedFiles = f.listFiles();
            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()){
                    deque.offer(nestedFile);
                }
            }
        }
        System.out.println(counter + " folders");
    }
}
