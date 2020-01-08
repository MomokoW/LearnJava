package before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sunyuqing on 2019/9/18.
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("NNNN");
        for(String str:list){
            System.out.println(str);
        }
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }
}
