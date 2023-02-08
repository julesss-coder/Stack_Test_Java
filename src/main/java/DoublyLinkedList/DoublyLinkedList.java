package DoublyLinkedList;

public class DoublyLinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int nodeCounter;

    public DoublyLinkedList(ListNode<T> head, ListNode<T> tail) {
        this.head = head;
        this.tail = tail;
        nodeCounter = 0;
    }

    // Leave this constructor so you can call class without arguments, too
    public DoublyLinkedList() {}

    public void append(T value) {
        ListNode<T> node = new ListNode<T>(value); // 8.2.2023: Added <T>
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            nodeCounter++;
        } else if (this.head == this.tail) {
            this.head.setNext(node);
            this.tail = node;
            this.tail.setPrevious(this.head);
            nodeCounter++;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
            this.tail.setNext(null);
            nodeCounter++;
        }
    }

    public void add(int index, T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        int indexCounter = 0;

        // Case: listLength === 0 || listLength === 1 || index === listLength (insert after last element)
        if (nodeCounter == 0 || nodeCounter == 1 || index == nodeCounter) {
            append(value);
        }

        // Case: no element at given index:
        if (index > nodeCounter) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds."); // However, it is possible to pass in index = listLength, which is out of bounds, too. => Need better exception message.
        }

        // Case: listLength >= 2
        if (nodeCounter >= 2) {
            ListNode<T> currentNode = this.head;

            if (index == 0) {
                this.head.setPrevious(newNode);
                newNode.setNext(this.head);
                this.head = newNode;
            } else {
                while (indexCounter != index) {
                    indexCounter++;
                    currentNode = currentNode.getNext();
                }
                ListNode<T> leftNode = currentNode.getPrevious();
                leftNode.setNext(newNode);
                newNode.setPrevious(leftNode);
                newNode.setNext(currentNode);
                currentNode.setPrevious(newNode);
            }
            nodeCounter++;
        }
    }

    public int listLength() {
        return nodeCounter;
    }

    public void printList() {
        ListNode<T> node = this.head;
        if (node == null) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Doubly linked list: ");
            while (node != null) {
                System.out.println(node.getValue());
                node = node.getNext();
            }
        }
    }

    public void printListReverse() {
        if (this.head == null) {
            System.out.println("List is empty.");
        } else {
            ListNode<T> node = this.tail;
            while (node != null) {
                System.out.println(node.getValue());
                node = node.getPrevious();
            }
        }
    }

    public T searchList(int index) {
        if (index >= nodeCounter) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        int currentIndex = 0;
        ListNode<T> node = this.head;
        while (node != null) {
            if (currentIndex == index) {
                return node.getValue();
            }
            currentIndex++;
            node = node.getNext();
        }

        return null;
    }

    public T searchListReverse(int index) {
        if (index >= nodeCounter) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        ListNode<T> node = this.tail;
        int currentIndex = this.listLength() - 1;

        while (node != null) {
            if (currentIndex == index) {
                return node.getValue();
            }
            currentIndex--;
            node = node.getPrevious();
        }

        return null;
    }

    public T delete(int index) {
        if (index >= nodeCounter) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        ListNode<T> node = this.head;
        int currentIndex = 0;
        while (node != null) {
            if (currentIndex == index) {
                if (index == 0) {
                    if (nodeCounter == 1) {
                        this.head = null;
                        this.tail = null;
                    } else {
                        this.head = node.getNext();
                        node.getNext().setPrevious(null);
                    }
                } else if (index == nodeCounter - 1) {
                    this.tail = node.getPrevious();
                    node.getPrevious().setNext(null);
                } else {
                    ListNode<T> leftNode = node.getPrevious();
                    ListNode<T> rightNode = node.getNext();
                    leftNode.setNext(rightNode);
                    rightNode.setPrevious(leftNode);
                }
                nodeCounter--;
                return node.getValue();
            }
            node = node.getNext();
            currentIndex++;
        }

        return null;
    }
}
