

public class Stack<T> {
    private int maxSize = 0;
    private int currentSize = 0;
    private T[] arr ;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.maxSize = size;
        arr = (T[]) new Object[maxSize];
    }

    public boolean isEmpty(){
        if (currentSize == 0 ) return true;
        return false;
    }

    public boolean isFull(){
        if (currentSize == maxSize ) return true;
        return false;
    }

    public T pop() throws RuntimeException{
        if(currentSize == 0){
            throw new RuntimeException("Stack is empty");
        }
        T temp = arr[0];
        for(int i=0;i<currentSize-1;i++)
            arr[i] = arr[i+1];
        arr[currentSize-1] = null;
        currentSize--;
        return temp;
    }

    public void push(T val) throws RuntimeException{
        if(currentSize == maxSize){
            throw new RuntimeException("Stack is full");
        }
        for(int i=currentSize;i>0;i--)
            arr[i] = arr[i-1];

        arr[0] = val;
        currentSize++;
    }

    public Stack<T> copy(){
        Stack<T> newstack = new Stack<>(maxSize);
        newstack.setCurrentSize(currentSize);
        for(int i=0;i<this.currentSize;i++)
            newstack.getArr()[i] = this.arr[i];
        return newstack;
    }


    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public T[] getArr() {
        return arr;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public void setArr(T[] arr) {
        this.arr = (T[]) new Object[maxSize];
        for(int i=0;i<maxSize;i++)
            this.arr[i] = arr[i];
    }


}
