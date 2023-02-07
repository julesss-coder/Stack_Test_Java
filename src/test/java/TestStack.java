import DoublyLinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO Fragen:
// - Brauche ich zum Zweck dieses Tests eine Main-Klasse im `main`-Ordner?
// - Muss ich auch `DoublyLinkedList` testen? Oder kann ich davon ausgehen, dass diese Klasse schon getestet ist? D.h. kann ich die Methoden von `DoublyLinkedList` aufrufen, um die Methoden von `Stack` zu testen?
// - Inwieweit greife ich auf das, was in `DoublyLinkedList` passiert, zu?
// - Was muss ich beim Testen beachten, wenn meine Implementation von Stack mit Generics arbeitet?
// - Should I create a test object within each test method, or a `public` object?
    // - Does it matter what data type the test object is, given that Stack is implemented using generics?
// - @BeforeEach: Do I have to test `setUp()` it with all data types, due to using generics?
// - How to come up with all necessary test cases?
    // - More specifically: When testing an add() method, with how many elements do I have to test it? 0, 1, and > 1 seems reasonable to me. More doesn't seem provide any benefit.
// - Wie nenne ich die Testmethoden einer ueberladenen Methode am besten? popTest, popTest1?

// TODO
// - Use all methods in all test cases, if it makes sense. E.g. to test push, check with size() that the list length is correct.
// Check with pop()/peek()/(pop(n)?) and afterwards peek() that the correct element was pushed.
public class TestStack<T> {
    private Stack<T> myList;

    @BeforeEach
    void setUp() {
        myList = new Stack<>();
    }

    // TEST: 1. Hat die Liste einen Knoten mehr als vorher, wenn `push()` ausgefuehrt wird?
            // 2. Wurden die richtigen Daten in der richtigen Reihenfolge hinzugefuegt?
    // Edge cases: ?
    @Test
    void pushTest() {
        Stack<Integer> testList = new Stack<>();

        // Case: number of elements === 0
        assertEquals(0, testList.size());

        // Case: number of elements === 1
        testList.push(0);
        assertEquals(1, testList.size());
        // Check that correct value is in last element
        assertEquals(0, testList.peek());
        assertEquals(0, testList.pop());

        // Case: number of elements > 1
        testList.push(0);
        testList.push(1);
        testList.push(2);
        assertEquals(3, testList.size());
        // Check that correct value is in last element
        assertEquals(2, testList.peek());
        assertEquals(2, testList.pop());
    }

    // TEST: Entspricht der Rueckgabewert der Anzahl der Listenelemente?
            // 1. nach dem Hinzufuegen von Elementen?
            // 2. nach dem Loeschen von Elementen?
            // 3. nach dem Loeschen mehrerer Elemente gleichzeitig?
    // Edge cases:
        // - Leere Liste
    @Test
    void sizeTest() {
        // TODO Ansatz: Rufe `listLength()` aus `DoublyLinkedList` auf und vergleiche mich Rueckgabewert von `size()` aus `Stack`
        // TODO Stimmt dieser Ansatz grundsaetzlich?
        // TODO Oder muss ich mehrere Testlisten erstellen, deren Laenge ich kenne, und diesen mit dem Rueckgabewert von `size()` vergleichen?
        // Problem: Ich kann nicht auf die Methode `size()` zugreifen.
//        assertEquals(myList.listLength(), /* return value of call to size() */ );
        // =============
        // Create test list
        Stack<Integer> testStack = new Stack<>();

        // Test `size()` after adding elements
        // Case: Number of elements === 0
        assertEquals(0, testStack.size());

        // Case: Number of elements > 0
        testStack.push(0);
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        assertEquals(4, testStack.size());

        // Test `size()` after deleting an element
        testStack.pop();
        assertEquals(3, testStack.size());
        testStack.pop();
        assertEquals(2, testStack.size());

        // Test `size()` after deleting several elements
        testStack.pop(2);
        assertEquals(0, testStack.size());
    }

    /* TEST:
    1. Does it return the value of the last element?
    2. Does it delete the last element?
     */
    @Test
    void popTest() {    }

    // Deal with empty list
    @Test
    void exceptionPopTest() {}

    @Test
    void popTest2() {}

    // Deal with n > number of list elements
    @Test
    void exceptionPopTest2() {}

    @Test
    void peekTest() {}

    @Test
    void exceptionPeekTest() {}
}
