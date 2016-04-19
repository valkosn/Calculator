import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Valko Serhii on 19-Apr-16.
 */
public class TestCalculator {

    private static Calculator calc;

    @Before
    public void setup(){
        calc = new StringCalculator();
    }

    @Test
    public void testAppendAllPositiveSmallNumbers (){
        assertEquals("100", calc.append("20", "80"));
    }

    @Test
    public void testAppendPositiveAndNegativeSmallNumbers (){
        assertEquals("50", calc.append("100", "-50"));
    }

    @Test
    public void testAppendAllNegativeSmallNumbers (){
        assertEquals("-150", calc.append("-100", "-50"));
    }

    @Test
    public void testAppendAllPositiveBigNumbers (){
        assertEquals("220086516391", calc.append("154621384241", "65465132150"));
    }

    @Test
    public void testAppendPositiveAndNegativeBigNumbers (){
        assertEquals("89156252091", calc.append("154621384241", "-65465132150"));
    }

    @Test
    public void testAppendAllNegativeBigNumbers (){
        assertEquals("-220086516391", calc.append("-154621384241", "-65465132150"));
    }

    @Test
    public void testSubtractAllPositiveSmallNumbers (){
        assertEquals("60", calc.append("80", "20"));
    }

    @Test
    public void testSubtractPositiveAndNegativeSmallNumbers (){
        assertEquals("150", calc.append("100", "-50"));
    }

    @Test
    public void testSubtractAllNegativeSmallNumbers (){
        assertEquals("-50", calc.append("-100", "-50"));
    }

    @Test
    public void testSubtractAllPositiveBigNumbers (){
        assertEquals("89156252091", calc.append("154621384241", "65465132150"));
    }

    @Test
    public void testSubtractPositiveAndNegativeBigNumbers (){
        assertEquals("220086516391", calc.append("154621384241", "-65465132150"));
    }

    @Test
    public void testSubtractAllNegativeBigNumbers (){
        assertEquals("-89156252091", calc.append("-154621384241", "-65465132150"));
    }

    @Test
    public void testMultiplyAllPositiveSmallNumbers (){
        assertEquals("5000", calc.append("100", "50"));
    }

    @Test
    public void testMultiplyPositiveAndNegativeSmallNumbers (){
        assertEquals("-5000", calc.append("100", "-50"));
    }

    @Test
    public void testMultiplyAllNegativeSmallNumbers (){
        assertEquals("5000", calc.append("-100", "-50"));
    }

    @Test
    public void testMultiplyAllPositiveBigNumbers (){
        assertEquals("10122309352552992448150", calc.append("154621384241", "65465132150"));
    }

    @Test
    public void testMultiplyPositiveAndNegativeBigNumbers (){
        assertEquals("-10122309352552992448150", calc.append("154621384241", "-65465132150"));
    }

    @Test
    public void testMultiplyAllNegativeBigNumbers (){
        assertEquals("10122309352552992448150", calc.append("-154621384241", "-65465132150"));
    }

}
