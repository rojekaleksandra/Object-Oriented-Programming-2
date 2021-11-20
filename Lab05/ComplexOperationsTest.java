import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ComplexOperationsTest{
    @Test
    public void TestAdd(){
        assertEquals(new Complex(3,4), ComplexOperations.add(new Complex(1,2), new Complex(2,2)));
    }

    @Test
    public void TestSubtract(){
        assertEquals(new Complex(3,4), ComplexOperations.subtract(new Complex(4,5), new Complex(1,1)));
    }

    @Test
    public void TestMultiply(){
        assertEquals(new Complex(-9.46 ,-113.6), ComplexOperations.multiply(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)));
    }

    @Test
    public void TestDivide(){
        assertEquals(new Complex(-0.4522310429783739,-1.4932931836846426), ComplexOperations.divide(new Complex(2.5, 13.1), new Complex(-8.5, -0.9)));
    }
}