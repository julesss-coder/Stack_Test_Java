import DoublyLinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO Brauche ich zum Zweck dieses Tests eine Main-Klasse im `main`-Ordner?
// TODO Muss ich auch `DoublyLinkedList` testen? Oder kann ich davon ausgehen, dass diese Klasse schon getestet ist?
    // TODO D.h. kann ich die Methoden von `DoublyLinkedList` aufrufen, um die Methoden von `Stack` zu testen?
// TODO Inwieweit greife ich auf das, was in `DoublyLinkedList` passiert, zu?
// Was muss ich beim Testen beachten, wenn meine Implementation von Stack mit Generics arbeitet?
public class TestStack<T> {
    // Arrange
    private Stack<T> myList;

    // Test constructor
    // Do I have to test it with all data types, due to using generics?
    @BeforeEach
    void setUp() {
        myList = new Stack<>();
    }

    @Test
    // TEST: Hat die Liste einen Knoten mehr als vorher, wenn `push()` ausgefuehrt wird?
    // Edge cases: ?
    void pushTest() {
        // Create test object
        // TODO Ich erzeuge eine neue Testliste, da ich einen spezifischen Datentyp verwenden moechte.
        // Ich moechte aber `myList` in `setUp()` als Generic belassen, um den Test nicht zu beeinflussen.
        Stack<Integer> testList = new Stack<>();
        // Case: empty list
        assertEquals(0, testList.size());

        // Case: 1 element
        testList.push(0);
        assertEquals(1, testList.size());

        // Case: 3 elements
        testList.push(1);
        testList.push(2);
        assertEquals(3, testList.size());
    }

    @Test
    // TEST: Entspricht der Rueckgabewert der Anzahl der Listenelemente?
    // Edge cases:
        // - Leere Liste
    void sizeTest() {
        // TODO Ansatz: Rufe `listLength()` aus `DoublyLinkedList` auf und vergleiche mich Rueckgabewert von `size()` aus `Stack`
        // TODO Stimmt dieser Ansatz grundsaetzlich?
        // TODO Oder muss ich mehrere Testlisten erstellen, deren Laenge ich kenne, und diesen mit dem Rueckgabewert von `size()` vergleichen?
        // Problem: Ich kann nicht auf die Methode `size()` zugreifen.
//        assertEquals(myList.listLength(), /* return value of call to size() */ );



        // Create test list with 4 elements
            // TODO Ist es in Ordnung, `push` zum Testen zu verwenden? oder erst, nachdem ich `psuh()` selbst getestet habe?
        Stack<Integer> testStack = new Stack<>();
        // Case: empty list
        assertEquals(0, testStack.size());
        // Case: 4 list elements
        testStack.push(0);
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        assertEquals(4, testStack.size());

        // TODO `sizeTest()` bestanden.
    }
}
