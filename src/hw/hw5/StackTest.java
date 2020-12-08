package hw5; 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
 
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.NoSuchElementException;

public class StackTest {
    //the element pushed last is the one which is popped first;
    @Test 
    public void isLastPushEqualFirstPop(){
        StackCustom stk = new StackCustom(10); 
        stk.push(1);
        stk.push(2);
        stk.push(3); 

        int popv = stk.pop(); 
        
        assertTrue(3 == popv); 
    }

    //a freshly constructed stack is empty;
    @Test
    public void isStackEmpty(){
        StackCustom stk = new StackCustom(10); 
        assertTrue(stk.empty());
    }

    //a stack containing one element is not empty;
    @Test 
    public void containOne(){
        StackCustom stk = new StackCustom(10);
        stk.push(1);

        assertFalse(stk.empty()); 
    }

    //it is not possible to pop from an empty stack (i.e. whether the exception is thrown);
    @Test(expected = NoSuchElementException.class)
    public void popEmptyStack(){
        StackCustom stk = new StackCustom(10); 
        
        stk.pop();
    }

    // the `size()` method works properly in corner cases (0, 1);
    @Test 
    public void sizeCorner(){
        StackCustom stk = new StackCustom(10); 
        stk.push(1);
        assertEquals(stk.size(), 1);
        
        StackCustom stk2 = new StackCustom(10);
        assertEquals(stk2.size(), 0); 
    }

    //if the last element is popped, the stack becomes empty.
    @Test 
    public void lastPop(){
        StackCustom stk = new StackCustom(10); 
        stk.push(1);
        stk.pop();

        assertTrue(stk.empty()); 
    }
    

}


// javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar StackTest.java
// java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore StackTest