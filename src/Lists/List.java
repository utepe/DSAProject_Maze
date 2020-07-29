package Lists;

public class List<E> {
    private static final int DEFAULT_SIZE = 10;
    private E[] data;
    public int size;

    public List(){
        this.data = (E[]) new Object[DEFAULT_SIZE];
    }

    public List(int size){
        this.data = (E[]) new Object[size];
    }

    public void add(E ele){
        if(this.size == this.data.length){
            ensureCapacity();
        }
        this.data[this.size++] = ele;
    }

    public void add(int index, E ele){
        if(index >= this.data.length){
            ensureCapacity(index);
        }
        this.data[this.size++] = ele;
    }

    public void set(int index, E ele) throws Exception {
        if(index >= this.data.length) throw new Exception("ArrayIndexOutofBounds");
        if(index < 0) throw new Exception("Cannot Get: Negative Index Entered");
        this.data[index] = ele;
    }

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

    public E get(int index) throws Exception {
        if(index >= this.data.length) throw new Exception("ArrayIndexOutofBounds");
        if(index < 0) throw new Exception("Cannot Get: Negative Index Entered");
        return this.data[index];
    }

    public void remove(int index) throws Exception {
        if(index >= this.data.length) throw new Exception("ArrayIndexOutofBounds");
        if(index < 0) throw new Exception("Cannot Get: Negative Index Entered");
        for (int i = index; i < this.data.length; i++) {
            this.data[i] = this.data[i+1];
        }
    }

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

    public boolean isContain(E ele){
        for (int i = 0; i < this.data.length; i++) {
            if(this.data == ele){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
    
}