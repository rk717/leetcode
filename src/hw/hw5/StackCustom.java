package hw5; 
import java.util.NoSuchElementException;

public class StackCustom {
    int size; 
    int arr[];
    int top;

    StackCustom(int size){
        this.size = size; 
        this.arr = new int[size];
        this.top = -1; 
    }

    /*
        it provides the following two operations
        push(); 
    */
    public void push(int pushedElement){
        if(!full()){
            top++; 
            arr[top] = pushedElement; 
        }
    }

    /*
    pop();
        if pop(), is call on an empty stacck, the method should throw a `java.util.NoSuchElementException`.
        and return its value; 
    */
    public int pop(){
        if(!empty()){
            int returnedTop = top; 
            top--; 
            return arr[returnedTop];
        }else{
            throw new NoSuchElementException();
        }
    }

    //empty(), method, to chekc whether stack is empty //stack.empty()
    public boolean empty(){
        return (top == -1);
    }

    public boolean full(){
        return (size - 1 == top);
    }

    //size(), method, to return the number of elements stroed in the stack //stack.size()
    public int size(){
        return (top + 1); 
    }
}
