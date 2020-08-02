package ADTs;

public class Stack<E> extends LinkedList<E>{
    public int top;
    public int bottom;
    private int size;

    public Stack(){
        super();
        this.size = super.size();
    }

    public void push(E data){
        insertFirst(data);
        this.size = super.size();
    }

    public E pop(){
        if(super.isEmpty()) return null;
        E data = this.head.data;
        this.head = this.head.next;
        this.size = super.size();
        return data;
    }

    public E peek(){
        if(super.isEmpty()) return null;
        return this.head.data;
    }

    public int getSize(){
        return this.size;
    }
}