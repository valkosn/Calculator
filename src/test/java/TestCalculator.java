import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Valko Serhii on 19-Apr-16.
 */
public class TestCalculator {

    private static Calculator calc;

    @Before
    public void setup() {
        calc = new StringCalculator();
    }

    @Test
    public void testAppendAllPositiveSmallNumbers() {
        assertEquals("100", calc.append("20", "80"));
    }

    @Test
    public void testAppendPositiveAndNegativeSmallNumbers() {
        assertEquals("50", calc.append("100", "-50"));
    }

    @Test
    public void testAppendAllNegativeSmallNumbers() {
        assertEquals("-150", calc.append("-100", "-50"));
    }

    @Test
    public void testAppendAllPositiveSmallNumbersWithUpRank() {
        assertEquals("10000", calc.append("9999", "1"));
    }

    @Test
    public void testAppendAllPositiveBigNumbers() {
        assertEquals("220086516391", calc.append("154621384241", "65465132150"));
    }

    @Test
    public void testAppendAllPositiveBigNumbers1() {
        assertEquals("65619753534479", calc.append("154621384241", "65465132150238"));
    }

    @Test
    public void testAppendPositiveAndNegativeBigNumbers() {
        assertEquals("89156252091", calc.append("154621384241", "-65465132150"));
    }

    @Test
    public void testAppendAllNegativeBigNumbers() {
        assertEquals("-220086516391", calc.append("-154621384241", "-65465132150"));
    }

    @Test
    public void testAppendAllPositiveVeryBigNumbers() {
        assertEquals("22008651639100000000000000000000000000000000000000000000000000000000000",
                calc.append("15462138424100000000000000000000000000000000000000000000000000000000000",
                        "6546513215000000000000000000000000000000000000000000000000000000000000"));
    }

    @Test
    public void testSubtractAllPositiveSmallNumbers() {
        assertEquals("60", calc.subtract("80", "20"));
    }

    @Test
    public void testSubtractPositiveAndNegativeSmallNumbers() {
        assertEquals("150", calc.subtract("100", "-50"));
    }

    @Test
    public void testSubtractAllNegativeSmallNumbers() {
        assertEquals("-50", calc.subtract("-100", "-50"));
    }

    @Test
    public void testSubtractAllPositiveBigNumbers() {
        assertEquals("89156252091", calc.subtract("154621384241", "65465132150"));
    }

    @Test
    public void testSubtractAllPositiveBigAndSmallNumber() {
        assertEquals("154621384213", calc.subtract("154621384241", "28"));
    }

    @Test
    public void testSubtractAllPositiveSmallAndBigNumber() {
        assertEquals("-154621384213", calc.subtract("28", "154621384241"));
    }

    @Test
    public void testSubtractAllPositiveBigNumbers2() {
        assertEquals("-1", calc.subtract("154621384240", "154621384241"));
    }

    @Test
    public void testSubtractAllPositiveBigNumbers3() {
        assertEquals("1", calc.subtract("154621384242", "154621384241"));
    }

    @Test
    public void testSubtractAllPositiveBigNumbers4() {
        assertEquals("15305378620001", calc.subtract("15460000004242", "154621384241"));
    }

    @Test
    public void testSubtractAllPositiveBigIdenticalNumbers() {
        assertEquals("0", calc.subtract("154621384241", "154621384241"));
    }

    @Test
    public void testSubtractPositiveAndNegativeBigNumbers() {
        assertEquals("220086516391", calc.subtract("154621384241", "-65465132150"));
    }

    @Test
    public void testSubtractNegativeAndPositiveBigNumbers() {
        assertEquals("-220086516391", calc.subtract("-154621384241", "65465132150"));
    }

    @Test
    public void testSubtractAllNegativeBigNumbers() {
        assertEquals("-89156252091", calc.subtract("-154621384241", "-65465132150"));
    }

    @Test
    public void testSubtractAllNegativeBigNumbers1() {
        assertEquals("65449670012", calc.subtract("-15462138", "-65465132150"));
    }

    @Test
    public void testMultiplyAllPositiveSmallNumbers() {
        assertEquals("5000", calc.multiply("100", "50"));
    }

    @Test
    public void testMultiplyPositiveAndNegativeSmallNumbers() {
        assertEquals("-5000", calc.multiply("100", "-50"));
    }

    @Test
    public void testMultiplyAllNegativeSmallNumbers() {
        assertEquals("5000", calc.multiply("-100", "-50"));
    }

    @Test
    public void testMultiplyAllPositiveBigAndSmallNumbers() {
        assertEquals("111111111", calc.multiply("12345679", "9"));
    }

    @Test
    public void testMultiplyAllPositiveBigNumbers() {
        assertEquals("10122309352552992448150", calc.multiply("154621384241", "65465132150"));
    }

    @Test
    public void testMultiplyPositiveAndNegativeBigNumbers() {
        assertEquals("-10122309352552992448150", calc.multiply("154621384241", "-65465132150"));
    }

    @Test
    public void testMultiplyAllNegativeBigNumbers() {
        assertEquals("10122309352552992448150", calc.multiply("-154621384241", "-65465132150"));
    }

}
