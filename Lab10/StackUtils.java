

public class StackUtils {
    public static<T> String toString(Stack<T> stack) {
        String s = "[";
        for (int i = 0; i < stack.getCurrentSize() - 1; i++) {
            s += stack.getArr()[i] + ", ";
        }
        s += stack.getArr()[stack.getCurrentSize() - 1] + "]";
        return s;
    }

    public static<T,U> boolean equals(Stack<T> stack1, Stack<U> stack2){
        if(stack1.getClass() != stack2.getClass())
            return false;
        if(stack1.getCurrentSize() != stack2.getCurrentSize() || stack1.getMaxSize() != stack2.getMaxSize())
            return false;
        for(int i=0;i<stack1.getCurrentSize();i++){
            if(!stack1.getArr()[i].equals(stack2.getArr()[i])) return false;
        }
        return true;
    }

    public static<T> Stack<T> swap(Stack<T> stack, int index1, int index2) throws ArrayIndexOutOfBoundsException{
        if(index1 >= stack.getMaxSize() || index2 >= stack.getMaxSize())
            throw new ArrayIndexOutOfBoundsException("Given indexes are greater than stack max size");
        if(index1 > stack.getCurrentSize() || index2 > stack.getCurrentSize())
            throw new ArrayIndexOutOfBoundsException("Given indexes are greater than current stack size");
        if(index1 < 0 || index2 < 0)
            throw new ArrayIndexOutOfBoundsException("Given indexes are below zero");
        T temp = stack.getArr()[index1];
        stack.getArr()[index1] = stack.getArr()[index2];
        stack.getArr()[index2] = temp;
        return stack;
    }
}
