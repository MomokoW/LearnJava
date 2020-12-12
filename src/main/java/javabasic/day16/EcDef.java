package javabasic.day16;

/**
 * Created by momoko on 2020/12/12.
 */
public class EcDef extends Exception{

    static final long serialVersionUID = -7034897190743766939L;

    public EcDef() {

    }

    public EcDef(String msg) {
        super(msg);
    }

}