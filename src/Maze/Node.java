package Maze;

public class Node<E> {
    Node<E> next;
    E data;

    public Node(E data){
        this.data = data;
        this.next = null;
    }
}