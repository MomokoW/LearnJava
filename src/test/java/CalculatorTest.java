import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Calculator;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */
public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        this.calculator = null;
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(100, calculator.add(100));
        Assertions.assertEquals(150,calculator.add(50));
        Assertions.assertEquals(200,calculator.add(50));
    }

    @Test
    void testSub() {

    }


}
