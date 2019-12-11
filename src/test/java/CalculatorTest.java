import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */

/**
 * 编写Fixture的套路如下：
 *
 * 对于实例变量，在@BeforeEach中初始化，在@AfterEach中清理，它们在各个@Test方法中互不影响，因为是不同的实例；
 *
 * 对于静态变量，在@BeforeAll中初始化，在@AfterAll中清理，它们在各个@Test方法中均是唯一实例，会影响各个@Test方法。
 *
 * 大多数情况下，使用@BeforeEach和@AfterEach就足够了
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
        assertEquals(100, calculator.add(100));
        assertEquals(150,calculator.add(50));
        assertEquals(200,calculator.add(50));
    }

    @Test
    void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));

    }


}
