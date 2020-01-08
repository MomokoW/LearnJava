package java8lambda;

import java.util.ArrayList;
import java.util.List;

public class MissingNumberTest {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random()*list.size()));
//        int removed = list.remove(10);
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
         return list.stream().filter(integer -> integer-list.indexOf(integer)!=end-start)
                 .findFirst().map(i -> i-1).orElse(end);
    }




}
