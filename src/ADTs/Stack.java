package ADTs;

public class Stack<E> {
    private Node<E> top, bottom;
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
     * Stack Contructor
     */
    public Stack(){
        this.top = null;
        this.bottom = null;
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
     * @return False since stack can never be full
     */
    public boolean isFull(){
        return false;
    }

    /**
     * enqueue Method
     * inserts the entered data to the top of the stack
     * @param data
     */
    public void push(E data){
        Node<E> newNode = new Node<E>(data);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }
    
    /**
     * dequeue Method
     * removed and returns the data at the top of the Stack
     * @return element
     */
    public E pop(){
        if(isEmpty()) return null;
        if(this.top == this.bottom) this.bottom = null;
        Node<E> topEle = this.top;
        this.top = this.top.next;
        this.size--;
        return topEle.data;
    }

    /**
     * peek Method
     * returns the element at the front of the Queue (doesnt remove)
     * @return front.data (data at front of queue)
     */
    public E peek(){
        if(isEmpty()) return null;
        else{
            return this.top.data;
        }
    }

    /**
     * getSize Method
     * @return the current size of the Queue
     */
    public int Size(){
        return this.size;
    }

    /**
     * display Method
     * prints each element of the Queue from top to bottom
     */
    public void display(){
        Node<E> current = this.top;

        System.out.print("top -> ");
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println("<- bottom");
    }
}