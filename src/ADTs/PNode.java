public class PNode<E>{
    E data; // holds data of type e
    PNode<E> next; // points to next node
    int priority;  // priority of the node

    public PNode(E data, int priority){ // constructor
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}
