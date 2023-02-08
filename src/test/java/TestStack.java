import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// TODO Fragen:
// - What do I have to do differently when testing a class that uses generics?
    // - Does it matter what data type the test object is, given that Stack is implemented using generics?
    // - @BeforeEach: Do I have to test `setUp()` it with all data types, due to using generics?
// - Should I create a test object within each test method, or a `public` object?
// - How to come up with all necessary test cases?
    // - More specifically: When testing an add() method, with how many elements do I have to test it? 0, 1, and > 1 seems reasonable to me. More doesn't seem provide any benefit.
// - How to best name the test methods for an overloaded method? popTest, popTest1?
    // Alex: Name von Testmethode fuer ueberladene Methode: einfach verstaendlich, es gibt keine Konvention.
// How can I use a method reference when referring to an overloaded method? E.g. testStack::pop to call pop(int n).

public class TestStack<T> {
    private Stack<T> myStack;

    @BeforeEach
    void setUp() {
        myStack = new Stack<>();
    }

    @Test
    void pushTest() {
        Stack<Integer> testStack = new Stack<>();

        // Case: number of elements === 0
        assertEquals(0, testStack.size());

        // Case: number of elements > 1
        testStack.push(1);
        testStack.push(2);
        assertEquals(2, testStack.size());
        // Check that correct value is in last element
        assertEquals(2, testStack.peek());
    }

    @Test
    void sizeTest() {
        Stack<Integer> testStack = new Stack<>();

        // Case: Number of elements === 0
        assertEquals(0, testStack.size());

        // Case: Number of elements > 0
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        assertEquals(3, testStack.size());

        // Case: Deleting 1 element
        testStack.pop();
        assertEquals(2, testStack.size());

        // Case: Deleting > 1 elements
        testStack.pop(2);
        assertEquals(0, testStack.size());
    }

    @Test
    void popTest() {
        Stack<Integer> testStack = new Stack<>();

        // Case: Number of elements === 0
        testStack.push(0);
        // Check if correct value is returned
        assertEquals(0, testStack.pop());
        // Check if list size is decremented by one
        assertEquals(0, testStack.size());

        // Case: Number of elements > 1
        testStack.push(1);
        testStack.push(2);
        assertEquals(2, testStack.pop());
        assertEquals(1, testStack.size());
    }

    @Test
    void exceptionPopTest() {
        Stack<Integer> testList = new Stack<>();
        // Using method reference instead of lambda expression, as pop() is a known function.
        Exception exception = assertThrows(NullPointerException.class, testList::pop);
        assertEquals("Stack is empty - nothing to delete.", exception.getMessage());
        assertEquals(0, testList.size());
    }

    @Test
    void popTest2() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(0);
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        Object[] poppedArray = testStack.pop(2);
        // Check that the returned Object array is the correct length
        assertEquals(2, poppedArray.length);

        // Check list length
        assertEquals(2, testStack.size());
        // Check new last element of list
        assertEquals(1, testStack.peek());
        // Check that value of deleted element is correct and in correct position
        assertEquals(0, testStack.pop(2)[1]);
        assertEquals(0, testStack.size());
    }

    @Test
    void exceptionPopTest2() {
        Stack<Integer> testStack = new Stack<>();

        Exception exception = assertThrows(NullPointerException.class, () -> testStack.pop(1));
        assertEquals("Stack is empty - nothing to delete.", exception.getMessage());

        testStack.push(0);
        testStack.push(1);
        assertThrows(NullPointerException.class, () -> testStack.pop(3));
    }

    @Test
    void peekTest() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(0);
        assertEquals(0, testStack.peek());

        testStack.push(1);
        testStack.push(2);
        assertEquals(2, testStack.peek());

        // Check that peek() works after an element is deleted.
        testStack.pop();
        assertEquals(1, testStack.peek());
    }

    @Test
    void exceptionPeekTest() {
        Stack<Integer> testStack = new Stack<>();
        Exception exception = assertThrows(NullPointerException.class, testStack::peek);
        assertEquals("Stack is empty - no elements to show.", exception.getMessage());
    }
}
