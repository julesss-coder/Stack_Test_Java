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
// How can I use a method reference when referring to an overloaded method? E.g. testStack::pop to call pop(int n).

public class TestStack<T> {
    private Stack<T> myStack;

    @BeforeEach
    void setUp() {
        myStack = new Stack<>();
    }

    // TEST: 1. Hat die Liste einen Knoten mehr als vorher, wenn `push()` ausgefuehrt wird?
            // 2. Wurden die richtigen Daten in der richtigen Reihenfolge hinzugefuegt?
    // Edge cases: ?
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

    // TEST: Entspricht der Rueckgabewert der Anzahl der Listenelemente?
            // 1. nach dem Hinzufuegen von Elementen?
            // 2. nach dem Loeschen von Elementen?
            // 3. nach dem Loeschen mehrerer Elemente gleichzeitig?
    // Edge cases:
        // - Leere Liste
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

    /* TEST:
    1. Does it return the value of the last element?
    2. Does it delete the last element?
     */
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

    /* TEST
    - Does it throw a NullPointerException when pop is called on empty stack?
    - Is list size still the same as before?
     */
    @Test
    void exceptionPopTest() {
        Stack<Integer> testList = new Stack<>();
        // Using method reference instead of lambda expression, as pop() is a known function.
        assertThrows(NullPointerException.class, testList::pop);
        assertEquals(0, testList.size());
    }

    /*
    TEST:
    - Does it return an Object array with
        - the deleted values
        - the correct number of elements?
    - Does it delete the correct values?
    - Is the list size decremented accordingly?
     */
    @Test
    void popTest2() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(0);
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.pop(2);
        // Check list length
        assertEquals(3, testStack.size());
        // Check new last element of list
        assertEquals(2, testStack.peek());
        // Check that value of deleted element is correct and in correct position
        assertEquals(1, testStack.pop(2)[1]);
        assertEquals(1, testStack.size());
        // FIXME Check that the return value is an Object array
        // ?
    }

    /*
    TEST:
    - Does it throw a NullPointerException when pop(n) is called on empty stack?
    - Does it throw a NullPointerException when pop(n) is called on stack where size < n?
    - Is list size still the same as before?
     */
    @Test
    void exceptionPopTest2() {
        Stack<Integer> testStack = new Stack<>();

        assertThrows(NullPointerException.class, () -> testStack.pop(1));

        testStack.push(0);
        testStack.push(1);
        assertThrows(NullPointerException.class, () -> testStack.pop(3));
    }

    /*
    TEST:
    - Should return value of last element
     */
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

    /*
    TEST:
    - Should throw exception if peek() is called on empty stack.
     */
    @Test
    void exceptionPeekTest() {
        Stack<Integer> testStack = new Stack<>();
        assertThrows(NullPointerException.class, testStack::peek);
    }
}
