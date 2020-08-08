package ADTs;

public class Node<E>{
    E data; // stores data of type E
    Node<E> next; // points to next node

    public Node(E data){ // constructor
        this.data = data;
        this.next = null;
    }
}
