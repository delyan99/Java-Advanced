import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList_10 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(0.11);
        arrayList.add(53.1);
        arrayList.add(9502.);
        ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("list.ser"));
        write.writeObject(arrayList);
        write.close();
        ObjectInputStream read = new ObjectInputStream(new FileInputStream("list.ser"));
        System.out.println(read.readObject());
    }
}
