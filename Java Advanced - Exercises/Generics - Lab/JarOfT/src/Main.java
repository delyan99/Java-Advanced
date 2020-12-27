public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(3);

        System.out.println(jar.remove());

    }
}
