package javabasic.day15;

/**
 * Created by momoko on 2020/12/10.
 */
public abstract class AbstractTest {
    public AbstractTest(int i) {
        System.out.println("i");
    }
    public abstract void  testMethod();

    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTest(3) {
            @Override
            public void testMethod() {

            }
        };
    }
}

class Sub extends AbstractTest {

    public Sub(int i) {
        super(i);
    }

    @Override
    public void testMethod() {

    }
}
