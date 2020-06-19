package java8lambda;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by momoko on 2019/11/14
 *
 * @author chengww
 */
public class Main {
    public static void main(String[] args) {
//        List<Student> list = List.of(
//                new Student("Bob", 78),
//                new Student("Alice", 85),
//                new Student("Brush", 66),
//                new Student("Newton", 99));
//        Students holder = new Students(list);
//        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
//        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
//        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
}

class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
            score = findInList(name);
            if(score!=null)
            cache.put(name,score);
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (Student ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

