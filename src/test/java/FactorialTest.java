import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Factorial;

/**
 * Created by momoko on 2019/12/11
 *
 * @author momoko
 */
public class FactorialTest {
    @Test
    void testNegtive() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->Factorial.fact(-1));
    }

    @Test
    void testTooBig() {
        Assertions.assertThrows(ArithmeticException.class,()->Factorial.fact(21));
    }
}
