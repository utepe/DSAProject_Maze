package ADTs;

public class LinkedList<E> {
    public Node<E> head;
    private Node<E> tail;
    private int length;

    /**
     * Static Nested Node Class
     * @param <E>
     */
    static class Node<E> {
        Node<E> next;
        E data;
        
        /**
         * Nest Class Constructor
         * @param data
         */
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * LinkedList Constructor
     */
    public LinkedList(){
        this.length = 0;
    }

    /**
     * insertFirst Method
     * inserts element to front of LL
     * @param data
     */
    public void insertFirst(E data){
        Node<E> newNode = new Node<E>(data);
        if(isEmpty()) initialInsert(newNode);
        else{
            newNode.next = this.head;
            this.head = newNode;
            this.length++;
        }
    }

    /**
     * push Method
     * for LL based Stack imp
     * @param data
     */
    public void push(E data){
        insertFirst(data);
    }

    /**
     * insertAt Method
     * inserts element at desired index
     * @param index
     * @param data
     */
    public void insertAt(int index, E data){
        Node<E> newNode = new Node<E>(data);
        if (index >= this.length) insertLast(data);
        else if (index == 0) initialInsert(newNode);
        else{
            Node<E> prevNode = traverseToIndex(index - 1);
            Node<E> nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nextNode;
            this.length++;
        }
    }

    /**
     * insertLast Method
     * inserts element at end of LL
     * @param data
     */
    public void insertLast(E data) {
        Node<E> newNode = new Node<E>(data);
        if(isEmpty()) initialInsert(newNode);
        else{
            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
        }
    }

    /**
     * deleteFirst Method
     * deletes the first element of the LL
     */
    public void deleteFirst(){
        if(isEmpty()) return;
        this.head = this.head.next;
        this.length--;
    }

    /**
     * pop Method for Stack imp
     * deletes and returns the element at the front of the LL
     * @return data
     */
    public E pop(){
        if(isEmpty()) return null;
        E data = this.head.data;
        this.head = this.head.next;
        this.length--;
        return data;
    }

    /**
     * deleteAt Method
     * deletes the element at the desired index
     * @param index
     */
    public void deleteAt(int index){
        if(isEmpty()) return;
        Node<E> prevNode = traverseToIndex(index - 1);
        Node<E> deletingNode = prevNode.next;
        prevNode.next = deletingNode.next;
        this.length--;
    }

    public void deleteLast(){
        if(isEmpty()) return;
        Node<E> currentNode = this.head;
        while(currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        this.length--;
    }

    /**
     * printList Method
     * prints the list from head to tail
     */
    public void printList(){
        Node<E> currentNode = this.head;
        System.out.print("head -> ");
        for(int i = 0; i < this.length; i++){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }

    /**
     * reverseMethod
     * reverses the LL
     */
    public void reverse(){
        if(this.head.next == null) return;
        Node<E> prev = this.head;
        this.tail = this.head;
        Node<E> current = this.head;
        Node<E> next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head.next = null;
        this.head = prev;
    }

    /**
     * isContain Method
     * checks if the LL contains the passed in element
     * @param data
     * @return boolean
     */
    public boolean isContain(E data){
        Node<E> current = this.head;
        while(current.next != null){
            if(current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * size Method
     * returns the length of the LL
     * @return
     */
    public int size(){
        return this.length;
    }

    private void initialInsert(Node<E> newNode){
        this.head = newNode;
        this.tail = this.head;
        this.length++;
    }
    
    /**
     * traverseToIndex Method
     * traverses to and returns the node at the specified index
     * @param index
     * @return Node<E>
     */
    private Node<E> traverseToIndex(int index) {
        int counter = 0;
        Node<E> currentNode = this.head;
        while (counter != index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode;
    }

    /**
     * isEmpty Method
     * returns true is the LL is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return this.length == 0;
    }

    /**
     * peek Method for Stack imp
     * returns the top element of the data (doesn't remove)
     * @return
     */
	public E peek() {
		return this.head.data;
	}
}