package before;

/**
 * Created by sunyuqing on 2019/9/18.
 */
public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
        integerBox.setT(10);
        stringBox.setT(new String("等着我"));

        System.out.printf("整型值为 :%d\n\n", integerBox.getT());
        System.out.printf("字符串为 :%s\n", stringBox.getT());
    }
}
