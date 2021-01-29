import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        StringBuilder addCollectionStringBuilder = new StringBuilder();
        StringBuilder addRemoveCollectionStringBuilder = new StringBuilder();
        StringBuilder myListStringBuilder = new StringBuilder();
        for (String string : input) {
            addCollectionStringBuilder.append(addCollection.add(string)).append(" ");
            addRemoveCollectionStringBuilder.append(addRemoveCollection.add(string)).append(" ");
            myListStringBuilder.append(myList.add(string)).append(" ");
        }
        System.out.println(addCollectionStringBuilder.toString());
        System.out.println(addRemoveCollectionStringBuilder.toString());
        System.out.println(myListStringBuilder.toString());
        addRemoveCollectionStringBuilder = new StringBuilder();
        myListStringBuilder = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            addRemoveCollectionStringBuilder.append(addRemoveCollection.remove()).append(" ");
            myListStringBuilder.append(myList.remove()).append(" ");
        }
        System.out.println(addRemoveCollectionStringBuilder.toString());
        System.out.println(myListStringBuilder.toString());
    }
}
