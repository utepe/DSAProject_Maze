package ADTs;

<<<<<<< HEAD
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
=======
public class Queue<E> {
    private Node<E> first, last;
    private int size;


    static class Node<E> {
        Node<E> next;
        E data;
    
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * LLQueue Contructor
     */
    public Queue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * isEmpty Method
     * @return True if size == 0
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * isFull Method
     * @return False since LLQueue can never be full
     */
    public boolean isFull(){
        return false;
    }

    /**
     * enqueue Method
     * inserts the entered data to the rear of thre queue
     * @param data
     */
    public void enqueue(E data){
        Node<E> newNode = new Node<E>(data);
        if(isEmpty()){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }
    
    /**
     * dequeue Method
     * removed and returns the data at the front of the Queue
     * @return element
     */
    public E dequeue(){
        if(isEmpty()) return null;
        if(this.first == this.last) this.last = null;
        Node<E> firstEle = this.first;
        this.first = this.first.next;
        this.size--;
        return firstEle.data;
    }

    /**
     * peek Method
     * returns the element at the front of the Queue (doesnt remove)
     * @return front.data (data at front of queue)
     */
    public E peek(){
        if(isEmpty()) return null;
        else{
            return this.first.data;
        }
    }

    /**
     * getSize Method
     * @return the current size of the Queue
     */
    public int getSize(){
        return this.size;
    }

    /**
     * display Method
     * prints each element of the Queue from first to last
     */
    public void display(){
        Node<E> current = this.first;

        System.out.print("first -> ");
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println("<- last");
    }
}
>>>>>>> c2274ff3118dbc2027125cc874dd89954229f8d5
