package ADTs;

public class PriorityQueue<E>{
    private PNode<E> head, tail; // head and tail point to first and last nodes
    private int size, maxSize;

    public PriorityQueue(int size){ // constructor
        this.head = this.tail = null;
        this.maxSize = size;
        this.size = 0;
    }

    public void enqueue(E data, int priority){ // enqueue with prio
        enqueueMain(data, priority);
    }

    public void enqueue(E data){ // enqueue with default prio
        int priority = 10;
        enqueueMain(data, priority);
    }

    private void enqueueMain(E data, int priority) { // main enqueue method
        PNode<E> newNode = new PNode<>(data, priority); // new node to be enqueued
        if(isEmpty()){ // if the queue is empty, the new node is the only node
            head = tail = newNode;
            return;
        }
        else
            tail.next = newNode; // add the item to the end

        tail = newNode;
        size++;

        PNode<E> current = head, index = null; // sort the linked list so that the highest priority items are first
        E temp; // temp variables for swapping during sorting
        int tempPriority;

        while(current != null){ // loop through all elements and swap
            index = current.next;

            while(index != null){
                if(current.priority > index.priority){
                    temp = current.data;
                    tempPriority = current.priority;

                    current.data = index.data;
                    current.priority = index.priority;

                    index.data = temp;
                    index.priority = tempPriority;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public E dequeue(){ // remove first item and  return it
        PNode<E> newNode = head; // new node to remove
        head = head.next; // move head position

        if(isEmpty()) // if the queue is empty, then set the tail to null
            tail = null;

        size--;
        return newNode.data;
    }

    public E dequeueSorted(){ // for default priorities
        PNode<Integer> current = (PNode<Integer>) head, index = null; // sort the linked list so that the highest priority items are first
        int temp; // temp variables for swapping during sorting
        int tempPriority;

        while(current != null){ // loop through all elements and swap so that smallest data appears first
            index = current.next;

            while(index != null){
                if(current.data > index.data){
                    temp = current.data;
                    tempPriority = current.priority;

                    current.data = index.data;
                    current.priority = index.priority;

                    index.data = temp;
                    index.priority = tempPriority;
                }
                index = index.next;
            }
            current = current.next;
        }

        PNode<E> newNode = head; // new node to remove
        head = head.next; // move head position

        if(isEmpty()) // if the queue is empty, then set the tail to null
            tail = null;

        size--;
        return newNode.data;
    }

    public E peek(){ // return the highest priority item without removing it
        return head.data;
    }
    public int getSize(){ // get the size of the queue
        return size;
    }
    public boolean isEmpty(){ // is the queue empty?
        return head == null;
    }
    public boolean isFull(){ // is the queue full?
        return size == maxSize;
    }
    public void display(){ // display the queue
        PNode<E> temp = head;

        System.out.print("[ ");
        while(temp != null){
            System.out.print("(" + temp.data + ", " + temp.priority + ") ");
            temp = temp.next;
        }
        System.out.println("]");
    }
}
