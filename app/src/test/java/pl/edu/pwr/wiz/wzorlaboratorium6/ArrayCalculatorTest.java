package pl.edu.pwr.wiz.wzorlaboratorium6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testy jednostkowe do klasy ArrayCalculator
 */
public class ArrayCalculatorTest {
    private ArrayCalculator ac;
    private String string;

    @Before
    public void setUp() throws Exception {
        /* Tutaj możemy zdefiniować co chcemy zrobić przed rozpoczęciem testów
         * np. przygotować dane, połączenie z bazą itd.
         */
    }

    @Test
    public void getArray() throws Exception {
        /* Testy konstuktora - tego czy prawidłowo parsuje dane */
        Float[] result;

        /* Najpierw pojedynczy wpis */
        string = "1";
        result = new Float[1];
        result[0] = new Float(1.0);

        ac = new ArrayCalculator(string);
        assertArrayEquals(result, ac.getArray());

        /* Kilka wpisów */
        string = "1,2,3,4,5";
        result = new Float[5];
        result[0] = new Float(1.0); result[1] = new Float(2.0); result[2] = new Float(3.0);
        result[3] = new Float(4.0); result[4] = new Float(5.0);

        ac = new ArrayCalculator(string);
        assertArrayEquals(result, ac.getArray());

        /* Kilka wpisów + ujemne wartości i ułamki */
        string = "1.0,2.2,-3,-4.4,50";
        result = new Float[5];
        result[0] = new Float(1.0); result[1] = new Float(2.2); result[2] = new Float(-3.0);
        result[3] = new Float(-4.4); result[4] = new Float(50.0);

        ac = new ArrayCalculator(string);
        assertArrayEquals(result, ac.getArray());
    }

    @Test
    public void getSum() throws Exception {
        /* Prosty przypadek */
        string = "1,2,3,4,5";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(15.0), ac.getSum());

        /* Liczby ujemne  */
        string = "1,2,-5,3,4";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(5.0), ac.getSum());

        /* Liczby ujemne + ułamki  */
        string = "1.5,2.3,-5.5,3,4";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(5.3), ac.getSum());
    }

    @Test
    public void getMultiplied() throws Exception {
        /* Todo napisać testy do funkcji multipled */
        string = "1,2,3";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(6.0), ac.getMultiplied());

        string = "-1,5,10";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(-50.0), ac.getMultiplied());
    }

    @Test
    public void getSize() throws Exception {
        string = "1,2,3,4,5";
        ac = new ArrayCalculator(string);
        assertEquals(new Integer(5), ac.getSize());

        string = "1,2,3,4,5,4,1,5";
        ac = new ArrayCalculator(string);
        assertEquals(new Integer(8), ac.getSize());

        string = "1,2,3,4.2,-5.4,6,-7,8.4,9,10";
        ac = new ArrayCalculator(string);
        assertEquals(new Integer(10), ac.getSize());
    }

    /* TODO napisać test do funkcji getAvarage */

    @Test
    public void getAverage() throws Exception {
        string = "1,2,3,4,5,6,7,8";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(4.5), ac.getAverage());

        string = "1,3,5,10,12";
        ac = new ArrayCalculator(string);
        assertEquals(new Float(6.2), ac.getAverage());
    }
}