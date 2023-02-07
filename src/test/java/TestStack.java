import DoublyLinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO Brauche ich zum Zweck dieses Tests eine Main-Klasse im `main`-Ordner?
// TODO Muss ich auch `DoublyLinkedList` testen? Oder kann ich davon ausgehen, dass diese Klasse schon getestet ist?
    // TODO D.h. kann ich die Methoden von `DoublyLinkedList` aufrufen, um die Methoden von `Stack` zu testen?
// TODO Inwieweit greife ich auf das, was in `DoublyLinkedList` passiert, zu?
public class TestStack<T> {
    // Arrange
    private DoublyLinkedList<T> myList;

    // Test constructor
    @BeforeEach
    void setUp() {
        myList = new DoublyLinkedList<T>();
    }

    @Test
    void pushTest() {
        /*
        Was soll `push()` ergeben?
        - dataList hat einen Knoten mehr als vorher:
            - Dazu brauche ich erst die Methode `size()`
        Cases:
        value === null
        value !== null
         */
    }

    @Test
    void sizeTest() {
        /*
        Should return number of elements in list
        Count elements with methods of `DoublyLinkedList`
        and compare to result of call to `size()`
       */
        // TODO Ansatz: Rufe `listLength()` aus `DoublyLinkedList` auf und vergleiche mich Rueckgabewert von `size()` aus `Stack`
        // TODO Stimmt dieser Ansatz grundsaetzlich?
        // TODO Oder muss ich mehrere Testlisten erstellen, deren Laenge ich kenne, und diesen mit dem Rueckgabewert von `size()` vergleichen?
        // Problem: Ich kann nicht auf die Methode `size()` zugreifen.
        assertEquals(myList.listLength(), /* return value of call to size() */ );


    }
}
