import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyFunctionalityTest {


    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdditionPositive() {
        assertEquals(calculator.sum(2, 3), 5);
    }

    @Test
    public void testSubtractionPositive() {
        assertEquals(calculator.sub(5, 3), 2);
    }

    @Test
    public void testMultiplicationPositive() {
        assertEquals(calculator.mult(2, 3), 6);
    }

    @Test
    public void testDivisionPositive() {
        assertEquals(calculator.div(6, 3), 2);
    }

    @Test
    public void testAdditionNegative() {
        assertEquals(calculator.sum(-2, 3), 1);
    }

    @Test
    public void testSubtractionNegative() {
        assertEquals(calculator.sub(2, 5), -3);
    }

    @Test
    public void testMultiplicationNegative() {
        assertEquals(calculator.mult(-2, 3), -6);
    }


}
