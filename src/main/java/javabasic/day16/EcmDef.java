package javabasic.day16;

/**
 * Created by momoko on 2020/12/12.
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);

            int result = ecm(i, j);

            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("除零");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }

    }
    public static int ecm(int a, int b) throws EcDef {
        if (a < 0 || b < 0) {
           throw new EcDef("分子或分母为负数!");
        }
        return a / b;

    }
}