package learnset;

/**
 * Created by momoko on 2019/11/21
 *
 * @author momoko
 */


import java.util.*;

/**
 * 使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口
 * 如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象
 */
public class LearnTreeSet {
    public static void main(String[] args) {
        List<Message> received = new ArrayList<>();
        received.add(new Message(1, "Hello!"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(4, "Bye"));

        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }

    }

    static List<Message> process(List<Message> received) {
        Set<Message> set = new HashSet<>();
        set.addAll(received);
        received = new ArrayList<>();
        received.addAll(set);
        return received;
    }

    static class Message {
        public final int sequence;
        public final String text;

        public Message(int sequence, String text) {
            this.sequence = sequence;
            this.text = text;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Message) {
                Message message = (Message) obj;
                return Objects.equals(this.text,message.text)&&message.sequence==((Message) obj).sequence;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int h = 0;
            h = 31 * h + text.hashCode();
            h = 31 * h + sequence;
            return h;
        }
    }
}
