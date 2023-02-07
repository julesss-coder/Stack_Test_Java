package DoublyLinkedList;

public class ListNode<T> {
    private T value;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    // Getter methods
    public T getValue() {
        return this.value;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public ListNode<T> getPrevious() {
        return this.previous;
    }

    // Setter methods
    public void setValue(T value) {
        if (value != null) {
            this.value = value;
        } else {
            System.out.println("You cannot set `null` as a node value.");
        }
    }

    public void setNext(ListNode<T> node) {
        this.next = node;
    }

    public void setPrevious(ListNode<T> node) {
        this.previous = node;
    }
}
