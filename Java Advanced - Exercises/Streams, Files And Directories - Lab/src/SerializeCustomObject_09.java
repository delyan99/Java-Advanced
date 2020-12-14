import java.io.*;
import java.util.List;
import java.util.Scanner;

public class SerializeCustomObject_09 {
    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;
        public Cube( ){}
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width  = 15.3;
        cube.height = 12.4;
        cube.depth =  3.0;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cube_09.txt"));
        out.writeObject(cube);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("cube_09.txt"));
        Cube readCube = (Cube)in.readObject();
        System.out.println(readCube.color);
        System.out.println(readCube.width);
        System.out.println(readCube.height);
        System.out.println(readCube.depth);

    }
}
