public class Main {
    public static void main(String[] args) {
        Set<Integer> mySet = new Set<>();
        mySet.add(5);
        mySet.add(2);
        mySet.add(-10);
        mySet.add(456);
        mySet.add(123);
        mySet.add(5);
        mySet.remove(123);
        System.out.println(mySet.length());
        mySet.print();
        System.out.println();

        Set<String> mySet2 = new Set<>();
        mySet2.add("x");
        mySet2.add("b");
        mySet2.add("e");
        mySet2.add("d");
        mySet2.add("d");
        mySet2.print();
        System.out.println();


        Stack<Integer> myStack = new Stack<>();
        myStack.add(1);
        myStack.add(1);
        myStack.add(-10);
        myStack.add(8);
        myStack.add(5);
        myStack.add(2);

        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.length());

    }
}