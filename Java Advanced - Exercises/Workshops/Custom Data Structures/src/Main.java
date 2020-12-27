
public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();
        for (int i = 1; i < 10; i++) {
            smartArray.add(i);
        }
        for (int i = 1; i < 5; i++) {
            smartArray.remove(0);
        }
        System.out.println(smartArray.remove(0));
        System.out.println();
        for (int i = 0; i < smartArray.size(); i++) {
            System.out.println(smartArray.get(i));
        }
        System.out.println(smartArray.contains(-1));

        for (int i = 0; i < 10; i++) {
            smartArray.add(1, 100);
        }

        smartArray.forEach(p-> System.out.println(p));



        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.forEach(p-> System.out.println(p));


        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println(linkedList.get(10));

        for (int i = 0; i < 10; i++) {
            System.out.println(linkedList.removeFirst());
        }
        linkedList.removeFirst();
        linkedList.forEach(System.out::println);

        int[] array = linkedList.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(linkedList.removeLast());
        }
        System.out.println(linkedList.removeLast());

        System.out.println();

    }
}
