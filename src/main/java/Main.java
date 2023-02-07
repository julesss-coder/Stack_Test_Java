import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Value of the deleted element: " + stack.pop());

        // Task description required method `pop(n)` to return an array with the deleted values.
        // As I am using generics, I could not create this array right within pop(n).
        // Therefore, I am creating an array of objects which I then push into an integer array.
        Object[] deleted = stack.pop(3);
        Integer[] deletedValues = new Integer[deleted.length];
        for (int i = 0; i < deleted.length; i++) {
            deletedValues[i] = (Integer) deleted[i];
        }

        System.out.println("Deleted values: " + Arrays.toString(deletedValues));

        stack.push(0);
        System.out.println("Last (= most recently added) value on stack: " + stack.peek());
    }
}
