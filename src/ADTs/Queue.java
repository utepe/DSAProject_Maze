package ADTs;

public class Queue<E>{
    private Node<E> head, tail; // head and tail to keep track of beginning and end of queue
    private int size, maxSize;

    public Queue(int size){ //constructor
        this.head = null;
        this.tail = null;
        this.maxSize = size;
        this.size = 0;
    }

    public void enqueue(E data){ // add item to the end of the queue
        Node<E> newNode = new Node<E>(data); // new node for data insertion
        if(isEmpty()){ // if the queue is empty
            head = tail = newNode;
            return;
        }
        else{
            tail.next = newNode; // add to end
        }
        tail = newNode;
        size++;
    }

    public E dequeue(){ // remove first item and  return it
        Node<E> newNode = head; // new node to remove
        head = head.next; // move head position

        if(isEmpty()) // if the queue is empty, then set the tail to null
            tail = null;

        size--;
        return newNode.data;
    }

    public E peek(){ // return first item without removing
        return head.data;
    }

    public boolean isEmpty(){ // is the queue empty?
        return head == null;
    }

    public boolean isFull(){ // is the queue full?
        return size == maxSize;
    }
    public int getSize(){
        return size;
    }

    public void display(){ // display the queue
        Node<E> temp = head;

        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }

}
