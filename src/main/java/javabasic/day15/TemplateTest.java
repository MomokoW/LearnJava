package javabasic.day15;

/**
 * Created by momoko on 2020/12/11.
 * 模板方法
 */
public class TemplateTest {
    public static void main(String[] args) {
        SubTemplate subTemplate = new SubTemplate();
        subTemplate.spendTine();
    }
}

abstract class Template {
    public void spendTine() {
        long start = System.currentTimeMillis();
        code(); //不确定的部分
        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));

    }
    
    public abstract void code();
}

class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i < 500; i++) {
            boolean isFlag = true;

            for (int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0) {
                    isFlag = false;
                    break;
                }
                
            }
            if(isFlag) {
                System.out.println(i + "为质数");
            }
        }
    }
}