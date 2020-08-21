package ADTs;

public class List<E> {
    private static final int DEFAULT_SIZE = 10;
    private E[] data;
    public int size;

    /**
     * List Constructor
     */
    public List(){
        this.data = (E[]) new Object[DEFAULT_SIZE];
    }

    /**
     * Overloaded List Constructor
     * @param size
     */
    public List(int size){
        this.data = (E[]) new Object[size];
    }

    /**
     * Appends the specified element to the end of this list.
     * @param ele
     */
    public void add(E ele){
        if(this.size == this.data.length){
            ensureCapacity();
        }
        this.data[this.size++] = ele;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index
     * @param ele
     */
    public void add(int index, E ele){
        if(index >= this.data.length){
            ensureCapacity(index);
        }
        this.data[this.size++] = ele;
    }
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index
     * @param ele
     * @throws Exception
     */
    public void set(int index, E ele) throws Exception {
        if(index >= this.data.length) throw new Exception("ArrayIndexOutofBounds");
        if(index < 0) throw new Exception("Cannot Get: Negative Index Entered");
        this.data[index] = ele;
    }

    /**
     * Increases the capacity of this ArrayList instance, if necessary, 
     * to ensure that it can hold at least the number of elements specified
     * by the minimum capacity argument.
     * @param index
     */
    private void ensureCapacity(int index) {
        E[] newData = (E[]) new Object[index];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    private void ensureCapacity() {
        E[] newData = (E[]) new Object[this.data.length*2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return E
     * @throws Exception
     */
    public E get(int index) throws Exception {
        if(index >= this.data.length) throw new Exception("ArrayIndexOutofBounds");
        if(index < 0) throw new Exception("Cannot Get: Negative Index Entered");
        return this.data[index];
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index
     * @throws Exception
     */
    public void remove(int index) throws Exception {
        if(index >= this.data.length) throw new Exception("ArrayIndexOutofBounds");
        if(index < 0) throw new Exception("Cannot Get: Negative Index Entered");
        for (int i = index; i < this.data.length; i++) {
            this.data[i] = this.data[i+1];
        }
    }

    /**
     * Removes the first occurrence
     * of the specified element from this list, if it is present.
     * @param ele
     * @throws Exception
     */
    public void remove(E ele) throws Exception {
        if(!isContain(ele)) throw new Exception("Element not in Array");
        int counter = 0;
        while(this.data[counter] != ele){
            counter++;
        }
        for (int i = counter; i < this.data.length; i++) {
            this.data[i] = this.data[i+1];
        }
    }

    /**
     * Returns if the specified element is in this list
     * @param ele
     * @return boolean
     */
    public boolean isContain(E ele){
        for (int i = 0; i < this.data.length; i++) {
            if(this.data == ele){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     * @return int
     */
    public int size(){
        return this.size;
    }

    /**
     * Returns true if this list contains no elements
     * @return boolean
     */
    public boolean isEmpty(){
        return this.size == 0;
    }
    
}