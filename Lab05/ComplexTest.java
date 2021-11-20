import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest{
    @Test
    public void TestToString(){
        assertEquals("11.0 + 14.0i", new Complex(11, 14).toString());
    }

    @Test
    public void TestEquals(){
        assertEquals(new Complex(1,1), new Complex(1,1));
    }

    @Test
    public void TestHashCode(){
        assertEquals(new Complex(1,1).hashCode(), new Complex(1,1).hashCode());
    }

    @Test
    public void TestEqalsHashCode(){
        assertEquals(new Complex(1,1).hashCode(), new Complex(1,1).hashCode());
        assertEquals(new Complex(1,1), new Complex(1,1));
    }
}