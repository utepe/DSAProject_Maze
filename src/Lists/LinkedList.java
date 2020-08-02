package Lists;

public class LinkedList<E> {
    public Node<E> head;
    private Node<E> tail;
    private int length;

    static class Node<E> {
        Node<E> next;
        E data;
    
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList(){
        this.length = 0;
    }

    public void insertFirst(E data){
        Node<E> newNode = new Node<E>(data);
        if(isEmpty()) initialInsert(newNode);
        else{
            newNode.next = this.head;
            this.head = newNode;
            this.length++;
        }
    }

    public void push(E data){
        insertFirst(data);
    }

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

    public void insertLast(E data) {
        Node<E> newNode = new Node<E>(data);
        if(isEmpty()) initialInsert(newNode);
        else{
            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
        }
    }

    public void deleteFirst(){
        if(isEmpty()) return;
        this.head = this.head.next;
        this.length--;
    }

    public E pop(){
        if(isEmpty()) return null;
        E data = this.head.data;
        this.head = this.head.next;
        this.length--;
        return data;
    }

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

    public void printList(){
        Node<E> currentNode = this.head;
        System.out.print("head -> ");
        for(int i = 0; i < this.length; i++){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }

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

    public boolean isContain(E data){
        Node<E> current = this.head;
        while(current.next != null){
            if(current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    public int size(){
        return this.length;
    }

    private void initialInsert(Node<E> newNode){
        this.head = newNode;
        this.tail = this.head;
        this.length++;
    }

    private Node<E> traverseToIndex(int index) {
        int counter = 0;
        Node<E> currentNode = this.head;
        while (counter != index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode;
    }

    private Boolean isEmpty(){
        return this.length == 0;
    }

	public E peek() {
		return this.head.data;
	}
}