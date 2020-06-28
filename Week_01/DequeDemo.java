import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String... argv) {
        testAddLast();
        testAddFirst();
    }

    private static void testAddFirst() {
        System.out.println("----------testAddFirst start-------------");
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        // 队列，输出c b a
        System.out.println(deque);

        String str = deque.peek();
        // 队头 c 不出队
        System.out.println(str);
        // 输出c b a
        System.out.println(deque);

        // 依次出队 c b a
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        // 空队列
        System.out.println(deque);

        System.out.println("----------testAddFirst end-------------");
    }
    private static void testAddLast() {
        System.out.println("----------testAddLast start-------------");
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        // 队列，输出a b c
        System.out.println(deque);

        String str = deque.peek();
        // 队头 a 不出队
        System.out.println(str);
        // 输出a b c
        System.out.println(deque);

        // 依次出队 a b c
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        // 空队列
        System.out.println(deque);

        System.out.println("----------testAddLast end-------------");
    }
}
