package learnset;

/**
 * Created by momoko on 2019/11/22
 *
 * @author momoko
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 如果我们自己编写了一个集合类，想要使用for each循环，只需满足以下条件：
 * <p>
 * 集合类实现Iterable接口，该接口要求返回一个Iterator对象；
 * 用Iterator对象迭代集合内部数据。
 * 集合类通过调用iterator()方法，返回一个Iterator对象
 */
public class LearnIterator {
    public static void main(String[] args) {
        ReverseList<String> rlist = new ReverseList<>();
        rlist.add("Apple");
        rlist.add("Orange");
        rlist.add("Pear");
        for (String s : rlist) {
            System.out.println(s);
        }
    }
}

class ReverseList<T> implements Iterable<T> {

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        public ReverseIterator(int size) {
            index = size;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}
